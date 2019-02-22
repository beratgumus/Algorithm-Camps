import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.TreeMap;
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
        ClosestNumbers solver = new ClosestNumbers();
        solver.solve(1, in, out);
        out.close();
    }

    static class ClosestNumbers {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            Arrays.sort(arr);
            TreeMap<Integer, ArrayList<Integer>> map = new TreeMap();

            for (int i = 1; i < n; i++) {
                int diff = Math.max(arr[i], arr[i - 1]) - Math.min(arr[i], arr[i - 1]);
                if (map.containsKey(diff)) {
                    map.get(diff).add(arr[i - 1]);
                    map.get(diff).add(arr[i]);
                } else {
                    map.put(diff, new ArrayList<>());
                    map.get(diff).add(arr[i - 1]);
                    map.get(diff).add(arr[i]);
                }
            }
            int[] result = new int[map.get(map.firstKey()).size()];
            int i = 0;
            for (int element : map.get(map.firstKey())) {
                result[i] = element;
                i++;
            }
            System.out.println(Arrays.toString(result));
        }

    }
}

