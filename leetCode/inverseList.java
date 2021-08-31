package leetCode;
    /**
     * 单链表，按1 2 3 ... 分组，按组为单位整体逆序
    如[1] [2 3] [4 5 6] [7 8] 
    逆序后为 [7 8] [4 5 6] [2 3] [1]
     */
    public class inverseList {
        public static void main(String[] args) {
            ListNode node8=new ListNode(8,null);
            ListNode node7=new ListNode(7,node8);
            ListNode node6=new ListNode(6,node7);
            ListNode node5=new ListNode(5,node6);
            ListNode node4=new ListNode(4,node5);
            ListNode node3=new ListNode(3,node4);
            ListNode node2=new ListNode(2,node3);
            ListNode head=new ListNode(1,node2);
            ListNode res=solution(head);
            while(res!=null)
            {
                System.out.println(res.val);
                res=res.next;
            }
        }
        public static ListNode solution(ListNode head)
        {
            if(head==null)
            {
                return null;
            }
            ListNode prev=null;
            ListNode cur=head;
            int k=1;
            while(cur!=null)
            {
                ListNode tail=cur;
                for(int i=1;i<k;i++)
                {
                    if(tail.next==null)
                    {
                        break;
                    }
                    tail=tail.next;
                }
                k++;
                ListNode nextNode=tail.next;
                tail.next=prev;
                if(nextNode==null)
                {
                    return cur;
                }
                prev=cur;
                cur=nextNode;
            }
            return cur;
        }
    }
    