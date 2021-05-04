import java.io.*;
import java.util.StringTokenizer;

/*
 * 1717. 집합의 표현
 */
public class boj1717 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if ("0".equals(op)) {
                union(a, b);
            } else if ("1".equals(op)) {
                sb.append(hasSameParent(a, b) ? "YES" : "NO").append("\n");
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }

    }

    private static boolean hasSameParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        return a == b;
    }

    private static int findParent(int a) {
        if (parent[a] == a) {
            return a;
        }
        parent[a] = findParent(parent[a]); // 경로 압축
        return parent[a];
    }
}
