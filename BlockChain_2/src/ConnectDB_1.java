import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;



public class ConnectDB_1 {

	static Connection connection = null;
	static String database = "kulanici_oy_db";
	static String url = "jdbc:mysql://localhost:3306/" + database;

	static String userName = "root";
	static String password = "123456";

	
	public ConnectDB_1() throws SQLException {
		connection = DriverManager.getConnection(url,userName,password);
	}
	
	public ResultSet selectData() throws SQLException {
		
		java.sql.Statement st = connection.createStatement();
		String sql = ("select * from kullanici_oy;");
		ResultSet rs = st.executeQuery(sql);
		return rs;
		
	}
	public void executeUpdate_1(String a) throws SQLException {
		java.sql.Statement st = connection.createStatement();
		String b = a;
		st.executeUpdate(b);
	}
}