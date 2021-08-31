package leetCode;
import java.util.Deque;
import java.util.LinkedList;

public class RemoveKdigits {
    /**
     * 给你一个以字符串表示的非负整数 num 和一个整数 k 
     * 移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
     * 思路：把高位的数字降低，则对新整数的值影响最大，把原整数的所有数字从左到右进行比较，
     * 如果发现某一位数字大于它右边的数字，那么在删除该数字后，必然会使该数位的值降低，
     * 因为右面比它小的数字顶替了它的位置
     * 从局部最优解，得到全局最优解的思路，叫做贪心算法。
     * 用单调栈+贪心算法的方式实现，栈用队列实现
     * 考虑到栈的特点是后进先出，如果通过栈实现，
     * 则需要将栈内元素依次弹出然后进行翻转才能得到最小数。
     * 为了避免翻转操作，可以使用双端队列代替栈的实现。
     */
    public static void main(String[] args) {
        String s="1000000123";
        int k=2;
        System.out.println(removeKdigits(s,k));
    }

    public static String removeKdigits(String num,int k)
    {
        int length=num.length();
        if(length<=k)
        {
            return "0";
        }
        Deque<Character> deque=new LinkedList<>();
        for(int i=0;i<length;i++)
        {
            /**
             * 对于每个数字，如果该数字小于栈顶元素，我们就不断地弹出栈顶元素，
             * 直到栈为空
             * 或者新的栈顶元素不大于当前数字
             * 或者我们已经删除了k位数字
             */
            char c=num.charAt(i);
            while(!deque.isEmpty()&&k>0&&deque.peekLast()>c)
            {
                deque.pollLast();
                k--;
            }
            deque.offerLast(c);
        }
        //如果没有去除掉k个数则直接移除栈顶即末尾的数即可
        for(int i=0;i<k;i++)
        {
            deque.removeLast();
        }
        StringBuilder res=new StringBuilder(); 
        //剔除前缀0
        boolean flag=true;//是不是开头的0
        while(!deque.isEmpty())
        {
            char c=deque.pollFirst();
            if(c=='0'&&flag)
            {
                continue;
            }
            flag=false;//出现了第一个非0的数，则后面出现的0都不是整数开头的0了
            res.append(c);
        }
        //当前面的步骤没有移除掉3个数字时，则直接移除末尾的值即可，newLength-offset限定了新字符串的长度，会移除掉末尾
        return res.length()==0?"0":res.toString();

    }
    
}
