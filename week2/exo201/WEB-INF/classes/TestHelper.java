import java.sql.Connection;
import java.sql.SQLException;

import user.UserDao;
import user.UserDaoSqlite;

public class TestHelper {
	
	private static Connection connection;
	
	private static class TestUserDao extends UserDaoSqlite {
		TestUserDao(String str) throws SQLException {
			super(str);
			TestHelper.connection = this.conn;
		}
	}
	
	
	private static TestUserDao dao = null;
	
	public static UserDao createUserDao() throws SQLException {
		if ( dao != null ) return dao;
		try {
		dao = new TestUserDao( "C:\\Utilisateurs\\a694672\\Documents\\E-Services\\JEE\\mooc_jee_spring\\week2\\exo201\\WEB-INF\\users.db" );
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return dao;
	}
	
	public static int updateDb(String sql) throws SQLException {
		
		if ( connection == null ) createUserDao();
		
		return connection
			.createStatement()
			.executeUpdate(sql);
	}
	
	public static Connection getConnection() {
		return connection;
	}
	
}
