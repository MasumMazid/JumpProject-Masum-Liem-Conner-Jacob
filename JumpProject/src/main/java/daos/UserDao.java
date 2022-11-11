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


    public static void CreateAccount(String username, String Password) throws SQLException {
        Random rd = new Random();
        int x = rd.nextInt((10000 - 1) + 1);
        User user = new User(x, username, Password);
        Connection connection = ConnectionMaker.getConnection();
        PreparedStatement ps = connection.prepareStatement("INSERT INTO user_login(user_id,name,password) values(?,?,?)");
        ps.setInt(1, x);
        ps.setString(2, user.getUser_name());
        ps.setString(3, user.getUser_password());
        ps.executeUpdate();
    }


    public User loginCheck(String Username, String Password) throws SQLException {
        User VerifiedUser = null;
        try {
            Connection connection = ConnectionMaker.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from user_login where password=?");
            ps.setString(1, Password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                try {
                    VerifiedUser = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
                    System.out.println(VerifiedUser.getUser_id());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            System.out.println("You are logged in");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return VerifiedUser;
    }
}




