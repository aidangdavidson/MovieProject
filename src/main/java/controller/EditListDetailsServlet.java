package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Movie;
import model.MovieListDetails;
import model.Studio;

/**
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		
		ListDetailsHelper dao = new ListDetailsHelper();
		MovieHelper mh = new MovieHelper();
		StudioHelper sh = new StudioHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("listId"));
		MovieListDetails listToUpdate = dao.searchForMovieListDetailsById(tempId);
		
		String newListName = request.getParameter("listName");
		Studio newStudio = sh.findStudio(newListName);
		
		try {
			
			String[] selectedMovies = request.getParameterValues("allMoviesToAdd");
			List<Movie> selectedMoviesInList = new ArrayList<Movie>();
			
			for (int i = 0; i < selectedMovies.length; i++) {
				
				Movie movie = mh.searchForMovieByID(Integer.parseInt(selectedMovies[i]));
				selectedMoviesInList.add(movie);
				
			}
			
			listToUpdate.setListOfMovies(selectedMoviesInList);
			
		} catch (NullPointerException ex) {
			
			List<Movie> selectedMoviesInList = new ArrayList<Movie>();
			listToUpdate.setListOfMovies(selectedMoviesInList);
			
		}
		
		listToUpdate.setListName(newListName);
		dao.updateList(listToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		
	}

}
