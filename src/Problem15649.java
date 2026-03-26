import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class Problem15649 {
    static StringBuilder sb = new StringBuilder();
    static int[] arr = new int[10];
    static boolean[] visited = new boolean[10];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        func(n, m, 0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void func(int n, int m, int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                func(n, m, depth + 1);
                visited[i] = false;
            }
        }
    }
}