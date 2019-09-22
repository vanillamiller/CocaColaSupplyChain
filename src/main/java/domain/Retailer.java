package domain;
import com.sun.corba.se.impl.orb.ParserTable;

import java.sql.*;
import java.util.List;

public class Retailer implements ClientEntity{
	private int retailerId;
	private String name;
	private int accountBookID;
	private int totalPalletsBought;

	public Retailer(int retailerId, String name, int accountBookID){
		this.retailerId = retailerId;
		this.name = name;
		this.accountBookID = accountBookID;
		this.totalPalletsBought = totalPalletsBought;
	}

	public int getretailerId(){
		return retailerId;
	}

	public void setretailerId(int retailerId){
		this.retailerId = retailerId;
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


	public boolean buy(int buyPallets, int DCId) throws SQLException {
		DC dc = DCMapper.findDC(DCId);
		int palletsBought = dc.ship(buyPallets, this.retailerId);
		if(palletsBought == -1){
			return false;
		}else{
			this.totalPalletsBought = this.totalPalletsBought + palletsBought;
			return true;
		}

	}

//	public static List<retailer> getAllretailers() {
//		retailerGateway retailerg = new retailerGateway();
//		TODOTODOTODOTODOTODOTODOTODO
//		return result;
//	}

}