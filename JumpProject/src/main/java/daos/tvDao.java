package daos;

import connection.ConnectionMaker;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class tvDao implements crudDaos<User>{

public static tvDao getShows() throws SQLException {

    Connection connection=ConnectionMaker.getConnection();
    PreparedStatement ps = connection.prepareStatement("SELECT * from tvshowtracker.tvshow");
    ResultSet rs=ps.executeQuery();
    List<String> usersList = new ArrayList<String>();
    while (rs.next()) {
        usersList.add(rs.getString(2));

    }
    System.out.print("Available tv shows are: \n"+usersList);
    rs.close();
    return null;
}
    public static void getprogress() throws SQLException {}
    public static void updateProgress() throws SQLException{}


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

