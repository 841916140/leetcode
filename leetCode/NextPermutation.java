package leetCode;
import java.util.Arrays;

public class NextPermutation {
    /*
    寻找全排列的下一个数，比如给出一个数12345,要求找到一个全排列后仅大于原数的数，即12354
    如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）
    采用字典序算法：
    1.从后向前查看逆序的区域，逆序区域要包括最后一位，如果没有逆序区域则最后一位就是逆序区域,找到逆序区域的前一位，也就是数字置换的边界
    2.让逆序区域的前一位和逆序区域中大于它的最小数字交换位置
    3.把原来的逆序区域转为顺序状态
    */
    public static void main(String[] args) {
        int[] array=new int[]{1,3,2};
        nextPermutation(array);
        System.out.println(Arrays.toString(array));
    }
    public static void nextPermutation(int[] array)
    {
        int n=array.length;
        int index=n-1;
        for(int i=n-1;i>=1;i--)
        {
            if(array[i]>array[i-1])
            {
                index=i;
                break;
            }
            index=0;
        }
        if(index==0)
        {
            //说明整个数都是逆序排列的，是最大值，则根据题意返回最小值即升序排列
            Arrays.sort(array);
            return;
        }
        int j=index-1;
        for(int i=n-1;i>=index;i--)
        {
            //找逆序区间中比逆序区间前一位大的最小数
            if(array[i]>array[j])
            {
                //交换值
                int temp=array[i];
                array[i]=array[j];
                array[j]=temp;
                break;
            }
        }
        
        //将逆序区间整理有序,逆序区间反转即可
        for(int i=n-1,k=index;i>k;i--,k++)
        {
            int t=array[i];
            array[i]=array[k];
            array[k]=t;
        }
    }

    
}
