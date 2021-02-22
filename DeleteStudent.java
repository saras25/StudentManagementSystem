package Curd;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;

public class DeleteStudent {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
	
	Driver d = new com.mysql.jdbc.Driver();
	DriverManager.registerDriver(d);
	
	
	String db = "jdbc:mysql://localhost:3306/student_info?user=root&password=root";  
	Connection con1 = DriverManager.getConnection(db);
	
	
	String q = "DELETE FROM student WHERE id=? ";
	
	
	PreparedStatement stmt = con1.prepareStatement(q);
	
	System.out.println("Enter the id to be deleted");
	int id = sc.nextInt();
	
	stmt.setInt(1, id);
	
	int r = stmt.executeUpdate();
	if(r>0)
	{
		System.out.println("deletion is done successfully");
		
	}
	
	stmt.close();
	con1.close();
	DriverManager.deregisterDriver(d);
	
	



}
}

