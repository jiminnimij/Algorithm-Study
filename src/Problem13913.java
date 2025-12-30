import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
import java.lang.StringBuilder;

public class Problem13913 {
    static final int MAX = 100000;
    static int[] before = new int[MAX + 1];
    static int[] count = new int[MAX + 1];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Arrays.fill(count, MAX+1);
        Arrays.fill(before, 0);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        before[n] = -1;
        count[n] = 0;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            if (cur == k) {
                writePath(n, k);
                return;
            }

            int[] nextPositions = {cur - 1, cur + 1, cur * 2};

            for (int next : nextPositions) {
                if (next >= 0 && next <= MAX && count[next] > count[cur] + 1) {
                    before[next] = cur;
                    count[next] = count[cur] + 1;
                    queue.add(next);
                }
            }
        }

    }

    public static void writePath(int n, int k) throws IOException {
        Stack<Integer> stack = new Stack<>();
        int index = k;
        while (index != n) {
            stack.push(index);
            index = before[index];
        }

        stack.push(n);

        StringBuilder sb = new StringBuilder();
        sb.append(count[k]).append("\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}