import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Arrays;

public class Problem2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] fixedSeat = new int[m];
        int[] dp = new int[n+1];

        for (int i = 0 ; i < m ; i++) {
            fixedSeat[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2 ; i < n + 1 ; i++) {
            int index = i;
            if (Arrays.stream(fixedSeat).anyMatch(seat -> seat == index)) {
                dp[index] = dp[index - 1];
            }
            else if (Arrays.stream(fixedSeat).anyMatch(seat -> seat == index - 1)) {
                dp[index] = dp[index - 1];
            }
            else {
                dp[index] = dp[index - 1] + dp[index - 2];
            }

        }

        bw.write(String.valueOf(dp[n]));
        bw.flush();
        bw.close();

    }
}