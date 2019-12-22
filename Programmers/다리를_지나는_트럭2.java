import java.util.*;

class Truck {
  int w, t;

  public Truck(int w) {
    this.w = w;
  }
}

class Solution {
  public int solution(int bridge_length, int weight, int[] truck_weights) {
    Queue<Truck> Q = new LinkedList<>();
    for (int w : truck_weights) {

    }

    Queue<Integer> goingQ = new LinkedList<>();
    Queue<Integer> waitingQ = new LinkedList<>();
    for (int w : truck_weights) {
      waitingQ.add(w);
    }
    Queue<Integer> timeQ = new LinkedList<>();
    int time = 0;
    int weightSum = 0;

    while (!goingQ.isEmpty() || !waitingQ.isEmpty()) {
      if (!timeQ.isEmpty() && time - timeQ.peek() == bridge_length) {
        weightSum -= goingQ.peek();
        goingQ.poll();
        timeQ.poll();
      }

      if (!waitingQ.isEmpty()) {
        if (goingQ.isEmpty() || (weightSum + waitingQ.peek() <= weight)) {
          weightSum += waitingQ.peek();
          goingQ.add(waitingQ.poll());
          timeQ.add(time);
        }
      }
      time++;
    }
    return time;
  }
}