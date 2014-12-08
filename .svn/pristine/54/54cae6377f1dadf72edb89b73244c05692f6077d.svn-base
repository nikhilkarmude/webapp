package controller;

import java.sql.SQLException;
import java.sql.Statement;

public class insertMaterialSelection {

	public void insertIntoMaterialSelection(String MaterialName){
		DataBaseConnection db=new DataBaseConnection();
		db.connectDB();
		try {
			Statement stmt=db.getCon().createStatement();
			String sql=" INSERT INTO MaterialSelections(ID, MaterialSelection)"
					+ " SELECT ID, MaterialName FROM MaterialsAvailable"
					+ " WHERE MaterialName='"+MaterialName+"'";
			System.out.println(MaterialName);
			int resultset = stmt.executeUpdate(sql.trim());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//
//	INSERT INTO MaterialSelections(ID, MaterialSelection) " & _
//    " SELECT [ID], [MaterialName] " & _
//    " FROM MaterialsAvailable " & _
//    " WHERE MaterialName = '" & [Forms]![frmSelectGroupsForMailing]!frmListMaterialsAvailable & "'"
}
