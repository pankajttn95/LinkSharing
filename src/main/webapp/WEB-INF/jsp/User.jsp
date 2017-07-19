
<%@ taglib prefix="border" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 14/7/17
  Time: 1:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/css/bootstrapvalidator.min.css"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">




    <script>
        $(document).ready(function() {
            $('#registeration_form').bootstrapValidator({
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    fname: {
                        validators: {
                            stringLength: {
                                min: 2,
                            },
                            notEmpty: {
                                message: 'Please enter your first name'
                            }
                        }
                    },
                    lname: {
                        validators: {
                            stringLength: {
                                min: 2,
                            },
                            notEmpty: {
                                message: 'Please enter your last name'
                            }
                        }
                    },
                    email: {
                        validators: {
                            notEmpty: {
                                message: 'Please enter your email address'
                            },
                            emailAddress: {
                                message: 'Please enter a valid email address'
                            }
                        }
                    },
                    password: {
                        validators: {
                            identical: {
                                field: 'confirmPassword',
                                message: 'Confirm your password below'
                            }
                        }
                    },
                    confirmPassword: {
                        validators: {
                            identical: {
                                field: 'password',
                                message: 'The password are not same'
                            }
                        }
                    }


                }
            })

        });
    </script>

    <style>
        .btn{
            float:right;
            width:110px;
            height:25px;
            padding-bottom:10px;
            border: solid black 2px;
            background-color:#c9cacc;
            font-color:black;
        }
        .form-control{
            float: right;
            max-width: 60%;
            height:30px;
        }
        label{
            font-size:14px;
            font-weight:bold;
        }
        .panel-body{
            padding-left: 3%;
            padding-right: 3%;
        }
        .pic-class{
            width:80px;
            height:90px;
            border:solid 2px;
            border-color:#c9cacc;
        }
        .dropdown{
            float: right;
        }
        .stylish-input-group .input-group-addon{
            background: white !important;

        }
        .stylish-input-group {
            border-right:0;
            box-shadow:0 0 0;
            border-color:#ccc;
            border: solid black 2px;
            border-radius:20px;
            width:250px;

        }
        .stylish-input-group button{
            border:0;
            background:transparent;

        }

        .headdiv{
            border-radius:25px;
            border-color:black;
            padding:20px;
            margin:20px;
            border:solid;
            height:100px;
        }
        .insidehead{
            border-top-right-radius:10px;
            border-top-left-radius:10px;
            border-width:2px;
            border-color: black;
            padding:25px;
            background-color:#c9cacc;
            height:14px;
            margin-top:-15px;
            margin-right:-15px;
            margin-left:-15px;

        }

        .insidediv{
            border:solid;
            margin:5px;
            border-color:black;
            border-top-right-radius:10px;
            border-top-left-radius:10px;
        }
        .insidediv{

            padding:15px;

        }
    </style>
</head>
<body>

<div class="page-header headdiv">
    <div class="col-md-8 col-xs-12 col-"> <h1><a href="#"><u>Link Sharing</u></a></h1></div>
    <span class="col-md-4 col-xs-12"><span class="input-group ">
            <div class="input-group stylish-input-group">
                   <span class="input-group-addon" style="border-radius:20px; border: white 0;">
                        <button type="submit">
                            <span class="glyphicon glyphicon-search"></span>
                        </button>
                    </span>
                    <input type="text"  style= "width: 200px; border: white 0; margin-top:4px;margin-right:4px;"placeholder="Search" >
               <span class="input-group-addon" style="border-radius:20px; border: white 0;">
                        <button type="submit">
                            <span class="glyphicon glyphicon-remove-sign"></span>
                        </button>
                    </span>
                </div>
      </span>
      </span>
</div>
</div>

