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
        ArrayXorRevisited solver = new ArrayXorRevisited();
        solver.solve(1, in, out);
        out.close();
    }

    static class ArrayXorRevisited {
        int[] d;
        int[] sg;

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int q = in.nextInt();
            d = new int[(int) 1e5 + 1];
            sg = new int[(int) 1e5 * 4];
            for (int i = 1; i <= n; i++) {
                d[i] = in.nextInt();
            }
            init(1, 1, n);

            for (int i = 0; i < q; i++) {
                if (in.nextInt() == 1)
                    out.println(find(1, 1, n, in.nextInt(), in.nextInt()));
                else {
                    int o1 = in.nextInt();
                    int o2 = in.nextInt();
                    int diff = o2 ^ find(1, 1, n, o1, o1);
                    update(1, 1, n, o1, diff);
                }

            }


        }

        private void update(int k, int lf, int rg, int plc, int value) {
            if (rg < plc || lf > plc)
                return;
            sg[k] ^= value;
            if (lf == rg) return;
            int mid = (lf + rg) / 2;
            update(2 * k, lf, mid, plc, value);
            update(2 * k + 1, mid + 1, rg, plc, value);

        }

        void init(int k, int lf, int rg) {
            if (lf == rg) {
                sg[k] = d[lf];
                return;
            }
            int mid = (lf + rg) / 2;
            init(k * 2, lf, mid);
            init((k * 2) + 1, mid + 1, rg);
            sg[k] = sg[2 * k] ^ sg[2 * k + 1];
        }

        int find(int k, int lf, int rg, int qleft, int qright) {
            if (qleft <= lf && rg <= qright)
                return sg[k];
            if (lf > qright || rg < qleft)
                return 0;
            return find(2 * k, lf, (lf + rg) / 2, qleft, qright) ^ find(2 * k + 1, ((lf + rg) / 2) + 1, rg, qleft, qright);

        }

    }
}

