package Sort;

import java.util.Arrays;

public class BubbleSort
{
    //冒泡排序算法实现
    public static void main(String[] args) 
    {
        int[] array=new int[]{5,8,6,3,9,2,1,7};
        bubbleSort2(array);
        System.out.println(Arrays.toString(array));
    }
    public static void bubbleSort1(int []array)
    {
        //冒泡排序，时间复杂度为O(n²),是稳定排序,总共遍历size-1轮，每一轮冒泡排序都能确定一个元素的最终位置，所以每轮冒泡排序只需比较size-1-i次
        int size=array.length;
        for(int i=0;i<size-1;i++)
        {
            for(int j=0;j<size-i-1;j++)
            {
                if(array[j]>array[j+1])
                {
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }
    //冒泡排序优化，原排序算法中可能会有在几轮排序后数组就已经有序的情况，此时就不需要再进行比较排序了，所以我们可以通过设置一个标志位判断是否有序；
    //还可能会有数组中一部分数组已经有序，所以不需要再比较，我们可以通过记录无序数列边界的位置来减少比较的次数，在此边界之后的元素就不需要再比较了
    public static void bubbleSort2(int []array)
    {
        int size=array.length;
        int lastExchangeIndex=0;//记录最后一次交换的位置即是无序数列的边界
        int sortBorder=size-1;//无序数列的边界,每次只需要比较到这为止
        for(int i=0;i<size-1;i++)
        {
            boolean isSorted=true;//有序标记，每一轮初始值都是true
            for(int j=0;j<sortBorder;j++)
            {
                if(array[j]>array[j+1])
                {
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    isSorted=false;//发生了比较交换，说明还不是有序的
                    lastExchangeIndex=j;//更新为最后一次交换元素的位置
                }
            }
            sortBorder=lastExchangeIndex;
            if(isSorted)
            {
                break;
            }
        }
    }
}