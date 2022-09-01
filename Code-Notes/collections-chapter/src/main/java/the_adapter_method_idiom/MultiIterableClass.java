package the_adapter_method_idiom;

import forin_and_iterators.IterableClass;

import java.util.*;

public class MultiIterableClass extends IterableClass {
    public Iterable<String> reversed() {
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                return new Iterator<String>() {
                    int current = words.length - 1;
                    @Override
                    public boolean hasNext() {
                        return current > -1;
                    }

                    @Override
                    public String next() {
                        return words[current--];
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public Iterable<String> randomized() {
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                List<String> shuffled = new ArrayList<>(Arrays.asList(words));
                Collections.shuffle(shuffled, new Random(47));
                return shuffled.iterator();
            }
        };
        /*
        Notice that this method, randomized(), doesn’t create its own Iterator but
        returns the one from the shuffled List.

        The output shows that the Collections.shuffle() method doesn’t affect the
        original array, but only shuffles the references in shuffled. This is only true
        because the randomized() method wraps an ArrayList around the result of
        Arrays.asList().
         */
    }

    public static void main(String[] args) {
        MultiIterableClass mic = new MultiIterableClass();

        for (String s : mic.reversed()) {
            System.out.print(s + " ");
        }
        System.out.println();

        for (String s : mic.randomized()) {
            System.out.print(s + " ");
        }
        System.out.println();

        for (String s : mic) {
            System.out.print(s + " ");
        }
    }
}
