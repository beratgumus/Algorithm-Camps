import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
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
        EvenTree solver = new EvenTree();
        solver.solve(1, in, out);
        out.close();
    }

    static class EvenTree {
        ArrayList<Integer>[] graph;
        int[] result;

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            graph = new ArrayList[n + 1];
            result = new int[n + 1];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                int from = in.nextInt();
                int to = in.nextInt();
                graph[to].add(from);
            }
            dfs(1);
            int ans = 0;
            for (int i = 2; i < result.length; i++) {
                if (result[i] % 2 == 0)
                    ans++;
            }
            System.out.println(ans);
        }

        int dfs(int root) {
            int count = 1;
            for (Integer item : graph[root]) {
                count += dfs(item);
            }

            result[root] = count;
            return count;

        }

    }
}

