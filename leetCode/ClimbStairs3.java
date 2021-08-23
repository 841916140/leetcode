
/**
 * 爬楼梯，不能爬到7及7的整数
 * dp[i],如果i为7的整数倍那么dp[i]=0即可
 */
public class ClimbStairs3 {
    public static void main(String[] args) {
        int n=8;
        System.out.println(climbStairs(n));
    }
    public static int climbStairs(int n)
    {
        int[]dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<dp.length;i++)
        {
            if(i%7==0)
            {
                dp[i]=0;
            }
            else
            {
                dp[i]=dp[i-1]+dp[i-2];
            }
        }
        return dp[n];
    }
}
