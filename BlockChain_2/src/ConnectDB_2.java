import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectDB_2 {

	static Connection connection = null;
	static String database = "deneme";
	static String url = "jdbc:mysql://localhost:3306/" + database;

	static String userName = "root";
	static String password = "123456";

	//public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		//Class.forName("com.mysql.jdbc.Driver").newInstance();
	//	connection = DriverManager.getConnection(url,userName,password);

		//java.sql.Statement st = connection.createStatement();
		//String sql = ("select * from kulanicilar_tb;");
		//ResultSet rs = st.executeQuery(sql);
		//while(rs.next()) {
		//	System.out.println(rs.getString("Kulanici_tc"));
		//}
		
	//}
	
	
	public ConnectDB_2() throws SQLException {
		connection = DriverManager.getConnection(url,userName,password);
		
	}
	
	public ResultSet selectData() throws SQLException {
		
		java.sql.Statement st = connection.createStatement();
		String sql = ("select * from previos_hash;");
		ResultSet rs = st.executeQuery(sql);
		return rs;
		
	}
	public void insertData( String b ) throws SQLException {
		java.sql.Statement st = connection.createStatement();
		String sql = ("INSERT INTO `deneme`.`previos_hash` ( `previos_hash_1`) VALUES ('"+b+"');");
		st.executeUpdate(sql);
	}
}