package org.example;

import java.util.Random;

public class Quicksort {
    public static void quickSort(int[] arr, int lowIndex, int highIndex) {
        int pivot = arr[highIndex];

        int leftPointer = lowIndex;
        int rightPointer = highIndex;
        if(leftPointer >= rightPointer){
            return;
        }
        while (leftPointer < rightPointer) {
            while (arr[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            while (arr[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
        swap(arr,leftPointer,rightPointer);
        }
        swap(arr,leftPointer,highIndex);
        quickSort(arr,lowIndex,leftPointer -1 );
        quickSort(arr,leftPointer+1, highIndex);
    }
    public static void swap(int[] arr, int index1, int index2){
        int temp = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = temp;
    }

    public static void main(String[] args) {
        System.out.println("Mains");
        int[] randomIntegers = new int[10];
        Random rand = new Random();
        for (int i=0;i<10;i++){
            randomIntegers[i] = rand.nextInt(100);
        }
        System.out.println("Before");
        for (int i = 0; i < randomIntegers.length; i++) {
            System.out.print(" "+randomIntegers[i]);
        }
        quickSort(randomIntegers, 0, randomIntegers.length - 1);
        System.out.println("After");
        for (int i = 0; i < randomIntegers.length; i++) {
            System.out.print(" "+randomIntegers[i]);
        }
    }
}
