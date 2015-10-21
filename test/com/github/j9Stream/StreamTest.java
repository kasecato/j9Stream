package com.github.j9Stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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
        int[] listA = null;
        int[] listB = new int[] { 0, 1 };

        // act
        Optional<int[]> actualA = Stream.ofNullable(listA).findFirst();
        Optional<int[]> actualB = Stream.ofNullable(listB).findFirst();

        // assert
        assertEquals(false, actualA.isPresent());
        assertEquals(true, actualB.isPresent());
        assertEquals(0, actualB.get()[0]);
        assertEquals(1, actualB.get()[1]);
    }
}
