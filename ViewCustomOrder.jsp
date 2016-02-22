<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>

<title>Customized Pizza</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body style="background-color: gray;">

	<%
		String ADD_INGREDIENTS = (String) request.getParameter("ADD INGREDIENTS");
		String CHOOSE_YOUR_SAUCE = (String) request.getParameter("CHOOSE YOUR SAUCE");
		String CHEESE_OR_NO_CHEESE = (String) request.getParameter("CHEESE OR NO CHEESE");
		String PICK_A_SIZE = (String) request.getParameter("PICK A SIZE");
		String CHOOSE_YOUR_CRUST = (String) request.getParameter("CHOOSE YOUR CRUST");

		double price_total = Double.parseDouble(ADD_INGREDIENTS.split("_")[1])
				+ Double.parseDouble(CHOOSE_YOUR_SAUCE.split("_")[1])
				+ Double.parseDouble(CHEESE_OR_NO_CHEESE.split("_")[1])
				+ Double.parseDouble(PICK_A_SIZE.split("_")[1])
				+ Double.parseDouble(CHOOSE_YOUR_CRUST.split("_")[1]);
		int price_int = (int)price_total;
		int customNumber = 0;
		if(session.getAttribute("customNumber")!=null){
			customNumber = (Integer)session.getAttribute("customNumber");
		}
		//int customNumber = (Integer)session.getAttribute("customNumber");
		//In customNumber  = Integer.parseInt(customNumber1);
		Integer custNum =0;
		if(customNumber==-1){
			session.setAttribute("customNumber",3000);
			custNum = 3000;
		}
		else {
			custNum = customNumber;
			custNum =custNum+1;
			session.setAttribute("customNumber", custNum);
		}
	%>

	<div class="container">
		<h2>The item that you have chosen</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Items</th>
					<th>Choice</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Ingredients</td>
					<td><%=ADD_INGREDIENTS.split("_")[0]%></td>
					<td><%=ADD_INGREDIENTS.split("_")[1]%></td>
				</tr>
				<tr>
					<td>Sauce</td>
					<td><%=CHOOSE_YOUR_SAUCE.split("_")[0]%></td>
					<td><%=CHOOSE_YOUR_SAUCE.split("_")[1]%></td>
				</tr>
				<tr>
					<td>Cheese/ No Cheese</td>
					<td><%=CHEESE_OR_NO_CHEESE.split("_")[0]%></td>
					<td><%=CHEESE_OR_NO_CHEESE.split("_")[1]%></td>
				</tr>
				<tr>
					<td>Base Size</td>
					<td><%=PICK_A_SIZE.split("_")[0]%></td>
					<td><%=PICK_A_SIZE.split("_")[1]%></td>
				</tr>
				<tr>
					<td>Crust chosen</td>
					<td><%=CHOOSE_YOUR_CRUST.split("_")[0]%></td>
					<td><%=CHOOSE_YOUR_CRUST.split("_")[1]%></td>
				</tr>

				<tr>
					<td>Total</td>
					<td></td>
					<td><%=price_total%></td>
				</tr>
				<tr>
					<td>
					<form action="/PizzaParty/ShoppingCartOperationsServlet" method="get">
					<input type='hidden' name='name' value="customizedPizza">
					<input type='hidden' name='desc' value="Its a custom pizza">
					<input type='hidden' name='id' value='<%=custNum %>'>
					<input type='hidden' name='flag' value='two'>
					<input type='hidden' name='price' value='<%=price_int%>'>
					<input type='hidden' name='quantity' value=1>
					<input type='hidden' name='action' value='Place Order'>
						<input type="submit" class="btn btn-lg btn-default" name="back"
							value="Add Cart" />
					</form>
					</td>
					<td>
					<form action="MainPage">
						<input type="submit" class="btn btn-lg btn-default" name="back"
							value="Back" />
					</form>
					</td>
				</tr>

			</tbody>
		</table>
	</div>
</body>
</html>