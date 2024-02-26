<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a New List</title>
</head>
<body>
	<form action = "createNewListServlet" method = "post">
		<b>Studio Name:</b> <input type = "text" name = "studioName"><br />
		<b>Founding Date:</b> <input type = "text" name = "month" placeholder = "mm" size = "4"> / <input type = "text" name = "day" placeholder = "dd" size = "4"> / <input type = "text" name = "year" placeholder = "yyyy" size = "4">
		<br />
		Available Movies:<br />
		<select name ="allMoviesToAdd" multiple size = "6">
			<c:forEach items = "${requestScope.allMovies }" var = "currentMovie">
				<option value = "${currentMovie.movieId }">
					${currentMovie.movieId } | ${currentMovie.movieTitle } | ${currentMovie.movieGenre } | ${currentMovie.movieLength } | ${currentMovie.movieRating }
				</option>
			</c:forEach>
		</select>
		<br />
		<input type = "submit" value = "Create Studio and Add Movies">
	</form>
	<a href = "index.jsp">Add New Movies Instead</a>
</body>
</html>