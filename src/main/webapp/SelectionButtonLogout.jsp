<%--
    This jsp will be called whenever the user press the logout button.
    Will ask the user if he/she wants to logout or not. 
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- JQuery Script -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<!-- SweetAlert Script -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.css">
<script>
  $(window).load(function(){
      swal({
          title: "",
          text: "Are you sure you want to logout?",
          type: "warning",
          showCancelButton: true,
          confirmButtonColor: "#DD6B55",
          confirmButtonText: "Yes",
          closeOnConfirm: false
        },
        function(isConfirm){
            if (isConfirm){
                window.location.href="Login.jsp";
            }else{
             window.location.href = "SelectButton.jsp";
            }
        });
  });
  </script>
</head>
<body>

</body>
</html>