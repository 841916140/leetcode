package leetCode;
/**
 * 编写一个函数来查找字符串数组中的最长公共前缀
 * 如果不存在公共前缀，返回空字符串""。
 * 思路1：两两进行比较，得出最长前缀，然后用这个前缀再和后面的字符串进行两两比对再得最长前缀
 * 循环结束即可得到整个字符串数组的最长前缀
 * 比较方式是通过一个字符一个字符的比较，相等就比较下一个字符，然后切割字符串即可
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs=new String[]{"dog","racecar","car"};
        String res=longestCommonPrefix(strs);
        System.out.println(res);
    }
    public static String longestCommonPrefix(String[] strs)
    {
        String res=strs[0];
        for(int i=1;i<strs.length;i++)
        {
            res=compare(res,strs[i]);
            if(res.equals(""))
            {
                return res;
            }
        }
        return res;
    }
    public static String compare(String a,String b)
    {
        int index=0;
        int length=a.length()>b.length()?b.length():a.length();//最长前缀长度取决于最短的字符串
        while(index<length)
        {
            if(a.charAt(index)==b.charAt(index))
            {
                index++;
            }
            else
            {
                break;
            }
        }
        return a.substring(0, index);
    }

}
