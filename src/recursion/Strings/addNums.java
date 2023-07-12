package recursion.Strings;

public class addNums {
    public static void main(String[] args) {
        //PASS - 23,23
        //pass - 26, 24
        //pass - 86, 24

        String num1 = "189";
        String num2 = "918";
        int carry = 0;
        int sum = 0;
        StringBuilder finalSum = new StringBuilder("");
        finalSum = solve(Integer.valueOf(num1), Integer.valueOf(num2),
                carry, sum, new StringBuilder(""), 0, 0, num1.length(), num2.length());
        System.out.println("sum is " + finalSum);


    }


    public static StringBuilder solve(int num1, int num2, int carry, int sum, StringBuilder finalSum,
                                      int i, int j, int len1, int len2) {
        if (i == len1 && j == len2) {
            if (carry != 0) {
                finalSum = new StringBuilder(String.valueOf(carry)).append(finalSum.reverse());
            }
            return finalSum;
        }
        // units , tens, etc...
        int digit1 = num1 % 10;
        int digit2 = num2 % 10;
        num1 = num1 / 10;
        num2 = num2 / 10;

        sum = carry + digit1 + digit2;
        carry = sum / 10;
        finalSum = finalSum.append(sum%10);
       // sum = sum % 10;
        i++;
        j++;

        //if carry is remaining append it to sum
        return solve(num1, num2, carry, sum, finalSum, i, j, len1, len2);

    }
}
