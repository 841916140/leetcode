package leetCode;
import java.util.*;
/**
 * 字符串的全排列如abc，则有acb bac等，同样用回溯法来做
 * 字符串中包含重复元素，则要进行剪枝操作
 */
public class PermutationString {
    static List<String> res=new ArrayList<>();
    static StringBuilder stringBuilder=new StringBuilder();
    static boolean[] visited;
    public static void main(String[] args) {
        String s="abc";
        visited=new boolean[s.length()];
        backtrack(s,0);
        System.out.println(Arrays.toString(res.toArray(new String[res.size()])));
    }
    public static void backtrack(String s,int cur)
    {
        if(cur==s.length())
        {
            res.add(stringBuilder.toString());
            return;
        }
        Set<Character> set=new HashSet<>();//记录同一层中出现过的元素，方便剪枝
        for(int i=0;i<s.length();i++)
        {
            if(visited[i]||set.contains(s.charAt(i)))//如果该元素已访问过，或者在同一个位置中出现了重复的元素则进行剪枝
            {
                continue;
            }
            set.add(s.charAt(i));
            stringBuilder.append(s.charAt(i));
            visited[i]=true;
            backtrack(s,cur+1);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            visited[i]=false;
        }
    }
}
