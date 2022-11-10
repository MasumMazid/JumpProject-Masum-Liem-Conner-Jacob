package daos;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();
    public User getUserById();
    public User getUserByUsername();
    public boolean addUser();
    public boolean deleteUser();
    public boolean updateUser();
}
