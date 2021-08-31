package leetCode;

/**
 * @author DavidQ
 * @version 1.0.0
 * @ClassName OddEvenList1.java
 * @Description 排序奇升偶降链表,给定一个奇数位升序，偶数位降序的链表，将其重新排序。
 * 输入: 1->8->3->6->5->4->7->2->NULL
 * 输出: 1->2->3->4->5->6->7->8->NULL
 * @createTime 2021年08月29日 10:39:00
 */
public class OddEvenList1 {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode node2=new ListNode(8);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(6);
        ListNode node5=new ListNode(5);
        ListNode node6=new ListNode(4);
        ListNode node7=new ListNode(7);
        ListNode node8=new ListNode(2);
        head.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        node7.next=node8;
        node8.next=null;
        ListNode res=oddEvenList(head);
        while(res!=null)
        {
            System.out.println(res.val);
            res=res.next;
        }
    }
    public static ListNode oddEvenList(ListNode head)
    {
        //先把按照奇偶把链表拆开成两个链表，然后翻转偶链表，在拆分的时候直接进行翻转也可以，这样就变成了合并两个升序链表
        if(head == null || head.next == null)
        {
            return head;
        }
        //拆分出奇节点链表和偶节点链表
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead=new ListNode(-1);
        evenHead.next=null;
        while(even != null && even.next != null)
        {
            odd.next = even.next;
            odd = odd.next;
            even.next=evenHead.next;
            evenHead.next=even;
            ListNode evenNext=odd.next;
            even = evenNext;
        }
        odd.next=null;
        even.next=evenHead.next;
        evenHead.next=even;
        return mergeTwoLists(head,evenHead.next);
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                p.next = l1;
                l1 = l1.next;
            }
            else
            {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 != null? l1 : l2;
        return dummy.next;
    }
}
