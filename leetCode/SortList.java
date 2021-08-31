package leetCode;

public class SortList {
    /**
     * 给你链表的头结点 head ，请将其按升序排列并返回排序后的链表 
     */
    public static void main(String[] args) {
        ListNode node4=new ListNode(3,null);
        ListNode node3=new ListNode(1,node4);
        ListNode node2=new ListNode(2,node3);
        ListNode head=new ListNode(4,node2);
        ListNode res=sortList4(head);

        while(res!=null)
        {
            System.out.println(res.val);
            res=res.next;
        }
    }

    public static ListNode sortList1(ListNode head)
    {
        //做法1，选择排序，创建一个新链表，每次把最小的元素插入到新链表中,时间复杂度为O(n^2)
        if(head==null)
        {
            return null;
        }
        ListNode dum=new ListNode(-1);//创建虚拟头节点，方便插入和删除
        dum.next=head;
        ListNode newHead=new ListNode(-1);//新链表
        ListNode tail=newHead;
        while(dum.next!=null)
        {
            head=dum.next;
            ListNode min=head;
            ListNode cur=head;
            ListNode pre=dum;
            ListNode minPre=dum;
            while(cur!=null)
            {
                // 先遍历找最小的节点,记录下最小节点和它前面一个节点
                if(cur.val<min.val)
                {
                    minPre=pre;
                    min=cur;
                }
                pre=cur;
                cur=cur.next;
            }
            // 把min节点从原链表中摘除,并拼接到新链表中  
            tail.next = min;
            tail = tail.next;
            minPre.next = min.next;
        }
        return newHead.next;
    }
    public static ListNode sortList2(ListNode head)
    {
        //做法2，插入排序,维护一个有序序列，每次都将一个元素插入到有序队列的适当位置，时间复杂度为O(n^2)
        if(head==null)
        {
            return null;
        }
        ListNode dum=new ListNode(-1);
        dum.next=head;
        ListNode lastSorted=head;//有序序列的边界，初始时有序序列长度为1
        ListNode cur=head.next;//待插入的节点
        while(cur!=null)
        {
            if(lastSorted.val<=cur.val)
            {
                lastSorted=lastSorted.next;
            }
            else
            {
                ListNode prev=dum;
                while(prev.next.val<cur.val)
                {
                    prev=prev.next;
                }
                lastSorted.next=cur.next;
                cur.next=prev.next;
                prev.next=cur;
            }
            cur=lastSorted.next;
        }
        return dum.next;
    }
    public static ListNode sortList3(ListNode head)
    {
        //做法3，递归的归并排序,时间复杂度为O(nlogn),省去了数组中为了用于存储合并后的数组所开辟新数组的开销，但使用了递归空间复杂的为O(logn)
        //首先通过链表的中点将链表拆分成两个链表，然后递归的对两个子链表进行排序，然后将排序好的子链表进行合并
        if(head==null)
        {
            return null;
        }
        if(head.next==null)
        {
            //如果链表中只有一个节点，那么就不需要拆分了
            return head;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null)
        {
            //使用快慢指针找到链表的中点
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=slow;
        ListNode head2=mid.next;
        mid.next=null;
        ListNode list1=sortList3(head);
        ListNode list2=sortList3(head2);
        return merge(list1,list2);
    }

    public static ListNode merge(ListNode list1,ListNode list2)
    {
        //通过双指针合并两个链表
        ListNode dum=new ListNode(-1);
        ListNode p=dum;
        ListNode p1=list1;
        ListNode p2=list2;
        while(p1!=null||p2!=null)
        {
            if(p1==null)
            {
                p.next=p2;
                p2=p2.next;
                p=p.next;
                continue;
            }
            if(p2==null)
            {
                p.next=p1;
                p1=p1.next;
                p=p.next;
                continue;
            }
            if(p1.val<=p2.val)
            {
                p.next=p1;
                p1=p1.next;
                p=p.next;
            }
            else
            {
                p.next=p2;
                p2=p2.next;
                p=p.next;
            }
        }
        p.next=null;
        return dum.next;
    }

    public static ListNode sortList4(ListNode head) {
        //非递归的归并排序,自底向上，通过迭代的方式拆分链表，时间复杂度为O(nlogn),空间复杂度为O(1)
        if (head == null) {
            return head;
        }
        // 1. 首先从头向后遍历,统计链表长度
        int length = 0; // 用于统计链表长度
        ListNode node = head;
        while (node != null)
        {
            length++;
            node = node.next;
        }
        // 2. 初始化 引入虚拟头节点
        ListNode dum = new ListNode(-1);
        dum.next = head;
        // 3. 每次将链表拆分成若干个长度为subLen的子链表,并按照每两个子链表一组进行合并,初始长度为1，然后为2，为4
        for (int subLen = 1; subLen < length; subLen <<= 1)
        {
            // subLen每次左移一位（即sublen = sublen*2）PS:位运算对CPU来说效率更高
            ListNode prev = dum;
            ListNode curr = dum.next;// curr用于记录拆分链表的位置
            while(curr != null)//如果链表没有被拆完
            {
                //3.1 拆分subLen长度的链表1
                ListNode head1 = curr;
                for(int i = 1; i < subLen && curr != null && curr.next != null; i++)
                {     // 拆分出长度为subLen的链表1
                    curr = curr.next;
                }
                // 3.2 拆分subLen长度的链表2
                ListNode head2 = curr.next; // 第二个链表的头,即链表1尾部的下一个位置
                curr.next = null;// 断开第一个链表和第二个链表的链接
                curr = head2;// 第二个链表头 重新赋值给curr
                for(int i = 1;i < subLen && curr != null && curr.next != null;i++)
                {
                    // 再拆分出长度为subLen的链表2
                    curr = curr.next;
                }
                // 3.3 再次断开 第二个链表最后的next的链接
                ListNode next = null;
                if(curr != null)
                {
                    next = curr.next;   // next用于记录 拆分完两个链表的结束位置
                    curr.next = null;   // 断开连接
                }
                // 3.4 合并两个subLen长度的有序链表
                ListNode merged = mergeTwoLists(head1,head2);
                prev.next = merged;// prev.next 指向排好序链表的头
                while(prev.next != null)
                {
                    // while循环 将prev移动到 subLen*2 的位置后去
                    prev = prev.next;
                }
                curr = next;// next用于记录 拆分完两个链表的结束位置
            }
        }
        return dum.next;
    }
    public static ListNode mergeTwoLists(ListNode list1,ListNode list2)
    {
        //通过双指针合并两个链表
        ListNode dum=new ListNode(-1);
        ListNode p=dum;
        ListNode p1=list1;
        ListNode p2=list2;
        while(p1!=null&&p2!=null)
        {
            if(p1.val<=p2.val)
            {
                p.next=p1;
                p1=p1.next;
            }
            else
            {
                p.next=p2;
                p2=p2.next;
            }
            p=p.next;
        }
        if(p1!=null)
        {
            p.next=p1;
        }
        else
        {
            p.next=p2;
        }
        return dum.next;
    }
    
}
