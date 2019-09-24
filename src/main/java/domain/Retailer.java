package domain;
import java.sql.*;
import java.util.List;

public class Retailer {
	private int retailerId;
	private String name;
	private int accountBookID;

	public Retailer(int retailerId, String name, int accountBookID){
		this.retailerId = retailerId;
		this.name = name;
		this.accountBookID = accountBookID;
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

//	public static List<retailer> getAllretailers() {
//		retailerGateway retailerg = new retailerGateway();
//		TODOTODOTODOTODOTODOTODOTODO
//		return result;
//	}

}