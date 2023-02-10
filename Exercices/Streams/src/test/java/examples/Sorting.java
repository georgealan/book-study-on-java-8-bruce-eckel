package examples;

import com.george.beans.Car;
import com.george.beans.Person;
import mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {

    @Test
    public void sortingSteamOfElements() throws IOException {
        List<Person> people = MockData.getPeople();
        // Sort person by name in alphabetical order.
        List<String> personSorted = people.stream()
                .map(Person::getFirstName)
                .sorted()
                .collect(Collectors.toList());

        personSorted.forEach(System.out::println);
    }

    @Test
    public void sortingSteamOfElementsReverse() throws IOException {
        List<Person> people = MockData.getPeople();
        // Sort person by name in alphabetical reverse order
        List<String> personSorted = people.stream()
                .map(Person::getFirstName)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        personSorted.forEach(System.out::println);
    }

    @Test
    public void sortingSteamOfObjets() throws IOException {
        List<Person> people = MockData.getPeople();
        // Sort without using map()
        List<Person> peopleSorted = people.stream()
                .sorted(Comparator.comparing(Person::getFirstName))
                .collect(Collectors.toList());

        List<Person> peopleSortedReverse = people.stream()
                .sorted(Comparator.comparing(Person::getFirstName).reversed())
                .collect(Collectors.toList());

        List<Person> peopleSortedByTwoParams = people.stream()
                .sorted(Comparator.comparing(Person::getFirstName)
                        .thenComparing(Person::getEmail))
                .collect(Collectors.toList());

//        peopleSorted.forEach(System.out::println);
//        peopleSortedReverse.forEach(System.out::println);
        peopleSortedByTwoParams.forEach(System.out::println);
    }

    @Test
    public void topTenMostExpensiveBlueCars() throws IOException {
        List<Car> cars = MockData.getCars();
        List<Car> topTenMostExpensiveCars = cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase("blue"))
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .limit(10)
                .collect(Collectors.toList());

        topTenMostExpensiveCars.forEach(System.out::println);
    }

}
