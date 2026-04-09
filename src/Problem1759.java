import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.lang.StringBuilder;

public class Problem1759 {
    static int l, c;
    static char[] arr;
    static char[] result;
    static char[] vowel = {'a', 'e', 'i', 'o', 'u'};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[c];
        result = new char[l];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
        backtracking(0, 0, false, 0);

        bw.flush();
        bw.close();
    }

    static void backtracking(int depth, int start, boolean hasVowel, int consonantCount) throws IOException {
        if (depth == l) {
            if (hasVowel && consonantCount > 1) {
                for (int i = 0; i < l; i++) {
                    sb.append(result[i]);
                }
                bw.write(sb.toString());
                bw.newLine();
                sb.setLength(0);
            }
        }
        else {
            for (int i = start; i < c; i++) {
                result[depth] = arr[i];
                boolean vowelFound = Arrays.binarySearch(vowel, arr[i]) > -1;
                if (vowelFound) {
                    backtracking(depth + 1, i + 1, true, consonantCount);
                }
                else {
                    backtracking(depth + 1, i + 1, hasVowel, consonantCount + 1);
                }
            }
        }
    }
}