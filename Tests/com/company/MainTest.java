package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Random;

//generic
//хэш таблицы

public class MainTest {

    //private Main sum = new Main();
    private Random random = new Random();
    private int EVENSIZE = 1000;

    private void createRandArray(int[] arr) {
        for (int i : arr) {
            arr[i] = random.nextInt();
        }
    }

    private boolean sortfunc(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void lonelyArrayTest() throws Exception {

        int[] arr1 = {1};
        int a = arr1[0];

        Main.cocktailsort(arr1);
        assertEquals(a, arr1[0]);
    }

    @Test
    public void sameTest() throws Exception {
        int[] arr = new int[EVENSIZE];
        int i;
        for (i = 0; i < arr.length; i++) {
            arr[i] = 42;
        }
        Main.cocktailsort(arr);

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


        int[] arr = new int[EVENSIZE + 1];

        createRandArray(arr);

        Main.cocktailsort(arr);

        assertTrue("not sorted", sortfunc(arr));


    }

    @Test
    public void evenTest() throws Exception {

        int[] arr = new int[EVENSIZE];

        createRandArray(arr);

        Main.cocktailsort(arr);

        assertTrue("not sorted", sortfunc(arr));
    }

    @Test
    public void AlresdySortedTest() throws Exception {

        int i;
        int[] arr = new int[EVENSIZE];

        for (i = 0; i < arr.length; i++) {
            arr[i] = i + 42;
        }
        Main.cocktailsort(arr);

        assertTrue("not sorted", sortfunc(arr));
    }

    @Test
    public void alresdySortedBackTest() throws Exception {

        int i;
        int[] arr = new int[EVENSIZE];

        for (i = 0; i < arr.length; i++) {
            arr[i] = arr.length - i;
        }
        Main.cocktailsort(arr);

        assertTrue("not sorted", sortfunc(arr));
    }

    @Test
    public void negativeTest() throws Exception {

        int i;
        int[] arr = new int[EVENSIZE];

        for (i = 0; i < arr.length; i++) {
            arr[i] = (-1) * random.nextInt();
        }
        Main.cocktailsort(arr);

        assertTrue("not sorted", sortfunc(arr));
    }

    @Test
    public void hugeTest() throws Exception {

        int[] arr = new int[EVENSIZE * 100];

        createRandArray(arr);
        Main.cocktailsort(arr);

        assertTrue("not sorted", sortfunc(arr));
    }


    @Test
    public void mergeSortlonelyArrayTest() throws Exception {

        int[] arr1 = {1};
        int a = arr1[0];

        Main.mergeSort(arr1);
        assertEquals(a, arr1[0]);
    }

    @Test
    public void mergeSortsameTest() throws Exception {
        int[] arr = new int[EVENSIZE];
        int i;
        for (i = 0; i < arr.length; i++) {
            arr[i] = 42;
        }
        Main.mergeSort(arr);

        boolean check;
        for (i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                check = false;
                assertTrue(check);
            }
        }
    }

    @Test
    public void mergeSortoddTest() throws Exception {


        int[] arr = new int[EVENSIZE + 1];

        createRandArray(arr);

        Main.mergeSort(arr);

        assertTrue("not sorted", sortfunc(arr));


    }

    @Test
    public void mergeSortevenTest() throws Exception {

        int[] arr = new int[EVENSIZE];

        createRandArray(arr);

        Main.mergeSort(arr);

        assertTrue("not sorted", sortfunc(arr));
    }

    @Test
    public void mergeSortAlresdySortedTest() throws Exception {

        int i;
        int[] arr = new int[EVENSIZE];

        for (i = 0; i < arr.length; i++) {
            arr[i] = i + 42;
        }
        Main.mergeSort(arr);

        assertTrue("not sorted", sortfunc(arr));
    }

    @Test
    public void mergeSortalresdySortedBackTest() throws Exception {

        int i;
        int[] arr = new int[EVENSIZE];

        for (i = 0; i < arr.length; i++) {
            arr[i] = arr.length - i;
        }
        Main.mergeSort(arr);

        assertTrue("not sorted", sortfunc(arr));
    }

    @Test
    public void mergeSortnegativeTest() throws Exception {

        int i;
        int[] arr = new int[EVENSIZE];

        for (i = 0; i < arr.length; i++) {
            arr[i] = (-1) * random.nextInt();
        }
        Main.mergeSort(arr);

        assertTrue("not sorted", sortfunc(arr));
    }

    @Test
    public void mergeSorthugeTest() throws Exception {

        int[] arr = new int[EVENSIZE * 100];

        createRandArray(arr);
        Main.mergeSort(arr);

        assertTrue("not sorted", sortfunc(arr));
    }

}