package examples;


import com.george.beans.Person;
import mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

public class IntStreams {

    @Test
    public void range() throws Exception {
        System.out.println("Range 0 to 9");
        IntStream numbersExclusive = IntStream.range(0, 10);
        numbersExclusive.forEach(System.out::println);

        System.out.println("Range closed 0 to 10");
        IntStream numbersInclusive = IntStream.rangeClosed(0, 10);
        numbersInclusive.forEach(System.out::println);
    }

    // Loop through people using IntStream
    @Test
    public void rangeIteratingLists() throws Exception {
        List<Person> people = MockData.getPeople();

        IntStream.range(0, people.size())
                .forEach(i -> System.out.println(people.get(i)));
    }

    @Test
    public void intStreamIterate()  {
        IntStream.iterate(0, value -> value +1)
                .limit(11)
                .forEach(System.out::println);
    }
}
