package com.nana.studyjavarepo.sort;

public class Sort {
    /**
     * 1.交换排序
     * 冒泡排序
     *
     * @param a
     */
    public void bubbleSort(int[] a) {
        int temp;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 2。选择排序
     * 简单选择排序
     *
     * @param a
     */
    public void selectSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = a[i];
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }


}
