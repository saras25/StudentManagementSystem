package Curd;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class AddStudent {
	
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
		
		Driver d = new com.mysql.jdbc.Driver();
		System.out.println(d);
		DriverManager.registerDriver(d);
		
		
		String db = "jdbc:mysql://localhost:3306/student_info?user=root&password=root";  
		Connection con1 = DriverManager.getConnection(db);
		
		
		String q = "INSERT INTO student(id,Fname,Lname,Address,marks,Gender,DOB,Branch,Phno,Result)VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement stmt = con1.prepareStatement(q);
	           
		System.out.println("Enter the id");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the Fname");
		String Fname = sc.nextLine();
		sc.nextLine();
		
		System.out.println("Enter the Lname");
		String Lname = sc.nextLine();
		sc.nextLine();
		
		System.out.println("Enter the Address");
		String Address = sc.nextLine();
		sc.nextLine();
		System.out.println("Enter the marks");
		double marks = sc.nextDouble();
		
		sc.nextLine();
		System.out.println("enter the gender");
		String Gender = sc.nextLine();
		sc.nextLine();
		
		System.out.println("Enter the Dateofbirth");
		String DOB = sc.next();
		sc.nextLine();
		
		System.out.println("Enter the Branch name");
		String Branch = sc.next();
		sc.nextLine();
		System.out.println("Enter the phone number");
		String Phno = sc.next();
		sc.nextLine();
		
		
		System.out.println("Enter the result");
		String Result = sc.next();
	      stmt.setInt(1, id);
	      stmt.setString(2, Fname);
	      stmt.setString(3, Lname);
	      stmt.setString(4, Address);
	      stmt.setDouble(5, marks);
	      stmt.setString(6, Gender);
	      stmt.setString(7, DOB);
	      stmt.setString(8, Branch);
	      stmt.setString(9, Phno);
	      stmt.setString(10, Result);
	      
	      
	     
	int r = stmt.executeUpdate();
	if(r>0)
	{
		System.out.println("A new Student is added succesfully");
		
	}
	
	stmt.close();
	con1.close();
	DriverManager.deregisterDriver(d);
	
	
	}
}
