package Sort;
import java.util.Arrays;

public class CountSort {
    //简单的计数排序实现，计数排序有线性的时间复杂度，且是稳定的排序算法，但是却比较少用，第一点是因为比较浪费空间，第二点是因为只适用于整数的情况
    public static void main(String[]args)
    {
        int [] array=new int[]{5,8,6,3,9,2,1,7};
        System.out.println(Arrays.toString(countSort(array)));
    }

    public static int[] countSort(int[] array)
    {
        int max=array[0],min=array[0];
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
        int d=max-min;//差值
        int []countArray=new int[d+1];//新建计数数组
        for(int i=0;i<array.length;i++)
        {
            //遍历数组填充计数数组
            countArray[array[i]-min]++;
        }
        //返回排序数组
        int [] sortedArray=new int[array.length];
        int index=0;
        for(int i=0;i<countArray.length;i++)
        {
            while(countArray[i]!=0)
            {
                countArray[i]--;
                sortedArray[index++]=min+i;
            }
        }
        return sortedArray;
    }

    
}
