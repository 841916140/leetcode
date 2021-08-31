package leetCode;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 斐波那契数列:0 1 2 3 5
 */

public class ClimbStairs1 {
    public static void main(String[] args) {
        int n=6;
        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n)
    {
        int p=0;
        int q=1;
        int r=1;
        for(int i=1;i<n;i++)
        {
            p=q;
            q=r;
            r=p+q;
        }
        return r;
    }
}
