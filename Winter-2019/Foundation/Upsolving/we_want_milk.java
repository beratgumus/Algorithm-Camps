import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.TreeMap;
import java.util.Map;
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
        WeWantMilk solver = new WeWantMilk();
        solver.solve(1, in, out);
        out.close();
    }

    static class WeWantMilk {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int N = in.nextInt();
            int M = in.nextInt();

            Map<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < N; i++) {
                map.put(in.nextInt(), in.nextInt());
            }

            double answer = 0;
            for (Integer key : map.keySet()) {
                answer += key * (double) Math.min(map.get(key), M);
                M -= Math.min(map.get(key), M);
                if (M == 0)
                    break;

            }
            out.println(BigDecimal.valueOf(answer).toBigInteger());
        }

    }
}

