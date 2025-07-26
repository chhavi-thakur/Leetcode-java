 public class Solution {

    public boolean isAdditiveNumber(String num) {
        int n = num.length();

         for (int i = 1; i <= n / 2; i++) {
            if (num.charAt(0) == '0' && i > 1) return false; // leading zero

            for (int j = i + 1; n - j >= j - i && n - j >= i; j++) {
                if (num.charAt(i) == '0' && j - i > 1) break; // leading zero

                String num1 = num.substring(0, i);
                String num2 = num.substring(i, j);

                if (isValid(num1, num2, num.substring(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(String num1, String num2, String remaining) {
        while (!remaining.isEmpty()) {
            String sum = addStrings(num1, num2);
            if (!remaining.startsWith(sum)) return false;

            remaining = remaining.substring(sum.length());
            num1 = num2;
            num2 = sum;
        }
        return true;
    }

     private String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();

        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry != 0) {
            int d1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int d2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;

            int sum = d1 + d2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }

        return sb.reverse().toString();
    }

     
}
