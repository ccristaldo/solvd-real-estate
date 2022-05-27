package enums;

import java.util.stream.Stream;

public enum Zones {

    CENTER("1 - Center"),
    DONWNTON("2 - DownTown"),
    UPTOWN("3 - UpTown"),
    EASTSIDE("4 - EastSide"),
    WESTSIDE("5 - WestSide"),
    NORTHSIDE("6 - NorthSide"),
    SOUTHSIDE("7 - SouthSide");

    private final String output;

    Zones(String output){
        this.output = output;
    }

    public static Stream<Zones> stream() {
        return Stream.of(Zones.values());
    }

    public static int qEnum(){
        return Zones.values().length;
    }

    @Override
    public String toString() {
        return output;

    }

}
