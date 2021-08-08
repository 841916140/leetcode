package Sort;
import java.util.Arrays;

public class MergeSort {
    /*
    归并算法，先进行分组，分组之间再进行归并比较排序，将一个数组一分为二，然后二分为四，直到每一组只有两个元素，这可以理解为一个递归的过程，
    然后将两个元素进行排序，之后再将两个组的元素为一组进行排序。直到所有的元素都排序完成。体现了分而治之、递归的思想。
    时间复杂度为O(nlogn),是稳定排序
    */
    public static void main(String[] args) 
    {
        int[] array=new int[]{5,8,6,3,9,2,1,7};
        mergeSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
    public static void mergeSort(int[] array,int start,int end)
    {  
        if(start>=end)
        {
            return;
        }
        int mid=(start+end)/2;
        mergeSort(array, start, mid);
        mergeSort(array, mid+1, end);
        //把两个有序集合归并合并成一个大的有序集合
        merge(array,start,mid,end);                                                                              
    }
    public static void merge(int []array,int start,int mid,int end)
    {
        //开辟新数组用于存储合并后的数组
        int []mergeArray=new int[end-start+1];
        //两个指针，一个指向第一个数组的开头，一个指向另一个数组的开头，用于两两比较合并
        int p1=start;
        int p2=mid+1;
        int p=0;//新数组的下标
        while(p1<=mid&&p2<=end)
        {
            int index=0;
            if(array[p1]<=array[p2])
            {
                index=p1++;
            }
            else
            {
                index=p2++;
            }
            mergeArray[p++]=array[index];
        }
        while(p1<=mid)
        {
            mergeArray[p++]=array[p1++];
        }
        while(p2<=end)
        {
            mergeArray[p++]=array[p2++];
        }
        //将归并排序后的数组复制回原数组
        for(int i=0;i<mergeArray.length;i++)
        {
            array[i+start]=mergeArray[i];
        }
    }
    
}
