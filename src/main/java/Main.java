import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDao();
		User user = new User();
		
		user.setId("1");
		user.setName("김다은");
		user.setPassword("momo2701");
		try {
			userDao.add(user);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
