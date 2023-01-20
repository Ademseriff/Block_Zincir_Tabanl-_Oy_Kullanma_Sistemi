import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectDB_9 {

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
	
	
	public ConnectDB_9() throws SQLException {
		connection = DriverManager.getConnection(url,userName,password);
		
	}
	
	public ResultSet selectData() throws SQLException {
		
		java.sql.Statement st = connection.createStatement();
		String sql = ("SELECT * FROM deneme.block_sayimi;");
		ResultSet rs = st.executeQuery(sql);
		return rs;
		
	}
	public void insertData( String b ) throws SQLException {
		java.sql.Statement st = connection.createStatement();
		String sql = ("INSERT INTO `deneme`.`block_sayimi` (`partiler_þifreli`) VALUES ('"+b+"');");
		st.executeUpdate(sql);
	}
	public void update_data() throws SQLException {
		java.sql.Statement st = connection.createStatement();
		String sql = ("UPDATE `deneme`.`block_sayimi` SET `block_sayim` = '1' WHERE (`block_sayim` = '0');");
		st.executeUpdate(sql);
	}
	//UPDATE `deneme`.`block_sayimi` SET `block_sayim` = '2' WHERE (`id` = '10');
	public void update_data_1() throws SQLException {
		java.sql.Statement st = connection.createStatement();
		String sql = ("UPDATE `deneme`.`block_sayimi` SET `block_sayim` = '2' WHERE (`block_sayim` = '1');");
		st.executeUpdate(sql);
	}
	public void update_data_2() throws SQLException {
		java.sql.Statement st = connection.createStatement();
		String sql = ("UPDATE `deneme`.`block_sayimi` SET `block_sayim` = '3' WHERE (`block_sayim` = '2');");
		st.executeUpdate(sql);
	}
	public void update_data_3() throws SQLException {
		java.sql.Statement st = connection.createStatement();
		String sql = ("UPDATE `deneme`.`block_sayimi` SET `block_sayim` = '4' WHERE (`block_sayim` = '3');");
		st.executeUpdate(sql);
	}
	
}