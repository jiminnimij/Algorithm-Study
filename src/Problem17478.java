import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.StringBuilder;

public class Problem17478 {
    static String fixedLine = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
    static String question = "\"재귀함수가 뭔가요?\"\n";

    static String answer1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
    static String answer2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
    static String answer3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";

    static String indent = "____";
    static String rightAnswer = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
    static String endLine = "라고 답변하였지.\n";

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());

        sb.append(fixedLine);

        printRecursion(n, 0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void printRecursion(int n, int count){
        if (n == 0) {
            sb.append(indent.repeat(count));
            sb.append(question);
            sb.append(indent.repeat(count));
            sb.append(rightAnswer);
            sb.append(indent.repeat(count));
            sb.append(endLine);
        } else {
            sb.append(indent.repeat(count));
            sb.append(question);
            sb.append(indent.repeat(count));
            sb.append(answer1);
            sb.append(indent.repeat(count));
            sb.append(answer2);
            sb.append(indent.repeat(count));
            sb.append(answer3);
            printRecursion(n - 1, count + 1);
            sb.append(indent.repeat(count));
            sb.append(endLine);

        }
    }
}