<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Of Movies By Studio</title>
</head>
<body>
	<form method = "post" action = "listNavigationServlet">
		<table>
			<c:forEach items = "${requestScope.allLists }" var = "currentList">
				<tr>
					<td><input type = "radio" name = "id" value = "${currentList.listId }"></td>
					<td><h2>${currentList.listName }</h2></td>
				</tr>
				<tr>
					<td colspan = "3"><b>Studio:</b> ${currentList.studio.studioName }</td>
				</tr>
								<tr>
					<td colspan = "3"><b>Founded:</b> ${currentList.studio.foundingDate }</td>
				</tr>
				<c:forEach var = "listVal" items = "${currentList.listOfMovies }">
					<tr>
						<td></td>
						<td colspan = "3">${listVal.movieTitle } | ${listVal.movieGenre } | ${listVal.movieLength } | ${listVal.movieRating }</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
			<input type = "submit" value = "edit" name = "doThisToList">
			<input type = "submit" value = "delete" name = "doThisToList">
			<input type = "submit" value = "add" name = "doThisToList">
	</form>
	<a href = "addMoviesForListServlet">Create a New List</a>
	<a href = "index.jsp">Insert a New Movie</a>
</body>
</html>