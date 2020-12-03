package d1.S2058;

import java.util.Scanner;

public class Solution {
     
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
         
        String input = sc.nextLine();
        int answer = 0;
        for(char c : input.toCharArray()) {
            answer += (c-'0');
        }
        System.out.println(answer);
         
        sc.close();
    }
 
}
