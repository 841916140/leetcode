package leetCode;
import java.util.*;
/**
 * 给定一个字符串，如h)e(dh()ei9()34(39))，求其中括号的对数
 */
public class CountBrackets {
    public static void main(String[] args) {
        String s="h)e(dh()ei9()34(39))";
        System.out.println(countBrackets(s));
    }
    public static int countBrackets(String s)
    {
        int res=0;
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==')')
            {
                if(!stack.isEmpty()&&stack.pop()=='(')
                {
                    res++;
                }
                else
                {
                    continue;
                }
            }
            else if(s.charAt(i)=='(')
            {
                stack.push(s.charAt(i));
            }
        }
        return res;
    }
}
