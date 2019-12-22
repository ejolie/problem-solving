import java.util.*;

class Main {
  public static void main(String[] args) {
    System.out.println(solution(3));
  }

  public static String solution(int n) {
    String answer = "";
    return answer;
  }

  // 2진수
  public static String toBinary(int n) {
    String answer = "";
    return answer;
  }

  // 3진수
  public static String toTrinary(int n) {
    int q = 0;
    // n 보다 작은 최대의 3의 제곱수 찾는 과정 계속 //
    while (true) {
      if (Math.pow(3, q) >= n) {
        break;
      }
      q++;
    }

    String answer = "";
    return answer;
  }
}