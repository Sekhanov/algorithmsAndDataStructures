package com.skhanov.algorithmsAndDataStructures;

/**
 * SortingAlgorithms
 */
public class SortingAlgorithms {

    public static void bubbleSort(int[] arr) {
        boolean needSort = true;;
        while(needSort) {
            needSort = false;
            for (int i = 1; i < arr.length; i++) {
                if(arr[i] < arr[i - 1]) {
                    swap(i, i - 1, arr);
                    needSort = true;
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if(arr[j] < arr[j - 1]) {
                    swap(j - 1, j, arr);
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;                    
                }
            }
            swap(min, i, arr);
        }
    }

    public static void mergeSort(int[] arr) {
        if(arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[arr.length - mid];
        
        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = arr[i];            
        }
        for (int i = 0; i < rightArr.length; i++) {
            rightArr[i] = arr[mid + i];
        }
        mergeSort(leftArr);
        mergeSort(rightArr);

        merge(arr, leftArr, rightArr);

    }

    private static void merge(int[] arr, int[] leftArr, int[] rightArr) {
        int l = 0, r = 0, a = 0;
        while(l < leftArr.length && r < rightArr.length) {
            if (leftArr[l] <= rightArr[r]) {
                arr[a++] = leftArr[l++];
            } else {
                arr[a++] = rightArr[r++];
            }
        }
        while (l < leftArr.length) {
            arr[a++] = leftArr[l++];
        }
        while (r < rightArr.length) {
            arr[a++] = rightArr[r++];
        }
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}