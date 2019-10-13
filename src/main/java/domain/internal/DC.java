package domain.internal;
import domain.Transaction;
import domain.Transactor;
import domain.products.Order;
import domain.products.Product;
import mappers.*;

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
	}

	public void getInventory(){
		this.inventory=ProductMapper.findall(this.getID());
	}

	public DC(int DCID, String name){
		super(DCID, name);
	}


	public boolean restock(int restockPallets, int fromID) throws SQLException {

//		if(getTransactor) {
//			UnitOfWork.newCurrent();
//			this.numPallets += restockPallets;
//			UnitOfWork.getCurrent().registerDirty(this);
//		}
		return false;
	}

	public boolean ship(Order order) {
				try {
					Product curr;
					for (Product p : order.list()) {
						if (inventory.get().contains(p)) {
							curr = inventory.get().get(inventory.get().lastIndexOf(p));
							curr.ship(order.getReceiver());
							inventory.remove(p);
						}
					}
					new Transaction(order, this.getID(), order.getReceiver());
					UnitOfWork.getCurrent().registerDirty(this);
					UnitOfWork.getCurrent().commit();
				} catch (SQLException e){
					e.printStackTrace();
					return false;
				}
				return true;

	}

	public List<Transaction> getTransactions(){
		List<Transaction> ts;
		ts=TransactionMapper.findAll(this.getID(),"DC");
		return ts;
	}


		 
}