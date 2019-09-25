package domain;

import mappers.DCMapper;
import mappers.RetailerMapper;

import java.sql.*;

public class Retailer implements ClientEntity{
	private int retailerID;
	private String name;
	private int accountBookID;
	private int totalPalletsBought;

	public Retailer() {}

	public Retailer(int retailerID, String name){
		this.retailerID = retailerID;
		this.name = name;
	}

	public Retailer(int retailerID){
		this.retailerID = retailerID;
	}

	public Retailer(int retailerID, String name, int accountBookID, int totalPalletsBought){
		this.retailerID = retailerID;
		this.name = name;
		this.accountBookID = accountBookID;
		this.totalPalletsBought = totalPalletsBought;
	}

	public int getretailerID(){
		return retailerID;
	}

	public void setretailerID(int retailerID){
		this.retailerID = retailerID;
	}

	public String getname(){
		return name;
	}

	public void setname(String name){
		this.name = name;
	}

	public int getaccountBookID(){
		return accountBookID;
	}

	public void setaccountBookID(int accountBookID){
		this.accountBookID = accountBookID;
	}

	public int gettotalPalletsBought(){
		return totalPalletsBought;
	}

	public void settotalPalletsBought(int totalPalletsBought){
		this.totalPalletsBought = totalPalletsBought;
	}

	public boolean buy(int buyPallets, int DCID) throws SQLException {
		DC dc = DCMapper.find(DCID);
		int palletsBought = dc.ship(buyPallets, this.retailerID);
		if(palletsBought < 0){
			System.out.println("issue in buy, error code: " + buyPallets);
			return false;
		}else{
			this.totalPalletsBought = this.totalPalletsBought + buyPallets;
			RetailerMapper.updateRetailer(getretailerID(),this.totalPalletsBought);

			return true;
		}

	}

}