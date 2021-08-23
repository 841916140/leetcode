import java.util.*;

public class test5 {
    public static void main(String[] args) {
        ListNode head=new ListNode(7);
        ListNode node1=new ListNode(8);
        ListNode node2=new ListNode(13);
        ListNode node3=new ListNode(11);
        ListNode node4=new ListNode(15);
        ListNode node5=new ListNode(0);
        ListNode node6=new ListNode(10);
        ListNode node7=new ListNode(15);
        ListNode node8=new ListNode(9);
        ListNode node9=new ListNode(9);
        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        node7.next=node8;
        node8.next=node9;
        node9.next=null;
        int m=9;
        System.out.println(Arrays.toString(solve(m,head)));
    }
    public static ListNode[] solve (int m, ListNode a) {
        ListNode[] res=new ListNode[m];
        for(int i=0;i<m;i++)
        {
            ListNode head=a;
            ListNode dum=new ListNode(0);
            ListNode cur=dum;
            while(head!=null)
            {
                if(head.val%m==i)
                {
                    ListNode node=new ListNode(head.val);
                    cur.next=node;
                    cur=cur.next;
                }
                head=head.next;
            }
            cur.next=null;
            res[i]=dum.next;
        }
        return res;
    }
}
