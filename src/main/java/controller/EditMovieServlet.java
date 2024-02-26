package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Movie;

/**
 * Servlet implementation class EditMovieServlet
 */
@WebServlet("/editMovieServlet")
public class EditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		MovieHelper dao = new MovieHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Movie movieToUpdate = dao.searchForMovieByID(tempId);
		
		movieToUpdate.setMovieTitle(request.getParameter("movieTitle"));
		movieToUpdate.setMovieGenre(request.getParameter("movieGenre"));
		movieToUpdate.setMovieLength(Integer.valueOf(request.getParameter("movieLength")));
		movieToUpdate.setMovieRating(Double.valueOf(request.getParameter("movieRating")));
		
		dao.updateMovie(movieToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllMoviesServlet").forward(request, response);
		
	}

}
