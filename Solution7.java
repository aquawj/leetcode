package easy;

public class Solution7 {
	public static int reverseOld(int x) {
		if (x < 0) {
			return -normalReverse(-x);
		}
		return normalReverse(x);
	}

	public static int normalReverse(int x) {
		String str = Integer.toString(x);
		String reStr = reverseString(str);
		int rx = Integer.parseInt(reStr);
		/*
		 * if(rx>Integer.MAX_VALUE||rx<Integer.MIN_VALUE){ return 0; }
		 */
		return rx;
	}

	public static String reverseString(String str) {
		String reStr = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			reStr += str.charAt(i);
		}
		return reStr;
	}

	public static int reverse(int x) {
		int result = 0;
		while (x != 0) {
			int tail = x % 10;
			result = result * 10 + tail;
			x = x / 10;
		}
		return result;
	}
	
	//别人的最优解：巧妙的越界判断。提示：int越界后最大值变负数，最小值变正数。因此判断条件不等时，说明已经越界。
	public int reverseBest(int x){
		int res=0;
		while(x!=0){       //x！=0，个位数不能再除了
			int newRes=res*10+x%10;
			if(newRes-x%10!=res*10) return 0;  //此处为亮点，判断是否越界。
			res=newRes;
			x/=10;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(reverseOld(321));
		System.out.println(reverseOld(-321));
		System.out.println(reverseOld(1200));
		System.out.println(reverseOld(0));
		// System.out.println(reverseOld(1000000003));
		System.out.println("----better method----");
		System.out.println(reverse(321));
		System.out.println(reverse(-321));
		System.out.println(reverse(1200));
		System.out.println(reverse(0));
	}
}
