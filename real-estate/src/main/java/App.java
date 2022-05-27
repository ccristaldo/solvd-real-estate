import connection.ConnectionPool;
import enums.Operation;
import enums.Zones;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import view.MainMenu;
import view.apt.AptMenu;

import java.sql.Connection;
import java.time.ZonedDateTime;

public class App {

    private static final Logger LOGGER = LogManager.getLogger(App.class);
    public static void main(String[] args) {

        Connection conn = ConnectionPool.getInstance().getConnection();

        boolean finish = false;

        MainMenu mainMenu = new MainMenu();
        AptMenu aptMenu = new AptMenu(conn);

        while (!finish) {

            int operation = mainMenu.selectOption();
            switch (operation) {
                case 1:
                    break;
                case 2:
                    aptMenu.aptMenu();
                    break;
                case 6:
                    finish = true;
                    break;

            }
        }

    }
}
