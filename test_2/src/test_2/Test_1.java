package test_2;
import java.sql.*;

public class Test_1{

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";

		try {

			Class.forName(driver);
			System.out.println("JDBC Driver Loading 성공!!");

		} catch (Exception e) {
			
			System.out.println("JDBC Driver Loading 실패!!");
			e.printStackTrace();
			
		}

	}
}