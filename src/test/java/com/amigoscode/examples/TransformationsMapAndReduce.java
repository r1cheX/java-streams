package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.beans.PersonDTO;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;


public class TransformationsMapAndReduce {

    @Test
    void yourFirstTransformationWithMap() throws IOException {
        List<Person> people = MockData.getPeople();

//      * Sirve para realizar transformacion de un objeto a otro.

        Predicate<Person> personPredicate = person -> person.getAge() > 50;
        Function<Person, PersonDTO> personPersonDTOFunction = person -> new PersonDTO(
            person.getId(),
            person.getFirstName(),
            person.getAge());

        Function<Person, PersonDTO> map = PersonDTO::map;

        List<PersonDTO> personDTOS = people.stream()
            .filter(personPredicate)
            .map(map)
            .toList();

//        assertThat(people.size()).isEqualTo(personDTOS.size());
        personDTOS.forEach(System.out::println);
    }

    @Test
    void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> cars = MockData.getCars();
    }

    @Test
    public void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};
    }
}

