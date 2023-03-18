package com.sorting.countinversion;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public class MergeSortCountingInversions {


        public static long countInversions(List<Integer> arr) {
            int[] temp = new int[arr.size()];
            return mergeSort(arr, temp, 0, arr.size() - 1);
        }

        private static long mergeSort(List<Integer> arr, int[] temp, int left, int right) {
            if (left >= right) {
                return 0;
            }

            int mid = (left + right) / 2;
            long inversions = mergeSort(arr, temp, left, mid) + mergeSort(arr, temp, mid + 1, right);

            int i = left;
            int j = mid + 1;
            int k = 0;

            while (i <= mid && j <= right) {
                if (arr.get(i) <= arr.get(j)) {
                    temp[k++] = arr.get(i++);
                } else {
                    temp[k++] = arr.get(j++);
                    inversions += mid - i + 1;
                }
            }

            while (i <= mid) {
                temp[k++] = arr.get(i++);
            }

            while (j <= right) {
                temp[k++] = arr.get(j++);
            }

            for (i = left, k = 0; i <= right; i++, k++) {
                arr.set(i, temp[k]);
            }

            return inversions;
        }

        public static long sort(List<Integer> leftArr, List<Integer> rightArr, List<Integer> inputArr) {

            int i = 0, j = 0, k = 0;
            long swap = 0;
            while (i < leftArr.size() && j < rightArr.size()) {
                if (leftArr.get(i) <= rightArr.get(j)) {
                    inputArr.set(k, leftArr.get(i));

                    i++;
                } else {
                    inputArr.set(k, rightArr.get(j));
                    //the number of inversions which is how many elements are to the right of the array in the left.
                    // Since the two arrays are already sorted if the element on the right array is smaller than the left
                    // Than it must also be smaller than all other elements to the right of the current i element in the left Array.
                    swap = swap + (leftArr.size() - i);
                    j++;
                }
                k++;
            }

            while (i < leftArr.size()) {
                inputArr.set(k, leftArr.get(i));
                i++;
                k++;
            }

            while (j < rightArr.size()) {
                inputArr.set(k, rightArr.get(j));
                j++;
                k++;
            }
            return swap;

        }
    }
}
