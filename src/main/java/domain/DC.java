package domain;
import mappers.DCMapper;
import mappers.TransactionMapper;
import mappers.UnitOfWork;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DC extends Transactor implements SupplyChainEntity{

	private int accountBookID;
	private int numPallets;
	private DCMapper dcmap;

	public DC(int DCID, String name, int accountBookID, int numPallets){
		super(DCID, name);
		this.accountBookID = accountBookID;
		this.numPallets = numPallets;
		this.dcmap=new DCMapper();
	}

	public DC(int DCID, String name){
		super(DCID, name);
	}

	public int getnumPallets(){
		return this.numPallets;
	}

	public void setPallets(int numPallets){
		this.numPallets=numPallets;
	}

	public int restockPallets(int restockPallets) throws SQLException {
		this.numPallets = this.numPallets + restockPallets;
		this.dcmap.update(this.getID(),this.numPallets);
		return this.numPallets;
	}

	public boolean canShip(int shipPallets) {

		return shipPallets <= this.getnumPallets();

	}

	public void ship(int shipPallets, int toID) throws SQLException {
		this.numPallets = this.numPallets - shipPallets;
//		this.dcmap.update(getID(), this.numPallets);
		new Transaction(shipPallets, this.getID(), toID);
		UnitOfWork.getCurrent().registerDirty(this);
	}

	public List<Transaction> getTransactions(){
		List<Transaction> ts;
		ts=TransactionMapper.findAll(this.getID(),"DC");
		return ts;
	}


		 
}