package daos;

import connection.ConnectionMaker;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import java.util.Random;

public class UserDao {
	private Connection connection = ConnectionMaker.getConnection();

    public void CreateAccount(String username, String Password) throws SQLException {
        Random rd = new Random();
        int x = rd.nextInt((10000 - 1) + 1);
        User user = new User(x, username, Password);
        PreparedStatement ps = connection.prepareStatement("INSERT INTO user_login(user_id,name,password) values(?,?,?)");
        ps.setInt(1, x);
        ps.setString(2, user.getUser_name());
        ps.setString(3, user.getUser_password());
        ps.executeUpdate();
    }


    public User loginCheck(String Username, String Password) throws SQLException {
        User VerifiedUser = null;
        
        try {
            PreparedStatement ps = connection.prepareStatement("select * from user_login where password=?");
            ps.setString(1, Password);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                try {
                	
                    VerifiedUser = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
                    System.out.println(VerifiedUser.getUser_id());
                    
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
            
            System.out.println("You are logged in");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return VerifiedUser;
    }
    
    public User getUserByUsername(String name) {
		try {
			PreparedStatement pstmt = connection.prepareStatement
					("SELECT * FROM user_login WHERE user_name = ?");
			pstmt.setString(1, name);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			User user = new User(
                rs.getInt("user_id"),
                rs.getString("user_name"),
				rs.getString("password")
            );
			
            rs.close();
            pstmt.close();

			return user;
			
		} catch (SQLException e) {
			System.out.println("User with username = " + name + " not found.");
		}

        return null;
    }
    
    
}