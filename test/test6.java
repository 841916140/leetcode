import java.util.*;
public class test6 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        for(int i=0;i<t;i++)
        {
            int n=scan.nextInt();
            int [] arr=new int[n];
            for(int j=0;j<n;j++)
            {
                arr[j]=scan.nextInt();
            }
            Arrays.sort(arr);
            int sum=0;
            for(int k=n-1;k>=0;k--)
            {
                sum+=arr[k];
                for(int y=k-1;y>=0;y--)
                {
                    arr[y]+=arr[k];
                }
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(sum);
        }
    }
    
}
