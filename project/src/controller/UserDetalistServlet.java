package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserDetalistServlet
 */
@WebServlet("/UserDetalistServlet")
public class UserDetalistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetalistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId=request.getParameter("id");
		UserDao userdao = new UserDao();
		User UserList=userdao.UserDetalist(loginId);

		request.setAttribute("user", UserList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserDetalist.jsp");
		dispatcher.forward(request, response);
	}


		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.sendRedirect("UserListServlet");
	}


}
