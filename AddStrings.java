public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder str = new StringBuilder();

        int i = num1.length() - 1, j = num2.length() - 1, carry = 0, sum;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;

            sum = digit1 + digit2 + carry;
            str.append(sum % 10);
            carry = sum / 10;
        }

        return str.reverse().toString();
    }

    public static void main(String[] args) {
        AddStrings obj = new AddStrings();

        String num1 = "123";
        String num2 = "456";

        System.out.println("Sum: " + obj.addStrings(num1, num2));  // Output: 579

        num1 = "11";
        num2 = "999";

        System.out.println("Sum: " + obj.addStrings(num1, num2));  // Output: 1010
    }
}
