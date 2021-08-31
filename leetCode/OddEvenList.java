package leetCode;

/**
 * @author DavidQ
 * @version 1.0.0
 * @ClassName OddEvenList.java
 * @Description  奇偶链表,给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * @createTime 2021年08月29日 10:31:00
 */
public class OddEvenList {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        ListNode node6=new ListNode(6);
        ListNode node7=new ListNode(7);
        head.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        ListNode res=oddEvenList(head);
        while(res!=null)
        {
            System.out.println(res.val);
            res=res.next;
        }
    }
    public static ListNode oddEvenList(ListNode head)
    {
        if(head==null)
        {
            return null;
        }
        ListNode odd=head;
        ListNode even=head.next;
        ListNode evenHead=head.next;
        while(even!=null&&even.next!=null)
        {
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;
    }
}
