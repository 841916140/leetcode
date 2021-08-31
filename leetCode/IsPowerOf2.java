package leetCode;

public class IsPowerOf2 {
    //判断一个整数是否是2的整数幂
    //2的整数幂的整数二进制只有最高位是1，让其减1即可让其最高位为0其他位为1，也就是n-1&n=0
    public static void main(String[] args) {
        System.out.println(isPowerOf(6));
    }

    public static boolean isPowerOf(int x)
    {
        if((x&(x-1))==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
