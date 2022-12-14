package examples;

import com.george.beans.Car;
import com.george.beans.Person;
import com.george.beans.PersonDTO;
import mockdata.MockData;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TransformationsMapAndReduce {

    @Test
    void yourFirstTransformationWithMap() throws IOException {
        List<Person> people = MockData.getPeople();
        List<PersonDTO> peopleDtos = people.stream()
                .map(person -> new PersonDTO(
                        person.getId(),
                        person.getFirstName(),
                        person.getAge()))
                .collect(Collectors.toList());
        assertThat(people.size()).isEqualTo(peopleDtos.size());
        peopleDtos.forEach(System.out::println);
    }

    @Test
    void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> cars = MockData.getCars();
        double averagePrice = cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);
        System.out.println(averagePrice);
    }

    @Test
    public void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};
        int sum = Arrays.stream(integers)
                .reduce(0, Integer::sum);

        int subtract = Arrays.stream(integers)
                .reduce(0, (a, b) -> a - b);

        System.out.println(sum);
        System.out.println(subtract);
    }
}

