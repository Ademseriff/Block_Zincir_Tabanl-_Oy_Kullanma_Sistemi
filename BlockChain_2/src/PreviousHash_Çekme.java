import java.sql.ResultSet;
import java.sql.SQLException;

public class PreviousHash_Çekme {
	
	public String PreviousHash_Çekme_1() throws SQLException {
		ConnectDB_2 conn = new ConnectDB_2();
		ResultSet rs = conn.selectData();
		String a = null;
		while(rs.next()) {
			a=rs.getString("previos_hash_1");
		}
	return a;

}}
