package leetCode;
import java.util.*;
/**
 * A到B的最少步数
    A与B地相距n米，一个人第一步只能前进1米或者后退1米，第二步只能前进2米或者后退2米，A走到B最少需要几步
 */
public class MinStepOfA2B {
    public static void main(String[] args) {
        int n=10;
        int step=0;
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(0);
        while(!queue.isEmpty())
        {
            int size=queue.size();
            step++;
            while(size-->0)
            {
                int distance=queue.poll();
                for (int i = -1; i <= 1; i += 2) 
                {
                    int d = distance + step * i;
                    if (d == n) {
                        System.out.println(step);
                        return;
                    }
                    queue.offer(d);
                }
            }
        }
    }
}
