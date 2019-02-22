import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
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
        RoadsAndLibraries solver = new RoadsAndLibraries();
        solver.solve(1, in, out);
        out.close();
    }

    static class RoadsAndLibraries {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int q = in.nextInt();
            for (int t = 0; t < q; t++) {
                int n = in.nextInt();
                int m = in.nextInt();
                long libCost = in.nextLong();
                long roadCost = in.nextLong();
                boolean[] visited = new boolean[n + 1];
                ArrayList<Integer>[] graph = new ArrayList[n + 1];
                for (int i = 0; i <= n; i++) {
                    graph[i] = new ArrayList();
                }
                for (int i = 0; i < m; i++) {
                    int u = in.nextInt();
                    int v = in.nextInt();
                    graph[u].add(v);
                    graph[v].add(u);
                }
                if (libCost <= roadCost)
                    out.println(libCost * n);
                else {

                    Queue<Integer> queue = new LinkedList();
                    long res = 0;
                    for (int i = 1; i <= n; i++) {
                        long counter = 0;
                        if (visited[i]) continue;
                        queue.add(i);

                        visited[i] = true;
                        while (!queue.isEmpty()) {
                            int top = queue.remove();
                            for (int child : graph[top]) {
                                if (!visited[child]) {
                                    visited[child] = true;
                                    counter++;
                                    queue.add(child);
                                }

                            }
                        }
                        res += (counter) * roadCost + libCost;
                    }
                    out.println(res);


                }
            }
        }

    }
}

