package util;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class Util {
    private static final Logger LOGGER = LogManager.getLogger(Util.class);

    public void generateTicket(){
        try {

            int indexOp, indexCu;

            File ticketTxt = new File("src/main/resources/base.txt");
            String baseTicket = FileUtils.readFileToString(ticketTxt, "UTF-8");

            StringBuffer sb = new StringBuffer(baseTicket);
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/ticket.txt", false));

            String subStrOperation = "(1)";
            String subStrCustomer = "(2)";



            indexOp = sb.indexOf(subStrOperation) + 4;
            indexCu = sb.indexOf(subStrCustomer) + " RENT".length() + 4;

            sb.insert(indexOp, " RENT");
            sb.insert(indexCu, " Carlos Cristaldo");
            //System.out.println(baseTicket);

            System.out.println(sb);

            bw.write(sb.toString());

            bw.close();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }



}
