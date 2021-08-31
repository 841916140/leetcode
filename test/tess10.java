package test;

public class tess10 {
    public static void main(String[] args) {
        String s="-123 ,ajiasd 4";
        char[] arr=s.toCharArray();
        int index=0;
        int n=s.length();
        while(index<n&&arr[index]==' ')
        {
            index++;
        }
        if(index==n)
        {
            System.out.println(0);
        }
        int sign=1;
        char first=arr[index];
        if(first=='+')
        {
            index++;
        }
        else if(first=='-')
        {
            index++;
            sign=-1;
        }
        StringBuilder stringBuilder=new StringBuilder();
        while(index<n)
        {
            char ch=arr[index];
            if(ch>'0'&&ch<'9')
            {
                stringBuilder.append(ch);
            }
            index++;
        }
    
        String str=stringBuilder.toString();
        int res=0;
        for(int i=0;i<str.length();i++)
        {
            char c=str.charAt(i);
            if(res>Integer.MAX_VALUE/10)
            {
                System.out.println(Integer.MAX_VALUE);
            }
            if(res<Integer.MIN_VALUE/10)
            {
                System.out.println(Integer.MIN_VALUE);
            }
            res=res*10+sign*(c-'0');
        }
        System.out.println(res);
    }
    
}
