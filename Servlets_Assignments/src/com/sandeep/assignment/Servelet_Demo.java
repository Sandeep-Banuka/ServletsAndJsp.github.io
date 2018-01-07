package com.sandeep.assignment;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servelet_Demo
 */
@WebServlet("/Servelet_Demo")
public class Servelet_Demo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servelet_Demo() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try{
			// TODO Auto-generated method stub
			//doGet(request, response);
			Class.forName("com.mysql.jdbc.Driver");
			String a=request.getParameter("name");
			String b=request.getParameter("email");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/au","root","root");
			String sql="insert into servlet_streams_exercises "+"(name,email)"+"values(?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1,a);
			stmt.setString(2,b);
			stmt.executeUpdate();
			con.close();
		}
	 catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	 {
		doGet(request, response);

	}
}