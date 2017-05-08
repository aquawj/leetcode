package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].*/

public class Solution1{
	public static int[] twoSumOld(int[] nums, int target){
		int[] outcome=new int[2];
		for(int i=0;i<nums.length-1;i++){
			for(int j=i+1;j<nums.length;j++){
				if(nums[i]+nums[j]==target){
					outcome[0]=i;
					outcome[1]=j;
					break;
				}
			}
		}
		return outcome;
	}
	
	public static int[] twoSum(int[] nums,int target){
		Map<Integer,Integer> map=new HashMap<Integer, Integer>();
		int[] result=new int[2];
		for(int i=0;i<nums.length;i++){
			
			if(map.containsKey(target-nums[i])){
				result[1]=i;
				result[0]=map.get(target-nums[i]);
				break;
			}
			map.put(nums[i],i);
			
		}
		return result;
	}
	// add an extra function to practice reversing
	public static void reverseArray(int[] nums){
		for(int i=0;i<nums.length/2;i++){
			int temp=nums[i];
			nums[i]=nums[nums.length-1-i];
			nums[nums.length-1-i]=temp;
		}
	}
	
	public static void main(String[] args){
		int[] nums={3,2,4};
		System.out.println(Arrays.toString(twoSumOld(nums,6)));
		System.out.println(Arrays.toString(twoSum(nums,6)));
		// below are not needed in leetcode 1.
		reverseArray(nums);
		System.out.println(Arrays.toString(nums));
	}

	
}

