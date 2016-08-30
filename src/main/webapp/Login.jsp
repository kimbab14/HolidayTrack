<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="utils.*, bean.*, servlet.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="height=1, width=1,initial-scale=1,user-scalable=1" />
    <title>Login</title>
    
    <link href="http://fonts.googleapis.com/css?family=Lato:100italic,100,300italic,300,400italic,400,700italic,700,900italic,900" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="Bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="css/styles.css" />
</head>
<body>
    <section class="container">
        <section class="login-form">
            <form method="POST"  action="Login" role="login">
                <img src="images/logo.png" class="img-responsive" alt="" style="height:70px;"/>
                <span style="color:red;">${errMsg}</span> 
                      
                <div class="form-group has-feedback has-feedback-left">
                    <input type="text" name="username" placeholder="Username" id="inputError" required class="form-control input-lg" />
                    <i class="form-control-feedback glyphicon glyphicon-user"></i>
                </div>  
                
                <div class="form-group has-feedback has-feedback-left">
                    <input type="Password" id="pass" name="pass" placeholder="Password" required class="form-control input-lg" />
                    <i class="form-control-feedback glyphicon glyphicon-lock"></i>
                 </div>  
                    
                <p><input type="checkbox"> Keep me logged in</p>
                <button type="submit" name="btnLogin" class="btn btn-lg btn-primary btn-block">Login</button>
                <p align="center">Don't have an account ? <a href="Register.jsp">Register here</a>.</p>     
            </form>          
        </section>
    </section>
</body>
</html>