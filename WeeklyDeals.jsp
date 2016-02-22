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
	<body>
			<fieldset>
			<form action ='/PizzaParty/ShoppingCartOperationsServlet' method ='get'>
			<input type='hidden' name='name' value="WeeklyCombo1">
					<input type='hidden' name='desc' value="Pizza, Desert and Drink">
					<input type='hidden' name='id' value="1000">
					<input type='hidden' name='flag' value='none'>
					<input type='hidden' name='price' value="15">
					<input type='hidden' name='quantity' value=1>
					
			<table>
				<br>
				<tr>
					<td>
						<img id='background' height='150' width='300' src='/PizzaParty/images/cheese.jpg'>
						<br>
						<center><b>Cheese Pizza</b></center>
					</td>
					<td>
						<img id='background' height='150' width='300' src='/PizzaParty/images/knot.jpg'>
						<br>
						<center><b>Cinnamon Knots</b></center>
					</td>
					<td>
						<img id='background' height='150' width='300' src='/PizzaParty/images/pepsi.jpg'>
						<br>
						<center><b>Pepsi</b></center>
					</td>
				</tr>
				
				<tr>
					<td>
						<center><b>Price : $12</b></center>
					</td>
					<td>
						<center><b>Price : $10</b></center>
					</td>
					<td>
						<center><b>Price : $3</b></center>
					</td>
				</tr>
				<br>
				<tr>
					<td colspan="2">
						<font size= "5" color="red"><center><b>Special Offer Price : <strike>$25 </strike>$15</b></center></font>
					</td>
					<td >
						<input type="submit" name = 'action' value = 'Place Order' style="background-color:#ffad00;width:130px;height:40px " >
					</td>					
				</tr>
			</table>
			</form>
			</fieldset>
			<fieldset>
			<form action ='/PizzaParty/ShoppingCartOperationsServlet' method ='get'>
			<input type='hidden' name='name' value="WeeklyCombo2">
					<input type='hidden' name='desc' value="Pizza, Desert and Bread">
					<input type='hidden' name='id' value="1001">
					<input type='hidden' name='flag' value='none'>
					<input type='hidden' name='price' value="15">
					<input type='hidden' name='quantity' value=1>
			<table>
				<tr>
					<td>
						<img id='background' height='150' width='300' src='/PizzaParty/images/pizza1.jpg'>
						<br>
						<center><b>Pepperoni Pizza</b></center>
					</td>
					<td>
						<img id='background' height='150' width='300' src='/PizzaParty/images/brownie.jpg'>
						<br>
						<center><b>Double Chocolate Chip Brownie</b></center>
					</td>
					<td>
						<img id='background' height='150' width='300' src='/PizzaParty/images/garlicKnots.jpg'>
						<br>
						<center><b>Garlic Knots</b></center>
					</td>
				</tr>
				<tr>
					<td>
						<center><b>Price : $10</b></center>
					</td>
					<td>
						<center><b>Price : $7</b></center>
					</td>
					<td>
						<center><b>Price : $5</b></center>
					</td>
				</tr>
				
				<br>
				<tr>
					<td colspan="2">
						<font size= "5" color="red"><center><b>Special Offer Price : <strike>$22 </strike>$15</b></center></font>
					</td>
					<td >
						<input type="submit" name = 'action' value = 'Place Order' style="background-color:#ffad00;width:130px;height:40px " >
					</td>					
				</tr>
			</table>
			</form>
			</fieldset>
			<fieldset>
			<form action ='/PizzaParty/ShoppingCartOperationsServlet' method ='get'>
			<input type='hidden' name='name' value="WeeklyCombo3">
					<input type='hidden' name='desc' value="Pizza, Bread and Drink">
					<input type='hidden' name='id' value="1002">
					<input type='hidden' name='flag' value='none'>
					<input type='hidden' name='price' value="18">
					<input type='hidden' name='quantity' value=1>
			<table>
			<br>
				<tr>
					<td>
						<img id='background' height='150' width='300' src='/PizzaParty/images/spinach.jpg'>
						<br>
						<center><b>Spinach Pizza</b></center>
					</td>
					<td>
						<img id='background' height='150' width='300' src='/PizzaParty/images/cheeseSticks.jpg'>
						<br>
						<center><b>Cheese Sticks</b></center>
					</td>
					<td>
						<img id='background' height='150' width='300' src='/PizzaParty/images/dietPepsi.jpg'>
						<br>
						<center><b>Diet Pepsi</b></center>
					</td>
				</tr>
				<tr>
					<td>
						<center><b>Price : $14</b></center>
					</td>
					<td>
						<center><b>Price : $7</b></center>
					</td>
					<td>
						<center><b>Price : $4</b></center>
					</td>
				</tr>
				<br>
				<tr>
					<td colspan="2">
						<font size= "5" color="red"><center><b>Special Offer Price : <strike>$25 </strike>$18</b></center></font>
					</td>
					<td >
						<input type="submit" name = 'action' value = 'Place Order' style="background-color:#ffad00;width:130px;height:40px " >
					</td>					
				</tr>
			</table>
			</form>
			</fieldset>
			<fieldset>
			<form action ='/PizzaParty/ShoppingCartOperationsServlet' method ='get'>
			<input type='hidden' name='name' value="WeeklyCombo4">
					<input type='hidden' name='desc' value="Pizza, Desert and Desert">
					<input type='hidden' name='id' value="1003">
					<input type='hidden' name='flag' value='none'>
					<input type='hidden' name='price' value="20">
					<input type='hidden' name='quantity' value=1>
			<table>
			<br>
				<tr>
					<td>
						<img id='background' height='150' width='300' src='/PizzaParty/images/garden.jpg'>
						<br>
						<center><b>Garden Fresh Pizza</b></center>
					</td>
					<td>
						<img id='background' height='150' width='300' src='/PizzaParty/images/cheeseSticks.jpg'>
						<br>
						<center><b>Cheese Sticks</b></center>
					</td>
					<td>
						<img id='background' height='150' width='300' src='/PizzaParty/images/honey.jpg'>
						<br>
						<center><b>Honey Chipotle Wings</b></center>
					</td>
				</tr>
				<br>
				<tr>
					<td>
						<center><b>Price : $13</b></center>
					</td>
					<td>
						<center><b>Price : $7</b></center>
					</td>
					<td>
						<center><b>Price : $7</b></center>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<font size= "5" color="red"><center><b>Special Offer Price : <strike>$27 </strike>$20</b></center></font>
					</td>
					<td >
						<input type="submit" name = 'action' value = 'Place Order' style="background-color:#ffad00;width:130px;height:40px " >
					</td>					
				</tr>
				<br>
			</table>
			</form>
			</fieldset>
			</body></html>

	</body>
</html>