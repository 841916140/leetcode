package Sort;
import java.util.Arrays;

public class QuickSort {
    /*
    快速排序实现，快排使用了分治法，大大提高了排序效率，通过选取一个基准值，然后通过交换排序确定该基准值的最终排序位置，让比基准值小的数都在基准值左边，比基准值大的数都在基准值右边
    然后再将这左右分区看作是一个数组继续排序，通过递归即可将每一个元素都排序好。交换排序的过程可以使用两个指针，一个在最左，一个在最右，左指针一格格向右移动，右指针一格格向左移动
    每当左指针指向比基准值大的数就停下，每当右指针指向比基准值小的数就停下，两个指针停下后，交换两个指针指的数。这时，大的数就会跑到右边，小的数就会跑到左边，
    我们就把基准值放进左右半区中间，此时基准值索引就是排序准确的了
    平均时间复杂度为O(n*logn)，是不稳定的排序，最坏时间复杂度为O(n²)，当数组是有序时出现最坏情况，经过一轮排序整个数组并没有被分成两半，这与基准值的选取有关；
    如果直接选取第一个元素作为基准值可能就会这种情况，可以通过随机选择基准值来解决
    快排为什么从右边开始？其实快排没有一定要从右边开始，只是看你基准值的位置，如果你基数选的是最左边的，那么就需要从右边开始，因为要确保交换基准值时那个数要小于基准值，才能保证基准值左边的数小于基准值
    从左边开始无法保证，因为左指针到达大于基准值的数就会停下，此时交换不满足要求。

    快排如何优化？：
    优化1：序列长度达到一定大小时，使用插入排序当快排达到一定深度后，划分的区间很小时，再使用快排的效率不高。
    当待排序列的长度达到一定数值后，可以使用插入排序。由《数据结构与算法分析》(Mark Allen Weiness所著)可知，当待排序列长度为5~20之间，此时使用插入排序能避免一些有害的退化情形。
    优化2：尾递归优化
    快排算法和大多数分治排序算法一样，都有两次递归调用。但是快排与归并排序不同，归并的递归则在函数一开始， 快排的递归在函数尾部，这就使得快排代码可以实施尾递归优化。
    使用尾递归优化后，可以缩减堆栈的深度，由原来的O(n)缩减为O(logn)。当编译器检测到一个函数调用是尾递归的时候，它就覆盖当前的活动记录而不是在栈中去创建一个新的。
    优化3：聚集元素
    聚集元素的思想：在一次分割结束后，将与本次基准相等的元素聚集在一起，再分割时，不再对聚集过的元素进行分割。具体过程有两步
    ①在划分过程中将与基准值相等的元素放入数组两端，②划分结束后，再将两端的元素移到基准值周围。
     */
    public static void main(String[] args) 
    {
        int[] array=new int[]{5,8,6,3,9,2,1,7};
        quickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
        
    }
    public static void quickSort(int []array,int start,int end)
    {
        if(start>=end)
        {
            return;
        }
        int pivotIndex=partition1(array,start,end);//获取基准值排序后的位置
        //根据基准值下标进行分区继续递归排序
        quickSort(array, start, pivotIndex-1);
        quickSort(array, pivotIndex+1, end);

    }
    public static int partition1(int []array,int start,int end)
    {   
        //双边循环，直观易懂
        int key=array[start];//选取数组中第一个数作为基准值，也可以随机选取然后与第一个数进行交换
        int left=start;
        int right=end;
        while(left!=right)
        {
            while(left<right&&array[right]>=key)//右指针开始移动，移动到小于基准值的位置停下
            {
                right--;
            }
            while(left<right&&array[left]<=key)//左指针开始移动，移动到大于基准值的位置停下
            {
                left++;
            }
            if(left<right)//交换左右指针所指向的元素
            {
                int temp=array[left];
                array[left]=array[right];
                array[right]=temp;
            }
        }
        //交换基准值与指针重合点，即将基准值插到两个分区数组之间
        array[start]=array[left];
        array[left]=key;
        return left;//返回基准值排序后的位置
    }

    public static int partition2(int []array,int start,int end)
    {
        //单边循环，更加简洁
        int key=array[start];//同样选取数组中第一个数作为基准值，也可以随机选取然后与第一个数进行交换
        int mark=start;//记录小于基准元素的区域的边界
        for(int i=start+1;i<=end;i++)
        {
            if(array[i]<key)
            {
                //如果值小于基准值，mark指移动一位，因为mark指针指向小于基准元素区域的边界，小于基准值说明该区域多了一个元素，然后把该元素交换到区域中
                mark++;
                int temp=array[mark];
                array[mark]=array[i];
                array[i]=temp;
            }
        }
        array[start]=array[mark];
        array[mark]=key;

        return mark;
    }
    
}
