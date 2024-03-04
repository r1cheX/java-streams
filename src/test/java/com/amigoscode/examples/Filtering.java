package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filtering {

    @Test
    public void filter() throws Exception {
        List<Car> cars = MockData.getCars();

        Predicate<Car> carPredicate = car -> car.getPrice() <= 20_000.00;
        Predicate<Car> carPredicate1 = car -> car.getMake().contains("or");

        List<Car> carLessThan20k = cars.stream()
            .filter(carPredicate)
            .filter(carPredicate1)
            .collect(Collectors.toList());

        carLessThan20k.forEach(System.out::println);
    }

    @Test
    public void dropWhile() throws Exception {
//      * El DropWhile se utiliza para omitir los elementos
//      * mientras que la condición determinada se cumpla

        System.out.println("using filter");
        Stream.of(2, 4, 6, 8, 9, 10, 12).filter(n -> n % 2 == 0)
            .forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println("using dropWhile");
        Stream.of(2, 4, 6, 8, 9, 10, 12).dropWhile(n -> n % 2 == 0)
            .forEach(n -> System.out.println(n + " "));
    }

    @Test
    public void takeWhile() throws Exception {
        // using filter
        System.out.println("using filter");
        Stream.of(2, 4, 6, 8, 9, 10, 12).filter(n -> n % 2 == 0)
            .forEach(n -> System.out.print(n + " "));

//      * Take while, es que toma una condición hasta que no cumpla
        System.out.println();
        System.out.println("using take while");
        Stream.of(2, 4, 6, 8, 9, 10, 12).takeWhile(n -> n % 2 == 0)
            .forEach(n -> System.out.print(n + " "));
    }

    @Test
    public void findFirst() throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = Arrays.stream(numbers)
            .filter(x -> x > 5)
            .findFirst()
            .orElse(-1);

        List<Integer> numbersList = Arrays.asList(1, 3, 7, 2, 9);

        Optional<Integer>  resultInParallelStream = numbersList.parallelStream().filter(num -> num > 2).findFirst();

        System.out.println("El resultado es: " + result);
        System.out.println("El resultado en paralelo es: " + (resultInParallelStream.orElse(0)));
    }

    @Test
    public void findAny() throws Exception {
//      * La diferencia clave se observa en un flujo paralelo
//      * el resultado de findAny() puede devolver cualquier
//      * primer elemento que se encuentre sin importar su POSICIÓN

//      * findFirst() buscará el primer elemento según el orden de
//      * encuentro.

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10};
        int result = Arrays.stream(numbers).filter(n -> n > 5)
            .findAny()
            .orElse(-1);

        System.out.println(result);
    }

    @Test
    public void allMatch() throws Exception {
        int[] even = {2, 4, 6, 8, 10};
        boolean allMatch = Arrays.stream(even).allMatch(n -> n % 2 == 0);
        System.out.println(allMatch);
    }

    @Test
    public void anyMatch() throws Exception {
        int[] evenAndOneOdd = {2, 4, 6, 8, 10, 11};
        boolean anyMatch = Arrays.stream(evenAndOneOdd).anyMatch(n -> !(n % 2 == 0));
        System.out.println(anyMatch);
    }

}



