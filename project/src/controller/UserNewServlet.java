package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserNewServlet
 */
@WebServlet("/UserNewServlet")
public class UserNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
HttpSession session=request.getSession();


		if(session.getAttribute("userInfo")==null) {

			response.sendRedirect("loginServlet");
			return;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserNew.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String password1=request.getParameter("password1");
		String username=request.getParameter("username");
		String birthday=request.getParameter("birthday");

		UserDao userDao = new UserDao();
		User user = userDao.findByLoginInfo(loginId,password);
		if (user != null) {

			request.setAttribute("errMsg", "入力された内容が正しくありません。");


			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserNew.jsp");
			dispatcher.forward(request, response);
			return;
		}
		if(!password.equals(password1)) {

			request.setAttribute("errMsg", "入力された内容が正しくありません。");


			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserNew.jsp");
			dispatcher.forward(request, response);
			return;
		}
		if(loginId.length()==0||password.length()==0||password1.length()==0||username.length()==0||birthday.length()==0) {

			request.setAttribute("errMsg", "入力された内容が正しくありません。");


			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserNew.jsp");
			dispatcher.forward(request, response);
			return;
		}

		userDao.UserNewInfo(loginId,password,username,birthday);
		response.sendRedirect("UserListServlet");


}
}

