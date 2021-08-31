/**
 * 二分查找
 * 给定一个有序数组，找出目标值的下标，找不到则返回-1
 */
public class Search {
    public static void main(String[] args) {
        int[] nums=new int[]{1,5,6,7,9,11,15,16};
        int target=16;
        int left=0;
        int right=nums.length-1;
        int res=-1;
        while(left<=right)
        {
            int mid=left+(right-left)/2;//不用left+right/2是因为有可能会溢出
            if(nums[mid]==target)
            {
                res=mid;
                break;
            }
            else if(nums[mid]<target)
            {
                left=mid+1;
            }
            else
            {
                right=mid-1;
            }
        }
        System.out.println(res);
    }

}
