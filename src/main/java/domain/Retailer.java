package domain;

import mappers.DCMapper;
import mappers.RetailerMapper;

import java.sql.*;
import java.util.*;

public class Retailer extends Transactor implements ClientEntity{


	private int accountBookID;
	private int totalPalletsBought;

	public Retailer(int retailerID, String name){
		super(retailerID, name);
	}


	public Retailer(int retailerID, String name, int accountBookID, int totalPalletsBought){
		super(retailerID, name);
		this.accountBookID = accountBookID;
		this.totalPalletsBought = totalPalletsBought;
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

		DC dc = DCMapper.find(DCID);

		if(buyPallets < 0 || buyPallets > dc.getnumPallets()){
			System.out.println("issue in buy, error code: " + buyPallets);
			return false;
		}else{
			int palletsBought = dc.ship(buyPallets, this.getID());
			this.totalPalletsBought = this.totalPalletsBought + buyPallets;
			RetailerMapper.updateRetailer(this.getID(),this.totalPalletsBought);
			return true;
		}

	}

	public List<Transaction> getTransactions(){
		return new ArrayList<Transaction>();
	}

}