import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.StringBuilder;
import java.util.HashMap;

public class Problem1003 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static final int MAX_NUMBER = 40;

    static HashMap<Integer, Integer> dp0 = new HashMap<>();
    static HashMap<Integer, Integer> dp1 = new HashMap<>();

    public static void main(String[] args) throws IOException{
        int test = Integer.parseInt(br.readLine());
        int number;

        fibonacci();

        for (int i = 0 ; i < test; i++){
            number = Integer.parseInt(br.readLine());
            sb.append(dp0.get(number));
            sb.append(" ");
            sb.append(dp1.get(number));
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void fibonacci(){
        for (int i = 0; i <= MAX_NUMBER; i++){
            if (i == 0) {
                dp0.put(i, 1);
                dp1.put(i, 0);
            }
            else if (i == 1){
                dp0.put(i, 0);
                dp1.put(i, 1);
            }
            else {
                dp0.put(i, dp0.get(i - 1) + dp0.get(i - 2));
                dp1.put(i, dp1.get(i - 1) + dp1.get(i - 2));
            }

        }
    }
}