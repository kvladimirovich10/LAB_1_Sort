package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {

    public static void createArrayFunc(Integer[] arr1) {

        Random random = new Random();
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = random.nextInt(100);
        }
    }


    private static <T> void swap(T[] array, int i) {
        T swap = array[i + 1];
        array[i + 1] = array[i];
        array[i] = swap;

    }


    public static void main(String[] args) {

        Integer[] arr1 = new Integer[10];

        createArrayFunc(arr1);
        cocktailSort(arr1);
        System.out.println(Arrays.toString(arr1));

        createArrayFunc(arr1);
        mergeSort(arr1);
        System.out.println(Arrays.toString(arr1));

    }


    public static <T extends Comparable<T>> void cocktailSort(T[] array) {

        int left = 0;
        int right = array.length - 1;


        do {

            for (int i = left; i < right; i++) {
                if (array[i].compareTo(array[i + 1]) >= 0)
                    swap(array, i);
            }
            right--;
            for (int i = right; i > left; i--) {
                if (array[i].compareTo(array[i + 1]) >= 0)
                    swap(array, i);
            }
            left++;
        } while (left <= right);

    }


    public static <T extends Comparable<T>> void mergeSort(T[] a) {
        mergeSort(a, a, 0, a.length - 1);
    }


    private static <T extends Comparable<T>> void mergeSort(T[] a, T[] tmp, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmp, left, center);
            mergeSort(a, tmp, center + 1, right);
            merge(a, tmp, left, center + 1, right);
        }
    }


    private static <T extends Comparable<T>> void merge(T[] a, T[] tmp, int left, int right, int rightEnd) {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while (left <= leftEnd && right <= rightEnd)
            if (a[left].compareTo(a[right]) <= 0)
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while (left <= leftEnd)
            tmp[k++] = a[left++];

        while (right <= rightEnd)
            tmp[k++] = a[right++];

        for (int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }
}
