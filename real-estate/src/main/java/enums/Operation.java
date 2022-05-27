package enums;

import java.util.stream.Stream;

public enum Operation {
    TO_SELL("1 - FOR SELLING"),
    TO_RENT("2 - FOR RENTING"),;

    private final String output;

    Operation(String output){
        this.output = output;
    }

    public static Stream<Operation> stream() {
        return Stream.of(Operation.values());
    }

    public static int qEnum(){
        return Operation.values().length;
    }

    @Override
    public String toString() {
        return output;

    }
}
