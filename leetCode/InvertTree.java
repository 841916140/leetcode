
import java.util.LinkedList;
import java.util.Queue;

/**
 * 翻转二叉树
 *   4
   /   \
  2     7     
 / \   / \
1   3 6   9

     4
   /   \
  7     2
 / \   / \
9   6 3   1
 * 
 * 方法1：递归法，我们从根节点开始，递归的对树进行遍历，然后先对叶子节点进行翻转
 * 如果当前节点的左右子树都已翻转，那么只需要交换两棵子树的位置即可完成翻转
 * 
 * 方法2：迭代法，用队列来辅助实现，开始时将根节点入列
 * 每次取出队头节点，交换其左右子树，然后把它的左右子树入队
 * 依次循环处理直到队列为空停止循环
 * 
 * 
 */

public class InvertTree {
    public static void main(String[] args)
    {
        TreeNode root=new TreeNode(4);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(7);
        TreeNode node3=new TreeNode(1,null,null);
        TreeNode node4=new TreeNode(3,null,null);
        TreeNode node5=new TreeNode(6,null,null);
        TreeNode node6=new TreeNode(9,null,null);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;
        TreeNode res=invertTree(root);
        System.out.println(res);

    }
    public static TreeNode invertTree(TreeNode root)
    {
        //递归法：
        // if(root==null)
        // {
        //     return null;
        // }
        // TreeNode left=invertTree(root.left);
        // TreeNode right=invertTree(root.right);
        // root.left=right;
        // root.right=left;
        // return root;

        //迭代法：
        if(root==null)
        {
            return null;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            TreeNode node=queue.poll();
            TreeNode temp=node.left;
            node.left=node.right;
            node.right=temp;
            if(node.left!=null)
            {
                queue.add(node.left);
            }
            if(node.right!=null)
            {
                queue.add(node.right);
            }
        }
        return root;
    }
    
}
