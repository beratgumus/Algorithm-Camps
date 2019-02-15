import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.AbstractCollection;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.AbstractQueue;
import java.util.Comparator;
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
        Kruskal solver = new Kruskal();
        solver.solve(1, in, out);
        out.close();
    }

    static class Kruskal {
        int[] parent;

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            ArrayList<Kruskal.Node> edges = new ArrayList();

            ArrayList<Kruskal.Pair>[] graph = new ArrayList[n + 1];
            for (int i = 0; i < m; i++)
                edges.add(new Kruskal.Node(in.nextInt(), in.nextInt(), in.nextInt()));
  /*      for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int from = in.nextInt();
            int to = in.nextInt();
            int weight = in.nextInt();
            graph[from].add(new Pair(to, weight));
            graph[to].add(new Pair(from, weight));
        }
*/
            parent = new int[n + 1];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            PriorityQueue<Kruskal.Node> q = new PriorityQueue<>(Comparator.comparing(node -> node.weight));
            q.addAll(edges);
            int cost = 0;
            while (!q.isEmpty()) {
                Kruskal.Node node = q.remove();
                int fromP = find(node.from);
                int toP = find(node.to);
                if (toP == fromP) continue;
                else {
                    cost += node.weight;
                    parent[fromP] = toP;
                }
            }
            out.println(cost);

        }

        int find(int node) {
            return parent[node] != node ? find(parent[node]) : node;
        }

        static class Node {
            int from;
            int to;
            int weight;

            public Node(int from, int to, int weight) {
                this.from = from;
                this.to = to;
                this.weight = weight;
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

