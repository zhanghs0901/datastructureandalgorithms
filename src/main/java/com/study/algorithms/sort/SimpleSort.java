package com.study.algorithms.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 一简单的排序算法
 *
 * @author duchu
 * @date 2019/4/23 10:59 PM
 */
public class SimpleSort {

    /**
     * 冒泡排序
     * 思路：先找出数组中元素的最大值或最小值
     * <p>
     * 假设数组大小为n，则每相邻的两个数字就行比较，这样每次遍历后就会找打一个最大值（或最小值），然后用同样的方法找出剩下的n-1个元素的最大（或最小值）
     */
    public static void bubbleSort(int[] a) {

        if (a.length == 1) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            boolean ischang = false;

            for (int j = 1; j < a.length - i; j++) {
                //找出最大值
                int temp = a[j];
                if (a[j - 1] > temp) {
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                    ischang = true;
                }
            }

            if(!ischang){
                break;
            }
        }
    }

    /**
     * 插入排序
     * <p>
     * 思路：可以把当前数组看成一个有序数组和一个无序数组。
     * 1、有序数组的初始值为第一个元素
     * 2、无序数组的初始值为后面n-1个元素
     * 3、然后把后面无序数组中的元素依次有序的插入到前面的有序数组中
     */
    public static void insertSort(int[] a) {
        if (a.length == 1) {
            return;
        }

        for (int i = 1; i < a.length; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }

    /**
     * 选择排序
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
        bubbleSort(a);
        System.out.println(Arrays.toString(a));

        int[] b = {3, 5, 8, 5, 9, 2, 6, 1};
        insertSort(b);
        System.out.println(Arrays.toString(b));

        int[] c = {3, 5, 8, 5, 9, 2, 6, 1};
        choseSort(c);
        System.out.println(Arrays.toString(c));

        performacneCompare(1000);

    }

    /**
     * 随机生成 n 个数组，每个数组中包含 200 个数据
     *
     * @return
     */
    public static List<int[]> generateRodArray(int n) {

        List<int[]> list = new ArrayList<int[]>(n);
        Random ra =new Random();

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


    public static void performacneCompare(int n){
        List<int[]> a = generateRodArray(n);
        long l = System.currentTimeMillis();
        System.out.print("冒泡排序开始。。。。。");
        for (int i = 0; i <a.size(); i++) {
            bubbleSort(a.get(i));
        }
        System.out.println("冒泡排序结束。。。。。耗时："+(System.currentTimeMillis()-l));


        List<int[]>b  = generateRodArray(n);

        long bl = System.currentTimeMillis();
        System.out.print("插入排序开始。。。。。");
        for (int i = 0; i <b.size(); i++) {
            insertSort(b.get(i));
        }
        System.out.println("插入排序结束。。。。。耗时："+(System.currentTimeMillis()-bl));


        List<int[]>c  = generateRodArray(n);
        long cl = System.currentTimeMillis();
        System.out.print("选择排序开始。。。。。");
        for (int i = 0; i <c.size(); i++) {
            choseSort(c.get(i));
        }
        System.out.println("选择排序结束。。。。。耗时："+(System.currentTimeMillis()-cl));



    }
}
