package leetCode;
public class SingleNumber2 {
    /**
     * 给你一个整数数组 nums ，除某个元素仅出现一次外，其余每个元素都恰出现三次 。
     * 请你找出并返回那个只出现了一次的元素。
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     */
    public static void main(String[] args)
    {
        int []nums=new int[]{2,2,2,1};
        System.out.println(singleNumber2(nums));
    }
    
    public static int singleNumber2(int[]nums)
    {
        //位数统计：使用一个长度为32 的数组cnt[] 记录下所有数值的每一位共出现了多少次1
        //再对 cnt[] 数组的每一位进行mod3 操作，重新拼凑出只出现一次的数值;时间复杂度：O(n),空间复杂度：O(1)
        int []cnt=new int[32];
        for(int num:nums)
        {
            for(int i=0;i<32;i++)
            {
                if(((num>>i)&1)==1)
                {
                    cnt[i]+=1;
                }
            }
        }
        int res=0;//一位一位拼凑值
        for(int i=0;i<32;i++)
        {
            if(cnt[i]%3==1)
            {
                res+=1<<i;
            }
        }
        return res;
    }

}
