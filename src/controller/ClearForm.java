package controller;

import java.sql.SQLException;
import java.sql.Statement;

public class ClearForm {
	String Sql_del_grpSel = "DELETE * FROM GroupSelections";
	String Sql_del_matSel = "DELETE * FROM MaterialSelections";

	public void ClearFormQuery() {
		DataBaseConnection db = new DataBaseConnection();
		db.connectDB();
		Statement stmt;
		try {
			stmt = db.getCon().createStatement();
			stmt.executeUpdate(Sql_del_grpSel);
			stmt.close();
			stmt = db.getCon().createStatement();
			stmt.executeUpdate(Sql_del_matSel);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
