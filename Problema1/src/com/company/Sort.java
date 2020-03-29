package com.company;


public class Sort {
    //Insertion Sort
    public static int[] insertion_sort(int[] array){
        int element;
        for (int i = 1; i < array.length; i++){
            element = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > element){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = element;
        }
        return array;
    }

    //Binary Insertion Sort
    public static int[] binary_insertion_sort(int[] array){
        int element, left, right, mid, length = array.length;

        for(int i = 0; i < length; i++){
            element = array[i];
            left = 0;
            right = i-1;

            //Binary Search
            while (left <= right) {
                mid = (left + right) / 2;
                if(array[mid] > element) right = mid - 1;
                else left = mid + 1;
            }

            for(int j = i - 1; j >= left; j--) {
                array[j+1] = array[j];
            }

            array[left] = element;
        }

        return array;
    }

    //Selection Sort
    public static int[] selection_sort(int[] array){
        int length = array.length;
        for(int i = 0; i < length - 1; i++){
            //We compare each following element to the actual element,
            // if it is smaller, we save its index and swap the values later

            int min_index = i;
            for(int j = i + 1; j < length; j++)
                if(array[min_index] > array[j])
                    min_index = j;

            //Swapping the values
            int temp = array[min_index];
            array[min_index] = array[i];
            array[i] = temp;
        }
        return array;
    }

    //Interchange Sort
    public static int[] interchange_sort(int[] array){
        int length = array.length;
        for(int i = 0; i < length - 1; i++) {
            for( int j = i + 1; j < length; j++){
                if(array[i] > array[j]) {
                    int temp = array[j];
                    array[i] = array[j];
                }
            }
        }
        return array;
    }

    //Shaker Sort (Cocktail Sort)
    public static int[] shaker_sort(int[] array){
        int end = array.length, start = 0;
        boolean swapped = true;
        while(swapped) {
            swapped = false;

            for(int i = start; i < end - 1; i++) {
                if(array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }

            if (swapped == false) break;

            swapped = false;
            end--;

            for(int i = end - 1; i >= start; i--) {
                if(array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
            start++;
        }
        return array;
    }

    //Bubble Sort
    public static int[] bubble_sort(int[] array){
        int length = array.length - 1;
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length - i; j++){
                if(array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

}
