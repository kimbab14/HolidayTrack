<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="height=1, width=1,initial-scale=1,user-scalable=1" />
    <title>Select</title>
    
    <link href="http://fonts.googleapis.com/css?family=Lato:100italic,100,300italic,300,400italic,400,700italic,700,900italic,900" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="Bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="css/styles.css" />

</head>
<body>
<%
 String LeaveReq = "LeaveRequest.jsp";
 String viewAllData = "ViewAllData.jsp";
 //need to implement cookie here..
 String currentUser = request.getParameter("username");
%>
   <section class="container">
            <section class="login-form">
                <form method="POST" role="login">
                    <img src="images/logo.png" class="img-responsive" alt="" style="height:70px;"/>
                    <div style="display: inline-block;">Welcome <%= currentUser %></div>
                    <div style="display: inline-block; margin-left:200px;"><b><a href="SelectionButtonLogout.jsp">Logout</a></b></div>
                    <button type="button" name="btnLogin" class="btn btn-lg btn-primary btn-block" onClick="JavaScript:window.location='<%= LeaveReq %>';">New Leave Request</button>
                    <button type="button" name="btnLogin" class="btn btn-lg btn-primary btn-block" onClick="JavaScript:window.location='<%= viewAllData %>';">Team Leave Plans</button>
                </form>
            </section>
    </section>

</body>
</html>