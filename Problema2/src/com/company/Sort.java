package com.company;

import java.util.Random;
import java.util.Arrays;
public class Sort {
    public static int[] selection_sort(int[] array){
        Random random = new Random();
            int[] filtered_array = new int[6];

        for (int i = 0; i < 6; i++) {
            int rnd = random.nextInt(array.length);
            while(!Sort.contains(filtered_array, array[rnd]))
                filtered_array[i] = array[rnd];

            }


        for (int i = 0; i < filtered_array.length - 1; i++) {
            int lengh = filtered_array.length, min_index = i;

            for(int j = i + 1; j < lengh; j++){
                if(filtered_array[j] < filtered_array[min_index]) {
                    min_index = j;
                }
            }

            int temp = filtered_array[min_index];
            filtered_array[min_index] = filtered_array[i];
            filtered_array[i] = temp;

        }



        return filtered_array;
    }

    public static boolean contains(final int[] array, final int v) {

        boolean result = false;

        for(int i : array){
            if(i == v){
                result = true;
                break;
            }
        }

        return result;
    }
}
