package src.java.problems;
/*
 * 1108. Defanging an IP Address (Easy)
 */

public class Q1108 {
    public static void main(String[] args) {
        String address = "1.1.1.1";
        System.out.println(defangIPaddr(address));
    }

    // 1. String.replace()
    public static String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    // 2. String.replaceAll()
    public static String defangIPaddr2(String address) {
        return address.replaceAll("\\.", "[.]");
    }

    // 3. StringBuilder()
    public static String defangIPaddr3(String address) {
        StringBuilder sb = new StringBuilder();
        for (char ch : address.toCharArray()) {
            if (ch == '.') {
                sb.append("[.]");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}