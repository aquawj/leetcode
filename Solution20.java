package easy;
import java.util.*;

public class Solution20 {
	public boolean isValidOld(String s) { //˼·������(����ߣ�)���ұߡ��Լ������˴����޷�����()()()���������
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
	public boolean isValid(String s) { //�Լ�д�ġ��Ѿ�accepted��
		
		if(s.length()==0||s.length()==1) return false;
		
		ArrayList<Character> list=new ArrayList<Character>();	
		for(int i=0;i<s.length();i++){
			list.add(s.charAt(i));  //��ÿ���ַ�����ArrayList
			if(list.size()==1) continue;
			char last=list.get(list.size()-1);
			char last2=list.get(list.size()-2);
			boolean b1=(last==')'&&last2=='(');
			boolean b2=(last==']'&&last2=='[');
			boolean b3=(last=='}'&&last2=='{');
				if(b1||b2||b3){     //�����ԣ��Ƴ���ȥ
					list.remove(list.size()-1);
					list.remove(list.size()-1);
				}
			}
			if(list.size()!=0) return false;  //ֻҪ���黹��ʣ��Ԫ�أ�˵��û����ȫƥ�䣬����false
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
