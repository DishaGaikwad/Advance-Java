package com.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class TestCreateStatement {
	
	public static void main(String[] args) {
		Connection conn=null;
		try {
			
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			String url="jdbc:mysql://192.168.10.117:3306/dac20?useSSL=false";
			conn=DriverManager.getConnection(url,"dac20","welcome");
			if(conn!=null) {
				System.out.println("connection done");
			}else {
				System.out.println("connection not done");
			}
			Statement stmnt=conn.createStatement();
			ResultSet rs=stmnt.executeQuery("select * from myproduct");
			while(rs.next()) {
				System.out.println("pid "+rs.getInt(1));
				System.out.println("pname "+rs.getString(2));
				System.out.println("qty "+rs.getInt(3));
				System.out.println("price "+rs.getDouble(4));
				System.out.println("mfgdate "+rs.getDate(5));
				System.out.println("-----------------------------");
			}
			int pid=123;
			String pname="xxxx";
			int qty=45;
			double price = 456.78;
			LocalDate ldt=LocalDate.now();
			String sqlDate = ldt.toString();
			String query="insertinto myproduct values("+pid+","+pname+","+qty+","+price+","+sqlDate+")";
			System.out.println(query);
			int n=stmnt.executeUpdate(query);
			if(n>0) {
				System.out.println("insertion is done");
			}else {
				System.out.println("error");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
