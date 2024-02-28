<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Of Movies By Studio</title>

<style>
	body{
		font-family:Arial;
		}
	
	.container {
		max-width: 600px;
		border-radius: 5px;
		border-style: solid;
		padding: 20px;
		margin: 20px auto;
		border-radius: 5px;
	}
	
	.submitButton {
		background-color: #1E90FF;
  		border: none;
	    color: white;
	    padding: 15px;
	    text-align: center;
	    display: inline-block;
	    font-size: 16px;
	    cursor: pointer;
	    border-radius: 4px;
	}
	
	form input[type="submit"] {
	    background-color: #1E90FF;
	    border: none;
	    color: white;
	    padding: 15px;
	    text-align: center;
	    font-size: 16px;
	    cursor: pointer;
	    border-radius: 4px;
	    text-transform: capitalize;
	}
	
	.linkButton {
		background-color: #1E90FF;
	    border: none;
	    color: white;
	    padding: 15px;
	    text-align: center;
	    display: inline-block;
	    font-size: 16px;
	    cursor: pointer;
	    border-radius: 4px;
	    margin-top: 10px;
	}
	
</style>
</head>
<body>
<div class="container">
	<form method = "post" action = "listNavigationServlet">
		<table>
			<c:forEach items = "${requestScope.allLists }" var = "currentList">
				<tr>
					<td><input type = "radio" name = "listId" value = "${currentList.listId }"></td>
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
			<input type = "submit" value = "edit" name = "doThisToList" class="submitButton">
			<input type = "submit" value = "delete" name = "doThisToList" class="submitButton">
			<input type = "submit" value = "add" name = "doThisToList" class="submitButton">
	</form>
	<a href = "addMoviesForListServlet"><button class="linkButton">Create a New List</button></a>
	<a href = "index.jsp"><button class="linkButton">Insert a New Movie</button></a>
</div>
</body>
</html>