package examples;


import com.george.beans.Car;
import mockdata.MockData;
import org.junit.jupiter.api.Test;

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
    }

    @Test
    public void max() throws Exception {
        List<Car> cars = MockData.getCars();
    }


    @Test
    public void average() throws Exception {
        List<Car> cars = MockData.getCars();
    }

    @Test
    public void sum() throws Exception {
        List<Car> cars = MockData.getCars();
    }

    @Test
    public void statistics() throws Exception {
        List<Car> cars = MockData.getCars();
    }

}
