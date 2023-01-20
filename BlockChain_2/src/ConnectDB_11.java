
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectDB_11 {

	static Connection connection = null;
	static String database = "deneme";
	static String url = "jdbc:mysql://localhost:3306/" + database;

	static String userName = "root";
	static String password = "123456";
	
	public ConnectDB_11() throws SQLException {
		connection = DriverManager.getConnection(url,userName,password);
		
	}
	
	public ResultSet selectData() throws SQLException {
		
		java.sql.Statement st = connection.createStatement();
		String sql = ("SELECT * FROM deneme.oy_gösterim_alaný;");
		ResultSet rs = st.executeQuery(sql);
		return rs;
		
	}
	
	public void update_data(String a_parti,String b_parti,String c_parti,String d_parti) throws SQLException {
		java.sql.Statement st = connection.createStatement();
		String sql = ("UPDATE `deneme`.`oy_gösterim_alaný` SET `a_parti` = '"+a_parti+"', `b_parti` = '"+b_parti+"', `c_parti` = '"+c_parti+"', `d_parti` = '"+d_parti+"' WHERE (`id` = '1');");
		st.executeUpdate(sql);
	}



}