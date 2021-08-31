package leetCode;

import java.util.PriorityQueue;

/**
 * @author DavidQ
 * @version 1.0.0
 * @ClassName MergeKLists.java
 * @Description 合并K个升序链表
 * @createTime 2021年08月29日 09:47:00
 */
public class MergeKLists {
    public static void main(String[] args) {
        ListNode[] lists=new ListNode[10];
        ListNode res=null;
        if(lists.length==0)
        {
            res=null;
        }
        int n=lists.length;
        res=merge(lists,0,n-1);
    }
    public static ListNode mergeKLists(ListNode[] lists)
    {
        //使用优先队列合并
        if (lists == null || lists.length == 0 )
        {
            return null;
        }
        PriorityQueue<ListNode> queue=new PriorityQueue<>((node1,node2)->{
            return node1.val-node2.val;
        });
        for (ListNode node : lists)
        {
            if (node != null)
            {
                queue.offer(node);
            }
        }
        ListNode dum=new ListNode(-1);
        ListNode head=dum;
        while (!queue.isEmpty())
        {
            ListNode node = queue.poll();
            if (node.next != null) queue.offer(node.next);
            head.next = node;
            head = head.next;
        }
        head.next=null;
        return dum.next;
    }
    public static ListNode merge(ListNode[] lists,int begin,int end)
    {
        //分治合并，第一轮合并以后， k个链表被合并成了 k/2个链表,第二轮k/4个链表等等重复这一过程，直到我们得到了最终的有序链表
        if(begin==end)
        {
            return lists[begin];
        }
        if(begin>end)
        {
            return null;
        }
        int mid=(begin+end)>>1;//算中间值的一种方式，学到了
        return mergetTwoList(merge(lists,begin,mid),merge(lists,mid+1,end));
    }

    private static ListNode mergetTwoList(ListNode a, ListNode b)
    {
        if(a==null||b==null)
        {
            return a==null?b:a;
        }
        ListNode dum=new ListNode(-1);
        ListNode head=dum;
        while(a!=null&&b!=null)
        {
            if(a.val<=b.val)
            {
                head.next=a;
                a=a.next;
            }
            else
            {
                head.next=b;
                b=b.next;
            }
            head=head.next;
        }
        head.next=a==null?b:a;
        return dum.next;
    }

}
