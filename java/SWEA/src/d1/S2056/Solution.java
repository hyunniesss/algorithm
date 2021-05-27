package d1.S2056;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Solution {
 
    static int T;
    static StringBuilder sb = new StringBuilder();
    static String[] calendar = new String[3];
    static int[] date = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
 
            String input = br.readLine();
            calendar[0] = input.substring(0, 4);
            calendar[1] = input.substring(4, 6);
            calendar[2] = input.substring(6);
            if ((Integer.parseInt(calendar[1]) > 12) || (Integer.parseInt(calendar[1]) < 1)) {
                sb.append(-1);
            } else {
                if ((Integer.parseInt(calendar[2]) < 1)
                        || (Integer.parseInt(calendar[2]) > date[Integer.parseInt(calendar[1])])) {
                    sb.append(-1);
                } else {
                    sb.append(calendar[0]).append("/").append(calendar[1]).append("/").append(calendar[2]);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
 
}