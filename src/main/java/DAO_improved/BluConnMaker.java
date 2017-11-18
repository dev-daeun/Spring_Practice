package DAO_improved;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import configuration.Config;

public class BluConnMaker implements ConnMaker{
	/* ConnMaker 인터페이스를 구현한다. 추상메소드 makeConnection()을 구현한다. 여러 개의 디비와 제각각인 커낵션 생성 방법을 makeConnection에서 구현한다.*/
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection(Config.getDBurl(), Config.getDBuser(), Config.getDBpw());
		return c;
	}
	
	public void closeConnection(Connection c) throws ClassNotFoundException, SQLException{
		c.close();
	}

	public void closeConnection() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}
}
