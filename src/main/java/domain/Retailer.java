package domain;

import mappers.DCMapper;
import mappers.RetailerMapper;

import java.sql.*;
import java.util.*;

public class Retailer extends Transactor implements ClientEntity{


	private int accountBookID;
	private int totalPalletsBought;
	private RetailerMapper rmap;

	public Retailer(int retailerID, String name){
		super(retailerID, name);
	}


	public Retailer(int retailerID, String name, int accountBookID, int totalPalletsBought){
		super(retailerID, name);
		this.accountBookID = accountBookID;
		this.totalPalletsBought = totalPalletsBought;
		this.rmap=new RetailerMapper();
	}

//	public int getaccountBookID(){
//		return accountBookID;
//	}
//
//	public void setaccountBookID(int accountBookID){
//		this.accountBookID = accountBookID;
//	}
//
//	public int gettotalPalletsBought(){
//		return totalPalletsBought;
//	}
//
//	public void settotalPalletsBought(int totalPalletsBought){
//		this.totalPalletsBought = totalPalletsBought;
//	}

	public boolean buy(int buyPallets, int DCID) throws SQLException {

		DCMapper dmap=new DCMapper();
		DC dc = dmap.find(DCID);

		if(buyPallets < 0 || buyPallets > dc.getnumPallets()){
			System.out.println("issue in buy, error code: " + buyPallets);
			return false;
		}else{
			;
			int palletsBought = dc.ship(buyPallets, this.getID());
			this.totalPalletsBought = this.totalPalletsBought + palletsBought;
			this.rmap.update(this.getID(),this.totalPalletsBought);
			return true;
		}

	}

	public List<Transaction> getTransactions(){
		return new ArrayList<Transaction>();
	}

}