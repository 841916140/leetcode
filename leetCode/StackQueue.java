package leetCode;
import java.util.Stack;

public class StackQueue {
    //用两个栈实现队列，并能够实现队列的入队，出队，获取队首元素，以及判空的操作
    //一个栈用来存储入队元素，要出队时把栈元素都弹栈到另一个栈中，再从另一个栈弹栈，即实现出队操作
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public StackQueue()
    {
        stack1=new Stack<>();
        stack2=new Stack<>();
    }

    public void push(int element)
    {
        stack1.push(element);
    }

    public int pop()
    {
        if(stack2.isEmpty())
        {
            while(!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
        else
        {
            return stack2.pop();
        }
    }

    public int peek()
    {
        if(!stack2.isEmpty())
        {
            return stack2.peek();
        }
        else
        {
            while(!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }
    }
    
    public boolean isEmpty()
    {
        if(stack1.isEmpty()&&stack2.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    } 

    public static void main(String[] args) {
        StackQueue stackQueue=new StackQueue();
        stackQueue.push(1);
        stackQueue.push(2);
        stackQueue.push(3);
        stackQueue.push(4);
        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.peek());
        System.out.println(stackQueue.isEmpty());
    }
    
    
}
