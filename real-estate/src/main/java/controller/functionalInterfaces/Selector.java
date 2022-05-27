package controller.functionalInterfaces;

import enums.Zones;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@FunctionalInterface
public interface Selector<T>{


    T select(int id);
   /*
    Map<Integer, Zones> zonesMap = Zones.stream()
                .collect(Collectors.toMap( value -> value.ordinal()+1, value -> value));
        return zonesMap.get(index);

    */

}
