package easy;
/*9. Palindrome Number. Determine whether an integer is a palindrome. Do this without extra space.
�����壬�������ǡ���λ���ǡ�����׼�Ķ��壺���ַ�ת֮�󻹺�ԭ��һ����
����ʹ��extra space�����Բ���ʹ��intתString����ϵ��Ŀ7,ҲҪ����int�������.*/

public class Solution9 {
	
	/*old����ʹ����intתString����������ĿҪ��*/
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
    
    /*�Ƽ�����ķ��������Ʊ�׼��*/
    //���·���Ψһ���⣺δ����������������Ǹ��������⡣��wen587sort�Ľⷨһ����
    //�Ľ����Խ����Ŀ7�����±���newResult�����ڽ�β���жϡ�
    public static boolean isPalindrome(int x){
    	if(x<0) return false;
    	int result=0;
    	int y=x;//��Ҫ�������y����������Ϊ�����Ҫԭʼ����x���Ƚϡ�
    	while(y!=0){  
    		int newResult=result*10+y%10;
    		if(newResult-y%10!=result*10) {
    			return false;
    		}
    		result=newResult;
    		y/=10;
    	}
    	return (x==result)?true:false; //�ɼ�дΪ return ��x==result����
    }
    
    //����Ϊ�������Ž⣺ֻ�跭תһ��Ƚϼ��ɡ�
    /*���ͣ�x>res�������޶���ֻ��Ƚ�����һ�뼴�ɵó����ۡ�
     * ��xΪż��λ����88��ʱ��return�б�����Ϊx==res��
     * ��xΪ����λ����121��ʱ��return�б�����λx==res/10����ԭ������λ=ĩλ
     * ���ڵ�һ��if�ĵڶ���������x=0�������while�п��������жϡ�����x��λ�������ż�����return��������������˻�Ҫ�ж�x%10==0�����*/
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
