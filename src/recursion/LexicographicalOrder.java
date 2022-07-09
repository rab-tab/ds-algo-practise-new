package recursion;

public class LexicographicalOrder {
    public static void main(String[] args) {
        int n = 9;

        for (int i = 1; i <= 9; i++) {
            lexicographicOrder(i, n);
        }

    }


    public static void lexicographicOrder(int i, int n) {
        if(i>n) return;
        System.out.println(i);
        for (int j = 0; j < 10; j++) {
            lexicographicOrder(10 * i + j, n);
        }
    }
}
