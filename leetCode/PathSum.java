package leetCode;
import java.util.*;
public class PathSum {

    /**
     * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
     * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
     * 用前序遍历深度优先搜索，每到一个节点就用target-去当前节点的值，如果为0说明到这个节点的位置处和为0
     * 然后判断这个位置是否是叶子节点，如果是则把当前这条路径添加到结果列表中，如果不是则继续深度优先搜索
     */
    static List<List<Integer>> res=new ArrayList<>();
    static LinkedList<Integer> path=new LinkedList<>();
    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        TreeNode node1=new TreeNode(4);
        TreeNode node2=new TreeNode(8);
        TreeNode node3=new TreeNode(7,null,null);
        TreeNode node4=new TreeNode(2,null,null);
        TreeNode node5=new TreeNode(5,null,null);
        TreeNode node6=new TreeNode(1,null,null);
        TreeNode node7=new TreeNode(13,null,null);
        TreeNode node8=new TreeNode(11,node3,node4);
        TreeNode node9=new TreeNode(4,node5,node6);
        root.left=node1;
        root.right=node2;
        node1.left=node8;
        node1.right=null;
        node2.left=node7;
        node2.right=node9;
        pathSum(root,22);
        System.out.println(res.toString());
    }
    
    public static void pathSum(TreeNode root,int target)
    {
        //taget是值传递，所以每层递归中都有自己的target值，所以target不需要做撤回的处理
        if(root==null)
        {
            return;
        }
        target-=root.val;
        path.add(root.val);
        if(target==0&&root.left==null&&root.right==null)
        {
            res.add(new LinkedList(path));//要深拷贝，如果浅拷贝则后续path中的结果会被改变
        }
        pathSum(root.left,target);
        pathSum(root.right,target);
        path.removeLast();
    }
}
