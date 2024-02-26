package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Movie;

/**
 * Servlet implementation class AddMovieServlet
 */
@WebServlet("/addMovieServlet")
public class AddMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Movie movie = new Movie();
		MovieHelper dao = new MovieHelper();
		
		movie.setMovieTitle(request.getParameter("movieTitle"));
		movie.setMovieGenre(request.getParameter("movieGenre"));
		movie.setMovieLength(Integer.valueOf(request.getParameter("movieLength")));
		movie.setMovieRating(Double.valueOf(request.getParameter("movieRating")));
		dao.addMovie(movie);
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

}
