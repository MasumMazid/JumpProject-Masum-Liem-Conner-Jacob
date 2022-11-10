package connection;

import org.postgresql.core.ConnectionFactory;
import org.postgresql.core.QueryExecutor;
import org.postgresql.util.HostSpec;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class  ConnectionMaker {
    private static final String URL="jdbc:mysql://localhost:3306/tvshowtracker?serverTimezone=EST5EDT";

    //Our usernames and login for database
    private static final String USERNAME="root";
    private static final String PASSWORD="root";
    private static Connection connection=null;
    public static void makeConnection(){
        try {
            connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("Connected");
        }catch (SQLException e) {
            System.out.println("Not connected");
            e.printStackTrace();
        }
    }

    public static  Connection getConnection() {
        try {
            if(connection==null) {
                makeConnection();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
}
