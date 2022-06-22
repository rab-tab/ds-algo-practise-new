package stack;

public class TestMinStack {

    public static void main(String[] args) {

        MyStack stack = new MyStack();
        stack.push(18);
        System.out.println("Min is " + stack.min());
        stack.push(15);
        System.out.println("Min is " + stack.min());
        stack.push(15);
        System.out.println("Min is " + stack.min());
        stack.pop();
        System.out.println("Min is " + stack.min());
        //  mainStack.push(15);
        //  mainStack.push(16);
    }
}
