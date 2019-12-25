package src.java.problems;

/*
 * 1281. Subtract the Product and Sum of Digits of an Integer (Easy)
 */

public class Q1281 {
    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(234));
    }

    public static int subtractProductAndSum(int n) {
        int product = 1, sum = 0;
        while (n != 0) {
            product *= n % 10;
            sum += n % 10;
            n /= 10;
        }
        return product - sum;
    }
}