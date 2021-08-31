
import java.util.HashMap;

/**
     * 运用你所掌握的数据结构，设计和实现一个LRU(最近最少使用)缓存机制,实现 LRUCache 类：
     * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
     * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值,且应当更新该关键字为最新使用，否则返回-1
     * void put(int key, int value) 如果关键字已经存在，则变更其数据值，且应当更新该关键字为最新使用；
     * 如果关键字不存在，则插入该组「关键字-值」。
     * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     * 
     * 思路：使用哈希链表即linkedHashMap的数据结构来解决问题
     * 在linkedHashMap中hashmap中的键值对不在是彼此无关，而是和链表一样，具有前继节点和后继节点，前继节点一样是一个键值对
     * linkhashmap的结构实际上是HashMap<Integer,Node>,是通过node形成键值对间对链表结构的
     * 在访问缓存内容或更新内容后都应当将此内容更新到最新的位置，即链表末尾的位置表示最新使用
     * 当容量不够时则应该删除链表头部即最近没有使用的元素
     */
public class LruCache {
    int capacity;
    int size;
    Node head;
    Node tail;
    HashMap<Integer,Node> linkedHashMap=new HashMap<>();

    LruCache(int capacity)
    {
        this.capacity=capacity;
        this.size=0;
        // 使用伪头部和伪尾部节点,方便节点插入和删除
        head=new Node();
        tail=new Node();
        head.next=tail;
        tail.prev=head;
    }
    class Node{
        Node prev;
        Node next;
        Integer key;
        Integer value;
        Node(Integer key,Integer value)
        {
            this.key=key;
            this.value=value;
        }
        Node()
        {

        }
    }

    public void put(int key,int value)
    {
        if(linkedHashMap.containsKey(key))
        {
            Node node=linkedHashMap.get(key);
            node.value=value;
            moveToLast(node);//移至末尾表示最近使用
        }
        else
        {
            if(size>=capacity)
            {
                removeHead();
                size--;
            }
            Node node=new Node(key,value);
            linkedHashMap.put(key, node);
            appendToLast(node);//插入到链表中]
            size++;
        }

    }
    public int get(int key)
    {
        if(!linkedHashMap.containsKey(key))
        {
            return -1;
        }
        else
        {
            Node node=linkedHashMap.get(key);
            moveToLast(node);
            return node.value;
        }
    }

    public void removeHead()
    {
        linkedHashMap.remove(head.next.key);
        head.next=head.next.next;
        head.next.prev=head;
    }
    public void moveToLast(Node node)
    {
        remove(node);
        appendToLast(node);
    }
    public void appendToLast(Node node)
    {
        tail.prev.next=node;
        node.next=tail;
        node.prev=tail.prev;
        tail.prev=node;
    }
    public void remove(Node node)
    {

        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public static void main(String[] args) {
        LruCache lruCache=new LruCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
    
}
