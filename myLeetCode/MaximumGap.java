
import java.util.Arrays;

public class MaximumGap {
    /*
    给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。如果数组元素个数小于2则返回0
    请尝试在线性时间复杂度和空间复杂度的条件下解决此问题
    如3 6 9 1 排序后是1 3 6 9，3和6间存在最大差值为3
    因为要尝试在线性时间复杂度解决，又需要排序，学过的排序算法中可以使用桶排序来解决
    相邻两个桶，左桶的最大值与右边非空桶的最小值是排序后相邻的两个数，挨个比较即可得出最大差,所以不需要像桶排序一样在桶内部进行排序，只需要记录桶内的最大值和最小值即可
    */
    public static void main(String[]args)
    {
        int []array=new int[]{15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,10588,16521,6644,20880,15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,32683,23688,12439,30630,3895,7926,22101,32406,21540,31799,3768,26679,21799,23740};
        if(array.length<2)
        {
            System.out.println(0);
        }
        System.out.println(maximumGap(array));
    }
    
    private static class Bucket{
        Integer min;//定义成integer可以方便判断桶内无元素的情况，即为null
        Integer max;
    }
    public static int maximumGap(int[] array)
    {
        //接下来的步骤和桶排序一样，分配元素到桶中并记录更新最大最小值
        int max=Arrays.stream(array).max().getAsInt();
        int min=Arrays.stream(array).min().getAsInt();
        int d=Math.max(1,(max-min)/(array.length-1));//用于后面分配元素到对应桶中
        int bucketNum=(max-min)/d+1;
        Bucket[]buckets=new Bucket[bucketNum];
        for(int i=0;i<bucketNum;i++)
        {
            buckets[i]=new Bucket();
        }
        for(int i=0;i<array.length;i++)
        {
            
            int index=(int)((array[i]-min)/d);//元素分配到桶的对应下标，公式记住!
            if(buckets[index].min==null||buckets[index].min>array[i])
            {
                buckets[index].min=array[i];
            }
            if(buckets[index].max==null||buckets[index].max<array[i])
            {
                buckets[index].max=array[i];
            }
        }
        //循环遍历桶，得到最大差值
        int leftMax=buckets[0].max;//存左侧桶的最大值
        int res=0;
        for(int i=1;i<bucketNum;i++)
        {
            if(buckets[i].min==null)
            {
                continue;
            }
            if(buckets[i].min-leftMax>res)
            {
                res=buckets[i].min-leftMax;
            }
            leftMax=buckets[i].max;
        }
        return res;
    }
}
