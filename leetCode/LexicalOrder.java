package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DavidQ
 * @version 1.0.0
 * @ClassName LexicalOrder.java
 * @Description 字典序排数，给定一个整数 n, 返回从 1 到 n 的字典顺序
 * 字典序可以抽象为一颗前缀树，从大到小输出就是先序遍历这棵树，然后分别以1-9为根节点进行遍历即可,即十叉树的先序遍历
 * 以1为根节点为例，这颗树是这样的
 *          1
 *     0 1 2 3 4 5 6 7 8 9
 *  0..9 0..9 0..9 0..9 .. ...
 *  时间复杂度：O(n)
 * 空间复杂度：O(logn)
 * @createTime 2021年08月31日 09:23:00
 */
public class LexicalOrder {
    public static List<Integer> res=new ArrayList<>();
    public static void main(String[] args) {
        int n=13;
        for(int i=1;i<=9;i++)
        {
            dfs(n,i);
        }
        System.out.println(res.toString());

    }
    public static void dfs(int n,int num)
    {
        if(num>n)
        {
            return;
        }
        res.add(num);
        for(int i=0;i<=9;i++)
        {
            if(num*10<=n)
            {
                dfs(n,num*10+i);//num*10+i表示下一层的树
            }
        }
    }
}
