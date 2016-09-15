<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="bean.*, utils.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Holiday Tracker</title>
<link href="http://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.1/semantic.min.css" rel="stylesheet" type="text/css" />
<link href="css/dataTables.semanticui.min.css" rel="stylesheet" type="text/css" />       

<script src="js/jquery-1.12.3.js" type="text/javascript"></script>
<script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="js/dataTables.semanticui.min.js" type="text/javascript"></script>
<script src="js/semantic.min.js" type="text/javascript"></script>

 <script type="text/javascript">
        $(document).ready(function () {
            $("#hols").dataTable({
            	  "aaSorting": [[5,'ASC']]
            });
        });
 </script>
</head>

<body>
<%
 String goBack = "SelectButton.jsp";
%>

<div style="width:700px; margin-left:20px; margin-top:20px;">
<button type="button" style="border: 1px black; display: inline-block; " class="btn btn-secondary btn-lg btn-block" onClick="JavaScript:window.location='<%= goBack %>';">Go back </button>
<div style=" display: inline-block; height: 37px; margin-left:570px"><b><a href="Logout.jsp">Logout</a></b></div>
<div></div>
<div style="width:274px;align:center"><h1>Holiday Tracker</h1></div>
<br/>
<table id="hols" class="ui celled table"  cellspacing="0" width="100%">
		            <thead>
		                <tr>
		                    <th><u>Employee ID</u></th>
		                    <th><u>Full Name</u></th>
		                    <th><u>Start Date</u></th>
		                    <th><u>End Date</u></th>
		                    <th><u>Submitted Date</u></th>
		                </tr>
		            </thead>
		            <tbody>
		          		<% for(User c: FetchDataFromDb.getHolsData()){ %>
						  <tr>
						    <td><%=c.getEmpId()%></td>
						    <td><%=c.getFullname()%></td>
						    <td><%=c.getStartDate()%></td>
						    <td><%=c.getEndDate()%></td>
						    <td><%=c.getDateSubmitted()%></td>
						  </tr>
						<% } %>
		            </tbody>
		        </table>
		   </div>
</body>
</html>