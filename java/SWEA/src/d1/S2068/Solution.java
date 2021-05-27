package d1.S2068;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=1;t<=T;t++){
            sb.append("#").append(t).append(" ");
            StringTokenizer str = new StringTokenizer(br.readLine());
            int max = Integer.parseInt(str.nextToken());
            while(str.hasMoreTokens()){
                max = Math.max(Integer.parseInt(str.nextToken()), max);
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb.toString());
         
    }
}