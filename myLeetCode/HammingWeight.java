
/**
 * 输入是一个无符号整数n(以二进制串的形式),返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）
 * 有两种方式
 * 方法1：n-1会让n最低位的1变为0，如0110-1=0101，所以用n&n-1就能让最低位的1变为0
 * 所以每与一次就消除了一位1，直到为0时就没有位数就没有1了，
 * 循环次数等于 n 的二进制位中 1 的个数，最坏情况下n的二进制位全部为1。我们需要循环logn 次
 * 
 * 方法2：lowbit法
 * lowbit() 会在O(1) 复杂度内返回二进制表示中最低位1所表示的数值 例如lowbit(000110)=000010
 * 所以n每次减去该值后就能去除一位1,时间复杂度：O(k) k 为 int 的位数，固定为 32 位
 */
public class HammingWeight {
    public static void main(String[] args)
    {
        int n=00000000000000000000000000001011;
        int res=0;
        //法一
        // while(n!=0)
        // {
        //     n=n&(n-1);
        //     res++;
        // }
        while(n!=0)
        {
            n-=lowbit(n);
            res++;
        }
        //法二
        System.out.println(res);
    }
    public static int lowbit(int n)
    {
        return n&-n;
    }
    
}
