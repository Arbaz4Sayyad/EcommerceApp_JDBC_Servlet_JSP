<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page
    import="com.shashi.service.impl.*, com.shashi.service.*,com.shashi.beans.*,java.util.*,javax.servlet.ServletOutputStream,java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bill.css">
<title>Bill</title>
</head>
<body>
    <br><br>
	<h3>Order Bill</h3>

<hr>
<div class="left-div"><h3>Name: <%= session.getAttribute("username") %></h3></div>
<div class="right-div-right"><h3>Email:  <!-- Retrieve user email from session or database --></h3></div>
<div class="right-div"><h3>Mobile Number: <!-- Retrieve user mobile number from session or database --></h3></div>  

<div class="left-div"><h3>Order Date: <%= new java.util.Date() %></h3></div>
<div class="right-div-right"><h3>Payment Method: Credit Card</h3></div>
<div class="right-div"><h3>Expected Delivery: <!-- Calculate expected delivery date based on the current date --></h3></div> 

<div class="left-div"><h3>Transaction Id: <!-- Generate a unique transaction ID --></h3></div>
<div class="right-div-right"><h3>City: <!-- Retrieve user city from session or database --></h3></div> 
<div class="right-div"><h3>Address: <!-- Retrieve user address from session or database --></h3></div> 

<div class="left-div"><h3>State: <!-- Retrieve user state from session or database --></h3></div>
<div class="right-div-right"><h3>Country: <!-- Retrieve user country from session or database --></h3></div>  

<hr>


    
    <br>
    
<table id="customers">
<h3>Product Details</h3>
  <tr>
    <th>S.No</th>
    <th>Product Name</th>
    <th>category</th>
    <th>Price</th>
    <th>Quantity</th>
     <th>Sub Total</th>
  </tr>
  
  <tr>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
     <td></td>
  </tr>
  <tr>

</table>
<h3>Total: <!-- Display total amount paid --></h3>
<!-- <a href="continueShopping.jsp"><button class="button left-button">Continue Shopping</button></a> -->
<a onclick="window.print();"><button class="button right-button">Print</button></a>
<br><br><br><br>


</body>
</html>