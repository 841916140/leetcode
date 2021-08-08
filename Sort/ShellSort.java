package Sort;
import java.util.Arrays;

public class ShellSort {
    /*
    希尔排序的实现，希尔排序是插入排序的升级，通过分组在组内进行插入排序，元素少减少了，使用插入排序更加效率，分组通过分组跨度进行分组，一开始分组跨度是4，即隔4个元素的两个元素一组，即1和4，2和5，3和6
    然后每组进行插入排序后，再将分组跨度缩小一半即2，然后是1，（4，2，3）被成为希尔排序的增量;最坏时间复杂度是O(n^3/2),是不稳定排序。
    */
    public static void main(String[] args) 
    {
        int[] array=new int[]{5,8,6,3,9,2,1,7};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }
    
    public static void shellSort(int[] array)
    {
        int d=array.length;//希尔排序的增量
        while(d>1)
        {
            d/=2;//使用希尔增量的方式，即每次折半
            //然后每组进行插入排序
            for(int i=0;i<d;i++)
            {
                for(int j=i+d;j<array.length;j=j+d)
                {
                    int temp=array[j];
                    int k;
                    for(k=j-d;k>=0&&temp<array[k];k-=d)
                    {
                        array[k+d]=array[k];
                    }
                    array[k+d]=temp;
                }
            }
        }

    }
}
