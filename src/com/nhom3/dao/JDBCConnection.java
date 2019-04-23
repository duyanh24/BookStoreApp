
package com.nhom3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public static Connection getJDBCConnection(){
		final String user = "sa";
		final String password = "123456";
		final String url = "jdbc:sqlserver://localhost:1433;databaseName=QLBanHang;user="+user+";password="+password;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			return DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		Connection connection = getJDBCConnection();
		if(connection!=null){
			System.out.println("LÊ DUY ANH - 20160089 ket noi thanh cong");
		}
		else{
			System.out.println("ket noi that bai");
		}
	}
}
