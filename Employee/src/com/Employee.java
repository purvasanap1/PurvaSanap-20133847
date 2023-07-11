//load driver, create connection, create statement, execute statement,close connection
package com;

import java.sql.*;
import java.util.Scanner;


public class Employee{
	public static void main(String[] args) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/IGT","root","purva0108");
		PreparedStatement pstmt=con.prepareStatement("insert into emp values(?,?,?,?,?)");
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter id");
		int id = sc.nextInt();
		
		System.out.println("Enter name");
		String name = sc.next();
		
		System.out.println("Enter age");
		int age = sc.nextInt();
		
		System.out.println("Enter salary");
		int salary = sc.nextInt();
		
		System.out.println("Enter desig");
		String desig = sc.next();
		
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setInt(3, age);
		pstmt.setInt(4, salary);
		pstmt.setString(5, desig);
		
		pstmt.execute();
		pstmt.close();
		System.out.println("Employee Data inserted successfully");
		
		
		
	}catch(Exception e) 
	{
		System.out.println(e);
	}
	

	}

}

