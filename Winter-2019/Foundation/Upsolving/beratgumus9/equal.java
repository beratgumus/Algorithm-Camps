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
        Equa solver = new Equa();
        solver.solve(1, in, out);
        out.close();
    }

    static class Equa {
        int min;
        int n;
        int[] arr;

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int q = in.nextInt();
            for (int k = 0; k < q; k++) {
                n = in.nextInt();
                arr = new int[n];
                min = Integer.MAX_VALUE;
                for (int j = 0; j < n; j++) {
                    int item = in.nextInt();
                    arr[j] = item;
                    min = Math.min(min, item);
                }
                int globalMin = Integer.MAX_VALUE;
                for (int i = min; i > min - 5; i--)
                    globalMin = Math.min(globalMin, helper(i));
                out.println(globalMin);
            }

        }

        int helper(int min) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                int diff = arr[i] - min;
                count += diff / 5;
                diff = diff % 5;
                count += diff / 2;
                diff = diff % 2;
                count += diff;

            }
            return count;
        }

    }
}

