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
        RangeMinimumQuery solver = new RangeMinimumQuery();
        solver.solve(1, in, out);
        out.close();
    }

    static class RangeMinimumQuery {
        int[][] rmq;
        int log;
        int[] arr;

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            double logn = Math.log(n) / Math.log(2);
            log = (int) logn;
            rmq = new int[log + 2][n + 2];
            rmq[0] = arr;
            for (int i = 1; i <= log; i++) {
                for (int j = 0; j <= n; j++) {
                    if (j + (int) Math.pow(2, i - 1) >= n) break;
                    rmq[i][j] = Math.min(rmq[i - 1][j], rmq[i - 1][j + (int) Math.pow(2, i - 1)]); //1<<(i-1)
                }
            }
            for (int i = 0; i < m; i++) {
                out.println(find(in.nextInt(), in.nextInt()));
            }

        }

        int find(int a, int b) {
            int diff = b - a + 1;
            int min = arr[a];
            for (int i = log + 1; i >= 0; i--) {
                if (diff >= Math.pow(2, i)) {
                    min = Math.min(min, rmq[i][a]);
                    a += Math.pow(2, i);
                    diff -= Math.pow(2, i);
                }
            }
            return min;

        }

    }
}

