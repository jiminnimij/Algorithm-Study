import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());

        long result = powMod(a, b, c);
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    public static long powMod(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }
        else if (b == 2) {
            return (a * a) % c;
        }
        else if (b % 2 == 0) {
            long temp = powMod(a, b / 2, c);
            return (temp * temp) % c;
        }
        else {
            long temp = powMod(a, b - 1, c);
            return (temp * a) % c;
        }
    }
}