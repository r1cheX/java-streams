package com.amigoscode.examples;

import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class GettingStarted {

    @Test
    public void imperativeApproach() throws IOException {
        // 1. Find people aged less or equal 18
        // 2. Then change implementation to find first 10 people
        List<Person> people = MockData.getPeople();

    }

    @Test
    public void declarativeApproachUsingStreams() throws Exception {
        List<Person> people = MockData.getPeople();

        List<Person> youngPeople = people.stream()
            .filter(getFilterForYoungPeople())
            .limit(10)
            .collect(Collectors.toList());

        youngPeople.forEach(System.out::println);
    }

    private Predicate<Person> getFilterForYoungPeople() {
        return person -> {
            boolean isNotAdult = person.getAge() <= 18;
            boolean nameStartsWithM = person.getFirstName().startsWith("M");

            return isNotAdult && nameStartsWithM;
        };
    }
}
