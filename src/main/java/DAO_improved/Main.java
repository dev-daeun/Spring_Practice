package DAO_improved;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			/*UserDAO의 클라이언트인 Main에서 어떤 DB의 커낵션을 사용할 것인지 결정하고 DAO에 넘겨준다. 
			 *이것으로 DAO는 커낵션으로부터 독립되어 DAO와 커낵션 객체 클래스와의 의존성을 분리한다. */
			UserDAO userDAO = new DAOFactory().userDao();
			
			UserDTO user = new UserDTO();
			user.setId("2");
			user.setName("김지은");
			user.setPassword("momo2701");
			
			int addResult = userDAO.addUser(user);
			System.out.println("new added row : "+addResult);
			
			UserDTO selected = userDAO.getUserById("4");
			System.out.println("the user's name : "+selected.getName());
			
			
			userDAO.updateUserName("4", "김다은");
			UserDTO updated = userDAO.getUserById("4");
			System.out.println("the updated user's name : "+updated.getName());
			
			userDAO.deleteUser("4");
			System.out.println("4rd user deleted");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
