<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>Forgot Password</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.css"
          type="text/css" rel="stylesheet">
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-md-12 col-xs-12" style="margin-top: 150px;">
            <div class="panel panel-default" style="margin-left: 300px;margin-right: 300px; border: 2px solid;">
                <div class="panel-heading text-center" style="border-bottom: 2px solid;">
                    <b>Password Change</b>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" method="post" action="/changepass"  id="passwordUpdation">


                        <div class="form-group" >
                            <label class="control-label col-md-4" for="reg_password">Email*</label>
                            <div class="col-md-8">
                                <input type="text" name="email"  class="form-control" placeholder="Enter Email"  >
                            </div>
                        </div>
                        <div class="form-group" >
                            <label class="control-label col-md-4" for="reg_password">Password*</label>
                            <div class="col-md-8">
                                <input type="password" name="password" id="reg_password" class="form-control" placeholder="Enter password"  >
                            </div>
                        </div>
                        <div class="form-group" >
                            <label class="control-label col-md-4" for="confirm_password">Confirm Password*</label>
                            <div class="col-md-8">
                                <input type="password" name="confirm_password" id="confirm_password" class="form-control" placeholder="Confirm password" onkeyup="checkPass(); return false;"  >
                            </div>
                        </div>


                        <button type="submit" name="register" id="updatePassword" class="btn btn-default pull-right" style="margin-left: 280px;margin-top: 15px;">Update</button>

                    </form>

                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>