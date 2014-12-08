package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MaxRecord {
	public String getMaxIDRecord() {
		DataBaseConnection db=new DataBaseConnection();
		db.connectDB();
		Connection conn=db.getCon();
		try {
			Statement stmt=conn.createStatement();
			String sql="SELECT Max(MailingHistoryOverall.ID) AS MaxOfID, Max(MailingHistoryOverall.DateCompleted) AS MaxOfDateCompleted FROM MailingHistoryOverall";

			ResultSet resultset = stmt.executeQuery(sql.trim());
			resultset.next();
			return ""+resultset.getString("MaxOfID");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "No Record Found";
	}
	public String getMaxDateRecord() {
		DataBaseConnection db=new DataBaseConnection();
		db.connectDB();
		Connection conn=db.getCon();
		try {
			Statement stmt=conn.createStatement();
			String sql="SELECT Max(MailingHistoryOverall.ID) AS MaxOfID, Max(MailingHistoryOverall.DateCompleted) AS MaxOfDateCompleted FROM MailingHistoryOverall";

			ResultSet resultset = stmt.executeQuery(sql.trim());
			resultset.next();
			return ""+resultset.getString("MaxOfDateCompleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "No Record Found";
	}
}
