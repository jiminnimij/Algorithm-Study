import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem11659 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] dp = new int[n];
        st = new StringTokenizer(br.readLine());

        dp[0] = Integer.parseInt(st.nextToken());

        for (int i = 1 ; i < n; i++) {
            dp[i] = dp[i-1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            int result;
            if (start == 0) {
                result = dp[end];
            } else {
                result = dp[end] - dp[start - 1];
            }

            bw.write(String.valueOf(result));
            bw.newLine();
        }
        bw.flush();
        bw.close();

    }
}