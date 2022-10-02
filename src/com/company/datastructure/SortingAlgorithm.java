package org.training.datastructure;


import java.util.ArrayList;
import java.util.List;

public class SortingAlgorithm {

    public static void selectionSort(int[] arr, int size) {
        for (int i = 0; i < size - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[idx]) {
                    idx = j;
                }
            }
            swap(arr, i, idx);
        }
    }

    public static void bubbleSort(int[] arr, int size) {
        while (size != 1) {
            boolean optimize = false;
            for (int i = 0; i < size - 1; i++) {
                if (arr[i] < arr[i + 1]) {
                    optimize = true;
                    swap(arr, i, i + 1);
                }
            }
            if (!optimize)
                break;
            --size;
        }
    }

    public static void insertionSort(int[] arr, int size) {
        // Worst case -> O(n^2)  || Best case -> O(n)
        for (int i = 1; i < size; i++) {
            int current = arr[i];
            for (int j = i - 1; j > -1; --j) {
                if (current >= arr[j]) {
                    break;
                } else {
                    arr[j + 1] = arr[j];
                    arr[j] = current;
                }
            }
        }
    }

    public static void mergeSort(int[] arr, int l, int r) {
        // TODO: base case
        if (l == r) {
            return;
        }
        // TODO: Transition
        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        // TODO: Merge after transition
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        List<Integer> list = new ArrayList<>();
        int i = l;
        int j = mid + 1;
        while (i != mid + 1 || j != r + 1) {
            if (i > mid) {
                list.add(arr[j]);
                ++j;
            } else if (j > r) {
                list.add(arr[i]);
                ++i;
            } else if (arr[i] <= arr[j]) {
                list.add(arr[i]);
                ++i;
            } else if (arr[i] > arr[j]) {
                list.add(arr[j]);
                ++j;
            }
        }
        int w = 0;
        for (int q = l; q <= mid; ++w, q++) {
            arr[q] = list.get(w);
        }
        for (int k = mid + 1; k <= r; ++k, ++w) {
            arr[k] = list.get(w);
        }
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int pivot = partition(arr, l, r);
        quickSort(arr, l, pivot);
        quickSort(arr, pivot + 1, r);
    }

    private static int partition(int[] arr, int st, int end) { //o(n)
        int pivot = arr[st];
        int i = st;
        int j = end;
        while (i < j) {
            do {
                ++i;
            }
            while (arr[i] <= pivot);
            do {
                --j;
            }
            while (arr[j] > pivot);
            if (i < j) swap(arr, i, j);
        }
        swap(arr, st, j);
        return j;
    }

    public static void heapSort(int[] arr, int l, int r) {

    }

    public static int binarySearch(int[] arr, int n, int key) {
        int l = 0;
        int r = n;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == key) {
                return mid;
            } else {
                if (arr[mid] < key) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
        }
        return -1;
    }

    public static int linearSearch(int[] arr, int n, int key) {
        for (int i = 0; i < n; i++)
            if (arr[i] == key)
                return i;
        return -1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
