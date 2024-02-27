package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MovieListDetails;

/**
 * Servlet implementation class ListNavigationServlet
 */
@WebServlet("/listNavigationServlet")
public class ListNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNavigationServlet() {
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
		String action = request.getParameter("doThisToList");
		
		if(action == null) {
			
			getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			
		} else if (action.equals("edit")) {
			
			try {
				
				Integer tempId = Integer.parseInt(request.getParameter("listId"));
				MovieListDetails listToEdit = dao.searchForMovieListDetailsById(tempId);
				request.setAttribute("listToUpdate", listToEdit);
				
				MovieHelper daoForMovies = new MovieHelper();
				request.setAttribute("allMovies", daoForMovies.showAllMovies());
				
				if (daoForMovies.showAllMovies().isEmpty()) {
					
					request.setAttribute("allMovies", " ");
					
				}
				
				getServletContext().getRequestDispatcher("/edit-list.jsp").forward(request, response);
				
			} catch (NumberFormatException ex) {
				
				System.out.println("Exception with edit");
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
				
			}
			
		} else if (action.equals("delete")) {
			
			try {
				
				Integer tempId = Integer.parseInt(request.getParameter("listId"));
				MovieListDetails listToDelete = dao.searchForMovieListDetailsById(tempId);
				dao.deleteList(listToDelete);
				
			} catch (NumberFormatException ex) {
				
				System.out.println("Exception with delete");
				
			} finally {
				
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
				
			}
			
		} else if (action.equals("add")) {
			
			getServletContext().getRequestDispatcher("/new-list.jsp").forward(request, response);
			
		}
	}

}
