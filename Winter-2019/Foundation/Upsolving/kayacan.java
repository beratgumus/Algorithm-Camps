import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.Stream;
import java.util.Map;
import java.util.Collection;
import java.util.Scanner;
import java.util.Optional;
import java.util.HashMap;
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
        Kayacan solver = new Kayacan();
        solver.solve(1, in, out);
        out.close();
    }

    static class Kayacan {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
            for (int i = 0; i < m; i++) {
                int f = in.nextInt();
                int s = in.nextInt();
                if (!graph.containsKey(f))
                    graph.put(f, new ArrayList<Integer>() {{
                        add(s);
                    }});
                else
                    graph.get(f).add(s);
                if (!graph.containsKey(s))
                    graph.put(s, new ArrayList<Integer>() {{
                        add(f);
                    }});
                else
                    graph.get(s).add(f);
            }
            boolean[] visited = new boolean[n + 1];
            Queue<Integer> q = new LinkedList();
            int start = graph.keySet().stream().findFirst().get();
            q.add(start);
            visited[start] = true;
            while (!q.isEmpty()) {
                int item = q.poll();
                for (int child : graph.get(item)) {
                    if (!visited[child]) {
                        visited[child] = true;
                        q.add(child);
                    }
                }

            }
            int bug = 0;
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i])
                    bug++;
            }
            out.println(bug > 1 ? "Not Connected" : "Connected");
        }

    }
}

