package examples;


import com.george.beans.Car;
import mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingData {

    @Test
    public void simpleGrouping() throws Exception {
        Map<String, List<Car>> carMakers =  MockData.getCars()
                .stream()
                .collect(Collectors.groupingBy(Car::getMake));

        carMakers.forEach((maker, cars) -> {
            System.out.println("Maker: " + maker);
            cars.forEach(System.out::println);
            System.out.println("--------------------------");
        });
        /*
        Here you can use groupBy like use in SQL for group results in a organized bunch.
         */
    }

    @Test
    public void groupingAndCounting() throws Exception {
        List<String> names = List.of(
                "John",
                "John",
                "Mariam",
                "Alex",
                "Mohammado",
                "Mohammado",
                "Vincent",
                "Alex",
                "Alex"
        );

        Map<String, Long> namesMap = names.stream()
                .collect(Collectors.groupingBy(name -> name, Collectors.counting()));

        Map<String, Long> namesMapOtherApproach = names.stream()
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting())
                        );

        System.out.println(namesMap);
        System.out.println(namesMapOtherApproach);
    }

}
