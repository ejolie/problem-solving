package com.ejolie.problems.easy._1108;

/*
 * 1108. Defanging an IP Address
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String address = "1.1.1.1";
        System.out.println(solution.defangIPaddr(address));
    }

    // 1. String.replace()
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    // 2. String.replaceAll()
    public String defangIPaddr2(String address) {
        return address.replaceAll("\\.", "[.]");
    }

    // 3. StringBuilder()
    public String defangIPaddr3(String address) {
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
