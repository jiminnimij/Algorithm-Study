import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Problem11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i < n+1; i ++){
            int p = Integer.parseInt(st.nextToken());
            dp[i] = p;

            for (int j = 0; j < (i / 2) + 1; j++) {
                dp[i] = Math.max(dp[i], dp[j + 1] + dp[i - j - 1]);
            }
        }

        bw.write(String.valueOf(dp[n]));
        bw.flush();
        bw.close();

    }
}