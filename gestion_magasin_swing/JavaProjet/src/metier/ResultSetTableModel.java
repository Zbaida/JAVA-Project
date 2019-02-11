package metier;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

public class ResultSetTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ResultSet rs;
	private ResultSetMetaData rsmd;
	
	public ResultSetTableModel(ResultSet aResultSet) {
		rs = aResultSet;
		try {
			rsmd = rs.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int getColumnCount() {
		try {
			return rsmd.getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	@Override
	public int getRowCount() {
		try {
			rs.last();
			return rs.getRow();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	@Override
	public Object getValueAt(int r, int c) {
		try {
			rs.absolute(r + 1);
			return rs.getObject(c + 1);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String getColumnName(int c) {
		try {
			return rsmd.getColumnName(c + 1);
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
	}
}
