package it.unibo.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.HashMap;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int ELEMS1 = 100_000;
    private static final int ELEMS2 = 1_000;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        ArrayList<Integer> list1 = new ArrayList<>();
        for(int i = 1000; i < 2000; i++) {
            list1.add(i);
        }

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        LinkedList<Integer> list2 = new LinkedList<>(list1);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int temp = list2.getFirst();
        list2.set(0, list2.getLast());
        list2.set(list2.size() - 1, temp);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer i : list1) {
            System.out.println(i);
        }

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time1 = System.nanoTime();
        for (int i = 0; i < ELEMS1; i++) {
            list1.addFirst(i);
        }
        time1 = System.nanoTime() - time1;
        final var millis1 = TimeUnit.NANOSECONDS.toMillis(time1);
        System.out.println(
            "Inserting "
                + ELEMS1
                + " ints to ArrayList "
                + time1
                + "ns ("
                + millis1
                + "ms)"
        );

        long time2 = System.nanoTime();
        for (int i = 0; i < ELEMS1; i++) {
            list2.addFirst(i);
        }
        time2 = System.nanoTime() - time2;
        final var millis2 = TimeUnit.NANOSECONDS.toMillis(time2);
        System.out.println(
            "Inserting "
                + ELEMS1
                + " ints to LinkedList "
                + time2
                + "ns ("
                + millis2
                + "ms)"
        );

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        long time3 = System.nanoTime();
        for (int i = 0; i < ELEMS2; i++) {
            list1.get(list1.size()/2);
        }
        time3 = System.nanoTime() - time3;
        final var millis3 = TimeUnit.NANOSECONDS.toMillis(time3);
        System.out.println(
            "Reading "
                + ELEMS2
                + " times the middle element in ArrayList "
                + time3
                + "ns ("
                + millis3
                + "ms)"
        );

        long time4 = System.nanoTime();
        for (int i = 0; i < ELEMS2; i++) {
            list2.get(list2.size()/2);
        }
        time4 = System.nanoTime() - time4;
        final var millis4 = TimeUnit.NANOSECONDS.toMillis(time4);
        System.out.println(
            "Reading "
                + ELEMS2
                + " times the middle element in LinkedList "
                + time4
                + "ns ("
                + millis4
                + "ms)"
        );

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String, Long> map = new HashMap<>();
        map.put("Africa", 1110635000L);
        map.put("Americas", 972005000L);
        map.put("Antarctica", 0L);
        map.put("Asia", 4298723000L);
        map.put("Europe", 742452000L);
        map.put("Oceania", 38304000L);

        /*
         * 8) Compute the population of the world
         */
        long world_pop = 0;
        for (final Long v : map.values()) {
            world_pop += v;
        }
        System.out.println("World Population: " + world_pop);
    }
}
