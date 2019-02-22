import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.math.BigInteger;

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
        FibonaciModified solver = new FibonaciModified();
        solver.solve(1, in, out);
        out.close();
    }

    static class FibonaciModified {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int t1 = in.nextInt();
            int t2 = in.nextInt();
            int n = in.nextInt();

            BigInteger[] dp = new BigInteger[n + 1];
            dp[1] = new BigInteger(String.valueOf(t1));
            dp[2] = new BigInteger(String.valueOf(t2));
            for (int i = 3; i < n + 1; i++) {
                dp[i] = ((dp[i - 1].multiply(dp[i - 1]).add(dp[i - 2])));
            }
            out.println(dp[n]);
        }

    }
}

