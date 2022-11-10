package daos;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();
    public User getUserById(int userId);
    public User getUserByUsername(String name);
    public List<String> getShowsCompleted(int id);
    public List<String> getShowsInProgress(int id);
    public List<String> getShowsNotCompleted(int id);
    public boolean addUser(User user);
    public boolean deleteUser(int id);
    public boolean updateUserPassword(User user);
    public boolean updateUserProgress(User user, int tv_id, int progress);
    public boolean updateUserProgress(User user, String show_name, int progress);
    public int getNumCompleted(User user);
    public int getNumInProgress(User user);
    public int getNumNotCompleted(User user);
}
