package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class display{

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/IGT", "root", "purva0108");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from emp");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + ":" + rs.getString(2) + ":" + rs.getInt(3) + ":"  + rs.getInt(4) + ":"+ rs.getString(5));
			}

			System.out.println("Data displayed successfully");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
