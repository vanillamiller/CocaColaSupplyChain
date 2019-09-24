package domain;
import java.sql.*;


public class DC implements SupplyChainEntity{
	private int DCID;
	private String name;
	private int accountBookID;
	private int numPallets;
			
	public DC(int DCID, String name, int accountBookID, int numPallets){
		this.DCID = DCID;
		this.name = name;
		this.accountBookID = accountBookID;
		this.numPallets = numPallets;
	}
	
	public int getDCID(){
		return DCID;
	}

	public void setDCID(int DCID){
		this.DCID = DCID;
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

	public int restockPallets(int restockPallets) throws SQLException {
		this.numPallets = this.numPallets + restockPallets;
		DCMapper.updateDC(getDCID(),this.numPallets);
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
			DCMapper.updateDC(getDCID(),this.numPallets);
//			create transaction
			if(TransactionMapper.makeTransaction(shipPallets,this.DCID,toID)==true){
				return this.numPallets;
			}
			else{
				return -2;
			}


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