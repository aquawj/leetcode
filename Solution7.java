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
	
	//���˵����Ž⣺�����Խ���жϡ���ʾ��intԽ������ֵ�为������Сֵ������������ж���������ʱ��˵���Ѿ�Խ�硣
	public int reverseBest(int x){
		int res=0;
		while(x!=0){       //x��=0����λ�������ٳ���
			int newRes=res*10+x%10;
			if(newRes-x%10!=res*10) return 0;  //�˴�Ϊ���㣬�ж��Ƿ�Խ�硣
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
