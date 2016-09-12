package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Random;


public class MainTest {


    private Random random = new Random();
    private int EVENSIZE = 10;

    private Integer[] createRandArray(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10);
        }
        return arr;
    }

    private boolean sortFunctionCheck(Integer[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void lonelyArrayTest() throws Exception {

        Integer[] arr1 = {1};
        Integer a = arr1[0];

        Main.cocktailSort(arr1);
        assertEquals(a, arr1[0]);
    }

    @Test
    public void sameElemetArrayTest() throws Exception {
        Integer[] arr = new Integer[EVENSIZE];
        int i;

        for (i = 0; i < arr.length; i++) {
            arr[i] = 42;
        }
        Main.cocktailSort(arr);

        boolean check;
        for (i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                check = false;
                assertTrue(check);
            }
        }
    }

    @Test
    public void oddTest() throws Exception {


        Integer[] arr = new Integer[EVENSIZE + 1];

        arr = createRandArray(arr);

        Main.cocktailSort(arr);

        assertTrue("not sorted", sortFunctionCheck(arr));


    }

    @Test
    public void evenTest() throws Exception {

        Integer[] arr = new Integer[EVENSIZE];

        createRandArray(arr);

        Main.cocktailSort(arr);

        assertTrue("not sorted", sortFunctionCheck(arr));
    }

    @Test
    public void AlresdySortedTest() throws Exception {

        Integer[] arr = new Integer[EVENSIZE];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 42;
        }
        Main.cocktailSort(arr);

        assertTrue("not sorted", sortFunctionCheck(arr));
    }

    @Test
    public void alresdySortedBackTest() throws Exception {


        Integer[] arr = new Integer[EVENSIZE];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr.length - i;
        }
        Main.cocktailSort(arr);

        assertTrue("not sorted", sortFunctionCheck(arr));
    }

    @Test
    public void negativeTest() throws Exception {


        Integer[] arr = new Integer[EVENSIZE];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (-1) * random.nextInt();
        }
        Main.cocktailSort(arr);

        assertTrue("not sorted", sortFunctionCheck(arr));
    }

    @Test
    public void hugeTest() throws Exception {

        Integer[] arr = new Integer[EVENSIZE * 100];

        createRandArray(arr);
        Main.cocktailSort(arr);

        assertTrue("not sorted", sortFunctionCheck(arr));
    }


    @Test
    public void mergeSortlonelyArrayTest() throws Exception {

        Integer[] arr1 = {1};
        Integer a = arr1[0];

        Main.mergeSort(arr1);
        assertEquals(a, arr1[0]);
    }

    @Test
    public void mergeSortsameTest() throws Exception {
        Integer[] arr = new Integer[EVENSIZE];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 42;
        }
        Main.mergeSort(arr);

        boolean check;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                check = false;
                assertTrue(check);
            }
        }
    }

    @Test
    public void mergeSortoddTest() throws Exception {

        Integer[] arr = new Integer[EVENSIZE + 1];

        createRandArray(arr);

        Main.mergeSort(arr);

        assertTrue("not sorted", sortFunctionCheck(arr));


    }

    @Test
    public void mergeSortevenTest() throws Exception {

        Integer[] arr = new Integer[EVENSIZE];

        createRandArray(arr);

        Main.mergeSort(arr);

        assertTrue("not sorted", sortFunctionCheck(arr));
    }

    @Test
    public void mergeSortAlresdySortedTest() throws Exception {


        Integer[] arr = new Integer[EVENSIZE];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 42;
        }
        Main.mergeSort(arr);

        assertTrue("not sorted", sortFunctionCheck(arr));
    }

    @Test
    public void mergeSortalresdySortedBackTest() throws Exception {


        Integer[] arr = new Integer[EVENSIZE];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr.length - i;
        }
        Main.mergeSort(arr);

        assertTrue("not sorted", sortFunctionCheck(arr));
    }

    @Test
    public void mergeSortnegativeTest() throws Exception {

        int i;
        Integer[] arr = new Integer[EVENSIZE];

        for (i = 0; i < arr.length; i++) {
            arr[i] = (-1) * random.nextInt();
        }
        Main.mergeSort(arr);

        assertTrue("not sorted", sortFunctionCheck(arr));
    }

    @Test
    public void mergeSorthugeTest() throws Exception {

        Integer[] arr = new Integer[EVENSIZE * 100];

        createRandArray(arr);
        Main.mergeSort(arr);

        assertTrue("not sorted", sortFunctionCheck(arr));
    }

}