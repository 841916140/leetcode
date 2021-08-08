package Sort;
import java.util.Arrays;

public class InsertSort {
    //插入排序，维护一个有序区域，然后把一个个元素插入到有序区域的适当位置，直到所有元素都加入有序区域，时间复杂度为O(n²),是稳定的排序
    public static void main(String[] args) 
    {
        int[] array=new int[]{5,8,6,3,9,2,1,7};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void insertSort(int[] array)
    {
        for(int i=1;i<array.length;i++)
        {
            int insertValue=array[i];//这一轮要插入的值
            int j=i-1;//有序序列边界
            while(j>=0&&insertValue<array[j])//将当前元素与有序序列中元素从右往左比较，同时进行元素复制，如果当前元素更小，则往右移一个位置留个空给插入值插入，如0 6 1，1比6小，复制得 0 6 6，然后将插入值插入得0 1 6
            {
                array[j+1]=array[j];
                j--;
            }
            array[j+1]=insertValue;//将值插入
        }
    }
    
}
