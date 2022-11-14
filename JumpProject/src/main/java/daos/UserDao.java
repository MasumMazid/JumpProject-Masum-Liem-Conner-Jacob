package daos;

import connection.ConnectionMaker;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class UserDao implements UserDaoInterface {
	private Connection connection = ConnectionMaker.getConnection();

    public void CreateAccount(String username, String password) throws SQLException {
        Random rd = new Random();
        int x = rd.nextInt((10000 - 1) + 1);
        
        PreparedStatement ps = connection.prepareStatement("INSERT INTO user_login(user_id,user_name,password) values(?,?,?)");
        ps.setInt(1, x);
        ps.setString(2, username);
        ps.setString(3, password);
        
        ps.executeUpdate();
        
        ps.close();
        
        
        PreparedStatement pstmt = connection.prepareStatement(
        		"INSERT INTO user_show(user_id, tv_id, show_name, show_prog) VALUES(?,1,'Star Wars',0)"
        );
        pstmt.setInt(1, x);
        pstmt.executeUpdate();
        
        pstmt = connection.prepareStatement(
        		"INSERT INTO user_show(user_id, tv_id, show_name, show_prog) VALUES(?,2,'Game of Thrones',0)"
        );
        pstmt.setInt(1, x);
        pstmt.executeUpdate();
        
        pstmt = connection.prepareStatement(
        		"INSERT INTO user_show(user_id, tv_id, show_name, show_prog) VALUES(?,3,'The Boys',0)"
        );
        pstmt.setInt(1, x);
        pstmt.executeUpdate();
        
        pstmt = connection.prepareStatement(
        		"INSERT INTO user_show(user_id, tv_id, show_name, show_prog) VALUES(?,4,'Re:Zero',0)"
        );
        pstmt.setInt(1, x);
        pstmt.executeUpdate();
        
        pstmt = connection.prepareStatement(
        		"INSERT INTO user_show(user_id, tv_id, show_name, show_prog) VALUES(?,5,'The Witcher',0)"
        );
        pstmt.setInt(1, x);
        pstmt.executeUpdate();
        
        pstmt = connection.prepareStatement(
        		"INSERT INTO user_show(user_id, tv_id, show_name, show_prog) VALUES(?,6,'Gundam',0)"
        );
        pstmt.setInt(1, x);
        pstmt.executeUpdate();
        
        pstmt = connection.prepareStatement(
        		"INSERT INTO user_show(user_id, tv_id, show_name, show_prog) VALUES(?,7,'Castlevania',0)"
        );
        pstmt.setInt(1, x);
        pstmt.executeUpdate();
        
        pstmt = connection.prepareStatement(
        		"INSERT INTO user_show(user_id, tv_id, show_name, show_prog) VALUES(?,8,'Spiderman',0)"
        );
        pstmt.setInt(1, x);
        pstmt.executeUpdate();
        
        pstmt = connection.prepareStatement(
        		"INSERT INTO user_show(user_id, tv_id, show_name, show_prog) VALUES(?,9,'Lucifer',0)"
        );
        pstmt.setInt(1, x);
        pstmt.executeUpdate();
        
        pstmt = connection.prepareStatement(
        		"INSERT INTO user_show(user_id, tv_id, show_name, show_prog) VALUES(?,10,'Wall-E',0)"
        );
        pstmt.setInt(1, x);
        pstmt.executeUpdate();
        
        pstmt.close();
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