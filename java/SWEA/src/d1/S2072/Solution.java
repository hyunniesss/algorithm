package d1.S2072;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
 
    static int T, N;
    static StringBuilder sb = new StringBuilder();
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" "); // 출력 형태 맞춤
            int answer = 0;
            StringTokenizer str = new StringTokenizer(br.readLine(), " "); // 공백구분 입력
            for (int i = 0; i < 10; i++) {
                int input = Integer.parseInt(str.nextToken());
                answer += (input % 2 == 0 ? 0 : input); // 입력값이 홀수이면 더하고 짝수이면 +0
            }
             
            sb.append(answer).append("\n");
        }
        System.out.println(sb);// 마지막에 한번에 출력
 
    }
 
}