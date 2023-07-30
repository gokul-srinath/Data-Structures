package Stack;

public class Main {



    public static void main(String[] args) {
        Queue queueUsingStack = new Queue();

        queueUsingStack.enqueue(5);
        queueUsingStack.enqueue(4);
        queueUsingStack.enqueue(1);
        queueUsingStack.enqueue(3);
        System.out.println(queueUsingStack);
        queueUsingStack.dequeue();
        System.out.println(queueUsingStack);
    }
}
