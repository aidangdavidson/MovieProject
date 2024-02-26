package controller;

import java.io.IOException;
import java.time.LocalDate;
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
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		MovieHelper mh = new MovieHelper();
		String studioName = request.getParameter("studioName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		LocalDate ld;
		
		try {
			
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
			
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		String[] selectedMovies = request.getParameterValues("allMoviesToAdd");
		List<Movie> selectedMoviesInList = new ArrayList<Movie>();
		
		if (selectedMovies != null && selectedMovies.length > 0) {
			
			for(int i = 0; i < selectedMovies.length; i++) {
				
				Movie c = mh.searchForMovieByID(Integer.parseInt(selectedMovies[i]));
				selectedMoviesInList.add(c);
				
			}
			
		}
		
		Studio studioN = new Studio (studioName, ld);
		MovieListDetails mld = new MovieListDetails(studioName, studioN);
		
		mld.setListOfMovies(selectedMoviesInList);
		ListDetailsHelper slh = new ListDetailsHelper();
		slh.insertNewListDetails(mld);
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
