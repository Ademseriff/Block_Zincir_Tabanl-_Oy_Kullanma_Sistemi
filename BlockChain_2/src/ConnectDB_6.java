import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectDB_6 {

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
	
	
	public ConnectDB_6() throws SQLException {
		connection = DriverManager.getConnection(url,userName,password);
		//System.out.println("baglandin");
		
	}
public ResultSet selectData() throws SQLException {
		
		java.sql.Statement st = connection.createStatement();
		String sql = ("SELECT Block,Block_onay_sayisi FROM deneme.block_onay_tbl;");
		ResultSet rs = st.executeQuery(sql);
		return rs;
		
	}
	
	public void insertData( String b) throws SQLException {
		java.sql.Statement st = connection.createStatement();
		String sql = ("INSERT INTO `deneme`.`block_onay_tbl` (`Block`) VALUES ('"+b+"');");
		st.executeUpdate(sql);
	}
	/*public void update_data( String b) throws SQLException {
		java.sql.Statement st = connection.createStatement();
		//String sql1 = ("INSERT INTO `deneme`.`block_onay_tbl` (`Block`) VALUES ('"+b+"');");
		String sql = ("UPDATE `deneme`.`block_onay_tbl` SET `Block_onay_sayisi` = '"+b+"' WHERE (`Block_onay_sayisi` = '0')");
		String sql1 = ("UPDATE `deneme`.`block_onay_tbl` SET `Block_onay_sayisi` = '"+b+"' WHERE (`Block_onay_sayisi` = '1')");
		String sql2 = ("UPDATE `deneme`.`block_onay_tbl` SET `Block_onay_sayisi` = '"+b+"' WHERE (`Block_onay_sayisi` = '2')");
		st.executeUpdate(sql);
		st.executeUpdate(sql1);
		st.executeUpdate(sql2);
	}*/
	public void update_data() throws SQLException {
		java.sql.Statement st = connection.createStatement();
		//String sql1 = ("INSERT INTO `deneme`.`block_onay_tbl` (`Block`) VALUES ('"+b+"');");
		String sql = ("UPDATE `deneme`.`block_onay_tbl` SET `Block_onay_sayisi` = '1' WHERE (`Block_onay_sayisi` = '0')");
		st.executeUpdate(sql);
	}
	public void update_data_1() throws SQLException {
		java.sql.Statement st = connection.createStatement();
		//String sql1 = ("INSERT INTO `deneme`.`block_onay_tbl` (`Block`) VALUES ('"+b+"');");
		String sql = ("UPDATE `deneme`.`block_onay_tbl` SET `Block_onay_sayisi` = '2' WHERE (`Block_onay_sayisi` = '1')");
		st.executeUpdate(sql);
	}
	public void update_data_2() throws SQLException {
		java.sql.Statement st = connection.createStatement();
		//String sql1 = ("INSERT INTO `deneme`.`block_onay_tbl` (`Block`) VALUES ('"+b+"');");
		String sql = ("UPDATE `deneme`.`block_onay_tbl` SET `Block_onay_sayisi` = '3' WHERE (`Block_onay_sayisi` = '2')");
		st.executeUpdate(sql);
	}
	public void insertData_1( String b) throws SQLException {
		java.sql.Statement st = connection.createStatement();
		String sql = ("INSERT INTO `deneme`.`blocklar` (`Block`) VALUES ('"+b+"');");
		st.executeUpdate(sql);
	}
	public void DeleteData () throws SQLException {
		java.sql.Statement st = connection.createStatement();
		String sql = ("DELETE FROM `deneme`.`block_onay_tbl` WHERE (`Block_onay_sayisi` = '3');");
		st.executeUpdate(sql);
	}
}