import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectDB {

	static Connection connection = null;
	static String database = "kulanici_oy_db";
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
	
	
	public ConnectDB() throws SQLException {
		connection = DriverManager.getConnection(url,userName,password);
	}
	
	public ResultSet selectData() throws SQLException {
		
		java.sql.Statement st = connection.createStatement();
		String sql = ("select * from kulanicilar_tb;");
		ResultSet rs = st.executeQuery(sql);
		return rs;
		
	}
     public ResultSet selectData(String a) throws SQLException {
		
		java.sql.Statement st = connection.createStatement();
		String sql = ("SELECT Kullanici_onay FROM kulanici_oy_db.kulanicilar_tb where kulanici_tc='"+a+"';");
		ResultSet rs = st.executeQuery(sql);
		return rs;
		
	}
     public void update_data(String a) throws SQLException {
 		
 		java.sql.Statement st = connection.createStatement();
 		String sql = ("UPDATE `kulanici_oy_db`.`kulanicilar_tb` SET `Kullanici_onay` = '0' WHERE (`Kulanici_tc` = '"+a+"');");
 		st.executeUpdate(sql);
 	}
     // UPDATE `kulanici_oy_db`.`kulanicilar_tb` SET `Kullanici_onay` = '0' WHERE (`id` = '3');
}
