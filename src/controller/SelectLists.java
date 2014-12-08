package controller;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class SelectLists {
	@SuppressWarnings("finally")
	public HashMap<String, Integer> getSelectListPositonCode(
			HashMap<String, Integer> postionCountOld) {
		DataBaseConnection DB = new DataBaseConnection();
		DB.connectDB();
		Statement statement;
		try {
			statement = DB.getCon().createStatement();
			String sql = "SELECT PositionCodes.PositionCode, COUNT(Contacts.ID) AS CountOfID FROM PositionCodes, Contacts WHERE PositionCodes.PositionCode=Contacts.PositionCode GROUP BY PositionCodes.PositionCode;";
			ResultSet resultset = statement.executeQuery(sql.trim());

			while (resultset.next()) {
				int Count = resultset.getInt(2);
				String PostionCode = resultset.getString(1);
				postionCountOld.put(PostionCode, Count);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return postionCountOld;
		}

	}

	public ArrayList<String> getSelectedListMaterials(
			ArrayList<String> MaterialNames) {
		DataBaseConnection DB = new DataBaseConnection();
		DB.connectDB();
		Statement statement;
		String sql = "SELECT MaterialsAvailable.MaterialName FROM MaterialsAvailable WHERE MaterialsAvailable.Active=True;";
		try {
			statement = DB.getCon().createStatement();
			ResultSet resultset = statement.executeQuery(sql.trim());
			while (resultset.next()) {
				MaterialNames.add(resultset.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return MaterialNames;
	}

}
