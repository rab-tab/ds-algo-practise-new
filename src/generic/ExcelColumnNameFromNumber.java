package generic;

public class ExcelColumnNameFromNumber {
    public static void main(String[] args) {
       // int num = 80;
        int num=676;

       /* int div = num / 26;
        int rem = num % 26;
        System.out.println("divisor is " + div); // 1
        System.out.println("remaindr is " + rem); // 25
        System.out.println('c');
        System.out.println((int) 'c');
        int ascii1 = (int) 'a' + div - 1;
        int ascii2 = (int) 'a' + rem - 1;
        System.out.println("Ascii1 integer value " + ascii1 + "character " + (char) ascii1);
        System.out.println("Ascii2 integer value " + ascii2 + "character " + (char) ascii2);*/
        System.out.println("Column name is "+excelColumnName(num));
        System.out.println("Column name is "+excelColumnName(702));

    }


    public static String excelColumnName(int columnNumber) {
        StringBuilder colName = new StringBuilder();

        while (columnNumber > 0) {
            int remainder = columnNumber % 26;
            if (remainder == 0) {
                colName.append("Z");
                columnNumber = (columnNumber / 26)-1;

            } else {
                colName.append((char) ((remainder - 1) + 'A'));
                columnNumber = columnNumber / 26;
            }
        }
        return colName.reverse().toString();
    }
}
