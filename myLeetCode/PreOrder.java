import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * 二叉树的前序遍历，遍历过程为根节点左子节点，右子节点
 * 同样有两种方法
 * 方法1：递归，结束条件为节点为null，先从根节点开始不断向左子节点递归并记录值，当递归到null值时返回，然后再从右子节点递归
 * 
 * 方法2：迭代，根据递归回溯的特点用栈来进行辅助存储，跟递归法类似，当节点为null且栈为空时迭代停止
 * 然后从根节点开始循环，将节点记录并且压入栈中，然后从左子节点循环
 * 当节点为null时，弹出栈顶元素就相当于回溯节点，然后从其右子节点继续循环
 * 
 */

public class PreOrder {
    static List<Integer> res=new ArrayList<>();
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
        preOrder2(root);
        System.out.println(res);
    }
    public static void preOrder1(TreeNode root)
    {
        //递归法
        if(root==null)
        {
            return;
        }
        res.add(root.val);
        preOrder1(root.left);
        preOrder1(root.right);
    }

    public static void preOrder2(TreeNode root)
    {
        //迭代法
        Stack<TreeNode> stack=new Stack<>();
        while(root!=null||!stack.isEmpty())
        {
            while(root!=null)
            {
                res.add(root.val);
                stack.push(root);
                root=root.left;
            }
            TreeNode node=stack.pop();
            root=node.right;
        }
    }
    
}
