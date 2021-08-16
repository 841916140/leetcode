package leetCode;
import java.util.*;
/**
 * 全排列
 * 给定一个不含重复数字的数组 nums ，返回其所有可能的全排列
 * 递归回溯法
 * 
 */
public class Permute {
    static List<List<Integer>> res=new ArrayList<>();
    static List<Integer> list=new ArrayList<>();//用来存全排列的结果
    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3};
        List<List<Integer>> res=permute(nums);
        System.out.println(res.toString());
    }

    public static List<List<Integer>> permute(int[] nums)
    {
        
        for (int num : nums) 
        {
            list.add(num);
        }
        int n=nums.length;
        backtrack(n,0);
        return res;
    }

    public static void backtrack(int n,int cur)
    {
        if(cur==n)
        {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=cur;i<n;i++)
        {
            Collections.swap(list, i, cur);
            backtrack(n,cur+1);
            Collections.swap(list, i, cur);
        }
    }
}
