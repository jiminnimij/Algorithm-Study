import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class Problem15650 {
    static int n, m;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        backtracking(0, 0, "");
        bw.flush();
        bw.close();

    }
    static void backtracking(int depth, int x, String string) throws IOException{
        if (depth == m) {
            bw.write(string + "\n");
        }

        else {
            for (int i = x+ 1; i <= n; i ++) {

                backtracking(depth + 1, i, string + i + " ");
            }
        }



    }
}