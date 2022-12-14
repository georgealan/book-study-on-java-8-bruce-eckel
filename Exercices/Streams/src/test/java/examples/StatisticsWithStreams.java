package examples;


import com.george.beans.Car;
import mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class StatisticsWithStreams {

    @Test
    public void count() throws Exception {
        List<Car> cars = MockData.getCars();
        long count = cars.stream()
                .filter(car -> car.getMake().equalsIgnoreCase("Ford"))
                .count();

        System.out.println(count);
    }

    @Test
    public void min() throws Exception {
        List<Car> cars = MockData.getCars();
        double mostCheapCar = cars.stream()
                .mapToDouble(Car::getPrice)
                .min()
                .orElse(0);
        System.out.println(mostCheapCar);
    }

    @Test
    public void max() throws Exception {
        List<Car> cars = MockData.getCars();
        double mostExpensiveCar = cars.stream()
                .mapToDouble(Car::getPrice)
                .max()
                .orElse(0);
        System.out.println(mostExpensiveCar);
    }


    @Test
    public void average() throws Exception {
        List<Car> cars = MockData.getCars();
        double average = cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);
        System.out.println(average);
    }

    @Test
    public void sum() throws Exception {
        List<Car> cars = MockData.getCars();
        double sum = cars.stream()
                .mapToDouble(Car::getPrice)
                .sum();
        System.out.println(BigDecimal.valueOf(sum));
    }

    @Test
    public void statistics() throws Exception {
        List<Car> cars = MockData.getCars();
        DoubleSummaryStatistics statistics = cars.stream()
                .mapToDouble(Car::getPrice)
                .summaryStatistics();

        System.out.println("Count: " + statistics.getCount());
        System.out.println("Average price: " + statistics.getAverage());
        System.out.println("Minimum price: " + statistics.getMin());
        System.out.println("Maximum price: " + statistics.getMax());
        System.out.println("Sum of all prices: " + BigDecimal.valueOf(statistics.getSum()));
    }

}
