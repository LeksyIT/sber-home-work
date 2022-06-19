package collections;

import java.util.*;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        Map<String,List<Car>> carByType = new HashMap<>();
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("1","1"));
        carList.add(new Car("2","2"));
        carList.add(new Car("3","3"));
        carList.add(new Car("4","4"));
        carList.add(new Car("5","5"));
        carList.add(new Car("6","6"));
        carList.add(new Car("7","7"));
        carList.add(new Car("8","8"));
        for (Car car:carList) {
            if(carByType.containsKey(car.getType())){
                carByType.get(car.getType()).add(car);
            } else{
                ArrayList<Car> list = new ArrayList<>();
                list.add(car);
                carByType.put(car.getType(),list);
            }
        }
        System.out.println(carByType);
    }
}
