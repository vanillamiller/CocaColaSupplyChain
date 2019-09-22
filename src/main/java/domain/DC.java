package domain;
import java.sql.*;
import java.util.List;



public class DC implements SupplyChainEntity{
	private int DCId;
	private String name;
	private int accountBookID;
	private int numPallets;
			
	public DC(int DCId, String name, int accountBookID, int numPallets){
		this.DCId = DCId;
		this.name = name;
		this.accountBookID = accountBookID;
		this.numPallets = numPallets;
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

	public int getaccountBookID(){ return accountBookID;}

	public void setaccountBookID(int accountBookID){ this.accountBookID = accountBookID;}

	public int getnumPallets(){
		return numPallets;
	}

	public int restockPallets(int restockPallets){
		this.numPallets = this.numPallets + restockPallets;
		return this.numPallets;
	}

	public boolean canShip(int shipPallets) {
		if (shipPallets > this.numPallets) {
			return false;
		} else {
			return true;
		}
	}

	public int ship(int shipPallets, int toID) throws SQLException {
		if (canShip(shipPallets) == true) {
			this.numPallets = this.numPallets - shipPallets;
//			create transaction
			DBTransactionMapper.makeTransaction(shipPallets,this.DCId,toID);
			return this.numPallets;
		}
		else{
			return -1;
		}

	}

//	public static List<DC> getAllDCs() {
//		DCGateway dcg = new DCGateway();
//		TODOTODOTODOTODOTODOTODOTODO
//		return result;
//	}
		 
}