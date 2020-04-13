package jianzhiOffer;

// 面试题5：替换空格
// 扩充原数组反向替换，或者直接使用StringBuilder类

public class Solution5 {
    public String replaceSpace(StringBuffer str) {
        if (null == str) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append('%');
                sb.append('2');
                sb.append('0');
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public String replaceSpaceWithSpan(StringBuffer str) {
        if (null == str) {
            return null;
        }

        int originalLength = str.length();
        int numberOfBlank = 0;
        for (int i = 0; i < originalLength; i++) {
            if (str.charAt(i) == ' ') numberOfBlank++;
        }

        int newLength = originalLength + numberOfBlank * 2;
        str.setLength(newLength);
        int indexOfNew = newLength - 1;
        int indexOfOriginal = originalLength - 1;
        for (; indexOfOriginal >= 0; indexOfOriginal--) {
            if (indexOfOriginal == indexOfNew) break;
            char value = str.charAt(indexOfOriginal);
            if (value == ' ') {
                str.setCharAt(indexOfNew--, '0');
                str.setCharAt(indexOfNew--, '2');
                str.setCharAt(indexOfNew--, '%');
            } else {
                str.setCharAt(indexOfNew--, value);
            }
        }

        return str.toString();
    }
}
