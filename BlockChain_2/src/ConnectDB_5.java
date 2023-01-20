import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectDB_5 {

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
	
	
	public ConnectDB_5() throws SQLException {
		connection = DriverManager.getConnection(url,userName,password);
		//System.out.println("baglanti_ yapildi");
		
	}
	
	public void insertData( String tc, String sifre,String ad,String soyad) throws SQLException {
		java.sql.Statement st = connection.createStatement();
		
		//String sql = ("INSERT INTO `deneme`.`previos_hash_çöz` ( `previos_hash_çöz_1`) VALUES ('"+b+"');");
		String sql = ("INSERT INTO `kulanici_oy_db`.`kulanicilar_tb` ( `Kulanici_tc`,`Kullanici_Sifre`,`Kullanici_ad`,`Kullanici_Soyad`) VALUES ('"+tc+"','"+sifre+"','"+ad+"','"+soyad+"');");
		st.executeUpdate(sql);
	}
}