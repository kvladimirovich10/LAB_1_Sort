package com.company;

import java.util.*;
import java.util.Arrays;
import java.util.Random;

public class Main {



    public static void main(String[] args) {

        int [] arr1 = new int [100];

        createArray(arr1);
        cocktailsort(arr1);
        System.out.println(Arrays.toString(arr1));

        createArray(arr1);
        mergeSort(arr1);
        System.out.println(Arrays.toString(arr1));

    }

    public static void createArray(int[] arr1){

        Random random = new Random();
        for (int i=0;i< arr1.length;i++){
            arr1[i]=~i*random.nextInt();
        }
    }

    public static void cocktailsort(int[] array){

        int left = 0; // левая граница
        int right = array.length - 1; // правая граница

        do
        {
            //Сдвигаем к концу массива "тяжелые элементы"
            for (int i = left; i < right; i++)
            {
                if(array[i] > array[i+1])
                {
                    array[i] ^= array[i+1];
                    array[i+1] ^= array[i];
                    array[i] ^= array[i+1];
                }
            }
            right--;
            for (int i = right; i > left ; i--)
            {
                if(array[i] < array[i-1])
                {
                    array[i] ^= array[i-1];
                    array[i-1] ^= array[i];
                    array[i] ^= array[i-1];
                }
            }
            left++;
        } while (left <= right);

    }



    public static void mergeSort(int[] a)
    {
        int[] tmp = new int[a.length];
        mergeSort(a, tmp,  0,  a.length - 1);
    }


    private static void mergeSort(int[] a, int[] tmp, int left, int right)
    {
        if( left < right )
        {
            int center = (left + right) / 2;
            mergeSort(a, tmp, left, center);
            mergeSort(a, tmp, center + 1, right);
            merge(a, tmp, left, center + 1, right);
        }
    }


    private static void merge(int[] a, int[] tmp, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(a[left]<=a[right])
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while(left <= leftEnd)
            tmp[k++] = a[left++];

        while(right <= rightEnd)
            tmp[k++] = a[right++];

        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }
}
