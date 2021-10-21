<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/js/app.js"></script>

<title>Spring Boot</title>



</head>
<body>
  <%@ include file="header.jsp" %>
<div class="well"><h1 class="wellh1">Enter data to add department</h1></div>

  <div class="container">
  <form:form method="POST"  action="add-submit" modelAttribute="department" name="department_form" id="department_form" class="form-horizontal">
             
   <div class="form-group row">
  <form:label class="col-sm-2 col-form-label" path="name">Name:</form:label>
  <div class="col-sm-5">
  <form:input class="form-control" name="name" type="text" id="name" path="name" />
  </div>
  </div>
  

             
   <div class="form-group row">
    <label class="col-sm-2 col-form-label"></label>
    <div class="col-sm-2">
    <input type="submit" id="submit_button" class="btn btn-primary mb-2 sub_button" value="submit" />
    </div>
    
    <label class="col-sm-1 col-form-label" style="margin-left: 40px;"></label>
    <div class="col-sm-0">
<a href="/" class="btn btn-danger mb-2 sub_button" role="button" >Cancel</a>   
 </div>
</div>
         
        </form:form>
  </div>
<%@ include file="footer.jsp" %>
 
</body>
</html>