package domain.internal;
import domain.Transaction;
import domain.Transactor;
import domain.products.Order;
import mappers.DCMapper;
import mappers.TransactionMapper;
import mappers.UnitOfWork;

import java.sql.*;
import java.util.List;


public class DC extends Transactor implements SupplyChainEntity {

	private int accountBookID;
	private int numPallets;
	private DCMapper dcmap;

	private Inventory inventory;
	private List<Transaction> accountBook;

	public DC(){ super(); }

	public DC(int DCID, String name, int accountBookID, int numPallets){
		super(DCID, name);
		this.accountBookID = accountBookID;
		this.numPallets = numPallets;
		this.dcmap=new DCMapper();
	}

	public DC(int DCID, String name){
		super(DCID, name);
	}

	public int getnumPallets(){
		return this.numPallets;
	}

	public void setPallets(int numPallets){
		this.numPallets=numPallets;
	}

	public boolean restock(int restockPallets, int fromID) throws SQLException {

//		if(getTransactor) {
//			UnitOfWork.newCurrent();
//			this.numPallets += restockPallets;
//			UnitOfWork.getCurrent().registerDirty(this);
//		}
		return false;
	}

	public boolean canShip(Order order){

		return inventory.numVanilla()>=order.getNumVanilla() && inventory.numRegular()>=order.getNumRegular()
				&& inventory.numZero()>=order.getNumZero();

	}
	public boolean ship(Order order, int toID) throws SQLException {

		if(this.canShip(order)){

			this.numPallets -= shipPallets;
			new Transaction(shipPallets, this.getID(), toID);
			UnitOfWork.getCurrent().registerDirty(this);
			UnitOfWork.getCurrent().commit();

			return true;

		} else {
			return false;
		}
	}

	public List<Transaction> getTransactions(){
		List<Transaction> ts;
		ts=TransactionMapper.findAll(this.getID(),"DC");
		return ts;
	}


		 
}