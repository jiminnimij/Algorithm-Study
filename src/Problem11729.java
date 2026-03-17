import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.lang.StringBuilder;

public class Problem11729 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int count = 0;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());

        int count = hanoi(n, 1, 3, 2);
        bw.write(count + "\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static int hanoi(int n, int from, int to, int temp) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            count++;
        }
        else {
            hanoi(n - 1, from, temp, to);
            sb.append(from).append(" ").append(to).append("\n");
            hanoi(n - 1, temp, to, from);
            count++;
        }

        return count;
    }
}