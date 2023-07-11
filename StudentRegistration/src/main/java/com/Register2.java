package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Register2() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int sid = Integer.parseInt(request.getParameter("sid"));
		String sname = request.getParameter("sname");
		int phone = Integer.parseInt(request.getParameter("phone"));
		int marks =Integer.parseInt(request.getParameter("marks"));
		String branch = request.getParameter("branch");

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/igt", "root", "purva0108");

			
			PreparedStatement statement = con.prepareStatement("insert into stud values(?,?,?,?,?)");
			statement.setInt(1, sid);
			statement.setString(2, sname);
			statement.setInt(3, phone);
			statement.setInt(4, marks);
			statement.setString(5, branch);

			int insertRow= statement.executeUpdate();
			statement.close();
			con.close();

			if (insertRow > 0) {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<h2>Congratulations you have successfully registered!</h2>");
			} else {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<h2>Error: Registration failed!</h2>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
