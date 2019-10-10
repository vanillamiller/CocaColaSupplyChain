package domain;
import mappers.DCMapper;
import mappers.TransactionMapper;
import mappers.UnitOfWork;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DC extends Transactor implements SupplyChainEntity{

	private int accountBookID;
	private int numPallets;
	private DCMapper dcmap;
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

	public int restockPallets(int restockPallets) throws SQLException {
		this.numPallets = this.numPallets + restockPallets;
		UnitOfWork.getCurrent().registerDirty(this);
		return this.numPallets;
	}

	public boolean canShip(int shipPallets) {

		return shipPallets <= this.getnumPallets();

	}

	public boolean ship(int shipPallets, int toID) throws SQLException {

		if(this.canShip(shipPallets)){

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