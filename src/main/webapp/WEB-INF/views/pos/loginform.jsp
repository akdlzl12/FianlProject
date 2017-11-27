<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>POS :: Login</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="/resources/js/pos/loginform.js"></script>
	<link rel="stylesheet" href="/resources/css/pos/loginform.css">
</head>
<body>
   	<div class="alert alert-danger text-center" style="display:none;">
   		<strong>WARNING!</strong> <span>${param.error }</span>
   	</div>
   	
    <div class="container well">
    
        <div id="image-box" class="row">
            <img src="/resources/images/pos/cinema.jpg" style="width: 990px; height: 280px;"/>
        </div>
        
        <div id="login-form-box" class="row">
            <form method="post" action="login.esc" class="form-horizontal">
            	<input type="hidden" name="posId" value="1"/>
            	
            	<div class="col-sm-9">
	                <div class="input-group">
	                    <span class="input-group-btn">
	                        <button type="button" id="user-span-btn" class="btn btn-boots">
	                            <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
	                        </button>                        
	                    </span>
	                    <input type="text" name="empId" id="id" class="form-control"/>
	                </div>
	                
	                <div class="input-group">
	                    <span class="input-group-btn">
	                        <button type="button" id="user-span-btn" class="btn btn-boots">
	                            <span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
	                        </button>                        
	                    </span>
	                    <input type="password" name="empPwd" id="pwd" class="form-control"/>
	                </div>
            	</div>
                
				<div class="col-sm-3">
					<input type="image" src="/resources/images/pos/login.jpg" class="img-circle" style="width: 150px;"/>
				</div>
            </form>
        </div>
    </div>
</body>
</html>