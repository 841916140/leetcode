package leetCode;


public class MissingNumber {
    /**
     * 缺失的数字，给出一个长度为n-1的递增数组，其中缺失了0~n-1 n个数中的一个，请你找出这个数
     */
    public static void main(String[] args) {
        int[] nums=new int[]{0,1,2,3,4,5,6,7,9};
        System.out.println(missingNumber(nums));
    }
    public static int missingNumber(int[] nums)
    {
        //先累加0~n-1，然后再用这个累加值循环的去减数组中的值，最后得到的即是缺失的值
        int n=nums.length;
        int sum=0;
        for(int i=0;i<=n;i++)
        {
            sum+=i;
        }
        for(int i=0;i<n;i++)
        {
            sum-=nums[i];
        }
        return sum;

    }
    
}
