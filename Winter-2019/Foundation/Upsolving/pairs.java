import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
        Pairs solver = new Pairs();
        solver.solve(1, in, out);
        out.close();
    }

    static class Pairs {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int target = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int res = 0;
            Set set = new HashSet();
            for (int i = 0; i < n; i++) {
                if (set.contains(arr[i] + target))
                    res++;
                if (set.contains(arr[i] - target))
                    res++;
                set.add(arr[i]);
            }
            out.println(res);
        }

    }
}

