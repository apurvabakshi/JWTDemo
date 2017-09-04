package authenticate;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** * Servlet implementation class LoginServlet */
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		try {
			//System.out.println("In servlet");
			//	System.out.println(request.getParameter("un")+request.getParameter("pw"));
			if(request.getParameter("un").equalsIgnoreCase("admin") && request.getParameter("pw").equalsIgnoreCase("password")){
				//response.sendRedirect("HomePage.jsp");
				RequestDispatcher view = request.getRequestDispatcher("HomePage.jsp");
				view.forward(request, response);
			}
			else
				response.sendRedirect("ErrorPage.jsp");
			/*
			 * UserBean user = new UserBean();
			 * user.setUserName(request.getParameter("un"));
			 * user.setPassword(request.getParameter("pw")); user =
			 * UserDAO.login(user); if (user.isValid()) { HttpSession session =
			 * request.getSession(true);
			 * session.setAttribute("currentSessionUser",user);
			 * response.sendRedirect("userLogged.jsp"); //logged-in page } else
			 * response.sendRedirect("invalidLogin.jsp"); //error page
			 */

		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}
}