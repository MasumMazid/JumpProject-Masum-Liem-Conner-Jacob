package menu;

import daos.UserDao;
import daos.tvDao;

import java.sql.SQLException;
import java.util.Scanner;

public class LoginMenu {
    public static LoginMenu startMenu() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Bob's discount Movie theatre,");

        String MenuChioce = sc.nextLine();
            Boolean Loggedout=true;
            UserDao NewUser= new UserDao();
            System.out.println("Enter a number for a selection\n[1]Create a new account\n[2]Login");
            while(Loggedout=true){
            switch (MenuChioce) {
                case "1":
                    NewUser.CreateAccount();

                    break;

                case "2":
                    //NewUser.loginCheck();
                    Loggedout=false;
            }

            while(true){
                System.out.println("Welcome to the main menu, make a selection:\n[1]See Progress\n[2]Update Progess\n[3]See all shows\n[4] Exit");
                String MenuOptions=sc.nextLine();
                switch(MenuOptions){
                    case "1":
                        //See Progress
                        break;
                    case "2":
                        //Update Progress
                    case"3":
                        //See all shows
                    case"4":
                        System.exit(0);

                }
            }
        }return null;
    }
}
