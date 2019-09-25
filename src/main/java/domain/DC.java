package domain;
import mappers.DCMapper;
import mappers.TransactionMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DC extends Transactor implements SupplyChainEntity{
	private int accountBookID;
	private int numPallets;
			
	public DC(int DCID, String name, int accountBookID, int numPallets){
		super(DCID, name);
		this.accountBookID = accountBookID;
		this.numPallets = numPallets;
	}

	public DC(int DCID, String name){
		super(DCID, name);
	}

	public int getnumPallets(){
		return numPallets;
	}

	public int restockPallets(int restockPallets) throws SQLException {
		this.numPallets = this.numPallets + restockPallets;
		DCMapper.update(this.getID(),this.numPallets);
		return this.numPallets;
	}

	public boolean canShip(int shipPallets) {

		return shipPallets <= this.getnumPallets();

	}

	public int ship(int shipPallets, int toID) throws SQLException {
		this.numPallets = this.numPallets - shipPallets;
		DCMapper.update(getID(), this.numPallets);
//			create transaction
		if (TransactionMapper.makeTransaction(shipPallets, this.getID(), toID) == true) {
			return this.numPallets;
		} else {
			return -1;
		}
	}



	public List<Transaction> getTransactions(){
		List<Transaction> ts=new ArrayList<Transaction>();
		ts=TransactionMapper.findAll(this.getID(),"DC");
		return ts;
	}


		 
}