import java.io.*;
import java.util.StringTokenizer;

public class Problem9466 {

    static int n;
    static int[] next;
    static int[] state;
    static int teamCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());

            next = new int[n];
            state = new int[n];
            teamCount = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                next[i] = Integer.parseInt(st.nextToken()) - 1; // 0-based
            }

            for (int i = 0; i < n; i++) {
                if (state[i] == 0) {
                    dfs(i);
                }
            }

            int notInTeam = n - teamCount;
            bw.write(notInTeam + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static void dfs(int x) {
        state[x] = 1;
        int y = next[x];

        if (state[y] == 0) {
            dfs(y);
        } else if (state[y] == 1) {
            teamCount++;
            for (int cur = next[y]; cur != y; cur = next[cur]) {
                teamCount++;
            }
        }

        state[x] = 2;
    }
}
