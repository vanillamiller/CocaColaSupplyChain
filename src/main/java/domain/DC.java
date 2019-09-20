package domain;
import java.sql.*;
import java.util.List;

public class DC{
	private int DCId;
	private String name;
	private int accountBookID;
	private int inventoryID;
			
	public DC(int DCId, String name, int accountBookID, int inventoryID){
		this.DCId = DCId;
		this.name = name;
		this.accountBookID = accountBookID;
		this.inventoryID = inventoryID;
	}
	
	public int getDCId(){
		return DCId;
	}

	public void setDCId(int DCId){
		this.DCId = DCId;
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

	public int getinventoryID(){
		return inventoryID;
	}

	public void setinventoryID(int inventoryID){
		this.inventoryID = inventoryID;
	}

//	public static List<DC> getAllDCs() {
//		DCGateway dcg = new DCGateway();
//		TODOTODOTODOTODOTODOTODOTODO
//		return result;
//	}
		 
}