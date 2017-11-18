package DAO_improved;

import java.sql.*;

public class UserDAO {
	private ConnMaker connMaker;
	
	public UserDAO(ConnMaker connMaker){
		this.connMaker = connMaker; 
		/* ConnMaker는 인터페이스 타입으로 다른 디비와 커낵션 방법을 사용할 클래스들은 이 인터페이스를 구현한다.*/
	}
	
	public int addUser(UserDTO user){ 
		try {
			Connection c = connMaker.makeConnection();
			/* makeConnection은 추상메소드로, 인터페이스를 구현하는 클래스에서 독자적으로 생성하는 커낵션 객체를 리턴한다. */
			PreparedStatement state = c.prepareStatement("insert into User(name, password) values(?,?)");
			state.setString(1, user.getName());
			state.setString(2, user.getPassword());
			
			int result = state.executeUpdate(); //INSERT, UPDATE, DELETE 메소드.
			state.close();
			connMaker.closeConnection(c);
			return result;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	
	}
	
	public UserDTO getUserById(String id) throws ClassNotFoundException, SQLException{
		Connection c = connMaker.makeConnection();
		PreparedStatement state = c.prepareStatement("select * from User where id = ?");
		state.setString(1, id);
		ResultSet result = state.executeQuery();
		result.next();
		
		UserDTO user = new UserDTO();
		user.setId(result.getString("id"));
		user.setName(result.getString("name"));
		user.setPassword(result.getString("password"));
		
		state.close();
		result.close();
		connMaker.closeConnection(c);
		
		return user;
	}
	
	public void deleteUser(String id) throws ClassNotFoundException, SQLException{
		Connection c = connMaker.makeConnection();
		PreparedStatement state = c.prepareStatement("delete from User where id = ?");
		state.setString(1, id);
		
		state.executeUpdate();
		
		state.close();
		connMaker.closeConnection(c);
	}
	
	public void updateUserName(String id, String name) throws ClassNotFoundException, SQLException{
		Connection c = connMaker.makeConnection();
		PreparedStatement state = c.prepareStatement("update User set name = ? where id = ?");
		state.setString(1, name);
		state.setString(2, id);
		state.executeUpdate();
		
		state.close();
		connMaker.closeConnection(c);
	}
}
