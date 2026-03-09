import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Problem15988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int[] testCases = new int[t];

        int max = 0;

        for (int i = 0; i < t; i++) {
            testCases[i] = Integer.parseInt(br.readLine());
            if (testCases[i] > max) {
                max = testCases[i];
            }
        }

        long[] dp = new long[max + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= max; i++) {
            dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % 1000000009;
        }

        for (int i = 0 ; i < t; i++) {
            bw.write(dp[testCases[i]] + "\n");
        }

        bw.flush();
        bw.close();

    }
}