import java.sql.*;

public class UserDao {
	public void add(User user) throws ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.jdbc.Driver");
		//주어진 스트링 파라미터에 해당하는 클래스를 가져온다.
		
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/Practice", "root", "momo2701");
		
		PreparedStatement ps = c.prepareStatement("insert into User(id, name, password) values(?,?,?)");
		
		//쿼리에 들어갈 값을 인덱스, 값 순서로 셋팅.
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());

		ps.executeUpdate();
		ps.close(); //쿼리 객체 해제
		c.close();//커낵션 객체 해제
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/Practice", "root", "momo2701");
		PreparedStatement ps = c.prepareStatement("select * from User where id = ?");
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next(); // rs 커서는 쿼리 결과의 앞 row에 위치. -> 다음 row에 위치하도록 옮겨줘야.
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		rs.close();
		ps.close();
		c.close();
		return user;
		
	}
}
