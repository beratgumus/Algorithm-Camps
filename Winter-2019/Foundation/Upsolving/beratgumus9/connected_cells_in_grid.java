import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
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
        ConnectedCellsInGrid solver = new ConnectedCellsInGrid();
        solver.solve(1, in, out);
        out.close();
    }

    static class ConnectedCellsInGrid {
        int[][] matrix;
        boolean[][] visited;

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            matrix = new int[n + 2][m + 2];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            visited = new boolean[n + 2][m + 2];
            Queue<Pair<Integer, Integer>> queue = new LinkedList();
            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= n - 1; i++) {
                for (int j = 1; j <= m; j++) {
                    int counter = 1;
                    if (visited[i][j] || matrix[i][j] == 0) continue;
                    queue.add(new Pair<>(i, j));
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        Pair top = queue.remove();
                        int x = (int) top.getKey();
                        int y = (int) top.getValue();
                        for (Pair child : getChilds(x, y)) {
                            int a = (int) child.getKey();
                            int b = (int) child.getValue();
                            if (!visited[a][b] && matrix[a][b] == 1) {
                                queue.add(new Pair<>(a, b));
                                visited[a][b] = true;
                                counter++;
                            }

                        }
                    }
                    max = Math.max(max, counter);
                }

            }
            out.println(max);


        }

        List<Pair> getChilds(int i, int j) {
            List<Pair> childs = new ArrayList();
            for (int m = -1; m < 2; m++) {
                for (int k = -1; k < 2; k++) {
                    if (!visited[i - m][j - k] && matrix[i - m][j - k] == 1) {
                        childs.add(new Pair(i - m, j - k));
                    }
                }

            }
            return childs;
        }

    }

    static class Pair implements Serializable {
        K getKey();

        V getValue();

        Pair;

        String toString();

        int hashCode();

        boolean equals;

    }
}

