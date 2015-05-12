
//Enrique Hernandez
//CS 4311
//Exercise 6a
//2/8/2015

import java.sql.*;

public class DataBase {
	public static void main(String args[]) {
	    DataBase db = new DataBase("SuppDB");  
	    ResultSet rs = db.execute("select * from S");
	      try {
	        while (rs.next())                                // 6th line of JDBC
	          System.out.println(rs.getString("S_NO"));      // 7th line of JDBC
	      } catch (SQLException e) {
	          System.out.println(e.getMessage());
	      }
	  }
	  
	  // NOT COMPLETE, see lecture notes page 76
	private String url = "jdbc:sqlite:./sqlite/";
	private static final String driverName= "org.sqlite.JDBC";
	private String dbname;
	  
	  public DataBase(String name) {
	    // NOT COMPLETE, see lecture notes page 77 
	   dbname = name;
	   url = url+dbname;
	  }
	  public ResultSet execute(String query) {
	    ResultSet rs = null;
	    // NOT COMPLETE, see lecture notes page 78, for the first 5 lines of JDBC
	    try {
			Class.forName(driverName);               // 1:
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}                 						      
	    Connection conn = null;
		try {
			conn = DriverManager.getConnection(url); // 2:
		} catch (SQLException e) {
			e.printStackTrace();
		}                                          
		try {
			Statement stmt = conn.createStatement(); // 3:
		    stmt.execute(query); 					 // 4: 
		    rs = stmt.getResultSet(); 				 // 5:
		} catch (SQLException e) {
			e.printStackTrace();
		}                                           
                                     
	    return rs;
	  }
}
