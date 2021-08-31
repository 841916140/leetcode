

public class GCD {
    //求最大公约数，有辗转相除法和更相减损术
    public static void main(String[]args)
    {
        System.out.println(gcd(100,105));
    }

    public static int gcd(int a,int b)
    {
        //辗转相除：缺点是取模运算性能差
        int big=a>b?a:b;
        int small=a<b?a:b;
        if(big%small==0)
        {
            return small;
        }
        return gcd(big%small,small);
    }
    
}
