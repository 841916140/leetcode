package leetCode;

/**
 * @author DavidQ
 * @version 1.0.0
 * @ClassName FindKthNumber.java
 * @Description 字典序的第K小数字
 * 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
 * 整个字典序排列也就是对十叉树进行先序遍历
 * 我们需要找到排在第k位的数,因此就需要找先序遍历的第k个节点即可
 * 所以我们需要统计每个前缀下所有子节点的数量，通过下一个前缀的起点减去当前前缀的起点，就得到当前前缀下的所有子节点数总和
 * 需要注意当下一个前缀起点的值大于上界的时候，那以这个前缀为根节点的十叉树就不是满十叉树了，应该到上界那里，后面都不再有子节点
 * 计算完当前前缀节点数后我们只需要判断第k个数在不在当前前缀，如果在则往子树里继续寻找，如果不在则换一个前缀
 * @createTime 2021年08月31日 09:48:00
 */
public class FindKthNumber {
    public static void main(String[] args) {
        int n=13;
        int k=2;
        int cur=1;
        k-=1;//第一小的数为1是固定的
        while(k>0)
        {
            //计算当前前缀下的所有子节点数
            int nums = getNums(n, cur, cur + 1);
            if (nums > k)
            {
                //第k个数在当前前缀下
                cur *= 10;
                //多了一个确定节点，继续-1
                k -= 1;
            }
            else
            {
                //不在当前前缀下
                cur+=1;//换下一个前缀
                k-=nums;
            }
        }
        System.out.println(cur);

    }
    public static int getNums(int n,long cur,long next)
    {
        //要注意int越界
        int count=0;
        while(cur<=n)
        {
            count+=Math.min(n+1,next)-cur;//比如12-10只计算出两个，但是实际上有三个10 11 12所以要+1
            // 如果说刚刚prefix是1，next是2，那么现在分别变成10和20
            // 1为前缀的子节点增加10个，十叉树增加一层, 变成了两层
            cur*=10;
            next*=10;
        }
        return count;
    }
}
