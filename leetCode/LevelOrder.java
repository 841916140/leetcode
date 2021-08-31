
package leetCode;
import java.util.*;

public class LevelOrder {
    /**
     * 二叉树的层序遍历
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(3);
        TreeNode node3=new TreeNode(4,null,null);
        TreeNode node4=new TreeNode(7,null,null);
        TreeNode node5=new TreeNode(5,null,null);
        TreeNode node6=new TreeNode(6,null,null);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node5;
        node2.left=node6;
        node2.right=node4;
        List<List<Integer>> res=levelOrder(root);
        System.out.println(res.toString());
    }
    public static List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)
        {
            return res;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            int size=queue.size();//队列中节点数量即为该层中节点数
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode node=queue.poll();
                list.add(node.val);
                if(node.left!=null)
                {
                    queue.offer(node.left);
                }
                if(node.right!=null)
                {
                    queue.offer(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
