package d1.S2050;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Solution {
     
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        char[] input = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : input) {
            sb.append(c>='a' ? (c+1)-'a' : (c+1)-'A').append(" ");
        }
        System.out.println(sb);
    }
 
}
