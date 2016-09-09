package com.company;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class Main {


    public static void main(String[] args) {

        Random random = new Random();

        int i;
        int [] arr1 = new int [1000];
        for (i=0;i<1000;i++){
            arr1[i]=~i*random.nextInt();
        }

        Cocktailsort(arr1);
        System.out.println(Arrays.toString(arr1));

    }




    public static int[] Cocktailsort(int[] array){

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

        return array;
    }

}
