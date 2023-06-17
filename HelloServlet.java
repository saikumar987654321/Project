package calculator;



	import java.io.IOException;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	@WebServlet("/HelloServlet")
	public class HelloServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// Retrieve user input from the form
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			// Perform user authentication
			boolean isAuthenticated = authenticateUser(username, password);

			if (isAuthenticated) {
				// Create a session for the user
				request.getSession().setAttribute("username", username);
				response.sendRedirect("calculator.jsp"); // Redirect to the calculator page
			} else {
				// Redirect back to the login page with an error message
				response.sendRedirect("hello.jsp?error=true");
			}
		}

		private boolean authenticateUser(String username, String password) {
			// Implement your authentication logic here using JDBC
			String url="jdbc:mysql://localhost:3306/teca40?user=root&password=12345";
			try  {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection(url);
				String sql = "SELECT * FROM student WHERE studentname = ? AND studentid = ?";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, username);
				statement.setString(2, password);
				ResultSet resultSet = statement.executeQuery();

				// If the result set has at least one row, the authentication is successful
				return resultSet.next();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	}



