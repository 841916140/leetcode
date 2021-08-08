package Sort;
import java.util.Arrays;

public class HeapSort {
    /*
    堆排序实现，若要实现升序排序则构建最大堆，反之构建最小堆
    所以手撕堆排序，第一步是构建堆，然后循环删除堆顶元素，并将该元素移到集合尾部，调整堆产生新的堆顶
    时间复杂度是O(nlogn),是不稳定的排序
    堆用数组存储，父节点下标*2+1=左孩子节点坐标，父节点下标*2+2=右孩子节点坐标
     */
    public static void main(String[] args) 
    {
        int[] array=new int[]{5,8,6,3,9,2,1,7};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void heapSort(int[] array)
    {
        int len=array.length-1;
        buildMaxHeap(array);//构建最大堆
        //构建完成后循环删除堆顶元素并将该元素移到集合尾部，并调整堆产生新的堆顶
        for(int i=len;i>=0;i--)
        {
            swap(array,0,i);
            downAdjust(array, 0, i);//之所以传的长度值一直在变是因为删除堆顶元素即将堆顶元素与集合尾部元素交换后，i到length中的元素即确定了顺序，不用再进行调整，破坏顺序
        }
    }

    public static void buildMaxHeap(int[] array)
    {
        //构建最大堆,将所有非叶子节点进行下沉调整操作
        for(int i=(array.length-2)/2;i>=0;i--)
        {
            downAdjust(array,i,array.length);
        }
    }

    public static void downAdjust(int[] array,int parentIndex,int len)
    {
        //堆的下沉调整操作
        int child=(parentIndex<<1)+1;
        while(child<len)
        {
            if((parentIndex<<1)+2<len&&array[(parentIndex<<1)+2]>array[child])
            {
                //如果右子节点存在且大于左子节点，那就拿右子节点与父节点进行比较即可
                child=(parentIndex<<1)+2;
            }
            if(array[parentIndex]>=array[child])
            {
                //如果父节点大于子节点，则不需要进行任何操作 
                break;   
            }
            else
            {
                //若父节点小于子节点，则进行下沉操作，替换值
                swap(array,parentIndex,child);
                parentIndex=child;
                child=(parentIndex<<1)+1;//继续判断该位置的子节点与父节点的大小，进行下沉操作
            }
        }
    }

    public static void swap(int[] array,int a,int b)
    {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    
}
