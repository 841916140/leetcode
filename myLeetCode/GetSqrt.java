
/**
 * 求数x的平方根，并打印十位小数
 * 采用二分法，以根号二为例，0到2中取中间值1，1的平方小于2，则值一定在1与2间
 * 然后取1与2的中间值，1.5，1.5的平方大于2则值在1与1.5间，通过这样不断缩小区间直到小于规定精度即可返回答案
 */
public class GetSqrt {
    public static void main(String[] args) {
        int x=2;
        System.out.println(getSqrt(x));
    }

    public static double getSqrt(int x)
    {
        double left=0,right=x;
        while(right-left>0.0000000001)
        {
            double mid=(left+right)/2;
            if(mid*mid==x)
            {
                return mid;
            }
            else if(mid*mid<x)
            {
                left=mid;
            }
            else
            {
                right=mid;
            }
        }
        return left;
    }
}
