package leetCode;
/**
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点
 * 如果有两个中间结点，则返回第二个中间结点
 */

public class MiddleNode {
    public static void main(String[] args) {
        ListNode head=new ListNode(5);
        ListNode node2=new ListNode(3);
        ListNode node3=new ListNode(7);
        ListNode node4=new ListNode(2);
        ListNode node5=new ListNode(6);
        ListNode node6=new ListNode(8);
        ListNode node7=new ListNode(1);
        head.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        System.out.println(middleNode(head).val);
    }
    public static ListNode middleNode(ListNode head)
    {
        //用快慢指针来求，当快指针停下时慢指针所指节点即为中间节点
        //如果是偶数则有两个中间节点，如果要返回第一个则终止条件为fast.next!=null&&fast.next.next!=null
        //若要返回第二个则中止节点为fast!=null&&fast.next!=null
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null&&fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    
}
