<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="height=1, width=1,initial-scale=1,user-scalable=1" />
    <title>Holiday Tracker</title>
    
    <link href="http://fonts.googleapis.com/css?family=Lato:100italic,100,300italic,300,400italic,400,700italic,700,900italic,900" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="Bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="css/styles.css" />
    
    <!-- Datepicker setup --> 
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>

      <script>
      $( function() {
            $('#datefrom').datepicker({
                dateFormat: 'dd/mm/yy',
                autoclose: true,
                todayHighlight: true,
                language: "en-GB",
                minDate: 0,
                onSelect: function(selected) {
                    $("#dateto").datepicker("option","minDate", selected)
                  }
            });
            
            $('#dateto').datepicker({
                dateFormat: 'dd/mm/yy',
                autoclose: true,
                todayHighlight: true,
                language: "en-GB",
                minDate: 0,
                onSelect: function(selected) {
                    $("#datefrom").datepicker("option","maxDate", selected)
                 }
            });
            
            $('#empnumber').keydown(function (e) {
                // Allow: backspace, delete, tab, escape, enter and .
                if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
                     // Allow: Ctrl+A, Command+A
                    (e.keyCode === 65 && (e.ctrlKey === true || e.metaKey === true)) || 
                     // Allow: home, end, left, right, down, up
                    (e.keyCode >= 35 && e.keyCode <= 40)) {
                         // let it happen, don't do anything
                         return;
                }
                // Ensure that it is a number and stop the keypress
                if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
                    e.preventDefault();
                }
            });
      });
      </script>
     
</head>
<body>

    <section class="container">
            <section class="login-form">
                <form method="POST"  action="Submit" role="login">
                    <img src="images/logo.png" class="img-responsive" alt="" style="height:70px;"/>
                    
                    <div class="form-group has-feedback has-feedback-left">
                    <input type="text" name="emp" placeholder="Employee's Full Name" required class="form-control input-lg" />
                    <i class="form-control-feedback glyphicon glyphicon-user"></i>
                    </div>  
                    
                    <div class="form-group has-feedback has-feedback-left">
                    <input type="text" id="empnumber" name="empnum" placeholder="Employee Number" required class="form-control input-lg" />
                    <i class="form-control-feedback glyphicon glyphicon-user"></i>
                    </div>  
                    
                    <div class="form-group has-feedback">
                    <input id="datefrom" type="text" name="startdate" placeholder="Date From" required class="date-picker form-control input-lg" />
                    <i class="form-control-feedback glyphicon glyphicon-calendar"></i>
                    </div>  
                    
                    <div class="form-group has-feedback">
                    <input id="dateto" type="text" name="enddate" placeholder="Date To" required class="date-picker form-control input-lg" />
                    <i class="form-control-feedback glyphicon glyphicon-calendar"></i>
                    </div>  
                    
                    <button type="submit" name="Submit" class="btn btn-lg btn-primary btn-block">Submit</button>
                    
                </form>
            </section>
    </section>

</body>
</html>