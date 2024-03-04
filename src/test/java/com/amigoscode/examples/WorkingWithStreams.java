package com.amigoscode.examples;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WorkingWithStreams {

    @Test
    void steams() {
        List<String> names = List.of("Amigoscode", "Alex", "Zara");

        Stream<String> stream = names.stream();
        Stream<String> namesStream = Stream.of("Amigoscode", "Alex", "Zara");

//        Esto no es correcto, pero se observa que se pueda concatenar con
//        los operadores intermedios y por ultimo poner un operador final

//        stream.map(null).filter(null).collect(Collectors.toList());

//        * Tambien, se puede realizar con un arreglo pero tenemos que convertirlo
//        * ya que los stream trabajan con colecciones

        String[] listStrings = {};

        Arrays.stream(listStrings);


    }
}
