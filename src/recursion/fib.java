package recursion;

public class fib {
    public static void main(String[] args) {
        int n=12;
        System.out.println("fib of "+n +"is" +fib(n));

    }

    public static int fib(int n)
    {
        if(n==0 || n==1) return n;
        return fib(n-1)+ fib(n-2);
    }
}
