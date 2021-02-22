package Curd;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class UpdateStudent {
	
	public static void main(String[] args) throws SQLException {
     Scanner sc = new Scanner(System.in);
     
		Driver d = new com.mysql.jdbc.Driver();
		System.out.println(d);
		DriverManager.registerDriver(d);
		
		
		String db = "jdbc:mysql://localhost:3306/student_info?user=root&password=root";  
		Connection con1 = DriverManager.getConnection(db);
		
		System.out.println("Enter the id to be updated");
		int id = sc.nextInt();
		
		String q = "UPDATE student "+
		           "SET Fname= 'Sreya' ,"
				   + "Lname= 'Ghosle' ,"
		           + "marks= 77 "+
				   "WHERE ID=? ";
		
				   
				  
		PreparedStatement stmt = con1.prepareStatement(q);
		stmt.setInt(1, id);
		int r = stmt.executeUpdate();
		if(r>0)
		{
			System.out.println("Updation is done successfully");
			
		}
		
		stmt.close();
		con1.close();
		DriverManager.deregisterDriver(d);
		
		
	
	}

}
