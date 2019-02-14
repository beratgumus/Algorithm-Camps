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
        UtopianTree solver = new UtopianTree();
        solver.solve(1, in, out);
        out.close();
    }

    static class UtopianTree {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int t = in.nextInt();
            for (int i = 0; i < t; i++) {
                int n = in.nextInt();
                int result = utopianTree(n);
                out.println(result);
            }

        }

        private int utopianTree(int n) {
            if (n == 0)
                return 1;
            if (n % 2 != 0)
                return helper(n);
            else
                return helper(n - 1) + 1;

        }

        static int helper(int n) {
            if (n == 1)
                return 2;
            return helper(n - 2) * 2 + 2;
        }

    }
}

