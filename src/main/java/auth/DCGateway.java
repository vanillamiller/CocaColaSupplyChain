package auth;
import java.sql.*;

public class DCGateway {
	private int DCId;
	private String name;
	private int accountBookID;
	private int inventoryID;
	private static final String addDCString = "INSERT INTO DCs VALUES (?, ?, ?, ?)";
	private static final String getAllDCsString = "SELECT * FROM DCs";
			
	public DCGateway(int DCId, String name, int accountBookID, int inventoryID){
		super();
		this.DCId = DCId;
		this.name = name;
		this.accountBookID = accountBookID;
		this.inventoryID = inventoryID;
	}
	
	public int getDCId(){
		return DCId;
	}
	public String getname(){
		return name;
	}
	public int getaccountBookID(){
		return accountBookID;
	}
	public int getinventoryID(){
		return inventoryID;
	}
	public void addDC() {
		PreparedStatement addDC = null;
		try {
			addDC = DBConnection.prepare(addDCString);
			
			addDC.setInt(1, DCId);
			addDC.setString(2, name);
			addDC.setInt(3, accountBookID);
			addDC.setInt(4, inventoryID);

			addDC.execute();
			
		} catch (Exception e) {
			
		}
		
	} 
}