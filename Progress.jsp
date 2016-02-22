<html>
	<head>
		<%@ page language="java" %>
		<%@page import="java.util.*" %>
		<%@page import="java.io.*" %>
		<%@page import="java.text.*" %>
		<%@page import="javax.servlet.*" %>
		<%@page import="javax.servlet.http.*" %>
		<%@page import="com.mongodb.*"%>
		<%@page import="java.io.IOException"%>
	</head>
	<body background="/PizzaParty/images/cooking.jpg">

						<head>
						<title>Success</title>
						<table id ='headbg' cell spacing = '2' border = '2' style='width:100%'>
						<tr BGCOLOR='#FFAD00'>
						<td colspan ='50'>
						<h1><center>Item added in Menu</center></h1>
						<div align = 'Right' >

						</div>
						</td>
						</tr>
						<tr >

						<td  class='head' colspan='5'><center><a href='#' class ='anchorhead'>Weekly Deals</a></center></td>

						<td class='head' colspan='5'><center><a href='#' class ='anchorhead'>Contact Us</a></center></td>
						</tr>
						</table></center>
						<link rel='stylesheet' href='mystyles.css' type='text/css' />
						</head>
					
		<%
		String orderNumber = request.getParameter("orderNumber");
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db=null;
		db = mongo.getDB("PizzaParty");
		DBCollection myOrders = db.getCollection("myOrders");
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("orderNumberDB", orderNumber);
		DBCursor cursor = myOrders.find(searchQuery);
		String orderDate = null;
		long diffDays=0;
		Date d1 = null;
		Date d2 = null;
		int check=0;
		if(cursor.count() == 0){
		out.println("There are No existing orders");
		}
		else{
			BasicDBObject obj = null;
			while (cursor.hasNext()) {
				obj = (BasicDBObject) cursor.next();
				orderDate = obj.getString("deliveryDateDB");
			}
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm");
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm");
			Date date = new Date();
			String today=dateFormat.format(date);
			Date date1 = new Date(orderDate);
			String past=dateFormat.format(date1);
			
			
			d1 = format.parse(past);
			d2 = format.parse(today);
			
			long diff = d1.getTime()- d2.getTime();
			diffDays = diff / ( 60 * 1000);
			
			
			String out1 = Long.toString(diffDays);
			check = Integer.parseInt(out1);
			/*if(check>15)
			{
				myOrders.remove(obj);
				out.println( "Your Order has been cancelled :)" );
			}
			else
			{
				out.println( "Your Order cannot be cancelled as the date exceeds our cancellation policy :(" );
			}	*/
			
			if(check>28){
				%>
				<table>
					<tr>
						<td> <img src="/PizzaParty/images/p1.jpg"/>
						</td>
						
					</tr>
				</table>
				<%
			}
			else if(check>20 && check<=28){
				%>
				<table>
					<tr>
						<td> <img src="/PizzaParty/images/p2.jpg"/>
						</td>
						
					</tr>
				</table>
				<%
			}
			else if(check>10 && check<=20){
				%>
				<table>
					<tr>
						<td> <img src="/PizzaParty/images/p3.jpg"/>
						</td>
						
					</tr>
				</table>
				<%
			}
			else if(check<=10 && check>5){
				%>
				<table>
					<tr>
						<td> <img src="/PizzaParty/images/p4.jpg"/>
						</td>
						
					</tr>
				</table>
				<%
			}
			else if(check<=5){
				%><center>
				<table>
					<tr>
						<td> <img src="/PizzaParty/images/p5.jpg"/>
						</td>
						<td>
						OUT FOR DELIVERY!!
						</td>
					</tr>
				</table>
				</center>
				<%
			}
			else {
				%><center>
				<table>
					<tr>
						<td> <img src="/PizzaParty/images/p1.jpg"/>
						</td>
						
					</tr>
				</table>
				</center>
				<%
			}
		}
		%>
		
	</body>
</html>