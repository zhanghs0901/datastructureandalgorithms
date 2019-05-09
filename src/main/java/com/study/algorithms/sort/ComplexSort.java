package com.study.algorithms.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 相对复杂的排序算法
 *
 * @author duchu
 * @date 2019/4/23 10:59 PM
 */
public class ComplexSort {

    /**
     * 归并排序
     * 思路：我把数组从中间分成前后两部分，然后对前后两部分分别排序，然后把这两部分数组合并成一个有序数组，这样整个数组就是有序的了
     * <p>
     * <p>
     * 由此可以得出，数组A中元素第p到r个元素进行排序递归公式：merge_sort(A,p,r)= merge(merge_sort(A,p,q),merge_sort(p,q+1,r));
     * 其中：q = (p+r)/2; 终止条件：q>=r(也就是当前数组被拆分的只剩一个元素时);
     *
     * 时间复杂度 O(nlogn)
     */
    public static int[] guibingSort(int[] a) {
        return merge_sort(a,0,a.length-1);
    }

    private static int[] merge_sort(int[] A, int head, int tail) {
        if (head >= tail) {
            return Arrays.copyOfRange(A, head, head+1);
        }

        int middle = (tail + head) / 2;

        int[]sort1 = merge_sort(A, head, middle);
        int[]sort2 = merge_sort(A, middle + 1, tail);

//        int[]sort1 = Arrays.copyOfRange(A, head, middle+1);
//        int[]sort2 = Arrays.copyOfRange(A, middle+1, tail+1);
//        return merge(A,sort1, sort2);
         merge(A,head,middle, tail);
         return null;
    }

    private static void merge(int[] origin, int head,int middle, int tail) {

//        int[] result = new int[tail-head];

        int[]sort1 = Arrays.copyOfRange(origin, head, middle+1);
        int[]sort2 = Arrays.copyOfRange(origin, middle+1, tail+1);

        int leftIndex = 0, rightIndex = 0, resultIndex = head;


        while (leftIndex < sort1.length && rightIndex < sort2.length) {
            if (sort1[leftIndex] < sort2[rightIndex]) {
                origin[resultIndex++] = sort1[leftIndex++];
            } else {
                origin[resultIndex++] = sort2[rightIndex++];
            }
        }

        if (rightIndex == sort2.length) {
            while (leftIndex < sort1.length) {
                origin[resultIndex++] = sort1[leftIndex++];
            }
        }
        if (leftIndex ==sort1.length  ) {
            while (rightIndex < sort2.length) {
                origin[resultIndex++] = sort2[rightIndex++];
            }
        }


    }
    private static int[] merge(int[] origin, int[] sort1, int[] sort2) {

        int[] result = new int[sort1.length + sort2.length];

        int leftIndex = 0, rightIndex = 0, resultIndex = 0;


        while (leftIndex < sort1.length && rightIndex < sort2.length) {
            if (sort1[leftIndex] < sort2[rightIndex]) {
                result[resultIndex++] = sort1[leftIndex++];
            } else {
                result[resultIndex++] = sort2[rightIndex++];
            }
        }

        if (rightIndex == sort2.length) {
            while (leftIndex < sort1.length) {
                result[resultIndex++] = sort1[leftIndex++];
            }
        }
        if (leftIndex ==sort1.length  ) {
            while (rightIndex < sort2.length) {
                result[resultIndex++] = sort2[rightIndex++];
            }
        }
        return result;

    }

    /**
     * 快速
     * eg   [4 5 6 3 2 1]
     * 一次循环找到数组 [4 5 6 3 2 1]中的最小值放到有序列表尾部  [1 5 6 3 2 4]
     * 2次循环找到数组 [5 6 3 2 4]中的最小值放到有序列表尾部   [1 2 6 3 5 4]
     * 3次循环找到数组 [6 3 5 4]中的最小值放到有序列表尾部   [1 2 3 6 5 4]
     * 4次循环找到数组 [6 5 4]中的最小值放到有序列表尾部   [1 2 3 4 6 5]
     * 5次循环找到数组 [6 5]中的最小值放到有序列表尾部   [1 2 3 4 5 6]
     * <p>
     * <p>
     * 思路：分有序和无序数组，每次找到无序数组的 最小值（或最打值），然后放到有序数组的头部或尾部
     */
    public static void choseSort(int[] a) {
        if (a.length == 1) {
            return;
        }

        for (int i = 0; i < a.length - 1; i++) {

            int minValue = a[i];
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < minValue) {
                    minValue = a[j];
                    minIndex = j;
                }
            }
            a[minIndex] = a[i];
            a[i] = minValue;
        }
    }


    public static void main(String[] args) {
        int[] a = {3, 5, 8, 5, 9, 2, 6, 1};
        int[]sort1 = Arrays.copyOfRange(a, 0, 0);
        System.out.println(Arrays.toString(sort1));


//        SimpleSort.bubbleSort(a);
//        System.out.println(Arrays.toString(a));
//
//
//        int[] c = {3, 5, 8, 5, 9, 2, 6, 1};
//        choseSort(c);
//        System.out.println(Arrays.toString(c));
//
        int[] b = {3, 5, 8, 5, 9, 2, 6, 1};
        int[] b1 =guibingSort(b);
        System.out.println(Arrays.toString(b));

//        performacneCompare(1000);

    }

    /**
     * 随机生成 n 个数组，每个数组中包含 200 个数据
     *
     * @return
     */
    public static List<int[]> generateRodArray(int n) {

        List<int[]> list = new ArrayList<int[]>(n);
        Random ra = new Random();

        for (int i = 0; i < n; i++) {
            int[] temp = new int[2000];
            for (int j = 0; j < temp.length; j++) {
                //生产0~2000直接的随机数
                temp[j] = ra.nextInt(2000000);
            }
            list.add(temp);
        }
        return list;
    }


//    public static void performacneCompare(int n) {
//        List<int[]> a = generateRodArray(n);
//        long l = System.currentTimeMillis();
//        System.out.print("冒泡排序开始。。。。。");
//        for (int i = 0; i < a.size(); i++) {
//            bubbleSort(a.get(i));
//        }
//        System.out.println("冒泡排序结束。。。。。耗时：" + (System.currentTimeMillis() - l));
//
//
//        List<int[]> b = generateRodArray(n);
//
//        long bl = System.currentTimeMillis();
//        System.out.print("插入排序开始。。。。。");
//        for (int i = 0; i < b.size(); i++) {
//            SimpleSort.insertSort(b.get(i));
//        }
//        System.out.println("插入排序结束。。。。。耗时：" + (System.currentTimeMillis() - bl));
//
//
//        List<int[]> c = generateRodArray(n);
//        long cl = System.currentTimeMillis();
//        System.out.print("选择排序开始。。。。。");
//        for (int i = 0; i < c.size(); i++) {
//            choseSort(c.get(i));
//        }
//        System.out.println("选择排序结束。。。。。耗时：" + (System.currentTimeMillis() - cl));
//
//
//    }
}
