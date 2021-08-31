package leetCode;

public class GetBestGoldMining {
    /**
     * 经典动态规划题，0/1背包问题
     * 每个金矿可以选择挖或不挖，将复杂的问题简化为规模较小的子问题
     * 通过寻找最优子结构，然后从从子问题自底向上一步步递推，最终得到复杂问题的最优解
     * 比如10个矿工 5个金矿，可以分解为两个最优子结构
     * 1.如果第五个矿选择挖，假设第五个矿需要3人，则变为7个人在前四个金矿中最最优选择
     * 2.如果第五个矿选择不挖，则变为10个人在前四个金矿中做最优选择
     * 而两个最优子结构可以通向全局最优解则要进行比对
     * 看10个人在前四个金矿的收益，和7个工人在前四个金矿的收益+最后一个金矿的收益谁大
     * 然后对于前四个金矿的选择，又可以细分为子问题继续解决，这样一分为2，2分为4，一直把问题简化成0个金矿或0个矿工时的最优选择
     * 这个收益结果显然是0，也就是问题的边界
     * 状态转移方程如下：n是金矿数量，w是工人数量，p是金矿所需开采人数的数组，g是金矿的价值,F(n,w)为n个金矿，w个工人时最优收益
     * 1.F(n,w)=0(n=0或w=0)
     * 2.F(n,w)=F(n-1,w)(n>=1,w<p[n-1])所剩工人不够挖当前金矿时，只能选择不挖
     * 3.F(n,w)=Max(F(n-1,w),F(n-1,w-p[n-1])+g[n-1]) (n>=1,w>=p[n-1])所剩工人够挖当前金矿时，可以选择挖或不挖
     */
    public static void main(String[] args) {
        int w=10;
        int[] p=new int[]{5,5,3,4,3};
        int[] g=new int[]{400,500,200,300,350};
        System.out.println(getBestGoldMining(g.length,w,p,g));
    }

    public static int getBestGoldMining(int n,int w,int[] p,int[] g)
    {
        //定义一个二维数组dp[n][w],表示前n个金矿可供选择下，w个工人的最优
        int[][]dp=new int[n+1][w+1];
        //按照动态规划方程，填充dp数组，最后dp[n][w]的值即是最优解
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                if(j<p[j-1])
                {
                    dp[i][j]=dp[i-1][j];
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-p[i-1]]+g[i-1]);
                }
            }
            
        }
        return dp[n][w];
    }
}
