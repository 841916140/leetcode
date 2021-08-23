import java.util.*;
/**
 * 搜索旋转排序数组,一个升序的数组如[0,1,2,4,5,6,7]在下标 3 处经旋转后变为[4,5,6,7,0,1,2]
 * 现给定这样一个旋转后的数组，和一个目标值，若数组中存在则返回其下标，不存在则返回-1
 * 
 * 思路：同样可以用二分查找法查找，这个旋转后的数组是局部有序的
 * 我们将它从中间分开后两部分中其中一部分肯定是有序的，如456和7012，拆分后左边是有序的
 * 所以我们可以用二分法来进行查找
 */
public class search1 {
    public static void main(String[] args) {
        int[] nums=new int[]{4,5,6,7,0,1,2};
        int target=0;
        System.out.println(search(nums,target));
    }
    public static int search(int[] nums,int target)
    {
        int n=nums.length;
        if(n==1)
        {
            return nums[0]==target?0:-1;
        }
        int left=0;
        int right=n-1;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            else if(nums[0]<=nums[mid])//左半区是有序的
            {
                if(nums[0]<=target&&target<nums[mid])
                {
                    right=mid-1;
                }
                else
                {
                    left=mid+1;
                }
            }
            else//右半区是有序的
            {
                if(nums[mid]<target&&target<=nums[right])
                {
                    left=mid+1;
                }
                else
                {
                    right=mid-1;
                }
            }
        }
        return -1;
    }
}
