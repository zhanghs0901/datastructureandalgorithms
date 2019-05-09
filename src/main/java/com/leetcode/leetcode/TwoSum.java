package com.leetcode.leetcode;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1]
 *
 * @author duchu
 * @date 2019/5/8 7:55 AM
 */
public class TwoSum {

    /**
     * 题目大意：给定一个int类型的数组，给的一个目标值：target，找出数组中两个加起来等于目标值的元素下标。
     *  题目前提：假设每个目标值在数组中只存在一个正确答案，并且同一个元素不能用两次
     *
     * 假定给的数组为n，长度为s
     *
     * 思路1：嵌套循环
     *
     * 外层循环：从i（i=0）开始遍历数组n，
     * 内层循环：遍历第j个元素（j=[i,s-1])，判断n[i]+n[j] 是否等于目标值
     * 时间复杂度：O(n2)
     *
     *
     * 思路2：利用hashMapkey值来存放数组n中元素的值，value存放元素在数组n中的下标。
     *  遍历数组n，把当前数组每个值作为要寻找的目标下标a，然后把当前map看着是另一个要寻找的下标集合。
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> otherTargetIndexMap = new HashMap(nums.length);

        for (int i = 0; i <nums.length ; i++) {
            otherTargetIndexMap.put(nums[i],i);
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>target){
                continue;
            }
            int targetValue = target-nums[i];
            Integer otherTargetIndex = otherTargetIndexMap.get(targetValue);
            if (otherTargetIndex != null && otherTargetIndex!=i) {
                return new int[]{i,otherTargetIndex};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int [] nums = new int[]{3,2,4};
        int target = 6;
        System.out.print(Arrays.toString(twoSum(nums,target)));
    }
}
