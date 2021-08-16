package leetCode;

import java.util.ArrayList;
import java.util.List;

public class TreePathSum {
    public static List<TreeNode> nodeList=new ArrayList<>();
    public static void main(String[] args) {
        TreeNode root=new TreeNode(2);
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(4);
        TreeNode node3=new TreeNode(5);
        TreeNode node4=new TreeNode(6,null,null);
        TreeNode node5=new TreeNode(7,null,null);
        TreeNode node6=new TreeNode(8);
        TreeNode node7=new TreeNode(4);
        TreeNode node8=new TreeNode(9);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;
        node3.left=node7;
        node3.right=null;
        node6.left=node8;
        node6.right=null;
        int count=0;
        int target=6;
        getNodeList(root);
        for(TreeNode node:nodeList)
        {
            count+=findPath(node,target);
        }
        System.out.println(count);
    }
    public static void getNodeList(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        nodeList.add(root);
        getNodeList(root.left);
        getNodeList(root.right);
    }
    public static int findPath(TreeNode root,int target)
    {
        int count=0;
        if(root==null)
        {
            return 0;
        }
        target-=root.val;
        if(target==0)
        {
            count++;
        }
        return count+findPath(root.left,target)+findPath(root.right,target);
    }
}
