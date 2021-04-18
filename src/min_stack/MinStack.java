package min_stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description: TODO
 * @author: lucachen
 * @Date: 2021-04-16
 */
public class MinStack {
    private Deque<Integer> stack = null;
    private Deque<Integer> miniStack = null;

    public MinStack() {
        stack = new LinkedList<>();
        miniStack = new LinkedList<>();
        miniStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        miniStack.push(Math.min(miniStack.peek(), val));
    }

    public void pop() {
        stack.pop();
        miniStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return miniStack.peek();
    }
}
