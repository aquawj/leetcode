package easy;

import java.util.HashMap;
import java.util.Map;
	/*
 	13.Given a roman numeral, convert it to an integer.
	Input is guaranteed to be within the range from 1 to 3999.
	 */

public class Solution13 {
	/*
	 * 自己的老方法理解错误：以为只要小的在左边全部减，小的在右边全部加。当时的思路是找到最大的，最后结果是右边和减左边和。属于转化法则理解错误。
	 * 而且用了map，以及遍历次数过多，效率低下。
	 */
	public int romanToIntOld(String s) {
		String[] markers = { "I", "V", "X", "L", "C", "D", "M" };
		int number = 0, position = 0;

		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0, r = 1; i < 7; i += 2, r *= 10) {
			map.put(markers[i], r);
		}
		for (int i = 1, r = 5; i < 6; i += 2, r *= 10) {
			map.put(markers[i], r);
		}

		int[] num = new int[s.length()];
		num[0] = map.get(s.charAt(0));
		int left = 0, right = 0;
		for (int i = 1; i < s.length(); i++) {
			int marker = s.charAt(i);
			num[i] = map.get(marker);
			if (num[i] > num[i - 1]) {
				position = i;
			}
		}
		for (int i = 0; i < position; i++) {
			left += num[i];
		}
		for (int i = position; i < s.length(); i++) {
			right += num[i];
		}
		number = right - left;
		System.out.println(number);
		return number;
	}

	// 以下为自己练习写最优解法
	public int romanToInt(String s) {
		int res = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			switch (c) {
			case ('I'): {
				res += (res >= 5 ? -1 : 1);
				break; // 注意break。第一次自己写落下了。
			}
			case ('V'): {
				res += 5;
				break;
			}
			case ('X'): {
				res += (res >= 50 ? -10 : 10);
				break;
			}
			case ('L'): {
				res += 50;
				break;
			}
			case ('C'): {
				res += (res >= 500 ? -100 : 100);
				break;
			}
			case ('D'): {
				res += 500;
				break;
			}
			case ('M'): {
				res += 1000;
				break;
			}
			}
		}
		return res;
	}

	//方法2：所有数按照代表的值加一遍。如果遇到前置的几种情况，要减2遍代表的值（因为已经加过一遍）。
	public int romanToInt2(String s) {
		int res = 0;
		//6种前置情况
		if (s.contains("IV"))
			res -= 2;
		if (s.contains("IX"))
			res -= 2;
		if (s.contains("XL"))
			res -= 20;
		if (s.contains("XC"))
			res -= 20;
		if (s.contains("CD"))
			res -= 200;
		if (s.contains("CM"))
			res -= 200;
		for (int i = 0; i < s.length(); i++) {  //从前或者从后遍历都可以，不影响。
			char c = s.charAt(i);
			switch (c) {
			case 'I': {
				res += 1;
				break;
			}
			case 'V': {
				res += 5;
				break;
			}
			case 'X': {
				res += 10;
				break;
			}
			case 'L': {
				res += 50;
				break;
			}
			case 'C': {
				res += 100;
				break;
			}
			case 'D': {
				res += 500;
				break;
			}
			case 'M': {
				res += 1000;
				break;
			}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Solution13 sl = new Solution13();

		System.out.println(sl.romanToInt("XIV"));
		System.out.println(sl.romanToInt2("XIV"));
	}
}
