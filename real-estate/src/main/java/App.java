/*
Catching Runtime exception.                             -DONE-
2 Enums are empty, one mor enum.                        -DONE-
3. All classes in util folder do not have any sence.    -DONE-
4. System out println!!!!                               -DONE-
5. 2 More generics                                      -IN PROGRESS-
6. Fields in classes have default modifier
instead of private                                      -ASK!-
7. Interfaces for services should have methods.         -DONE-
without them they do not have any sence.
8 FIELDS MODIFIERS.                                     -ASK!-
9 Maven do not have plugins                             -DONE-
 10. FIle reading and writing utils not implemented.    -IN PROGRESS-
 11 No functional interfaces
 12. connection pool was not implemented                -DONE-
 in requred way
 */

import util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import view.MainMenu;
import view.apt.AptMenu;

import java.sql.Connection;

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
