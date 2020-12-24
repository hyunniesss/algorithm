package d1.S2063;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine().trim());
        int[] data=new int[N];
        StringTokenizer str=new StringTokenizer(br.readLine());
         
        for(int i=0;i<N;i++) {
            data[i]=Integer.parseInt(str.nextToken());
        }
        
        Arrays.sort(data);
        System.out.println(data[N/2]);
    }
 
}
