package menu;

import daos.UserDao;
import daos.tvDao;
import models.User;

import java.sql.SQLException;
import java.util.Scanner;

public class LoginMenu {
    public static LoginMenu startMenu() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Bob's discount Movie theatre,");


        Boolean Loggedout = true;
        UserDao NewUser = new UserDao();
        while (Loggedout == true) {
            System.out.println("Enter a number for a selection\n[1]Create a new account\n[2]Login");
            String MenuChioce = sc.nextLine();
            switch (MenuChioce) {
                case "1":
                    System.out.println("Please enter your username");
                    String UserNameAttempt = sc.nextLine();
                    System.out.println("Please enter your password");
                    String UserPasswordAttempt = sc.nextLine();
                    NewUser.CreateAccount(UserNameAttempt, UserPasswordAttempt);

                    break;

                case "2":
                    try {
                        System.out.println("Please enter your username");
                        String UserNameAttempt2 = sc.nextLine();
                        System.out.println("Please enter your password");
                        String UserPasswordAttempt2 = sc.nextLine();
                        UserDao CheckUser = new UserDao();
                        User loggedInUser = CheckUser.loginCheck(UserNameAttempt2, UserPasswordAttempt2);
                        System.out.println(loggedInUser.getUser_name());
                        LoggedInUserMenu LoggedMenu= new LoggedInUserMenu();
                        LoggedMenu.LoggedInMenu(loggedInUser);

                        break;
                    } catch (Exception e) {

                    }finally{
                        Loggedout = false;
                        break;
                    }
            }


        }
        return null;
    }
}

