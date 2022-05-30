package view.apt;

import controller.apt.AptController;
import enums.Operation;
import enums.Zones;
import model.apt.Apt;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.implemented.AptImplemented;
import view.MainMenu;

import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AptMenu {

    private Connection conn;
    private static final Logger LOGGER = LogManager.getLogger(AptMenu.class);

    Scanner sn = new Scanner(System.in);

    public AptMenu(){}

    public AptMenu(Connection conn){
        this.conn = conn;
    }

    public void aptMenu(){

        AptImplemented aptImplemented = new AptImplemented(conn);
        AptController aptController = new AptController();

        int option = 0;
        boolean finish = false;

        final String option1 = "1. Register Apt";
        final String option2 = "2. Get Apt by Id";
        final String option3 = "3. Get all Apt";
        final String option4 = "4. Update Apt (IN PROGRESS)";
        final String option5 = "5. Delete Apt (working)";
        final String option6 = "6. Go Back";

        while (!finish) {
            try {

                LOGGER.log(Level.OFF,
                        "\n" +
                                option1 + "\n" +
                                option2 + "\n" +
                                option3 + "\n" +
                                option4 + "\n" +
                                option5 + "\n" +
                                option6 + "\n");

                try {

                    LOGGER.log(Level.OFF, "Select: ");
                    option = sn.nextInt();

                    switch (option) {
                        case 1:
                            LOGGER.log(Level.INFO, option1 + " selected\n");
                            aptImplemented.create(aptController.loadApt());
                            break;
                        case 2:
                            LOGGER.log(Level.INFO, option2 + " selected\n");
                            LOGGER.log(Level.INFO, "Enter Apt's ID: ");
                            aptImplemented.getById(sn.nextInt());
                            break;
                        case 3:
                            LOGGER.log(Level.INFO, option3 + " selected\n");
                            aptImplemented.getAll();
                            break;
                        case 4:
                            LOGGER.log(Level.INFO, option4 + " selected\n");
                            LOGGER.log(Level.INFO, "Enter Apt's ID for Update: ");
                            aptImplemented.update(sn.nextInt());
                            break;

                        case 5:
                            LOGGER.log(Level.INFO, option5 + " selected\n");
                            LOGGER.log(Level.INFO, "Enter Apt's ID for deletion: ");
                            aptImplemented.delete(sn.nextInt());
                            break;

                        case 6:
                            LOGGER.log(Level.INFO, "Going back");
                            finish = true;
                            break;
                        default:
                            LOGGER.log(Level.WARN, "Only numbers between 1 and 4");
                    }
                } catch (InputMismatchException e) {
                    LOGGER.log(Level.WARN, "Wrong value. Only numbers");
                    sn.next();
                }
            } catch (Exception e) {
                e.printStackTrace();
                //throw new CustomSQLException("Connection was not possible", e);
            }
        }

    }
}
