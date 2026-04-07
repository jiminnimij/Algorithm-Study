import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class Problem15664 {
    static int n, m;
    static int[] arr;
    static int[] count = new int [10001];
    static int[] result;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        result = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            count[arr[i]]++;
        }

        arr = Arrays.stream(arr).distinct().toArray();
        Arrays.sort(arr);

        backtracking(0, 0);

        bw.flush();
        bw.close();
    }

    static void backtracking(int depth, int start) throws IOException {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i]).append(" ");
            }
            bw.write(sb.toString());
            bw.newLine();
            sb.setLength(0);
        } else {
            for (int i = start; i < arr.length; i++) {
                if (count[arr[i]] > 0) {
                    count[arr[i]]--;
                    result[depth] = arr[i];
                    backtracking(depth + 1, i);
                    count[arr[i]]++;
                }
            }
        }
    }
}