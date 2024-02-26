<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Movie</title>
</head>
<body>
	<form action = "addMovieServlet" method = "post">
		<br /><h2>Please enter Length as total Whole Minutes (ex 93)</h2>
		<h2>Please enter Rating as decimal, max 5.0 (ex 4.3)</h2>
		<br /><br />
		Title: <input type = "text" name = "movieTitle"><br />
		Genre: <input type = "text" name = "movieGenre"><br />
		Length: <input type = "text" name = "movieLength"><br />
		Rating: <input type = "text" name = "movieRating">
		<br /><br />
		<input type = "submit" value = "Add Movie">
	</form><br />
	<a href = "viewAllMoviesServlet">View All Movies</a><br />
	<a href = "viewAllListsServlet">View All Lists</a><br />
	<a href = "addMoviesForListServlet">Create a New List</a>
</body>
</html>