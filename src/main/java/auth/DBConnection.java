package auth;
import java.sql.*;
import java.util.Date;

public class DBConnection {
	private static final String DB_CONNECTION = "jdbc:postgresql://ec2-23-21-148-223.compute-1.amazonaws.com:5432/dfc109863pt1p?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
	
	private static final String DB_USER = "gvkwjgcpmfgdqn";
	private static final String DB_PASSWORD = "effd128d0f9f5cf67e5f40c6b305437d3ef311bac1307cee9922bab51794e65e";
	
	static Connection dbConnection = null;
	
	public static PreparedStatement prepare(String stm) throws SQLException {
		
		PreparedStatement preparedStatement = null;
		try {
		
			Connection dbConnection = getDBConnection();
			
			preparedStatement = dbConnection.prepareStatement(stm);
			System.out.println("up to here2");
		} catch (SQLException e) {
		
			System.out.println(e.getMessage());
		
		}
		
		return preparedStatement;
	}
	
	private static Connection getDBConnection() {
		
		try {
			// register driver
			DriverManager.registerDriver(new org.postgresql.Driver());
			
			// open connection
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;
		
		} catch (SQLException e) {
		
			System.out.println(e.getMessage());
		
		}
		
		System.out.println("connection issues");
		return null;
	}

}