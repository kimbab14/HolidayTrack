<%--
    This jsp will be called when the click submit and successfully inserted the holiday.
    I have used the following http://t4t5.github.io/sweetalert/ to customise the alert
    message.
    After the user press the ok button it will be redirected to the SelectionButton.jsp
    where the user can select an option to new leave req or team leave plans.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- JQuery Script -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<!-- SweetAlert Script -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.css">

<script>
  $(window).load(function(){
  swal({
  	title: "",
   	text: "Successfully Submitted.",
   	type: "success"
  }, function() {
	  window.location.href = "SelectButton.jsp";
	 });
  });
  </script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
</body>
</html>