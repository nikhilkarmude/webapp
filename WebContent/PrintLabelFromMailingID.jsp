<%@page import="java.util.Date"%>
<%@page import="controller.DataBaseConnection"%>
<%@page import="controller.printLabelFromMailingID"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="controller.selectCount"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/generic.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/MyStyles.css">

<script type='text/javascript' src='js/select.js'></script>
<title>Contact DB</title>
<script type="text/javascript" src="js/CollapsibleLists.js"></script>
<style type="text/css">
</style>
</head>
<%@ page import="javax.naming.*"%>
	<%@ page import="java.sql.*"%>
	<%@ page import="javax.sql.*"%>
	<% 
		ArrayList<String> MailingIDs=new ArrayList<String>();
	%>
	
<body>
	<DIV align="center">
		<h1>Print Label From Mailing ID</h1>
	</DIV>
	<div id="formContent">
		<div id="center">
			<form name="mailingID" action="PrintLabelFromMailingID.jsp" method="post">
			<table>
			<tr>
			<td>Enter Mailing ID</td>
			<td>
			<select name="mailingID">
			<option value="null"></option>
					<%
						MailingIDs= new printLabelFromMailingID().displayMailingIDs();				
						for(int i=0;i<MailingIDs.size();i++){
							String id=MailingIDs.get(i);							
					%><option value="<%=id%>"><%=MailingIDs.get(i)%></option>
					<%
						}
					%>
			
			</select>
			</td>
			<td> <input id="Submitbtn" type="submit" value="OK" name="printLabel" /></td>
			</tr>
			</table>
			</form>
			</div>
			
		
	</div>
	<div>
		<!-- 	printLabel call -->
	<%
		String mailingID=request.getParameter("mailingID");
		System.out.println(mailingID);
		printLabelFromMailingID printLabel= new printLabelFromMailingID();
		printLabel.printLabel(mailingID);
	%>

	</div>
	
	<script lang="javascript">
		CollapsibleLists.apply();
	</script>

</body>
</html>

