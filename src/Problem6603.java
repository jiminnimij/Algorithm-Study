import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class Problem6603 {
    static final int count = 6;
    static int k;
    static int[] s;
    static int[] result = new int[count];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        while(true) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if (k == 0) {
                break;
            }

            s = new int[k];

            for (int i = 0; i < k; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }

            backtracking(0, 0);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    public static void backtracking(int depth, int start) throws IOException {
        if (depth == count) {
            for (int i = 0; i < count; i++) {
                sb.append(result[i]).append(" ");
            }
            bw.write(sb.toString());
            bw.newLine();
            sb.setLength(0);
        }

        else {
            for (int i = start; i < s.length; i++) {
                result[depth] = s[i];
                backtracking(depth + 1, i + 1);
            }
        }
    }
}