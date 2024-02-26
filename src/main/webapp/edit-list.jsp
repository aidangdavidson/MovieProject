<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit A List</title>
</head>
<body>
	<form action= "editListDetailsServlet" method = "post">
		<input type = "hidden" name = "id" value = "${listToEdit.listId }">
		<b>Studio Name:</b> <input type = "text" name = "listName" value = "${listToEdit.listName }"><br />
		<b>Available Movies:</b><br />
			<select name = "allMoviesToAdd" multiple size = "6">
				<c:forEach items = "${requestScope.allMovies }" var = "currentMovie">
					<option value = "${currentMovie.movieId }">
					${currentMovie.movieId } | ${currentMovie.movieTitle } | ${currentMovie.movieGenre } | ${currentMovie.movieLength } | ${currentMovie.movieRating }
					</option>
				</c:forEach>
			</select>
			<br />
			<input type = "submit" value = "Edit List and Add Items">
	</form>
	<a href = "index.jsp">Add New Movies Instead</a>
</body>
</html>