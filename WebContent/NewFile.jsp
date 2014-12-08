<%@page import="controller.MaxRecord"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="controller.SelectLists"%>
<%@page import="controller.insertGroupSelection"%>
<%@page import="controller.DataBaseConnection"%>
<%@page import="controller.TotalCountSection"%>
<%@page import="controller.namesInGroup"%>
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
		int Count = 0;
		String PostionCode = "";
		String selectedCount = "";
		HashMap<String, Integer> postion_count=new HashMap<String,Integer>();
		ArrayList<String> PostionSelected = new ArrayList<String>();
		ArrayList<String> MaterialName = new ArrayList<String>();
		ArrayList<String> MaterialNameselected = new ArrayList<String>();
		HashMap<String, ArrayList<String>> patronID = new HashMap<String, ArrayList<String>>();
		Date date = new Date();
		DateFormat dateFormat; 	
	%>
<body>
	<DIV align="center">
	
		<h1>Contact DB Form:</h1>
		<br> <input type="button" id="Submitbtn" value="Clear"
			onclick="window.location='Refresh.do'" />		
	<input id="Submitbtn" type="submit" value="Save/Complete"
			onclick="window.location='SaveFormSelection.do'" />

		<%
			//postion_count=(HashMap<String, Integer>)(session.getAttribute("posstionCode_counter_list"));
			postion_count=new SelectLists().getSelectListPositonCode(postion_count);
			//session.setAttribute("posstionCode_counter_list", postion_count);
		%>
	</DIV>
	<div id="content">
		<div id="left">
			<form action="addGroupSelection">
				<label class="label">Position Codes</label> <select
					name="postionCode">
					<option value="null">PostionCode || Count</option>
					<%
						
						for(String key:postion_count.keySet()){
							Count = postion_count.get(key);
							PostionCode = key;
							String display = PostionCode + " || " + Count;				
								
					%>
					<option value="<%=PostionCode%>"><%=display%></option>
					<%
						}
					%>

				</select> <br> <br> <br> <input id="Submitbtn" type="submit"
					value="Setect" />
			</form>

			<%
				ArrayList<String> ps =(ArrayList<String>) session
							.getAttribute("PositionSelected");
							if(!ps.isEmpty()){	
			%>
	<%-- 	<h1>PreviewCount:</h1>
			<h1><%=postion_count.get(request.getParameter("postionCode"))%></h1>
			<br> --%>
			
			<h1>Total Count:</h1>
			<h1><%=new TotalCountSection().totalCountFromList(postion_count,ps)%></h1>
			<br> <br>
			<h1>Groups For Mailing List Selected</h1>
			<ul id="image" class="collapsibleList">
				<%
					for (int i = 0; i < ps.size(); i++) {
				%>

				<li><%=ps.get(i)%>
					<ul>
						<%
							ArrayList<String> names = new namesInGroup().getNameInGroups(ps.get(i));
							for (String p : names) {
						%>
						<li><%=p%></li>
						<%
							}
						%>
					</ul></li>
				<%
					}
				%>
			</ul>
			<%
				}
				else{
					out.print("<h1>Nothing is Selected</h1>");
				}
			%>

		</div>
		<div id="right">
			<form action="addMaterialSelection">
				<label class="label">Materials Names</label> <select
					name="MaterialName">
					<option value="null">Material Names</option>
					<%
						MaterialName= new SelectLists().getSelectedListMaterials(MaterialName);				
						for(int i=0;i<MaterialName.size();i++){
							String materialName=MaterialName.get(i);							
					%><option value="<%=materialName%>"><%=MaterialName.get(i)%></option>
					<%
						}
					%>
				</select>
				 <br> <br> <br> <input id="Submitbtn" type="submit"
					value="Setect" />
			</form>
			<%
				ArrayList<String> ms =(ArrayList<String>) session
							.getAttribute("MaterialSelected");
							if(!ms.isEmpty()){
			%>
			<br> <br>
			<h1>Material Selected</h1>
			<ul id="materials">
				<%
					for (int i = 0; i < ms.size(); i++) {
				%>

				<li><%=ms.get(i)%></li>
				<%
					}
				%>
			</ul>
			<%
				}
				else{
					out.print("<h1>Nothing is Selected</h1>");
				}
			%>

		</div>
	</div>
	<div align="center">
	
	<%
	String id=new MaxRecord().getMaxIDRecord();
	String dateLast=new MaxRecord().getMaxDateRecord();
	%>
		<h3>Most Recent Mailing ID: <%=id%><br> Time:<%=dateLast %></h3>
	<footer>After saving a new MailingID, close this form and double-click "PrintingLabel from MailingID" to get the mailing addresses for a label.</footer>
	</div>
	<script lang="javascript">
		CollapsibleLists.apply();
	</script>

</body>
</html>
</body>
</html>
