package daos;

import java.sql.SQLException;

import models.User;

public interface UserDaoInterface {
	public void CreateAccount(String username, String password) throws SQLException;
	public User loginCheck(String Username, String Password) throws SQLException;
	public User getUserByUsername(String name);
}
