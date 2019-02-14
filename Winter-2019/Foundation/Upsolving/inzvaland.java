import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author berat
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        InzvaLand solver = new InzvaLand();
        solver.solve(1, in, out);
        out.close();
    }

    static class InzvaLand {
        ArrayList<Pair>[] graph;
        boolean[] visited;
        long max = 0;
        int temp = 0;

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int z = in.nextInt();
            graph = new ArrayList[n + 1];
            for (int i = 0; i < n + 1; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < n - 1; i++) {
                int city1 = in.nextInt();
                int city2 = in.nextInt();
                int distance = in.nextInt();
                graph[city1].add(new Pair(city2, distance));
                graph[city2].add(new Pair(city1, distance));

            }
            visited = new boolean[n + 1];
            dfs(1, 0);
            Arrays.fill(visited, false);
            dfs(temp, 0);
            out.println(max * z);

        }

        void dfs(int index, long distance) {
            if (distance > max) {
                max = distance;
                temp = index;
            }
            visited[index] = true;
            for (Pair item : graph[index]) {
                if (!visited[item.city]) {
                    dfs(item.city, item.distance + distance);
                }
            }
        }

        class Pair {
            int city;
            int distance;

            public Pair(int city, int distance) {
                this.city = city;
                this.distance = distance;
            }

        }

    }
}

