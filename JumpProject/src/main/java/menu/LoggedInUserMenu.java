package menu;

import daos.UserDao;
import daos.tvDao;
import models.User;

import java.sql.SQLException;
import java.util.Scanner;

public class LoggedInUserMenu {


    public LoggedInUserMenu() {
    }

    public void LoggedInMenu(User user) throws SQLException {
    while(true){
        Scanner sc= new Scanner(System.in);
        System.out.println("Welcome to the main menu, make a selection:\n[1]See Progress\n[2]Update Progess\n[3]See all shows\n[4] Exit");
        String MenuOptions=sc.nextLine();
        tvDao tvprograms= new tvDao();
        UserDao loggedUserDao= new UserDao();
        switch(MenuOptions){
            case "1":
                //returns list of progress
                System.out.println(user.getUser_id());
                tvprograms.getShowsCompleted(user);
                break;
            case "2":
                System.out.println("What is the show id?");
                int showID=Integer.valueOf(sc.nextLine());
                System.out.println("What percentage have you watched?");
                int percentage= Integer.valueOf(sc.nextLine());
                tvprograms.updateShowProgress(user,showID,percentage);
                break;
            case"3":
                tvprograms.getShows();
                break;
            case"4":

                System.exit(0);
                break;

        }
    }
}
        }


