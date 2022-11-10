package models;

public class User {
    private String user_id;
    private String user_name;
    private String user_password;
    private String user_userName;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_userName() {
        return user_userName;
    }

    public void setUser_userName(String user_userName) {
        this.user_userName = user_userName;
    }

    public User(String user_id, String user_name, String user_password, String user_userName) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_userName = user_userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_userName='" + user_userName + '\'' +
                '}';
    }
}
