import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem15651 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        backtracking(0, 0, "");

        bw.flush();
        bw.close();

    }

    public static void backtracking(int depth, int start, String output) throws IOException {
        if (depth == m) {
            bw.write(output);
            bw.write("\n");
            return;
        }
        else {
            for (int i = 0; i < n; i++) {
                backtracking(depth + 1, i, output + (i + 1) + " ");
            }
        }
    }
}