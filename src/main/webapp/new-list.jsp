<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a New List</title>
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

	input[type=text] {
	  padding: 0;
	  height: 30px;
	  position: relative;
	  left: 0;
	  outline: none;
	  border: 1px solid;
	  border-color: black;
	  font-size: 16px;
	  margin-top: 10px;
	}
	
	select {
        width: 50%;
        padding: 10px;
        font-size: 16px;
        border: 1px solid;
        border-radius: 4px;
        box-sizing: border-box;
        font-family:Arial;
    }
    
</style>
</head>
<body>
<div class="container">
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
		<input type = "submit" value = "Create Studio and Add Movies" class="submitButton">
	</form>
	<a href = "index.jsp"><button class="linkButton">Add New Movies Instead</button></a>
</div>
</body>
</html>