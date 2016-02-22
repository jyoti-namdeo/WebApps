<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="constants.Const,dao.MongoConnector,logic.CustomPizza_Singleton,com.mongodb.AggregationOutput, com.mongodb.BasicDBObject, com.mongodb.DB, com.mongodb.DBCollection,
 com.mongodb.DBCursor,
 com.mongodb.DBObject,
 com.mongodb.MongoException,constants.*,com.mongodb.BasicDBList"%>
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
		//Creating a DB connection
		DB db = MongoConnector.getInstance();
		DBCollection myReviews = db.getCollection(Const.DB_COLLECTION_CustomizePizza);
		BasicDBObject query = new BasicDBObject();
		DBObject match = null;
		DBObject groupFields = null;
		DBObject group = null;
		DBObject projectFields = null;
		DBObject project = null;

		AggregationOutput aggregate = null;
		// This is a place where you are createing your own query
		groupFields = new BasicDBObject("_id", 0);
		groupFields.put("_id", "$category");
		groupFields.put("name", new BasicDBObject("$push", "$name"));
		groupFields.put("description", new BasicDBObject("$push", "$description"));
		groupFields.put("imageName", new BasicDBObject("$push", "$imageName"));
		groupFields.put("price", new BasicDBObject("$push", "$price"));

		group = new BasicDBObject("$group", groupFields);

		projectFields = new BasicDBObject("_id", 0);
		projectFields.put("category", "$_id");
		projectFields.put("name", "$name");
		projectFields.put("description", "$description");
		projectFields.put("imageName", "$imageName");
		projectFields.put("price", "$price");
		project = new BasicDBObject("$project", projectFields);
		// aggreatagating all  the results
		aggregate = myReviews.aggregate(group, project);
		int count = 0;
	%>

	<form action='ViewCustomOrder.jsp' method='get'>
		<div class="container">
			<div class="row jumbotron well">
				<div class="row">
					<h1 class="center" style="text-align: center;">Customize your
						Pizza</h1>
				</div>
			</div>
			<div class="row ">


				<%
					//   you are getting all the data from  the query  displaying out in the output
					for (DBObject result : aggregate.results()) {
						BasicDBObject bobj = (BasicDBObject) result;
						BasicDBList name = (BasicDBList) bobj.get("name");
						BasicDBList description = (BasicDBList) bobj.get("description");
						BasicDBList imageName = (BasicDBList) bobj.get("imageName");
						BasicDBList price = (BasicDBList) bobj.get("price");

						out.println("<div class='row well'>");
						out.println("<h3 class ='center'>" + result.get("category") + "</h3><hr/>");
						while (count < name.size()) {
				%>
				<div class="col-md-6">
					<div class="col-sm-2 center" style='margin-top: 5px;'>
						<input type="radio" name='<%=result.get("category")%>'
							value='<%=name.get(count) + "_" + price.get(count)%>'>
					</div>
					<div class="col-sm-2">
						<img src="images/image_customPizza/<%=imageName.get(count)%>">
					</div>
					<div class="col-sm-2"><%=name.get(count)%></div>
					<div class="col-sm-4"><%=description.get(count)%></div>

					<%
						count++;
					%>
				</div>
				<%
					}
				%>
			</div>
			<%
				count = 0;

				}
			%>
			<div class="navbar well ">
				<input type="submit" class="btn btn-lg btn-default" name="submit"
					value="Continue with this customization" />
			</div>

		</div>
		

	</form>
	<div class="navbar well ">
		<form action="MainPage">
			<input type="submit" class="btn btn-lg btn-default" name="back"
				value="Back" />
		</form>
	</div>
</body>
</html>