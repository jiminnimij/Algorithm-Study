import java.io.*;
import java.util.*;

public class Problem14002 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] tails = new int[n];

        int[] tailsIdx = new int[n];

        int[] prev = new int[n];
        Arrays.fill(prev, -1);

        int len = 0;

        for (int i = 0; i < n; i++) {
            int pos = lowerBound(tails, 0, len, arr[i]);

            tails[pos] = arr[i];
            tailsIdx[pos] = i;

            if (pos > 0) {
                prev[i] = tailsIdx[pos - 1];
            }

            if (pos == len) {
                len++;
            }
        }

        int[] answer = new int[len];
        int idx = tailsIdx[len - 1];

        for (int i = len - 1; i >= 0; i--) {
            answer[i] = arr[idx];
            idx = prev[idx];
        }

        bw.write(len + "\n");
        for (int x : answer) {
            bw.write(x + " ");
        }
        bw.write("\n");

        bw.flush();
        bw.close();
    }


    // 이분탐색
    static int lowerBound(int[] arr, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}