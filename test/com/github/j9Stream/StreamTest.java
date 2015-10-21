package com.github.j9Stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.Assert.assertEquals;

public class StreamTest {

    @Test
    public void dropWhile() throws Exception {
        // arrange
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4);

        // act
        List<Integer> actual = list.stream().dropWhile(x -> x < 3).collect(Collectors.toList());

        // assert
        assertEquals(2, actual.size());
        assertEquals(3, actual.get(0).intValue());
        assertEquals(4, actual.get(1).intValue());
    }

    @Test
    public void takeWhile() throws Exception {
        // arrange
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4);

        // act
        List<Integer> actual = list.stream().takeWhile(x -> x < 3).collect(Collectors.toList());

        // assert
        assertEquals(3, actual.size());
        assertEquals(0, actual.get(0).intValue());
        assertEquals(1, actual.get(1).intValue());
        assertEquals(2, actual.get(2).intValue());
    }

    @Test
    public void ofNullable() throws Exception {
        // arrange
        List<String> list = Arrays.asList("Angular", "ES7", "React");
        Map<String, Integer> map = new HashMap<>() {
            {
                put("Angular", 1);
                put("ES2016", 2);
                put("React", 3);
            }
        };

        // act
        List<Integer> actual = list.stream().flatMap(str -> Stream.ofNullable(map.get(str))).collect(Collectors.toList());

        // assert
        assertEquals(2, actual.size());
        assertEquals(1, actual.get(0).intValue());
        assertEquals(3, actual.get(1).intValue());
    }
}
