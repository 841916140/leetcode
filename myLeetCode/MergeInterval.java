
import java.util.*;

public class MergeInterval {
    /**
     * 合并区间
     * 以数组 intervals 表示若干个区间的集合如：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 每个子数组如1，3表示1-3的区间，现要合并所有重叠的区间，返回一个不重叠的区间数组
     * 如1，3和2，6重合，合并为1 6
     *
     *  思路：先按每个区间的左端对区间进行升序排序，
     *  如果右边区间左端点在左边区间右端点的右边，那么说明不重叠
     *  否则重叠，在原地进行合并，选取两个区间右端点的最大值作为合并区间后的右端点即可
     *  index表示不重叠区间数组中的下标，只有不重叠才向右移动，表示加入了一个不重叠的区间
     */
    public static void main(String[] args) {
        int[][] intervals=new int[][]{{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.toString(merge(intervals)));
    }

    public static int[][] merge(int[][] intervals)
    {   
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int index = 1;
        int len = intervals.length;
        for(int i = 1;i < len;i++) {
            int[] arr = intervals[index - 1];
            if(intervals[i][0] > arr[1]) {
                intervals[index++] = intervals[i];
            } else {
                arr[1] = Math.max(intervals[i][1], arr[1]);
            }
        }
        return Arrays.copyOf(intervals, index);


    }
}
