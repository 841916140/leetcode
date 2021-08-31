package leetCode;

public class CountPrimes {
    //给出一个数n，统计所有小于非负整数n的质数的数量，对时间复杂度有要求
    //采用厄拉多塞筛法筛选质数：如果 x 是质数，那么大于 x 的 x 的倍数 2x,3x,… 一定不是质数
    public static void main(String[] args) {
        System.out.println(countPrimes(20));
    }

    public static int countPrimes(int n)
    {
        //定义一个数组，长度为n，值为0表示该数组下标的数为质数，1不是质数,如array[2]=0,表示2是质数
        int []array=new int[n];
        int res=0;
        for(int i=2;i<n;i++)
        {
            if(array[i]==0)
            {
                res++;
                for(int j=i+i;j<n;j+=i)
                {
                    array[j]=1;
                }
            }
        }
        return res;
    }
    
}
