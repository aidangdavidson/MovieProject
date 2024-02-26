<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Movies</title>
</head>
<body>
	<h2>Movies in the List</h2>
	<form method = "post" action = "navigationServlet">
		<table>
			<c:forEach items = "${requestScope.allMovies }" var = "currentMovie">
				<tr>
					<td><input type = "radio" name = "id" value = "${currentMovie.movieId }"></td>
					<td><b>Title:</b> ${currentMovie.movieTitle } | </td>
					<td><b>Genre:</b> ${currentMovie.movieGenre } | </td>
					<td><b>Length:</b> ${currentMovie.movieLength } mins | </td>
					<td><b>Rating:</b> ${currentMovie.movieRating } / 5.0</td>
				</tr>
			</c:forEach>
		</table>
		<input type = "submit" value = "add" name = "userChoiceForMovie">
		<input type = "submit" value = "edit" name = "userChoiceForMovie">
		<input type = "submit" value = "delete" name = "userChoiceForMovie">
	</form>
	<a href = "index.jsp">Return to Start</a>
</body>
</html>