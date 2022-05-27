package view;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import view.apt.AptMenu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {

    private static final Logger LOGGER = LogManager.getLogger(MainMenu.class);

    public int selectOption(){

        Scanner sn = new Scanner(System.in);
        int option = 0;

        final String option1 = "1. Employees (IN PROGRESS)";
        final String option2 = "2. Apartments";
        final String option3 = "3. Customers (IN PROGRESS)";
        final String option4 = "4. Branches (IN PROGRESS)";
        final String option5 = "5. Transactions (IN PROGRESS)";
        final String option6 = "6. Terminate Program (IN PROGRESS)";

        try{

                LOGGER.log(Level.OFF,
                        "\n" +
                                 option1  + "\n" +
                                 option2 + "\n" +
                                 option3 + "\n" +
                                 option4 + "\n" +
                                 option5 +"\n" +
                                 option6 + "\n");

                try {

                    LOGGER.log(Level.OFF, "Select: ");
                    option = sn.nextInt();

                    switch (option) {
                        case 1:
                            LOGGER.log(Level.INFO, option1 + " selected\n");
                            break;
                        case 2:
                            LOGGER.log(Level.INFO, option2 + " selected\n");
                            break;

                        case 6:
                            LOGGER.log(Level.INFO, "BYE");
                            //finish = true;
                            break;
                        default:
                            LOGGER.log(Level.WARN,"Only numbers between 1 and 4");
                    }
                } catch (InputMismatchException e) {
                    LOGGER.log(Level.WARN,"Wrong value. Only numbers");
                    sn.next();
                }
        } catch (Exception e) {
            e.printStackTrace();
            //throw new CustomSQLException("Connection was not possible", e);
        }


        return option;
    }
}
