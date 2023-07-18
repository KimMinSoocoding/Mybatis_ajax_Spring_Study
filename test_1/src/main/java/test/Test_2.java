package test;

import java.sql.Connection;

import java.sql.DriverManager;




public class Test_2 {


public static void main(String[] args) {
		
		
		String user = "root";
		String password = "6845alstn";
		String url = "jdbc:mysql://localhost:3306";
		try(
	
			Connection conn = DriverManager.getConnection(url, user, password);

		) {
			System.out.println(conn.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}






