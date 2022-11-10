

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAOClass implements UserDAO {
    private Connection conn = ConnectionManager.getConnection();

    public List<User> getAllUsers(){
        List<User> usersList = new ArrayList<User>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                "SELECT * FROM user_login"
            );

            while(rs.next()) {
                usersList.add( new User(
                    rs.getInt("user_id"),
                    rs.getString("full_name"),
                    rs.getString("password"),
		    rs.getString("user_name")
                ));
            }
            
            rs.close();
            stmt.close();

            return usersList;

        } catch(SQLException e) {
            e.printStackTrace();
        } 

        return null;
    }

    public User getUserById(int userId) {
		try {
			PreparedStatement pstmt = conn.prepareStatement
					("SELECT * FROM user_login WHERE user_id = ?");
			pstmt.setInt(1, userId);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			User user = new User(
                		rs.getInt("user_id"),
                    		rs.getString("full_name"),
                    		rs.getString("password"),
		    		rs.getString("user_name")
            		);
			
			return user;
			
		} catch (SQLException e) {
			System.out.println("User with id = " + userId + " not found.");
		}

        return null;
    }

    public User getUserByUsername(String name) {
		try {
			PreparedStatement pstmt = conn.prepareStatement
					("SELECT * FROM user_login WHERE user_name = ?");
			pstmt.setString(1, name);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			User user = new User(
				rs.getInt("user_id"),
                  	 	rs.getString("full_name"),
                   	 	rs.getString("password"),
		   	 	rs.getString("user_name")
           		 );
			
            		rs.close();
           		pstmt.close();

			return user;
			
		} catch (SQLException e) {
			System.out.println("User with username = " + name + " not found.");
		}

        return null;
    }

    public List<String> getShowsCompleted(int id) {
        List<String> completedShows = new ArrayList<String>();

        try {
            PreparedStatement pstmt = conn.prepareStatement(
                "SELECT user_id, user_show.tv_id, show_name, show_prog FROM user_show " +
                "LEFT JOIN TVShow ON TVShow.tv_id = user_show.tv_id " +
                "WHERE user_show.user_id = ?"
            );
		
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                if (rs.getInt("show_prog") == 3) 
                    completedShows.add(rs.getString("show_name"));
            }

            rs.close();
            pstmt.close();    
            
            return completedShows;
            
        } catch(SQLException e) {
    		System.out.println("User with id = " + id + " not found.");
    		e.printStackTrace();
        }

        return null;
    }

    public List<String> getShowsInProgress(int id) {
        List<String> inProgressShows = new ArrayList<String>();

        try {
            PreparedStatement pstmt = conn.prepareStatement(
                "SELECT user_id, user_show.tv_id, show_name, show_prog FROM user_show " +
                "LEFT JOIN TVShow ON TVShow.tv_id = user_show.tv_id " +
                "WHERE user_show.user_id = ?"
            );
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                if (rs.getInt("show_prog") == 2) 
                    inProgressShows.add(rs.getString("show_name"));
            }

            rs.close();
            pstmt.close();    
            
            return inProgressShows;
            
        } catch(SQLException e) {
    		System.out.println("User with id = " + id + " not found.");
    		e.printStackTrace();
        }

        return null;
    }

    public List<String> getShowsNotCompleted(int id) {
        List<String> notCompletedShows = new ArrayList<String>();

        try {
            PreparedStatement pstmt = conn.prepareStatement(
                "SELECT user_id, user_show.tv_id, show_name, show_prog FROM user_show " +
                "LEFT JOIN TVShow ON TVShow.tv_id = user_show.tv_id " +
                "WHERE user_show.user_id = ?"
            );
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                if (rs.getInt("show_prog") == 1) 
                    notCompletedShows.add(rs.getString("show_name"));
            }

            rs.close();
            pstmt.close();    
            
            return notCompletedShows;
            
        } catch(SQLException e) {
    		System.out.println("User with id = " + id + " not found.");
    		e.printStackTrace();
        }
        return null;
    }
    
    public boolean addUser(User user) {
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                "INSERT INTO user_login(user_id, full_name, user_name, password) "
                + "VALUES(?, ?, ?, ?)"
            );
            pstmt.setInt(1, user.getUserId());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getUsername());
            pstmt.setString(4, user.getPassword());

            int i = pstmt.executeUpdate();

            pstmt.close();

            if (i > 0) 
                return true;
            else 
                return false;

        } catch(SQLException e) {
    		System.out.println("User already exists.");
    		e.printStackTrace();
        }

        return false;
    }

    public boolean deleteUser(int id) {
        try {
            boolean success = false;

            PreparedStatement pstmt = conn.prepareStatement(
                "DELETE FROM user_login WHERE user_id = ?"
            );

            pstmt.setInt(1, id);

            int i = pstmt.executeUpdate();
            pstmt.close();

            if (i > 0)
                success = true;
            else 
                success = false;
            if (success) {
                PreparedStatement pstmt2 = conn.prepareStatement(
                    "DELETE FROM user_show WHERE user_id = ?"
                );

                pstmt2.setInt(1, id);

                int j = pstmt2.executeUpdate();
                pstmt2.close();

                if (j > 0)
                    return true;
                else 
                    return false;
            }

            return false;

        } catch(SQLException e) {
    		System.out.println("User does NOT exist.");
    		e.printStackTrace();
        }

        return false;
    }

    public boolean updateUserPassword(User user) {
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                "UPDATE user_login SET password = ? WHERE user_id = ?"
            );
            pstmt.setString(1, user.getPassword());
            pstmt.setInt(2, user.getUserId());

            int i = pstmt.executeUpdate();
            pstmt.close();
            
            if(i > 0)
                return true;
            else
                return false;

        } catch(SQLException e) {
    		System.out.println("User with id = " + user.getUserId() + " not found.");
    		e.printStackTrace();
        }

        return false;
    }

    public boolean updateUserProgress(User user, int tv_id, int progress) {
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                "UPDATE user_show SET show_prog = ? " +
                "WHERE user_id = ? AND tv_id = ?"
            );

            pstmt.setInt(1, progress);
            pstmt.setInt(2, user.getUserId());
            pstmt.setInt(3, tv_id);

            int i = pstmt.executeUpdate();
            pstmt.close();

            if (i > 0)
                return true;
            else   
                return false;

        } catch(SQLException e) {
    		System.out.println("User with id = " + user.getUserId() + " or TV Show with id = " 
    				+ tv_id + " not found.");
    		e.printStackTrace();
        }

        return false;
    }

    public boolean updateUserProgress(User user, String show_name, int progress) {
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                "SELECT * FROM TVShow WHERE show_name = ?"
            );
            
            pstmt.setString(1, show_name);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            int tv_id = rs.getInt("tv_id");

            if (!(tv_id > 0))
                return false;
            
            rs.close();
            pstmt.close();

            PreparedStatement pstmt2 = conn.prepareStatement(
                "UPDATE user_show SET show_prog = ? " +
                "WHERE user_id = ? AND tv_id = ?"
            );

            pstmt2.setInt(1, progress);
            pstmt2.setInt(2, user.getUserId());
            pstmt2.setInt(3, tv_id);

            int i = pstmt2.executeUpdate();
            pstmt2.close();

            if (i > 0)
                return true;
            else   
                return false;

        } catch(SQLException e) {
    		System.out.println("User with id = " + user.getUserId() + " or TV Show with name = " 
    				+ show_name + " not found.");
    		e.printStackTrace();
        }

        return false;
    }
    
    public int getNumCompleted(User user) {
    	int count = 0;
    	
    	try {
    		PreparedStatement pstmt = conn.prepareStatement(
    				"SELECT * FROM user_show WHERE show_prog = ? AND user_id = ?"
    		);
    		pstmt.setInt(1, 3);
    		pstmt.setInt(2, user.getUserId());
    		ResultSet rs = pstmt.executeQuery();
    		
    		while(rs.next()) {
    			count++;
    		}
    		
    		rs.close();
    		pstmt.close();
    		
    		return count;
    		
    	} catch(SQLException e) {
    		System.out.println("User with id = " + user.getUserId() + " not found.");
    		e.printStackTrace();
    	}
    	
    	return -1;
    }
    
    public int getNumInProgress(User user) {
    	int count = 0;
    	
    	try {
    		PreparedStatement pstmt = conn.prepareStatement(
    				"SELECT * FROM user_show WHERE show_prog = ? AND user_id = ?"
    		);
    		pstmt.setInt(1, 2);
    		pstmt.setInt(2, user.getUserId());
    		ResultSet rs = pstmt.executeQuery();
    		
    		while(rs.next()) {
    			count++;
    		}
    		
    		rs.close();
    		pstmt.close();
    		
    		return count;
    		
    	} catch(SQLException e) {
    		System.out.println("User with id = " + user.getUserId() + " not found.");
    		e.printStackTrace();
    	}
    	
    	return -1;
    }
    
    public int getNumNotCompleted(User user) {
    	int count = 0;
    	
    	try {
    		PreparedStatement pstmt = conn.prepareStatement(
    				"SELECT * FROM user_show WHERE show_prog = ? AND user_id = ?"
    		);
    		pstmt.setInt(1, 1);
    		pstmt.setInt(2, user.getUserId());
    		ResultSet rs = pstmt.executeQuery();
    		
    		while(rs.next()) {
    			count++;
    		}
    		
    		rs.close();
    		pstmt.close();
    		
    		return count;
    		
    	} catch(SQLException e) {
    		System.out.println("User with id = " + user.getUserId() + " not found.");
    		e.printStackTrace();
    	}
    	
    	return -1;
    }
}
