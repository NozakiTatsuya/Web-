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
 * Servlet implementation class UserInformationServlet
 */
@WebServlet("/UserInformationServlet")
public class UserInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInformationServlet() {
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
		String loginId=request.getParameter("id");
		UserDao userdao = new UserDao();
		User UserList=userdao.UserDetalist(loginId);

		request.setAttribute("user", UserList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserInformation.jsp");
		dispatcher.forward(request, response);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String birthday=request.getParameter("birth_date");
		String password = request.getParameter("password");
		String password1 = request.getParameter("password1");
		String Id=request.getParameter("Id");




		if(name.equals ("")||birthday.equals ("")) {
			request.setAttribute("errMsg", "入力内容に誤りがあります。");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserInformation.jsp");
			dispatcher.forward(request, response);
			return;
		}if(!password.equals(password1)){
			request.setAttribute("errMsg", "入力内容に誤りがあります。");

			request.setAttribute("loginId",Id);
			request.setAttribute("name",name);
			request.setAttribute("birth_date",birthday);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserInformation.jsp");
			dispatcher.forward(request, response);
			return;
		}


		UserDao userDao = new UserDao();


		userDao.UserInformationInfo(name,password,birthday, Id);
		response.sendRedirect("UserListServlet");

	}



}
