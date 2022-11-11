package models;

public class User {
    private int userId;
    private String user_name;
    private String user_password;
    private String user_userName;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return user_name;
    }

    public void setUserName(String user_name) {
        this.user_name = user_name;
    }

    public String getUserPassword() {
        return user_password;
    }

    public void setUserPassword(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_userName() {
        return user_userName;
    }

    public void setUser_userName(String user_userName) {
        this.user_userName = user_userName;
    }

    public User(int userId, String user_name, String user_password, String user_userName) {
        this.userId = userId;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_userName = user_userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + userId + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_userName='" + user_userName + '\'' +
                '}';
    }
}
