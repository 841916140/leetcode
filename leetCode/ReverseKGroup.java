package leetCode;


public class ReverseKGroup {
    /**
     * 
     *  给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
        k 是一个正整数，它的值小于或等于链表的长度。
        如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     */
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
        int k=3;
        ListNode res=reverseKGroup(head, k);
        while(res!=null)
        {
            System.out.println(res.val);
            res=res.next;
        }
    }
    public static ListNode reverseKGroup(ListNode head,int k)
    {
        ListNode dum=new ListNode(0);//设置一个伪头节点，方便得到链表进行翻转操作
        dum.next=head;
        ListNode prev=dum;
        while(head!=null)
        {
            ListNode tail=prev;
            //不足k个不做翻转：
            // for(int i=0;i<k;i++)//得到k个一组中每一组的末尾
            // {
            //     tail=tail.next;
            //     if(tail==null)//不足k个，不做翻转处理，直接返回整个链表（前一组已拼接到下一组的起始位置）
            //     {
            //         return dum.next;
            //     }
            // }
            //不足k个也做翻转：
            if(prev.next==null)
            {
                break;
            }
            for(int i=0;i<k;i++)//得到k个一组中每一组的末尾
            {
                tail=tail.next;
                if(tail.next==null)//不足k个，不做翻转处理，直接返回整个链表（前一组已拼接到下一组的起始位置）,要是条件变成tail.next==null
                {
                    break;
                }
            }
            ListNode[] res=reverse(prev.next, tail);
            head=res[0];
            tail=res[1];
            prev.next=head;//将前一个组与当前组拼接
            prev=tail;
        }
        return dum.next;
    }
    public static ListNode[] reverse(ListNode head,ListNode tail)
    {
        //翻转链表，定义两个指针pre指向前一个节点，p指向当前节点，每次将当前节点指向前一个节点，然后交换将pre节点替换为
        //当前节点，当前节点向后移一位
        ListNode pre=tail.next;//前一个节点为要对接的下一组节点的开头位置
        ListNode p=head;
        while(pre!=tail)
        {
            ListNode next=p.next;
            p.next=pre;
            pre=p;
            p=next;
        }
        return new ListNode[]{tail,head};
    }
    
}
