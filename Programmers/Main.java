import java.util.*;

class Info {
	int w, t;

	public Info(int w, int t) {
		this.w = w;
		this.t = t;
	}
}

class Main {
	public static void main(String[] args) {
		// int[] truck_weights = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
		// System.out.println(solution(100, 100, truck_weights));
		int[] truck_weights = { 7, 4, 5, 6 };
		System.out.println(solution(2, 10, truck_weights));
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Info> Q = new LinkedList<>();
		int time = 0, sum = 0;
		for (int i = 0; i < truck_weights.length; ++i) {
			while (sum + truck_weights[i] > weight) {
				if (!Q.isEmpty() && sum + truck_weights[i] > weight)
					time = Q.peek().t + bridge_length;
				if (!Q.isEmpty() && time - Q.peek().t >= bridge_length) {
					sum -= Q.poll().w;
				}
				time++;
			}
			sum += truck_weights[i];
			Q.add(new Info(truck_weights[i], time++));
		}
		while (!Q.isEmpty())
			time = Q.poll().t + bridge_length;

		return time;
	}
}