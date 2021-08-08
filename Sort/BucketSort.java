package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class BucketSort {
    //桶排序，数据结构用LinkedList作为一个桶存储数据，用ArrayList存放桶，使用桶排序可以解决计数排序不能排序小数的问题
    //桶排序平均时间复杂度为O(n)，最坏时间复杂度为O(nlogn),是稳定排序
    public static void main(String[]args)
    {
        double[] array=new double[]{4.5,0.84,3.25,2.18,0.5};
        System.out.println(Arrays.toString(bucketSort(array)));
    }

    public static double[] bucketSort(double[] array)
    {
        double max=Arrays.stream(array).max().getAsDouble();//从数组中快速获取最大最小值的方法
        double min=Arrays.stream(array).min().getAsDouble();
        for(int i=0;i<array.length;i++)
        {
            if(array[i]>max)
            {
                max=array[i];
            }
            if(array[i]<min)
            {
                min=array[i];
            }
        }
        double d=Math.max(1,(max-min)/(array.length-1));//用于后面分配元素到对应桶中
        int bucketNum=(int)((max-min)/d+1);
        ArrayList<LinkedList<Double>> bucket=new ArrayList<LinkedList<Double>>(bucketNum);
        //初始化桶
        for(int i=0;i<bucketNum;i++)
        {
            bucket.add(new LinkedList<Double>());
        }
        //遍历数组，将元素放入对应桶内
        for(int i=0;i<array.length;i++)
        {
            int num=(int)((array[i]-min)/d);//计算该元素应该放到哪个桶中，公式要记住
            bucket.get(num).add(array[i]);
        }
        //对每个桶内的元素进行排序，直接使用collections中的排序方法
        for(int i=0;i<bucketNum;i++)
        {
            Collections.sort(bucket.get(i));
        }
        //输出所有排序后的元素
        double[] sortedArray=new double[array.length];
        int index=0;;
        for(LinkedList<Double> linkedList:bucket)
        {
            for(double element:linkedList)
            {
                sortedArray[index++]=element;
            }
        }
        return sortedArray;
        

    }
    
}
