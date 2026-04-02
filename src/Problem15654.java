import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem15654 {
    static int n, m;
    static int[] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        arr = Arrays.stream(arr).sorted().toArray();

        backtracking(0, 0, "");

        bw.flush();
        bw.close();

    }

    static void backtracking(int depth, int current, String s) throws IOException {
        if (depth == m) {
            bw.write(s);
            bw.newLine();
        }
        else {
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    backtracking(depth + 1, current + arr[i], s + arr[i] +" ");
                    visited[i] = false;
                }
            }
        }
    }
}