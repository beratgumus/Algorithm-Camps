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
        StockMaximize solver = new StockMaximize();
        solver.solve(1, in, out);
        out.close();
    }

    static class StockMaximize {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int q = in.nextInt();
            for (int t = 0; t < q; t++) {
                int n = in.nextInt();
                int[] arr = new int[n];
                for (int z = 0; z < n; z++) {
                    arr[z] = in.nextInt();
                }
                int currentMax = 0;
                long profit = 0;
                for (int i = arr.length - 1; i >= 0; i--) {
                    if (arr[i] >= currentMax)
                        currentMax = arr[i];
                    profit += currentMax - arr[i];
                }
                out.println(profit);
            }
        }

    }
}

