package stack;

public class TestMaxStack {
    public static void main(String[] args) {
        MaximumStack stack=new MaximumStack();
        stack.push(10);
        System.out.println("Max after puhsing 10 is "+stack.getMax());
        stack.push(15);
        System.out.println("Max after puhsing 15 is "+stack.getMax());
        System.out.println("POPPING "+stack.top());
        stack.pop();
        System.out.println("Max after popping 15 is "+stack.getMax());
    }
}
