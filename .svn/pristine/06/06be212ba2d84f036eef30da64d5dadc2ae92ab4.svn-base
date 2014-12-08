package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class namesInGroup {

	ResultSet resultset = null;
	Statement statement;

	public ArrayList<String> getNameInGroups(String PostionCode) {
		try {
			DataBaseConnection db = new DataBaseConnection();
			db.connectDB();
			statement = db.getCon().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> names = new ArrayList<String>();
		String sql = "SELECT Contacts.PatronID FROM Contacts WHERE Contacts.PositionCode Like '%"
				+ PostionCode + "%' ORDER BY Contacts.PatronID;";
		try {
			resultset = statement.executeQuery(sql.trim());
			while (resultset.next()) {
				names.add(resultset.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return names;
	}

	public static void main(String[] args) {
		namesInGroup ps = new namesInGroup();
		ArrayList<String> names = ps.getNameInGroups("City Commissioners");
		for (String p : names)
			System.out.println(p);
	}

}
