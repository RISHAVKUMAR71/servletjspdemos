package validationofuserlogin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginServlet")
public class validationofuserloginTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public validationofuserloginTest() {
		super();

		// TODO Auto-generated constructor stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (Connection connection = DriverManager.getConnection("login:mysql://localhost/mydb", "root",
				"mysqljavafsd2528967"); Statement statement = connection.createStatement();) {

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// by using request.getParameter, it is matched
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		// To verify whether entered data is printing correctly or not
		System.out.println("emailId.." + emailId);
		System.out.println("password.." + password);

		if (emailId != null && emailId.equalsIgnoreCase("admin@gmail.com") && password != null
				&& password.equalsIgnoreCase("admin")) {

			HttpSession httpSession = request.getSession();
			// By setting the variable in session, it can be forwarded
			httpSession.setAttribute("emailId", emailId);
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}
	}
}
