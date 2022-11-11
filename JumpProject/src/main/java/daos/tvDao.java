package daos;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.TvShow;
import connection.ConnectionMaker;
import java.util.HashMap;
import models.User;

public class tvDao implements crudDaos<User> {
    private static Connection conn = ConnectionMaker.getConnection();

    public List<String> getShows() throws SQLException {
    	
        PreparedStatement ps = conn.prepareStatement("SELECT * from tvshowtracker.tvshow");
        ResultSet rs = ps.executeQuery();
        List<String> usersList = new ArrayList<String>();
        while (rs.next()) {
            usersList.add(rs.getString(2));

        }
        
        System.out.print("Available tv shows are: \n" + usersList + "\n ");
        
        rs.close();
        ps.close();
        
        return usersList;
    }

    public TvShow getTvShowByName(String name) {
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                "SELECT * FROM TVShow WHERE show_name = ?"
            );
            pstmt.setString(1, name);

            ResultSet rs = pstmt.executeQuery();

            TvShow show = new TvShow(
                rs.getString("tv_id"),
                rs.getString("show_name")
            );

            rs.close();
            pstmt.close();

            return show;

        } catch(SQLException e) {

        }
        
        return null;
    }
        
    public static List<String> getShowsCompleted(User user) {
        HashMap<String, Integer> Showprogress = new HashMap<>();
        List<String> showProg = new ArrayList<String>();

        try {
            PreparedStatement pstmt = conn.prepareStatement(
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
                
                showProg.add("Show: [" + rs.getString(3) + "] Progress: [" + rs.getInt(4) + "] " + showString);
            }

            rs.close();
            pstmt.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return showProg;
    }
    
    public static int getNumShowsCompleted(User user) {
    	int count = 0;
    	
    	try {
            PreparedStatement pstmt = conn.prepareStatement(
            		"SELECT * FROM user_show WHERE user_show.user_id = ?"
            );
            pstmt.setInt(1, user.getUser_id());

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                if (rs.getInt(4) == 100) 
                    count++;
            }

            rs.close();
            pstmt.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    	
        return count;
    }
    
    public static int getNumShowsInProgress(User user) {
    	int count = 0;
    	
    	try {
            PreparedStatement pstmt = conn.prepareStatement(
            		"SELECT * FROM user_show WHERE user_show.user_id = ?"
            );
            
            pstmt.setInt(1, user.getUser_id());

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                if ((!(rs.getInt(4) == 100)) && (rs.getInt(4) > 0)) 
                    count++;
            }

            rs.close();
            pstmt.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    	
        return count;
    }
    
    public static int getNumShowsNotCompleted(User user) {
    	int count = 0;
    	
    	try {
            PreparedStatement pstmt = conn.prepareStatement(
            		"SELECT * FROM user_show WHERE user_show.user_id = ?"
            );
            pstmt.setInt(1, user.getUser_id());

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                if (!(rs.getInt(4) > 0)) 
                    count++;
            }

            rs.close();
            pstmt.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    	
        return count;
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