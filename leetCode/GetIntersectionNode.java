package leetCode;
/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * 如4-1-8-4-5和5-0-1-8-4-5相交于节点节点1，所以返回1-8-4-5
 */

public class GetIntersectionNode {
    public static void main(String[] args) {
        ListNode headA=new ListNode(4);
        ListNode nodeA1=new ListNode(1);
        ListNode headB=new ListNode(5);
        ListNode nodeB1=new ListNode(0);
        ListNode nodeB2=new ListNode(1);
        ListNode nodeC1=new ListNode(8);
        ListNode nodeC2=new ListNode(4);
        ListNode nodeC3=new ListNode(5);
        nodeC1.next=nodeC2;
        nodeC2.next=nodeC3;
        nodeC3.next=null;
        headA.next=nodeA1;
        nodeA1.next=nodeC1;
        headB.next=nodeB1;
        nodeB1.next=nodeB2;
        nodeB2.next=nodeC1;
        
        ListNode res=getIntersectionNode(headA,headB);
        while(res!=null)
        {
            System.out.println(res.val);
            res=res.next;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA,ListNode headB)
    {
        //当两个链表都不为空时才可能相交
        if(headA==null||headB==null)
        {
            return null;
        }
        ListNode p1=headA;
        ListNode p2=headB;
        //两个指针，如果指针1不为空则移动到下一个节点，如果为空
        //则移动到headB的头节点，指针2不为空则移动到下一个节点，为空则移动到headB的头节点
        //第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
        // 两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度，都走到null
        while(p1!=p2)
        {
            p1=p1==null?headB:p1.next;
            p2=p2==null?headA:p2.next;
        }
        return p1;
    }
    
}
