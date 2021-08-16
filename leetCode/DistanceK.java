package leetCode;
import java.util.*;
/**
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 * 思路:用一个map存储每个节点的父节点，那么就可以从下往上搜索，那么问题就简单化了
 * 利用这个map就可以实现从当前节点向上向下进行搜索，同时又可以向下搜索，所以就能够从目标节点开始，进行深度优先搜索
 * 在深度优先搜索递归时需要传入上一个节点from，防止向上搜索时又向下搜索回去，向下搜索时又向上搜索回去
 * 然后每次递归搜索距离+1，距离为k时将当前节点加入列表中即可
 */
public class DistanceK {
    static Map<Integer,TreeNode> parentMap=new HashMap<>();
    static List<Integer> res=new ArrayList<>();
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(7,null,null);
        TreeNode node2=new TreeNode(4,null,null);
        TreeNode node3=new TreeNode(6,null,null);
        TreeNode node4=new TreeNode(0,null,null);
        TreeNode node5=new TreeNode(8,null,null);
        TreeNode node6=new TreeNode(2,node1,node2);
        TreeNode node7=new TreeNode(5,node3,node6);
        TreeNode node8=new TreeNode(1,node4,node5);
        TreeNode root=new TreeNode(3,node7,node8);
        distanceK(root,node7,2);
        System.out.println(res.toString());
    }
    public static void distanceK(TreeNode root,TreeNode target,int k)
    {
        findParent(root);//从根节点出发，找到所有节点的父节点
        getRes(target,null,k,0);
        
    }
    public static void findParent(TreeNode root)
    {
        if(root.left!=null)
        {
            parentMap.put(root.left.val, root);
            findParent(root.left);
        }
        if(root.right!=null)
        {
            parentMap.put(root.right.val, root);
            findParent(root.right);
        }
    }
    public static void getRes(TreeNode root,TreeNode from,int k,int depth)
    {
        if(root==null)
        {
            return;
        }
        if(depth==k)
        {
            res.add(root.val);
            return;
        }
        if(root.left!=from)
        {
            getRes(root.left,root,k,depth+1);
        }
        if(root.right!=from)
        {
            getRes(root.right,root,k,depth+1);
        }
        if(parentMap.get(root.val)!=from)
        {
            getRes(parentMap.get(root.val),root,k,depth+1);
        }
    }
    
}
