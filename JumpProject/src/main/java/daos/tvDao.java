package daos;

import connection.ConnectionMaker;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class tvDao implements crudDaos<User> {

    public static tvDao getShows() throws SQLException {

        Connection connection = ConnectionMaker.getConnection();
        PreparedStatement ps = connection.prepareStatement("SELECT * from tvshowtracker.tvshow");
        ResultSet rs = ps.executeQuery();
        List<String> usersList = new ArrayList<String>();
        while (rs.next()) {
            usersList.add(rs.getString(2));

        }
        System.out.print("Available tv shows are: \n" + usersList + "\n ");
        rs.close();
        return null;
    }

    public HashMap<String, Integer> getShowsCompleted(User user) {
        HashMap<String, Integer> Showprogress = new HashMap<>();

        try {
            Connection connection = ConnectionMaker.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(
                    "SELECT * FROM user_show WHERE user_show.user_id = ?"
            );
            pstmt.setInt(1, user.getUser_id());

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Showprogress.put(rs.getString(3), rs.getInt(4));
                String showString = "";
                if (rs.getInt(4) == 100) {
                    showString = "Show Completed";
                } else if (rs.getInt(4) > 0) {
                    showString = "Still watching";
                } else {
                    showString = "Now yet started";
                }
                System.out.println("Show: [" + rs.getString(3) + "] Progress: [" + rs.getInt(4) + "] " + showString);
            }

            rs.close();
            pstmt.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Showprogress;
    }

    public String updateShowProgress(User user, int show_id, int show_progress) throws SQLException {
        try {
            Connection connection = ConnectionMaker.getConnection();
            PreparedStatement ps = connection.prepareStatement("Update  user_show set show_prog=? where user_id=? and tv_id=?");
            ps.setInt(1, show_progress);
            ps.setInt(2, user.getUser_id());
            ps.setInt(3, show_id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Your progress has been updated";
    }


    @Override
    public void save(User obj) {

    }

    @Override
    public void update(User obj) {

    }

    @Override
    public void delete(User obj) {

    }

    @Override
    public User getById(String id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}




