package user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/register")
public class RegisterServlet extends HttpServlet {
	
	private UserDao userDao;
	
	@Override
	public void init() throws ServletException {
		// TODO : initialize user DAO
		try {
			this.userDao = new UserDaoSqlite("C:\\Utilisateurs\\a694672\\Documents\\E-Services\\JEE\\mooc_jee_spring\\week2\\exo201\\WEB-INF\\users.db");
		} catch (SQLException e) {
			System.out.println("[RegisterServlet] [INIT] : "+e.getMessage());
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO : create user using dao and redirect to login page
		throw new ServletException("not yet implemented");
	}

}
