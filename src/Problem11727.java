import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Problem11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];

        dp[0] = 1;

        if (n == 1) {
            bw.write(String.valueOf(dp[0]));
            bw.flush();
            bw.close();
            return;
        }

        dp[1] = 3;

        if (n == 2) {
            bw.write(String.valueOf(dp[1]));
            bw.flush();
            bw.close();
            return;
        }

        for (int i = 2; i < n; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
        }

        bw.write(String.valueOf(dp[n - 1]));
        bw.flush();
        bw.close();
    }
}