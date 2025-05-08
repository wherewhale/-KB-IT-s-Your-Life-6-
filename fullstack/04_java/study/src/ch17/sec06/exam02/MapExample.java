package ch17.sec06.exam02;

import java.util.Arrays;

public class MapExample {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5};

        double[] doubleArray = Arrays.stream(intArray).mapToDouble(i -> (double) i).toArray();

        Arrays.stream(doubleArray).forEach(System.out::println);
        System.out.println();

        Arrays.stream(doubleArray).mapToInt(i -> (int) i).forEach(System.out::println);
    }
}
