package leetCode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断二叉树是否对称，如下二叉树就是对称的
 *  1
   / \
  2   2
 / \ / \
3  4 4  3
可通过两种方式判断，一种是递归法，一种是迭代法，两种思想类似
1.递归法:用两个指针，分别从头向左右两颗子树进行探寻
结束条件为：当个指针所指元素都为null时返回真，当一个为null一个不为null时返回假
若都不为null，则判断值是否相等，相等则继续向左右两棵子树递归，不相等则返回false

2.迭代法：用队列辅助实现，也同样用两个指针在左右两颗字数进行探寻，并一起加入到队列中
这样每次将队列中两个元素取出，则就是二叉树对称位置的两个值，再和递归的步骤一样判断即可
如果两值不为null且相等，那么就将他们的左子节点和右子节点；右子节点和左子节点依次入队，继续进行循环
 */
public class IsSymmetric {
    public static void main(String[] args)
    {
        TreeNode root=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3,null,null);
        TreeNode node4=new TreeNode(3,null,null);
        TreeNode node5=new TreeNode(4,null,null);
        TreeNode node6=new TreeNode(4,null,null);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node5;
        node2.left=node6;
        node2.right=node4;

        System.out.println(isSymmetric(root.left,root.right));
        
    }

    public static boolean isSymmetric(TreeNode left,TreeNode right)
    {
        if(left==null&&right==null)
        {
            return true;
        }
        if(left==null||right==null)
        {
            return false;
        }
        return left.val==right.val?isSymmetric(left.left, right.right)&&isSymmetric(left.right, right.left):false;
    }
    //非递归的方式：迭代法
    public static boolean isSymmetric2(TreeNode left,TreeNode right)
    {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(left);
        queue.offer(right);
        while(!queue.isEmpty())
        {
            TreeNode node1=queue.poll();
            TreeNode node2=queue.poll();
            if(node1==null&&node2==null)
            {
                continue;
            }
            if(node1==null||node2==null)
            {
                return false;
            }
            if(node1.val==node2.val)
            {
                queue.offer(node1.left);
                queue.offer(node2.right);
                queue.offer(node1.right);
                queue.offer(node2.left);
            }
            else
            {
                return false;
            }
        }
        return true;
    }
    
}
