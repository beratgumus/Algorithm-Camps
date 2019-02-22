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
        KingSuhul solver = new KingSuhul();
        solver.solve(1, in, out);
        out.close();
    }

    static class KingSuhul {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int r = in.nextInt();
            int g = in.nextInt();
            commDiv(r, g, out);

        }

        static int gcd(int a, int b) {
            if (a == 0)
                return b;

            return gcd(b % a, a);
        }

        static void commDiv(int a, int b, PrintWriter out) {
            int n = gcd(a, b);
            int result = 0;
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    out.println(i + " " + a / i + " " + b / i);
                }
            }
        }

    }
}

