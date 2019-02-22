import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

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
        LCSreturns solver = new LCSreturns();
        solver.solve(1, in, out);
        out.close();
    }

    static class LCSreturns {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            String a = in.nextLine();
            String b = in.nextLine();
            int n = a.length();
            int m = b.length();
            int[][] first = new int[n + 1][m + 1];
            int[][] second = new int[n + 1][m + 1];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++) {
                    if (a.charAt(i) == b.charAt(j)) {
                        first[i + 1][j + 1] = first[i][j] + 1;
                    } else {
                        first[i + 1][j + 1] = Math.max(first[i + 1][j],
                                first[i][j + 1]);
                    }
                }
            for (int i = n - 1; i >= 0; i--)
                for (int j = m - 1; j >= 0; j--) {
                    if (a.charAt(i) == b.charAt(j)) {
                        second[i][j] = second[i + 1][j + 1] + 1;
                    } else {
                        second[i][j] = Math.max(second[i][j + 1], second[i + 1][j]);
                    }
                }
            int cur = first[n][m];
            int ret = 0;
            for (int i = 0; i <= n; i++) {
                boolean[] used = new boolean[256];
                for (int j = 0; j < m; j++) {
                    if (used[b.charAt(j)]) {
                        continue;
                    }
                    int now = first[i][j] + second[i][j + 1] + 1;
                    if (now == cur + 1) {
                        used[b.charAt(j)] = true;
                        ret++;
                    }
                }
            }
            out.println(ret);

        }

    }
}

