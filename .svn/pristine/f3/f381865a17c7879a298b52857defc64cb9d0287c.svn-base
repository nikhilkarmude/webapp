package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TotalCountSection {
	int totalCountSelected;
	ResultSet resultset = null;

	public String getTotalCountSelected() {
		DataBaseConnection db = new DataBaseConnection();
		db.connectDB();
		String count = "0";
		try {
			//String sql="SELECT Count (Contacts.[Contact_ID]) AS Total_Count FROM Contacts left JOIN GroupSelections ON(GroupSelections.GroupsForMailing=Contacts.PositionCode)";
			
//			String sql = "SELECT Count (Contacts.[Contact_ID / Per Position]) AS Total_Count"
//					+ " FROM Contacts, GroupSelections"
//					+ " WHERE PositionCode like GroupSelections.GroupsForMailing ;";
			String sql="SELECT Count(*) AS Total_Count FROM Contacts, GroupSelections WHERE Contacts.PositionCode Like [GroupSelections].[GroupsForMailing];";

			Statement stmt = db.getCon().createStatement();
			ResultSet resultset = stmt.executeQuery(sql.trim());
			resultset.next();
			count = "" + resultset.getString(1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;

	}
	public int totalCountFromList(HashMap<String, Integer> postion_count,ArrayList<String> ps ){
		for (int i=0;i<ps.size();i++) {
			totalCountSelected+= (Integer) postion_count.get(ps.get(i));		
		}
		return totalCountSelected;
		
	}

	public static void main(String[] args) {
		System.out.println(new TotalCountSection().getTotalCountSelected());

	}

}
