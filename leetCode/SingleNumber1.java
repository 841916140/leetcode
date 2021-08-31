package leetCode;
public class SingleNumber1 {
    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     */
    public static void main(String[] args)
    {
        int []nums=new int[]{2,2,1};
        System.out.println(singleNumber1(nums));
    }

    public static int singleNumber1(int[] nums)
    {
        int res=0;
        for(int num:nums)
        {
            res^=num;
        }
        return res;
    }
    
}
