
import java.util.ArrayList;
import java.util.List;

/**
 * 重排链表，L0 → L1 → … → Ln-1 → Ln重排成L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 * 例:
 * 1-2-3-4
 * 1-4-2-3
 * 
 * 法1：可以借助线性表来存储节点，从而灵活的进行重排
 * 
 * 法2：先找到链表的中间节点，如果是偶数则有两个中间节点，选择第一个中间节点
 * 然后以中间节点为界，反转转后半部节点
 * 然后，将链表的前半部分和链表的后半部分反转后的结果进行合并
 */
public class ReorderList {
    public static void main(String[] args) {
        ListNode node1=new ListNode(5);
        ListNode node2=new ListNode(3);
        ListNode node3=new ListNode(7);
        ListNode node4=new ListNode(2);
        ListNode node5=new ListNode(6);
        ListNode node6=new ListNode(8);
        ListNode node7=new ListNode(1);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
    }
    public static void reorderList1(ListNode head)
    {
        //法1：借助线性表来进行重排,能够快速定位节点位置进行重排
        if(head==null)
        {
            return;
        }
        List<ListNode> list=new ArrayList<>();
        ListNode node=head;
        while(node!=null)
        {
            list.add(node);
            node=node.next;
        }
        int i=0;
        int j=list.size()-1;
        while(i<j)
        {
            list.get(i).next=list.get(j);
            i++;
            if(list.get(j)==list.get(i))
            {
                break;
            }
            list.get(j).next=list.get(i);
            j--;
        }
        list.get(j).next=null;
    }

    public static void reorderList2(ListNode head)
    {
        //法2：先找到链表中点，然后反转后半部分链表，然后再重排
        if(head==null)
        {
            return;
        }
        //1.找链表中间节点，用快慢指针找到中间节点，并拆分成前后两部分
        ListNode mid=findMidNode(head);
        ListNode l1=head;
        ListNode l2=mid.next;
        mid.next=null;//拆分成两个链表
        //将后一部分反转
        l2=reverseList(l2);
        //开始拼接
        mergeList(l1,l2);

    }
    public static ListNode findMidNode(ListNode head)
    {
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    
    public static ListNode reverseList(ListNode head)
    {
        ListNode prev=null;
        ListNode cur=head;
        while(cur!=null)
        {
            ListNode nextNode=cur.next;;
            cur.next=prev;
            prev=cur;
            cur=nextNode;
        }
        return prev;
    }

    public static void mergeList(ListNode l1,ListNode l2)
    {
        ListNode temp1;
        ListNode temp2;
        while(l1!=null&&l2!=null)
        {
            temp1=l1.next;
            temp2=l2.next;
            l1.next=l2;
            l1=temp1;
            l2.next=l1;
            l2=temp2;

        }

    }
}
