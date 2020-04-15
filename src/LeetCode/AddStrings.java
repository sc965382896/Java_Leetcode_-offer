package LeetCode;

// 字符串相加
// 双指针法

public class AddStrings {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            sb.append(sum % 10);

            // ！！！while循环中不要忘了对循环条件进行改变。
            i--;
            j--;
        }
        if (carry == 1) sb.append(1);
        return sb.reverse().toString();
    }
}
