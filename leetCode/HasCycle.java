package leetCode;


public class HasCycle {
    //leetcode141:判断链表是否有环
    
    public static void main(String[] args)
    {
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
        node7.next=node4;
        System.out.println(hasCycle(node1));
    }

    public static boolean hasCycle(ListNode head)
    {
        //判断链表是否有环，通过定义快慢指针，一个指针每次移动1，另一个移动2，当指针相遇时说明有环,指针到达null值时说明到达链表末尾说明无环
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow)
            {
                //拓展，如果有环返回环的入口位置，以及环的长度,让一个指针从链表头部开始，另一个指针从相遇的位置开始，每次移一位，相遇的位置即是环的入口位置
                int length=1;
                ListNode node=slow.next;
                while(node!=fast)
                {
                    node=node.next;
                    length++;
                }
                System.out.println("链表有环且长度为"+length);

                ListNode node2=head;
                while(node2!=slow)
                {
                    node2=node2.next;
                    slow=slow.next;
                }
                System.out.println("链表有环且入口在"+node2.val);
                return true;
            }
        }
        return false;

    }
    
}
