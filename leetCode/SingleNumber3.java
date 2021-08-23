
import java.util.Arrays;

public class SingleNumber3 {
    /**
     * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 
     * 找出只出现一次的那两个元素。你可以按任意顺序返回答案。
     * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现
     */
    public static void main(String[] args)
    {
        int []nums=new int[]{2,2,1,3};
        System.out.println(Arrays.toString(singleNumber3(nums)));
    }
    
    public static int[] singleNumber3(int[] nums)
    {
        /**
         * 如果跟之前一样，是从出现两次的数中找只出现一次的数，那么很简单，通过异或即可求得
         * 而现在有两个只出现一次的数，那么异或的值就是两个只出现一次的数的异或值
         * 而我们现在可以通过分治法将数分为两组，这两个只出现一次的数分到不同的组中，那么就和之前一样直接异或求得
         * 而如何进行分组把这两个不同的数区分开呢？我们知道如果直接进行异或，最后求得的值是这两个数的异或值
         * 我们看这个异或值的二进制位哪位为1，就说明这两个只出现一次的数在这一位上一个是0一个是1
         * 所以可以通过判断这一位是0还是1来进行分组，然后再分组内直接异或即可
         */
        int a=0;//异或值
        for(int num:nums)
        {
            a^=num;
        }
        System.out.println(a);
        int b=0;//异或值为1的位数
        for(int i=0;i<32;i++)
        {
            if(((a>>i)&1)==1)
            {
                b=i;
                break;
            }
        }
        int []res=new int[2];
        for(int num:nums)
        {
            if(((num>>b)&1)==0)
            {
                res[0]^=num;
            }
            else
            {
                res[1]^=num;
            }
        }
        return res;
    }
}
