package schoolapp;

import java.sql.SQLException;

public class SchoolApp {

    public static void main(String[] args) throws SQLException {

        MainMenu menu = new MainMenu();
        menu.mainMenu();
    }
}
