package controller.apt;

import controller.functionalInterfaces.Selector;
import enums.Operation;
import enums.Zones;
import generics.apt.EnumAptGeneric;
import model.apt.Apt;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import view.apt.AptMenu;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class AptController  {

    private static final Logger LOGGER = LogManager.getLogger(AptController.class);

    Scanner sn = new Scanner(System.in);

    public Object selector(int index, int type){
        if (type == 0){
            Map<Integer, Operation> operationMap = Operation.stream()
                    .collect(Collectors.toMap( value -> value.ordinal()+1, value -> value));
            return operationMap.get(index);
        }else{
            Map<Integer, Zones> zonesMap = Zones.stream()
                    .collect(Collectors.toMap( value -> value.ordinal()+1, value -> value));
            return zonesMap.get(index);
        }
    }
/*
   public Operation selectOperation(int index){

       Map<Integer, Operation> operationMap = Operation.stream()
               .collect(Collectors.toMap( value -> value.ordinal()+1, value -> value));
       return operationMap.get(index);
   }

    public Zones selectZone(int index){

        Map<Integer, Zones> zonesMap = Zones.stream()
                .collect(Collectors.toMap( value -> value.ordinal()+1, value -> value));
        return zonesMap.get(index);
    }

 */

    public Apt loadApt(){
        String address;
        Operation operation;
        Zones zone;
        double cost;
        int dimension, rooms, op, zo;

        Apt apt = new Apt();

        LOGGER.log(Level.INFO, "Enter Address: ");
        address = sn.nextLine();

        LOGGER.log(Level.INFO, "Enter Operation: ");
        Operation.stream().forEach(o -> LOGGER.log(Level.OFF, o));
        op = sn.nextInt();
        while (op < 1 || op > Operation.qEnum()){
            LOGGER.log(Level.INFO, "Wrong value. Enter Operation: ");
            op = sn.nextInt();
        }
        operation = (Operation) selector(op, 0);


        //clear buffer
        sn.nextLine();

        LOGGER.log(Level.INFO, "Enter Zone: \n ");
        Zones.stream().forEach(z -> LOGGER.log(Level.OFF, z));
        zo = sn.nextInt();
        while (zo < 1 || zo > Zones.qEnum()){
            LOGGER.log(Level.INFO, "Wrong value. Enter Operation: ");
            zo = sn.nextInt();
        }

        zone = (Zones) selector(zo, 1);
        //zone = selectZone(zo);

        LOGGER.log(Level.INFO, "Enter cost: ");
        cost = sn.nextDouble();
        LOGGER.log(Level.INFO, "Enter dimension (sqrt mts): ");
        dimension = sn.nextInt();
        LOGGER.log(Level.INFO, "Enter Rooms: ");
        rooms = sn.nextInt();

        apt.setAddress(address);
        apt.setOperation(operation);
        apt.setZone(zone);
        apt.setCost(cost);
        apt.setDimension(dimension);
        apt.setRooms(rooms);
        apt.setActive(true);

        System.out.println(apt);
        return apt;
    }


}
