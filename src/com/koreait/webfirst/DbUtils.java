package com.koreait.webfirst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtils {
	public static void main(String[] args) {
		try {
			getCon();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getCon() throws Exception {
		final String URL = "jdbc:mysql://localhost:3303/javadev?serverTimezone=UTC";
		final String USER = "root";
		final String PW = "koreait2020";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PW);
		System.out.println("접속 성공");
		return con;
	}

	public static void close(Connection con, PreparedStatement ps) {
		close(con, ps, null); 
	}
	
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		if (rs != null) { // 하나의 try catch문이었다면 하나가 에러 터지면 밑에가 실행이 안되서 try catch문을 나눠 준거임
			try { rs.close();} catch (Exception e) {}
		}
		if (ps != null) {
			try { ps.close();} catch (Exception e) {}
		}
		if (con != null) {
			try { con.close();} catch (Exception e) {}
		}
	}
}
