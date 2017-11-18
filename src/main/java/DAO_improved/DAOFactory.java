package DAO_improved;

public class DAOFactory {
	
	public UserDAO userDao(){
		ConnMaker connMaker = new RedConnMaker();
		UserDAO userDao = new UserDAO(connMaker);
		return userDao;
	}
}
