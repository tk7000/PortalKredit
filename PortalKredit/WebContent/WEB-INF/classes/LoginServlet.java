

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import classes.Client;
import classes.Controller;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Loginservlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    @Resource(name = "jdbc/exampleDS")
	private DataSource ds1;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession(true);
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");
		boolean st = false;

		//TODO: Move the method to a utility class and call it authenticate
		st = Controller.authenticate(userID, password, ds1, session);
		
		if(st) {
			session.setAttribute("userID", userID);
			switch((Controller.Type)session.getAttribute("type")){
			case client:
				session.setAttribute("user", Controller.getClientInfo(userID, ds1));
				response.sendRedirect(request.getContextPath() + "/client/accounts");
				break;
			case banker:
				session.setAttribute("user", Controller.getBankerInfo(userID, ds1));
				response.sendRedirect(request.getContextPath() + "/banker/ViewClients");
				break;
			case admin:
				session.setAttribute("user", Controller.getAdminInfo(userID, ds1));
				response.sendRedirect(request.getContextPath() + "/admin/AdminFrontpage");
				break;
			default:
				break;
			}
			
		} else {
			request.setAttribute("logingStatus", "Wrong userID or Password");
			request.setAttribute("userID", userID);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
			request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

}
