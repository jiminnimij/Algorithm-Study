import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Problem12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        HashMap<Integer, Integer> number = new HashMap<>();

        dp[1] = 0;
        number.put(1, 1);

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            number.put(i, i - 1);

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
                if (dp[i] == dp[i / 2] + 1) {
                    number.put(i, i / 2);
                }
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
                if (dp[i] == dp[i / 3] + 1) {
                    number.put(i, i / 3);
                }
            }
        }

        bw.write(String.valueOf(dp[n]));
        bw.newLine();
        bw.write(String.valueOf(n));

        int current = n;
        while (current != 1) {
            current = number.get(current);
            bw.write(" " + current);
        }

        bw.flush();
        bw.close();

    }
}