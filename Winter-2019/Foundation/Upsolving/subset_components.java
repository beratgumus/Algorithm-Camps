import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
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
        SubsetComponents solver = new SubsetComponents();
        solver.solve(1, in, out);
        out.close();
    }

    static class SubsetComponents {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            ArrayList<Long> data = new ArrayList<>();
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                data.add(Long.parseUnsignedLong(in.next()));
            }
            int components = 0;
            int max = (1 << n);
            for (int j = 0; j < max; j++) {
                long subset = 0;
                int mask = 1;
                int subComponents = 0;
                for (Long l : data) {
                    if ((j & mask) != 0) {
                        int preBitCount = Long.bitCount(subset);
                        int lbitCount = Long.bitCount(l);
                        subset |= lbitCount < 2 ? 0 : l;
                        int postBitCount = Long.bitCount(subset);
                        if (postBitCount - preBitCount == lbitCount && lbitCount != 0L) {
                            subComponents++;
                        }
                    }
                    mask <<= 1;
                }
                components += 64 - Long.bitCount(subset) + subComponents;
            }
            System.out.println(components);
        }

    }
}

