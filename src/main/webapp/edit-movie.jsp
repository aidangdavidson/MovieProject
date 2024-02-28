<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Selected Movie</title>

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
	
	
	input[type=text] {
		  padding: 0;
		  height: 30px;
		  position: relative;
		  left: 0;
		  outline: none;
		  border: 1px solid;
		  border-color: black;
		  font-size: 16px;
	}

</style>
</head>
<body>
<div class="container">
	<form action="editMovieServlet" method="post">
    <h2>Please enter Length as total Whole Minutes (ex 93)</h2>
    <h2>Please enter Rating as decimal, max 5.0 (ex 4.3)</h2><br>
    	<label for="movieTitle">Title:</label><br>
	    <input type="text" id="movieTitle" name="movieTitle" value="${movieToEdit.movieTitle}"><br>
	    <label for="movieGenre">Genre:</label><br>
	    <input type="text" id="movieGenre" name="movieGenre" value="${movieToEdit.movieGenre}"><br>
	    <label for="movieLength">Length:</label><br>
	    <input type="text" id="movieLength" name="movieLength" value="${movieToEdit.movieLength}"><br>
	    <label for="movieRating">Rating:</label><br>
	    <input type="text" id="movieRating" name="movieRating" value="${movieToEdit.movieRating}"><br><br>
	    <input type="hidden" name="id" value="${movieToEdit.movieId}">
	    <input type="submit" value="Update Movie" class="submitButton">
</form>
</div>
</body>
</html>