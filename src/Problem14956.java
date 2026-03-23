import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.StringTokenizer;

public class Problem14956 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int count = 0;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] ans = solve(n, m);
        System.out.println((ans[1] + 1) + " " + (ans[0] + 1));
    }


    static int[] solve(int n, int m) {
        if (n == 2) {
            if (m == 1) return new int[]{0, 0};
            if (m == 2) return new int[]{1, 0};
            if (m == 3) return new int[]{1, 1};
            return new int[]{0, 1};
        }

        int half = n / 2;
        int block = half * half;

        int quad = (m - 1) / block;
        int nextM = (m - 1) % block + 1;

        int[] sub = solve(half, nextM);
        int sx = sub[0];
        int sy = sub[1];

        if (quad == 0) {
            return new int[]{sy, sx};
        } else if (quad == 1) {
            return new int[]{sx + half, sy};
        } else if (quad == 2) {
            return new int[]{sx + half, sy + half};
        } else {
            return new int[]{half - 1 - sy, n - 1 - sx};
        }
    }
}