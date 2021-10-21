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

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/js/app.js"></script>

<title>Spring Boot</title>
</head>
<body>

<%@include file="header.jsp" %>
 
<div class="well"><h1 class="wellh1">Department added</h1></div>

  <div class="container">
    <table
    class="table center table-striped table-hover table-condensed table-bordered">
    <tr class="danger">
     <th>Department Id</th>
     <th>Department Name</th>
    </tr>
     <tr class="success">
      <td>${department.dId}</td>
      <td>${department.name}</td>   
     </tr>
   </table>
  </div>
<%@ include file="footer.jsp" %>
</body>
</html>