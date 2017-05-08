package easy;

public class Solution14 {
	//�Լ��ķ������У����е㸴�ӡ��������м򻯷�����
	 public String longestCommonPrefix(String[] strs) {
	        if(strs.length==0 || strs[0]=="") return ""; // ��ʼû�뵽�ı߽�����
	        if(strs.length==1) return strs[0]; //��ʼû�뵽�ı߽�����
			 	String longPre="";
			 	int key=Integer.MAX_VALUE;
		        for(int i=1;i<strs.length;i++){ //������һ�д�����ʾ����java.lang.StringIndexOutOfBoundsException: String index out of range: 0
		        	//ע��Ҫ����ǰԪ��Ϊ�յ�����д��ǰ�档��Ȼ��������˵����ʾ������Ϊ����Ϊ�յĿ����ԣ�������charAt(0)����ĿǰIDEͨ������leetcode��Ȼ˵�����������⣬����Ϊ{"",""}���⣩
		        	if((strs[i]=="")||(strs[i].charAt(0)!=strs[i-1].charAt(0))) //��ǰԪ��Ϊ�գ��ǿ�ʼû�뵽�ı߽�����
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
	 
	 //���˵����Ž⡣����⡣
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
		 String[] strs4={"",""};//��֪��Ϊʲôleetcode���ڴ���������ʾ12�л���ֱ߽����0����
		 System.out.println("strs4:"+sl.longestCommonPrefix(strs4));
		 System.out.println("strs4:"+sl.longestCommonPrefix2(strs4));
	 }
}


