package daos;

import connection.ConnectionMaker;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public static void loginCheck(String password, String username) throws SQLException {

        Connection connection= ConnectionMaker.getConnection();
        PreparedStatement ps = connection.prepareStatement("select user_name from user_login where password=?;");
        ps.setString(1, password);
        ResultSet rs=ps.executeQuery();
        String Checkedpassword=rs.getString(1);
        //return User();
    }
    public static void CreateAccount(){}


}
