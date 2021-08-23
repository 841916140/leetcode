import java.util.*;
public class test2 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int k=scan.nextInt();
        System.out.println(findKthBit(n,k));
    }
    public static char findKthBit(int n,int k)
    {
        if(n<=1)
        {
            return 'a';
        }
        String[] strings=new String[n];
        strings[0]="a";
        for(int i=1;i<n;i++)
        {
            StringBuilder stringBuilder=new StringBuilder();
            stringBuilder.append(strings[i-1]);
            stringBuilder.append((char)(97+i));
            stringBuilder.append(reverse(strings[i-1]));
            strings[i]=stringBuilder.toString();
        }
        return strings[n-1].charAt(k-1);
           
    }
    public static String reverse(String s)
    {
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            stringBuilder.append((char) (97+122-s.charAt(i)));

        }
        return stringBuilder.reverse().toString();
    }
    
}
