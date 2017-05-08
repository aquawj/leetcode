package easy;

/*14.Write a function to find the longest common prefix string amongst an array of strings.*/

public class Solution14 {
	//自己的方法可行，但有点复杂。其他人有简化方法。
	 public String longestCommonPrefix(String[] strs) {
	        if(strs.length==0 || strs[0]=="") return ""; // 开始没想到的边界条件
	        if(strs.length==1) return strs[0]; //开始没想到的边界条件
			 	String longPre="";
			 	int key=Integer.MAX_VALUE;
		        for(int i=1;i<strs.length;i++){ //？下面一行代码提示错误：java.lang.StringIndexOutOfBoundsException: String index out of range: 0
		        	//注意要将当前元素为空的条件写在前面。不然会有上面说的提示错误，因为存在为空的可能性，不存在charAt(0)。（目前IDE通过，但leetcode仍然说存在上面问题，用例为{"",""}不解）
		        	if((strs[i]=="")||(strs[i].charAt(0)!=strs[i-1].charAt(0))) //当前元素为空，是开始没想到的边界条件
		        		return "";
		        	int minl=Math.min(strs[i].length(),strs[i-1].length());
		        	int count=0;
		        	for(int j=1;j<minl;j++){
		        		if(strs[i].charAt(j)==strs[i-1].charAt(j)) 
		        			count++;
		        	}
		        	key=Math.min(count, key);
		        }
		        for(int i=0;i<=key;i++){
		        	longPre+=strs[0].charAt(i);
		        }
		        return longPre;
		    }
	 
	 //下面为别人的最优解。不理解。
	 public String longestCommonPrefix2(String[] strs) {
		    if (strs.length == 0) return "";
		    String pre = strs[0];
		    for (int i = 1; i < strs.length; i++)
		        while(strs[i].indexOf(pre) != 0)
		            pre = pre.substring(0,pre.length()-1);
		    return pre;
		}
	 
	 public static void main(String[] args){
		 Solution14 sl=new Solution14();
		 String[] strs={"weha","ppis","weh","wehi"};
		 System.out.println("strs:"+sl.longestCommonPrefix(strs));
		 System.out.println("strs:"+sl.longestCommonPrefix2(strs));
		 String[] strs2={"abcddd","abcde","abcd","abcdeewq"};
		 System.out.println("strs2:"+sl.longestCommonPrefix(strs2));
		 System.out.println("strs2:"+sl.longestCommonPrefix2(strs2));
		 String[] strs3={"ab","","","",""};
		 System.out.println("strs3:"+sl.longestCommonPrefix(strs3));
		 System.out.println("strs3:"+sl.longestCommonPrefix2(strs3));
		 String[] strs4={"",""};//不知道为什么leetcode会在此用例上提示14行会出现边界溢出0错误。
		 System.out.println("strs4:"+sl.longestCommonPrefix(strs4));
		 System.out.println("strs4:"+sl.longestCommonPrefix2(strs4));
	 }
}


