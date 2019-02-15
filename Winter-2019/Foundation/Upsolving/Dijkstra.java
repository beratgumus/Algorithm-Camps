import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.AbstractCollection;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.AbstractQueue;
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
        MSTP solver = new MSTP();
        solver.solve(1, in, out);
        out.close();
    }

    static class MSTP {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int t = in.nextInt();
            for (int z = 0; z < t; z++) {
                int n = in.nextInt();
                int m = in.nextInt();

                ArrayList<MSTP.Pair>[] graph = new ArrayList[n + 1];
                for (int i = 0; i < n + 1; i++) {
                    graph[i] = new ArrayList<>();
                }
                for (int i = 0; i < m; i++) {
                    int u = in.nextInt();
                    int v = in.nextInt();
                    int c = in.nextInt();
                    graph[u].add(new MSTP.Pair(v, c));
                    graph[v].add(new MSTP.Pair(u, c));
                }

                int s = in.nextInt();
                PriorityQueue<MSTP.Pair> q = new PriorityQueue((o1, o2) -> {
                    if (((MSTP.Pair) o1).first > ((MSTP.Pair) o2).first)
                        return 1;
                    else if (((MSTP.Pair) o1).first < ((MSTP.Pair) o2).first)
                        return -1;
                    else
                        return 0;
                });
                q.add(new MSTP.Pair(0, s));
                int[] answer = new int[n + 1];
                Arrays.fill(answer, Integer.MAX_VALUE);
                while (!q.isEmpty()) {
                    MSTP.Pair top = q.remove();
                    int c = top.first;
                    int u = top.second;
                    if (answer[u] != Integer.MAX_VALUE) continue;
                    answer[u] = c;
                    for (MSTP.Pair pair : graph[u]) {
                        int v = pair.first;
                        int w = pair.second;

                        if (c + w < answer[v]) {
                            q.add(new MSTP.Pair(c + w, v));
                        }

                    }
                }
                int[] result = new int[n - 1];
                int j = 0;
                for (int i = 1; i < n + 1; i++) {
                    if (i == s) continue;
                    if (answer[i] == Integer.MAX_VALUE)
                        result[j] = -1;
                    else
                        result[j] = answer[i];
                    j++;
                }
                out.println(Arrays.toString(result));
            }


        }

        static class Pair {
            int first;
            int second;

            public Pair(int f, int s) {
                first = f;
                second = s;
            }

        }

    }
}

