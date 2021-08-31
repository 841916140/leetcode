package leetCode;
import java.util.*;

/**
 * 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 输入：s = "ADOBECODEBANC", t = "ABC" 输出："BANC"
 * 输入: s = "a", t = "aa" 输出: ""
 * 
 * 这类题都用滑动窗口来做，滑动窗口有l和r两个指针，通过r右移不断延申窗口，判断当前窗口中的字符串是否包含了所有t中的字符
 * 如果没包含就继续延申，包含了就通过l收缩，看下能否得到最小窗口
 * 用一个map来记录t中的所有字符，然后是value是其对应的数量，再用另一个map来动态维护当前窗口中出现的所有t中的字符及个数
 * 这样只需要比较两个map中每个字符对应的数量是否相等即可判断当前窗口是否包含了t
 */
public class MinWindow {
    static Map<Character,Integer> map1=new HashMap<>();
    static Map<Character,Integer> map2=new HashMap<>();
    public static void main(String[] args) {
        String s="ADOBECODEBANC";
        String t="ABC";
        String res=minWindow(s,t);
        System.out.println(res);
        
    }
    public static String minWindow(String s,String t)
    {   
        int tLen=t.length();
        for(int i=0;i<tLen;i++)//填充map1即字符串t中的字符以及出现的次数
        {
            char c=t.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0)+1);//getOrDefault如果没有该key，就返回默认值
        }
        int l=0,r=-1;
        int length=Integer.MAX_VALUE;//子串长度
        int left=-1,right=-1;//最短字串的起止节点
        int sLen=s.length();
        while(r<sLen)
        {
            r++;//窗口不断向右延申
            if(r<sLen&&map1.containsKey(s.charAt(r)))//当前字符在字符串t中，则记录到map2中
            {
                map2.put(s.charAt(r), map2.getOrDefault(s.charAt(r), 0)+1);
            }
            while(check()&&l<=r)//如果当前窗口中包含了所有字符串t中的字符，则窗口尝试收缩以得到最小子串
            {
                if(r-l+1<length)//更新子串长度以及起止位置
                {
                    length=r-l+1;
                    left=l;
                    right=r;
                }
                if(map1.containsKey(s.charAt(l)))
                {
                    map2.put(s.charAt(l), map2.getOrDefault(s.charAt(l), 0)-1);//右移缩小窗口后当前元素移除
                }
                l++;
            }
        }
        return left==-1?"":s.substring(left, right+1);//为-1表示窗口中从始至终都没有包含字符串t的子串

    }
    public static boolean check()
    {
        //用来比较当前窗口中是否包含所有字符串t中的字符
        for(Map.Entry entry:map1.entrySet())
        {
            Character key=(Character)entry.getKey();
            Integer value=(Integer) entry.getValue();
            if(map2.getOrDefault(key,0)<value)//对应字符数量也要匹配
            {
                return false;
            }
        }
        return true;
    }
    
}
