import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
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
        CoinChangeMin solver = new CoinChangeMin();
        solver.solve(1, in, out);
        out.close();
    }

    static class CoinChangeMin {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int target = in.nextInt();
            int n = in.nextInt();
            ArrayList<Integer> coins = new ArrayList();
            for (int i = 1; i <= n; i++) {
                coins.add(in.nextInt());
            }
            int dp[] = new int[n + 2];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int coin : coins) {
                for (int i = 0; i < dp.length - coin; i++) {
                    dp[i + coin] = Math.min(dp[i + coin], dp[i] + 1);

                }
            }
            out.println(dp[target]);

        }

    }
}

