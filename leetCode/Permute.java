
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
        backtrack(nums);
        return res;
    }

    public static void backtrack(int[] nums)
    {
        if(list.size()==nums.length)
        {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(list.contains(nums[i]))
            {
                continue;
            }
            list.add(nums[i]);
            backtrack(nums);
            list.remove(list.size()-1);
        }
    }
}
