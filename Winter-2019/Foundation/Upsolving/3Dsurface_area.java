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
        ThreeDsurfaceArea solver = new ThreeDsurfaceArea();
        solver.solve(1, in, out);
        out.close();
    }

    static class ThreeDsurfaceArea {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int h = in.nextInt();
            int w = in.nextInt();

            int[][] A = new int[h + 2][w + 2];
            for (int i = 1; i < h + 1; i++) {
                for (int j = 1; j < w + 1; j++) {
                    A[i][j] = in.nextInt();
                }
            }
            int area = 2 * h * w;
            for (int i = 1; i < h + 1; i++) {
                for (int j = 1; j < w + 1; j++) {
                    area += Math.max(0, A[i][j] - A[i][j - 1]);
                    area += Math.max(0, A[i][j] - A[i][j + 1]);
                    area += Math.max(0, A[i][j] - A[i - 1][j]);
                    area += Math.max(0, A[i][j] - A[i + 1][j]);
                }
            }
            out.println(area);
        }

    }
}

