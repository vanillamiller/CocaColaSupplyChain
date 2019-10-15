package domain;

import java.util.*;

public class Retailer extends Transactor implements ClientEntity {


	private int accountBookID;
	private int totalPalletsBought;

	private List<Transaction> accountBook;

	public Retailer(int retailerID, String name){
		super(retailerID, name);
	}

	public Retailer(){ super(); }
	public Retailer(int retailerID, String name, int accountBookID, int totalPalletsBought){
		super(retailerID, name);
		this.accountBookID = accountBookID;
		this.totalPalletsBought = totalPalletsBought;
	}

	public int getaccountBookID(){
	    IdentityMap map=IdentityMap.getInstance(this.getClass());
		return accountBookID;
	}

	public int gettotalPalletsBought(){
		return totalPalletsBought;
	}
//
//	public void settotalPalletsBought(int totalPalletsBought){
//		this.totalPalletsBought = totalPalletsBought;
//	}

	public boolean buy(Order order, int id) {

		InternalTransactor supplier=(InternalTransactor) TransactorMapper.find(id);
		if(supplier.ship(order)) {
			UnitOfWork.newCurrent();

			UnitOfWork.getCurrent().registerDirty(this);
			UnitOfWork.getCurrent().commit();
			return true;
		}
		return false;
	}

	public List<Transaction> getTransactions(){
		return new ArrayList<Transaction>();
	}

}