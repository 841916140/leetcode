package leetCode;

public class BigNumAdd {
    /**
     * 大数相加，用两个指针从个位开始两两相加，用stringbuilder 一个个append，最后再翻转，对于两个大数位数不同的情况
     * 通过补零来解决，即当某个指针变为负时即用0代替相加
     */
    public static void main(String[] args) {
        String a="426709752318";
        String b="95481253129";
        System.out.println(bigNumAdd(a,b));
    }

    public static String bigNumAdd(String a,String b)
    {
        int p1=a.length()-1;
        int p2=b.length()-1;
        int add=0;//进位
        StringBuilder stringBuilder=new StringBuilder();
        while(p1>=0||p2>=0||add!=0)
        {
            int x=p1>=0?a.charAt(p1)-'0':0;
            int y=p2>=0?b.charAt(p2)-'0':0;
            int result=x+y+add;
            add=result/10;
            stringBuilder.append(result%10);
            p1--;
            p2--;
        }
        return stringBuilder.reverse().toString();
    }
}