<div class="container">

    <div class="col-sm-6 col-md-7 outsidediv">
        <div class="row insidediv ">
            <div class="page-header insidehead" ><strong>Recent Shares</strong></div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-2">
                        <img class="pic-class" src="http://weekendwarriors.se/assets/img/defaultavatar.jpg";>
                    </div>
                    <div class="col-md-10">
                        <a href="#">Uday Pratap Singh </a>
                        <font size=2px color=grey> @uday 5 mins</font>
                        <a href="#" style="float: right; padding-right: 15px;">Grails</a>

                        <p>
                            We are a digital technology company providing end-to-end product development services.
                            We leverage the power of experience design, cutting-edge engineering and cloud to build
                            disruptive web and mobile products and enable digital transformation for businesses.
                        </p>
                        <i class="fa fa-facebook-square" style="font-size:20px"></i>
                        <i class="fa fa-twitter" style="font-size:20px"></i>
                        <i class="fa fa-google-plus" style="font-size:20px"></i>
                        <a href="#" style="float: right; padding-right:5%;"><u>View Post</u></a>
                    </div>
                </div>

            </div>
            <br>
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-2">
                        <img class="pic-class" src="http://weekendwarriors.se/assets/img/defaultavatar.jpg";>
                    </div>
                    <div class="col-md-10">
                        <a href="#">Uday Pratap Singh </a>
                        <font size=2px color=grey> @uday 10 mins</font>
                        <a href="#" style="float: right; padding-right: 15px;">Grails</a>

                        <p>
                            We are a digital technology company providing end-to-end product development services.
                            We leverage the power of experience design, cutting-edge engineering and cloud to build
                            disruptive web and mobile products and enable digital transformation for businesses.

                        </p>
                        <i class="fa fa-facebook-square" style="font-size:20px"></i>
                        <i class="fa fa-twitter" style="font-size:20px"></i>
                        <i class="fa fa-google-plus" style="font-size:20px"></i>
                        <a href="#" style="float: right; padding-right:5%;"><u>View Post</u></a>
                    </div>

                </div>

            </div>
        </div>
        <div class="row insidediv">
            <div class="page-header insidehead" ><strong>Top Posts</strong>
                <div class="dropdown">
                    <button class=" btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" style="padding:2px; background-color:white; ">
                        Today
                        <span class="glyphicon glyphicon-chevron-down" style=" border:black ;border-left-style: solid; height:22px; float:right;"></span>
                    </button>
                    <ul class="dropdown-menu" >
                        <li><a href="#" >Today</a></li>
                        <li><a href="#" >1 Week</a></li>
                        <li><a href="#" >1 Month</a></li>
                        <li><a href="#" >1 Year</a></li>
                    </ul>
                </div></div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-2">
                        <img class="pic-class" src="http://weekendwarriors.se/assets/img/defaultavatar.jpg";>
                    </div>
                    <div class="col-md-10">
                        <a href="#">Uday Pratap Singh </a>
                        <font size=2px color=grey> @uday 21 July 2014</font>
                        <a href="#" style="float: right; padding-right: 15px;">Grails</a>

                        <p>
                            We are a digital technology company providing end-to-end product development services.
                            We leverage the power of experience design, cutting-edge engineering and cloud to build
                            disruptive web and mobile products and enable digital transformation for businesses.
                        </p>
                        <i class="fa fa-facebook-square" style="font-size:20px"></i>
                        <i class="fa fa-twitter" style="font-size:20px"></i>
                        <i class="fa fa-google-plus" style="font-size:20px"></i>
                        <a href="#" style="float: right; padding-right:5%;"><u>View Post</u></a>
                    </div>
                </div>
            </div>
        </div> </div>
    <div class="col-sm-6 col-md-5 outsidediv">
        <div class="row insidediv">
            <div class="page-header insidehead" ><strong>Login</strong></div>
            <div class="panel-body">
                <form action="/login" method="get">
                    <div class="form-group">
                        <label for="usr">Email/Userame:*</label>
                        <input type="text" class="form-control" name="usremail" style="border:solid black;" placeholder="Enter email/username" id="usr">
                    </div>
                    <br>
                    <div class="form-group">
                        <label for="pwd">Password:*</label>
                        <input type="password" class="form-control" id="pwd" name="password" style="border:solid black;" placeholder="Enter password">
                    </div>

                <a href="/forgetpass"><u>Forgot Password</u></a>
                    <button type="submit" class="btn  form-control "><strong><font color=black>Login</font></strong></button>
                </form>
            </div>

        </div>
        <div class="row insidediv">
            <div class="page-header insidehead" ><strong>Register</strong></div>
            <div class="panel-body">
                <form action="/register" method="post" id="registeration_form" <%--enctype="multipart/form-data"--%>>
                    <div class="form-group">
                        <label for="usrf">First Name:*</label>
                        <input type="text" class="form-control" name="fname" placeholder="First name"  style="border:solid black;" id="usrf">
                    </div>
                    <br>
                    <div class="form-group">
                        <label for="usrl">Last Name:*</label>
                        <input type="text" class="form-control" name="lname" placeholder="Last name" style="border:solid black;" id="usrl">
                    </div>
                    <br>
                    <div class="form-group">
                        <label>Email:*</label>
                        <input type="text" class="form-control" name="email"  id="usre" placeholder="Enter email" style="border:solid black;">                    </div>
                    <br>
                    <div class="form-group">
                        <label for="usr">Username:*</label>
                        <input type="text" class="form-control" name="username" placeholder="Enter username" id="usr" style="border:solid black;">
                    </div>
                    <br>
                    <div class="form-group">
                        <label for="pwd">Password:*</label>
                        <input type="password" class="form-control" name="password" placeholder="Enter password" id="pwd" style="border:solid black;">
                    </div>
                    <br>
                    <div class="form-group">
                        <label for="cpwd">Confirm Password:*</label>
                        <input type="password" class="form-control" name="confirmPassword" placeholder="Confirm Password" id="cpwd" style="border:solid black;">
                    </div>
                    <br>
                    <div class="form-group">
                        <label for="pic">Photo:* </label>
                        <span class="input-group-addon form-control" style=" border: white 0; width:240px; border:solid black;">
                        <input type="file" name="file" style="float:right; border:solid black; margin:-4px;">
                            Browse
                        </input>
                    </span>
                    </div>
                    <br>
                    <button type="submit" class="btnSubmit btn form-control" ><strong><font color=black>Register</font></strong></button>
                </form>
            </div>

        </div>

    </div>
</div>

</body>

</html>
