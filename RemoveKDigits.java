package August;

import java.util.*;
class RemoveKDigits {
	
	public static void main(String args[])
	{
		System.out.println(removeKdigits("1432219",3));
	}
	public static String removeKdigits(String num, int k) {
        if (k==0) return num;
        
        int len  = num.length();
        if(len==k) return String.valueOf(0);
        
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<len;i++)
        {
            
            while(k > 0 && !st.isEmpty() && st.peek() > num.charAt(i))
            {
                st.pop();
                k -= 1;
            }
            
                
            
            
            st.push(num.charAt(i));
        }
        
        //Handle 1111 edge case
        
        while(k>0 && !st.isEmpty())
        {
            st.pop();
             k -= 1;
        }
        StringBuilder sb = new StringBuilder();
        
        while(!st.isEmpty())
        {
            sb.append(st.pop());
        }
        sb.reverse();
        //Remove leading zeros
        
        int i=0;
        
        while(i < sb.length() && sb.charAt(0)=='0')
        {
            sb.deleteCharAt(0);
        }
        return sb.toString();
        
        
    }
}