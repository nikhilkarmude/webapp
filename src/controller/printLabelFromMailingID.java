package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class printLabelFromMailingID {
	public ArrayList<String> displayMailingIDs()
	{	
		ArrayList<String> MailingIDs=new ArrayList<String>();
		DataBaseConnection db=new DataBaseConnection();
		db.connectDB();
		try {
			Statement stmt=db.getCon().createStatement();
			String sql="SELECT MailingHistoryOverall.ID	FROM MailingHistoryOverall "+
						"ORDER BY MailingHistoryOverall.ID DESC";
			ResultSet resultset = stmt.executeQuery(sql);

			while (resultset.next()) {
				MailingIDs.add(resultset.getString(1));
			}
										
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return MailingIDs;
		
	}
	public ArrayList<String> printLabel(String MailingID)
	{	System.out.println("called");
		DataBaseConnection db=new DataBaseConnection();
		db.connectDB();
		try {
			Statement stmt=db.getCon().createStatement();
			String sql="SELECT DISTINCT Contacts.Salutation, Contacts.Firstname, Contacts.Lastname, Contacts.Organization, Contacts.Address1, Contacts.Address2, Contacts.Address3, Contacts.Address4, Contacts.City, Contacts.State, Contacts.Zip FROM MailingHistoryContacts INNER JOIN Contacts ON MailingHistoryContacts.PatronContactID = Contacts.ID WHERE MailingHistoryContacts.MailingID = "+ MailingID +"";

			ResultSet resultset = stmt.executeQuery(sql);
			int i=0;
			while (resultset.next()) {
				System.out.println("Record: "+(i++));
				String Salutation=resultset.getString(8);
				String FirstName=resultset.getString(7);
				String LastName=resultset.getString(6);
				String Organization=resultset.getString(10);
				String Address1=resultset.getString(23);
				String Address2=resultset.getString(24);
				String Address3=resultset.getString(25);
				String Address4=resultset.getString(26);
				String City=resultset.getString(11);
				String State=resultset.getString(12);
				String Zip=resultset.getString(13);
				System.out.println(Salutation+" "+FirstName+" "+LastName+" "+Organization+" "+Address1+" "+Address2+" "+Address3+" "+Address4+" "+City+" "+State+" "+Zip);
//				int autoID= resultset.getInt(1);
//				System.out.println(autoID);
			}
										
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
