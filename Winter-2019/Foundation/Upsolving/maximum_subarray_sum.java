import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

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
        MaximumSubarraySum solver = new MaximumSubarraySum();
        solver.solve(1, in, out);
        out.close();
    }

    static class MaximumSubarraySum {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int q = in.nextInt();
            for (int t = 0; t < q; t++) {
                int n = in.nextInt();
                long m = in.nextLong();
                long[] a = new long[n];
                for (int i = 0; i < n; i++) {
                    a[i] = in.nextLong();
                }
                long result = maximumSum(a, m);
                out.print(String.valueOf(result));
            }


        }

        private long maximumSum(long[] a, long m) {
            int n = a.length;
            TreeSet<Long> set = new TreeSet();
            long maxSumMod = 0;
            a[0] = a[0] % m;
            for (int i = 1; i < n; i++) {
                a[i] = ((a[i] + a[i - 1]) % m);
            }
            set.add(0L);
            for (int i = 0; i < n; i++) {
                long ret = (set.higher(a[i]) != null) ? set.higher(a[i]) : 0;
                maxSumMod = Math.max(Math.floorMod(a[i] - ret, m), maxSumMod);
                set.add(a[i]);
            }
            return maxSumMod;
        }

    }
}

