package user;

import java.sql.*;

public class UserDaoSqlite implements UserDao {

	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			throw new Error(e);
		}
	}

	protected Connection conn;
	public UserDaoSqlite( String userFilePath ) throws SQLException {

		String jdbcUrl = "jdbc:sqlite:"+userFilePath;
		// TODO : complete JDBC URL and initialize a connection.
		this.conn = DriverManager.getConnection(jdbcUrl);
	}

	@Override
	public void add(User user, String password) {

		// TODO : create a user
		try {
			conn.setAutoCommit(false);
			Statement st = conn.createStatement();
			st.executeUpdate("INSERT INTO users VALUES ('"+user.getId()+"', '"+user.getFirstname()+"', '"+user.getLastname()+"', '"+user.getEmail()+"', '"+password+"' )");
			conn.commit();
		} catch (SQLException e) {
			System.out.println("[CREATE] ["+user.toString()+"] : "+e.getMessage());
		}
	}

	@Override
	public void update(User user, String password) {
		// TODO : update user information in DB
		try {
			conn.setAutoCommit(false);
			Statement st = conn.createStatement();
			st.executeUpdate("UPDATE users SET firstname = '"+user.getFirstname()+"' , lastname = '"+user.getLastname()+"', email = '"+user.getEmail()+"', password = '"+password+"' WHERE id = "+user.getId());
			conn.commit();
		} catch (SQLException e) {
			System.out.println("[UPDATE] ["+user.toString()+"] : "+e.getMessage());
		}
	}

	@Override
	public User find(long id) {
		User user = new User();
		// TODO : get user data by its ID and map to User object 
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * from users where id = "+id);
			user.setId(rs.getLong("id"));
			user.setFirstname(rs.getString("firstname"));
			user.setLastname(rs.getString("lastname"));
			user.setEmail(rs.getString("email"));
		} catch (SQLException e) {
			System.out.println("[FIND] ["+id+"] : "+e.getMessage());
		}
		return user;	
	}

	@Override
	public User findByEmail(String email) {
		// TODO : get user data by its ID and map to User object 
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT id from users where email = '"+email+"'");
			return this.find(rs.getLong(1));
		} catch (SQLException e) {
			System.out.println("[FINDBYEMAIL] ["+email+"] : "+e.getMessage());
		}
		return null;
	}

	@Override
	public long checkPassword(String email, String password) {
		// TODO : get user id that match, return -1 if none
		if(email.contains("@")) {
			try {
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("SELECT id from users where email = '"+email+"' AND password = '"+password+"'");
				if(!rs.isClosed())
					return rs.getLong(1);
			} catch (SQLException e) {
				System.out.println("[CHECKPASSWORD] ["+email+"] ["+password+"] : "+e.getMessage());
			}
		}else {
			System.out.println("[CHECKPASSWORD] ["+email+"] : email non valide.");
		}
		return -1;
		
	}

	@Override
	public void delete(long id) {
		// TODO : delete a user that match this ID
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("DELETE FROM users WHERE id = "+id);
		}catch (SQLException e) {
			System.out.println("[DELETE] ["+id+"] : "+e.getMessage());
		}
	}

	@Override
	public long exists(String email) {
		// TODO : check if user with that mail exists
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT id FROM users where email = '"+email+"'");
			if(!rs.isClosed()) 
				return rs.getLong(1);
		}catch (SQLException e) {
			System.out.println("[EXISTS] ["+email+"] : "+e.getMessage());
		}
		return -1;
	}



}
