package collections;

public class Car {
    private final String model;
    private final String type;

    public Car(String model, String type) {
        this.model = model;
        this.type = type;
    }

    public String getType(){
        return type;
    };
}
