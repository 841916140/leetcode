package Sort;
import java.util.Arrays;

public class SelectionSort {
    //选择排序，每次选择最小的元素交换到前面，然后选择次小的....时间复杂度为O(n²),不稳定
    public static void main(String[] args) 
    {
        int[] array=new int[]{5,8,6,3,9,2,1,7};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void selectionSort(int[] array)
    {
        for(int i=0;i<array.length-1;i++)//最后一个元素位置确定好了，不用再进行排序
        {
            int minIndex=i;
            for(int j=i+1;j<array.length;j++)
            {
                if(array[minIndex]>array[j])
                {
                    minIndex=j;
                }
            }

            if(i!=minIndex)//当前位置元素已经是最小值时不需要进行交换
            {
                int temp=array[i];
                array[i]=array[minIndex];
                array[minIndex]=temp;
            }
        }
    }
    
}
