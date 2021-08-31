import java.util.*;
/**
 * 锯齿形层序遍历二叉树，即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行
 * 我们和之前一样，同样也先层序遍历，然后在加入节点时用双端队列来实现存储，但需要从左往右时就用尾插法插入到队列中
 * 需要从右往左时则用头插法
 */
public class ZigzagLevelOrder {
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
        List<List<Integer>> res=zigzagLevelOrder(root);
        System.out.println(res.toString());
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root)
    {
        boolean flag=true;//true是从左往右，false是从右往左
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)
        {
            return res;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            int size=queue.size();
            Deque<Integer> deque=new LinkedList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode node=queue.poll();
                if(flag)//从左往右
                {
                    deque.offerLast(node.val);
                }
                else
                {
                    deque.offerFirst(node.val);
                }
                if(node.left!=null)
                {
                    queue.offer(node.left);
                }
                if(node.right!=null)
                {
                    queue.offer(node.right);
                }
                
            }
            flag=!flag;
            res.add(new LinkedList<Integer>(deque));//转换成list存储
        }
        return res;
    }
}
