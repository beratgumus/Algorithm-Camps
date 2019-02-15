import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
        Prim solver = new Prim();
        solver.solve(1, in, out);
        out.close();
    }

    static class Prim {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            ArrayList<Prim.Pair>[] graph = new ArrayList[n + 1];
            for (int i = 0; i < n + 1; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                int c = in.nextInt();
                graph[u].add(new Prim.Pair(v, c));
                graph[v].add(new Prim.Pair(u, c));
            }

            int s = in.nextInt();

            PriorityQueue<Prim.Node> q = new PriorityQueue<>(Prim.Node::compareTo);
            q.add(new Prim.Node(0, s, -1));
            int mst = 0;
            ArrayList<Prim.Pair> ret = new ArrayList<>();
            boolean[] visited = new boolean[n + 1];
            while (!q.isEmpty()) {
                Prim.Node top = q.remove();
                int cost = top.cost;
                int u = top.u;
                int back = top.back;

                if (visited[u]) continue;
                visited[u] = true;
                if (back != -1) {
                    ret.add(new Prim.Pair(u, back));
                    mst += cost;
                }

                for (Prim.Pair pair : graph[u]) {
                    int v = pair.first;
                    int w = pair.second;
                    q.add(new Prim.Node(w, v, u));

                }
            }

            out.println(mst);
        }

        static class Node implements Comparable<Prim.Node> {
            int u;
            int cost;
            int back;

            public Node(int c, int _u, int b) {
                u = _u;
                cost = c;
                back = b;
            }

            public int compareTo(Prim.Node o) {
                if (cost > o.cost)
                    return 1;
                else if (cost < o.cost)
                    return -1;
                else
                    return 0;
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

