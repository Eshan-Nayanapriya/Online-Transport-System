<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Confirmed</title>
<link rel="stylesheet" type="text/css" href="Css/header.css">
<link rel="stylesheet" type="text/css" href="Css/footer.css">
<style type="text/css">
  body {
    background-color: #f5f5f5;
    font-family: Arial, sans-serif;
    text-align: center;
  }

  .htt {
    color: #333;
    background-color: #2f9ce0;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
  }

  a {
    text-decoration: none;
  }

  a input[type="submit"] {
    background-color: #0e6195;
    color: #fff;
    border: none;
    padding: 10px 20px;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
  }

  a input[type="submit"]:hover {
    background-color: #130175;
  }
</style>
</head>
<body>
<%@ include file="header.jsp" %>
<%@ include file="navigation.jsp" %>
<br>
<br>

	<div class="htt"><h1>Order Confirmed</h1></div>
	<br><br><br><br><br><br>
	<a href="Rental.jsp"><input type="submit" name="submit" value="Back to Rental Page"></a>
	<br><br><br><br><br><br><br>
	<%@ include file="footer.jsp" %>
</body>
</html>
