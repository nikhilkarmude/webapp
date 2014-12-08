package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class saveEvent {

	public void SaveEventExecuteInsertDate(String date) {
		String sql = "Insert into MailingHistoryOverall (DateCompleted)  VALUES ('"
				+ date + "')";
		Execute(sql);

	}

	public void saveMailingHistory() {
		String sql = "Insert into MailingHistoryContacts(MailingID, PatronContactID, MaterialID, DeliveryMeth)"
				+ " SELECT N.MaxOfID, [G.ID], [M.ID], 'Test' FROM MaterialSelections M,qryFormSaveContactsToMailingHistory G, Max N";
		Execute(sql);
	}
	public void saveMailingHistoryPositionCodes(){
		String sql = "Insert into MailingHistoryPositionCodes(MailingID, PositionCode)"
				+ " SELECT [N.MaxOfID], [G.GroupsForMailing] FROM GroupSelections G, Max N";
		Execute(sql);
	}
	private void Execute(String sql){
		DataBaseConnection db = new DataBaseConnection();
		db.connectDB();
		Connection con = db.getCon();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql.trim());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
