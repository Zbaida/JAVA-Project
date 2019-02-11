package metier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ListCommands {
	public static ArrayList<Command> getListCommand(Connection conn) throws SQLException{
		ArrayList<Command> com = new ArrayList<Command>();
		Statement st = conn.createStatement();
		String Q = "SELECT * FROM Commande";
		ResultSet rs = st.executeQuery(Q);
		while (rs.next())
			com.add(new Command(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getString(11)));
		rs.close();
		st.close();
		
		return com;}
}
