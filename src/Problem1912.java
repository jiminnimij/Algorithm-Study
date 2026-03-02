import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class Problem1912{
    public static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int max = MAX * -1;
        int dp = max;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n ; i++ ) {
            int num = Integer.parseInt(st.nextToken());
            dp = max(num, dp + num);
            max = max(max, dp);

        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();

    }
}