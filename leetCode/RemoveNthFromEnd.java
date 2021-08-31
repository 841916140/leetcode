package leetCode;
/**
 * 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 用一个伪头节点辅助，以便删除头节点
 * 定义快慢指针，让快慢指针相聚k+2个位置，那么当fast指针位null时，slow指针的位置就是倒数k+1个位置
 * 即要删除节点的前驱节点，此时直接进行删除即可
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode node1=new ListNode(2);
        ListNode node2=new ListNode(3);
        ListNode node3=new ListNode(4);
        ListNode node4=new ListNode(5);
        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=null;
        int n=2;
        ListNode res=removeNthFromEnd(head,n);
        while(res!=null)
        {
            System.out.println(res.val);
            res=res.next;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head,int n)
    {
        ListNode dum=new ListNode(0);
        dum.next=head;
        ListNode fast=head;
        ListNode slow=dum;
        for(int i=0;i<n;i++)
        {
            fast=fast.next;
        }
        while(fast!=null)
        {
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;//删除节点
        return dum.next;
    }
}
