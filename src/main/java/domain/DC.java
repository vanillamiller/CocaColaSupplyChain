package domain;

import java.sql.*;
import java.util.List;


public class DC extends InternalTransactor {

	private int accountBookID;
	private Inventory inventory;
	private List<Transaction> accountBook;

	public DC(){ super(); }

	public DC(int DCID, String name, int accountBookID, int numPallets){
		super(DCID, name);
	}

	public DC(int DCID, String name){
		super(DCID, name);
	}


	public boolean restock(int restockPallets, int fromID) throws SQLException {


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
		ts=TransactionMapper.findAll(this.getID());
		return ts;
	}


		 
}