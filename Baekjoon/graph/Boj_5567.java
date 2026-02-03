import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_5567 {

    private static List<Integer>[] graph;
    private static boolean[] visited;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        visited[1] = true;

        int count = 0;
        int depth = 0;

        // depth 0 -> 1 -> 2까지만
        while (!queue.isEmpty() && depth < 2) {
            int size = queue.size();    // 현재 depth에 있는 사람 수

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                for (int friend : graph[current]) {
                    if (!visited[friend]) {
                        visited[friend] = true;
                        queue.offer(friend);
                        count++;
                    }
                }
            }

            depth++;
        }
        return count;
    }
}
