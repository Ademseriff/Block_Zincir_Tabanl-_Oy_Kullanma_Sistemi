import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;



public class ConnectDB_8 {

	static Connection connection = null;
	static String database = "kulanici_oy_db";
	static String url = "jdbc:mysql://localhost:3306/" + database;

	static String userName = "root";
	static String password = "123456";

	
	public ConnectDB_8() throws SQLException {
		connection = DriverManager.getConnection(url,userName,password);
	}
	
	public void executeUpdate_1(String a) throws SQLException {
		java.sql.Statement st = connection.createStatement();
		
		//String sql = ("UPDATE `deneme`.`block_onay_tbl` SET `Block_onay_sayisi` = '"+b+"' WHERE (`Block_onay_sayisi` = '0')");
		String b =("UPDATE `kulanici_oy_db`.`kulanicilar_tb` SET `Kullanici_bool` = '0' WHERE (`Kulanici_tc` = '"+a+"');") ;
		st.executeUpdate(b);
	}
}