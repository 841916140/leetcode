import java.util.*;
/**
 * 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集不能包含重复的子集。你可以按任意顺序 返回解集。
 * 用递归回溯算法
 */

public class Subsets {
    static List<Integer> list=new ArrayList<>();
    static List<List<Integer>> res=new ArrayList<>();
    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3};
        subsets(nums,0);
        System.out.println(res.toString());
    }
    public static void subsets(int[] nums,int cur)
    {
        if(cur==nums.length)
        {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        list.add(nums[cur]);
        subsets(nums,cur+1);
        list.remove(list.size()-1);//递归回溯后去掉末位，重新组合排列如 1 2 3 ->1 2 ,1 2->1 3
        subsets(nums, cur+1);
    }
}
