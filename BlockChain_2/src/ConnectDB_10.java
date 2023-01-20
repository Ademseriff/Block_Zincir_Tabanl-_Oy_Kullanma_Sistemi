import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectDB_10 {

	static Connection connection = null;
	static String database = "deneme";
	static String url = "jdbc:mysql://localhost:3306/" + database;

	static String userName = "root";
	static String password = "123456";
	
	public ConnectDB_10() throws SQLException {
		connection = DriverManager.getConnection(url,userName,password);
		
	}
	
	public ResultSet selectData() throws SQLException {
		
		java.sql.Statement st = connection.createStatement();
		String sql = ("SELECT * FROM deneme.kiþi_onayladýgý_oylar;");
		ResultSet rs = st.executeQuery(sql);
		return rs;
		
	}
	public void insertData( String a,String b,String c,String d ) throws SQLException {
		java.sql.Statement st = connection.createStatement();
		//INSERT INTO `deneme`.`kiþi_onayladýgý_oylar` (`a_parti`, `b_parti`, `c_parti`, `d_parti`) VALUES ('0', '0', '0', '0');
		String sql = ("INSERT INTO `deneme`.`kiþi_onayladýgý_oylar` (`a_parti`, `b_parti`, `c_parti`, `d_parti`) VALUES ('"+a+"', '"+b+"', '"+c+"', '"+d+"');");
		st.executeUpdate(sql);
	}
	public void DeleteData () throws SQLException {
		java.sql.Statement st = connection.createStatement();
		String sql = ("DELETE FROM kiþi_onayladýgý_oylar  where id>0");
		st.executeUpdate(sql);
	}
	
}