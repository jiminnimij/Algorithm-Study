import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem9663 {
    static int n;
    static int count = 0;
    static boolean[] visited1 = new boolean[35];
    static boolean[] visited2 = new boolean[35];
    static boolean[] visited3 = new boolean[35];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        backtracking(0);
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    static void backtracking(int depth) {
        if (depth == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited1[i] && !visited2[depth + i] && !visited3[depth - i + n - 1]) {
                visited1[i] = true;
                visited2[depth + i] = true;
                visited3[depth - i + n - 1] = true;

                backtracking(depth + 1);

                visited1[i] = false;
                visited2[depth + i] = false;
                visited3[depth - i + n - 1] = false;
            }
        }
    }
}