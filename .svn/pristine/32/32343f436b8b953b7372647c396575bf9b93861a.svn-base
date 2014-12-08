package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class insertGroupSelection {
	public void insertIntoGroupSelection(String PostionCode){
		DataBaseConnection db=new DataBaseConnection();
		db.connectDB();
		try {
			Statement stmt=db.getCon().createStatement();
			String sql=" INSERT INTO GroupSelections VALUES('"+PostionCode+"');";
			int resultset = stmt.executeUpdate(sql.trim());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//
	}

}
