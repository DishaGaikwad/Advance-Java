package com.demo.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestCallableStatement {
	
	public static void main(String[] args) {
		
		//Connection conn=null;
		try {
			
			Connection conn=DriverManager.getConnection("jdbc:mysql://192.168.10.117:3306/dac20?useSSL=false","dac20","welcome");
			
//			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
//			String url="jdbc:mysql://192.168.10.117:3306/dac20?useSSL=false";
//			conn=DriverManager.getConnection(url,"dac20","welcome");
			CallableStatement cst=conn.prepareCall("call getcnt(?,?)");
			cst.setInt(1, 10);
			cst.registerOutParameter(2, java.sql.Types.INTEGER);
			cst.execute();
			int cnt=cst.getInt(2);
			System.out.println("count :"+cnt);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				
//				e.printStackTrace();
//			}
//		}

	}
	
	
	

}
