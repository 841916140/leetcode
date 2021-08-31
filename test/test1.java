package test;
import java.util.*;

public class test1 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String s=scan.nextLine();
        String []arr=s.split(" ");
        int []nums=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            nums[i]=Integer.valueOf(arr[i]);
        }
        int m=scan.nextInt();
        if(nums.length<2)
        {
            System.out.println(0);
        }
        Arrays.sort(nums);
        int a=0;
        int b=a+1;
        int sum=0;
        while(a!=b&&a<nums.length&&b<nums.length)
        {
            if(nums[a]+nums[b]<=m)
            {
                b++;
                sum++;
                if(b==nums.length)
                {
                    a++;
                    b=a+1;
                }
                continue;
            }
            a++;
            b=a+1;
        }
        System.out.println(sum);
        scan.close();
    }
    
    
}
