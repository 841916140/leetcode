package leetCode;

import java.util.Stack;

//实现一个栈，该栈带有出栈，入栈，取最小元素(getMin)3个方法，保证这3个方法的时间复杂度都是O(1)
//使用两个栈来实现，一个栈用来储存值，另一个栈用来存储最小值的记录
public class MinStack {
    private Stack<Integer> stack1=new Stack<>();
    private Stack<Integer> stack2=new Stack<>();

    public void push(int element)
    {
        stack1.push(element);
        if(stack2.isEmpty())
        {
            stack2.push(element);
        }
        else
        {
            //stack2存储最小值的记录，即曾经的最小值，栈顶元素是当前元素的最小值，因此当元素小于当前最小值时将它入栈更新最小值
            if(element<=stack2.peek().intValue())
            {
                stack2.push(element);
            }
        }
    }

    public int pop()
    {
        int num=stack1.pop();
        if(num==stack2.peek().intValue())
        {
            //当主栈弹出的值为最小值时才将存储最小值的栈进行弹栈操作，更新最小值为原先的次小值
            stack2.pop();
        }
        return num;
    }

    public int getMin()
    {
        return stack2.peek();
    }
    
    public static void main(String[]args)
    {
        MinStack minStack=new MinStack();
        minStack.push(3);
        minStack.push(2);
        minStack.push(1);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

    }
    
}
