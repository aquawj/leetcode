package easy;
/*9. Palindrome Number. Determine whether an integer is a palindrome. Do this without extra space.
按定义，负数不是。个位数是。更精准的定义：数字反转之后还和原来一样。
不能使用extra space，所以不能使用int转String。联系题目7,也要考虑int溢出问题.*/

public class Solution9 {
	
	/*old方法使用了int转String，不符合题目要求*/
    public static boolean isPalindromeOld(int x) {
    	if(x<0) return false;
        String str=Integer.toString(x);
        int N=str.length();
        for(int i=0,j=N-1;i<N/2;i++,j-- ){
        	if(str.charAt(i)!=str.charAt(j)){
        		return false;
        	}
        }
        return true;
    }
    
    /*推荐下面的方法，近似标准答案*/
    //以下方法唯一问题：未考虑溢出。但这仍是个争议问题。和wen587sort的解法一样。
    //改进可以结合题目7，设新变量newResult，并在结尾加判断。
    public static boolean isPalindrome(int x){
    	if(x<0) return false;
    	int result=0;
    	int y=x;//需要新设变量y来操作，因为最后还需要原始数据x来比较。
    	while(y!=0){  
    		int newResult=result*10+y%10;
    		if(newResult-y%10!=result*10) {
    			return false;
    		}
    		result=newResult;
    		y/=10;
    	}
    	return (x==result)?true:false; //可简写为 return （x==result）；
    }
    
    //以下为别人最优解：只需翻转一半比较即可。
    /*解释：x>res条件，限定了只需比较数字一半即可得出结论。
     * 当x为偶数位（如88）时，return判别条件为x==res；
     * 当x为基数位（如121）时，return判别条件位x==res/10，即原数据首位=末位
     * 对于第一行if的第二个条件：x=0的情况在while中可以正常判断。由于x的位数可奇可偶，结合return的两个条件，因此还要判断x%10==0的情况*/
    public static boolean isPalindromeBest(int x){
    	if((x<0)||(x!=0 && x%10==0)) return false;
    	int res=0;
    	while(x>res){
    		res=res*10+x%10;
    		x/=10;
    	}
    	return (x==res)||(x==res/10);
    }
    
    public static void main(String[] args){
    	System.out.println(isPalindromeOld(12321));
    	System.out.println(isPalindromeOld(552255));
    	System.out.println(isPalindromeOld(-3223));
    	System.out.println(isPalindromeOld(0));
    	
    	System.out.println("----------");
    	System.out.println(isPalindrome(12321));
    	System.out.println(isPalindrome(552255));
    	System.out.println(isPalindrome(-3223));
    	System.out.println(isPalindrome(0));

    }
}
