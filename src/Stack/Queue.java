package Stack;

import java.util.Stack;

public class Queue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;


    public Queue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    void enqueue(int ele) {
        stack1.add(ele);
    }


    int dequeue() {


        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }

        int ele = stack2.pop();

        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }

        return ele;

    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for(Integer ele:stack1) {
            result.append(ele);
            result.append(" ");
        }
        return result.toString();
    }


}
