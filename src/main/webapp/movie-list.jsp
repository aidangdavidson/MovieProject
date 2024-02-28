<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Movies</title>
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
	  	margin-top: 10px;
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
	
	table{
		border-collapse: collapse;
		margin: 5px;
		padding: 5px;
	}
	
	th, td {
        border: 1px solid;
        padding: 8px;
    }

</style>
</head>
<body>
<div class="container">
	<h2>Movies in the List</h2>
	<form method = "post" action = "navigationServlet">
		<table>
			<c:forEach items = "${requestScope.allMovies }" var = "currentMovie">
				<tr>
					<td><input type = "radio" name = "id" value = "${currentMovie.movieId }"></td>
					<td><b>Title:</b> ${currentMovie.movieTitle }  </td>
					<td><b>Genre:</b> ${currentMovie.movieGenre }  </td>
					<td><b>Length:</b> ${currentMovie.movieLength } mins  </td>
					<td><b>Rating:</b> ${currentMovie.movieRating } / 5.0</td>
				</tr>
			</c:forEach>
		</table>
		<input type = "submit" value = "add" name = "userChoiceForMovie">
		<input type = "submit" value = "edit" name = "userChoiceForMovie">
		<input type = "submit" value = "delete" name = "userChoiceForMovie">
	</form>
	<a href = "index.jsp"><button class="submitButton">Return to Start</button></a>
	</div>
</body>
</html>