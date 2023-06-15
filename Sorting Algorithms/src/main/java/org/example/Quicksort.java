package org.example;

import java.util.Random;

public class Quicksort {
    public static void quickSort(int[] arr, int lowIndex, int highIndex) {
        //int pivot = arr[highIndex];

        int leftPointer = lowIndex;
        int rightPointer = highIndex;
        if(leftPointer >= rightPointer){
            return;
        }
        //Choosing a Pivot has a impact on Average Case.
        // We are randomly the choosing the pivot and doing the sorting

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, highIndex);
        //If the left side is greater move the index
        //If the right side is lesser increase the index
        while (leftPointer < rightPointer) {
            while (arr[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            while (arr[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
        //The left index will be in a position where the number is large and right index will be in position where the number is large. Swap each other
        swap(arr,leftPointer,rightPointer);
        }
        //Swap the last element which is higher with the leftpointer.
        swap(arr,leftPointer,highIndex);
        //Sort the left half and right half separately
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
        for (int i: randomIntegers) {
            System.out.print(" "+i);
        }
        quickSort(randomIntegers, 0, randomIntegers.length - 1);
        System.out.println("After");
        for (int i: randomIntegers) {
            System.out.print(" "+i);
        }
    }
}
