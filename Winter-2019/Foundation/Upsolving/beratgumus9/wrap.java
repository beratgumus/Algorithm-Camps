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
        Wrap solver = new Wrap();
        solver.solve(1, in, out);
        out.close();
    }

    static class Wrap {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int[] s = new int[n];
            int[] u = new int[n];
            for (int i = 0; i < n; i++) {
                s[i] = in.nextInt();
                u[i] = in.nextInt();
            }

            int sp = 1;
            int su = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < (1 << n); i++) {
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) > 0) {
                        sp = sp * s[j];
                        su = su + u[j];
                    }
                }
                min = Math.min(Math.abs(sp - su), min);
                su = 0;
                sp = 1;
            }

            out.print(min);
        }

    }
}

