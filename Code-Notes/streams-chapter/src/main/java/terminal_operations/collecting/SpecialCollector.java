package terminal_operations.collecting;

import intermediate_operations.FileToWords;

import java.util.ArrayList;

/*
Most of the time, if you look through java.util.stream.Collectors you’ll be
able to find a predefined Collector that will do what you need. In the rare situation
when you don’t, you can use the second form of collect(). Here’s an example
showing the basics of the second form:
 */
public class SpecialCollector {
    public static void main(String[] args) throws Exception {
        ArrayList<String> words = FileToWords.stream("src/main/resources/Cheese.dat")
                .collect(ArrayList::new,
                        ArrayList::add,
                        ArrayList::addAll);

        words.stream()
                .filter(s -> s.equals("cheese"))
                .forEach(System.out::println);
    }
}

// TODO Continue in page 560, Topic: Combining All Stream Elements
