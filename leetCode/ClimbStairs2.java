
/**
 * 爬楼梯的拓展，不能连续走两步，也就是说上一次走了两步，下一次就不能走
 * 思路:动态规划+递归
 * f(n) = f(n-1)+f(n-2)
 * 如果是f(n-2),说明爬了两步到达n层，则需要记录该状态，他的上一步只能是爬一步
 * 如果是f(n-1)，说明爬了一步到达n层，记录该状态，他的上一步可以是一步或者两步；
 * f(n, status) = f(n-1, 1)+f(n-2,2);
 */

public class ClimbStairs2 {
    public static void main(String[] args) {
        int n=5;
        System.out.println(climbStairs(n,0));
    }
    public static int climbStairs(int n,int status)
    {
        if(n==0)
        {
            return 0;
        }
        else if(n==1)
        {
            return 1;
        }
        else if(n==2)
        {
            if(status==0)//0是初始状态，也就是说阶数就为2
            {
                return 2;
            }
            else if(status==1)//状态1表示下一次走了一步，那么这次可以走两步或1步所以有两种走法
            {
                return 2;
            }
            else //状态2表示下次走了两步，那么这次只能走一步，所以只有一种走法
            {
                return 1;
            }
        }
        else
        {
            if(status==0)//初始状态有两种走法
            {
                return climbStairs(n-1,1)+climbStairs(n-2, 2);
            }
            else if(status==1)//下一次走了一步，那么这一次有两种走法
            {
                return climbStairs(n-1,1)+climbStairs(n-2, 2);
            }
            else//下一次走了两步，那么这一次有1种走法
            {
                return climbStairs(n-1,1);
            }
        }
    }
}
