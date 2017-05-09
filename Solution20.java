package easy;
import java.util.*;

public class Solution20 {
	public boolean isValidOld(String s) { //思路：必须(在左边，)在右边。自己发现了错误：无法处理()()()这样的情况
		if(s.isEmpty()) return false;
		if(s.length()%2!=0) return false;
		else{
			String left=s.substring(0, s.length()/2);
			String right=s.substring(s.length()/2,s.length());
			boolean b=(left.contains(")"))||(left.contains("}"))||(left.contains("]"))||(right.contains("("))||(right.contains("["))||(right.contains("{"));
			if(b) return false;
			return true;
		}
	}
	public boolean isValid(String s) { //自己写的。已经accepted。
		
		if(s.length()==0||s.length()==1) return false;
		
		ArrayList<Character> list=new ArrayList<Character>();	
		for(int i=0;i<s.length();i++){
			list.add(s.charAt(i));  //将每个字符存入ArrayList
			if(list.size()==1) continue;
			char last=list.get(list.size()-1);
			char last2=list.get(list.size()-2);
			boolean b1=(last==')'&&last2=='(');
			boolean b2=(last==']'&&last2=='[');
			boolean b3=(last=='}'&&last2=='{');
				if(b1||b2||b3){     //如果配对，移除出去
					list.remove(list.size()-1);
					list.remove(list.size()-1);
				}
			}
			if(list.size()!=0) return false;  //只要数组还有剩余元素，说明没有完全匹配，返回false
			return true;
	}
	
	public static void main(String[] args){
		Solution20 sl=new Solution20();
		String s="";
		System.out.println(sl.isValid(s));
		s="((())";
		System.out.println(sl.isValid(s));
		s="((()))";
		System.out.println(sl.isValid(s));
		s=")()()(";
		System.out.println(sl.isValid(s));
		s="()()()";
		System.out.println("OLd:"+sl.isValidOld(s));
		System.out.println(sl.isValid(s));
		
		System.out.println("---complex----");
		String s1="[";
		System.out.println(sl.isValid(s1));
		s1="()[]{}";
		System.out.println(sl.isValid(s1));
		s1="(})([]";
		System.out.println(sl.isValid(s1));
		s1="(({}[)])";
		System.out.println(sl.isValid(s1));

	}
}
