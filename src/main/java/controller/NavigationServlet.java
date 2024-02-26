package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Movie;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
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
		String userAction = request.getParameter("userChoiceForMovie");
		String path = "/viewAllMoviesServlet";
		
		if (userAction.equals("add")) {
			
			path = "/index.jsp";
			
		} else if (userAction.equals("edit")) {
			
			try {
				
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Movie movieToEdit = dao.searchForMovieByID(tempId);
				request.setAttribute("movieToEdit", movieToEdit);
				path = "/edit-movie.jsp";
				
			} catch (NumberFormatException e) {
				
				
				
			}
			
		} else if (userAction.equals("delete")) {
			
			try {
				
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Movie movieToDelete = dao.searchForMovieByID(tempId);
				dao.deleteMovie(movieToDelete);
				
			} catch (NumberFormatException e) {
				
				
				
			}				
			
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
		
	}

}
