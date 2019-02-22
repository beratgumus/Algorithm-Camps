import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.OptionalInt;

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
        KasmailAndTrees solver = new KasmailAndTrees();
        solver.solve(1, in, out);
        out.close();
    }

    static class KasmailAndTrees {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int max = Arrays.stream(arr).max().getAsInt();

            int left = 0;
            int right = max;
            while (left < right) {
                int middle = (right + left) / 2;
                long s = tryValue(arr, middle);

                if (s >= m && tryValue(arr, middle + 1) < m) {
                    left = middle;
                    break;
                } else if (s > m)
                    left = middle;
                else
                    right = middle;
            }
            out.println(left);
        }

        private long tryValue(int[] arr, int value) {
            long result = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > value)
                    result += arr[i] - value;
            }
            return result;
        }

    }
}

