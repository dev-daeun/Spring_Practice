package DAO_improved;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnMaker {
	Connection makeConnection() throws ClassNotFoundException, SQLException;
	void closeConnection(Connection c) throws ClassNotFoundException, SQLException;
}
