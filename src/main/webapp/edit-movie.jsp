<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Selected Movie</title>
</head>
<body>
	<form action = "editMovieServlet" method = "post">
		<br /><h2>Please enter Length as total Whole Minutes (ex 93)</h2>
		<h2>Please enter Rating as decimal, max 5.0 (ex 4.3)</h2>
		<br /><br />
		Title: <input type = "text" name = "movieTitle" value = "${movieToEdit.movieTitle }"><br />
		Genre: <input type = "text" name = "movieGenre" value = "${movieToEdit.movieGenre }"><br />
		Length: <input type = "text" name = "movieLength" value = "${movieToEdit.movieLength }"><br />
		Rating: <input type = "text" name = "movieRating" value = "${movieToEdit.movieRating }">
		<input type = "hidden" name = "id" value = "${movieToEdit.movieId }">
		<br /><br />
		<input type = "submit" value = "Update Movie">
	</form>
</body>
</html>