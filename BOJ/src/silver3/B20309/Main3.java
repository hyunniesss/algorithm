package silver3.B20309;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine()," ");
        int temp;
        for(int n=1;n<=N;n++){
            temp = Integer.parseInt(str.nextToken());
            if(n%2==temp%2){
                continue;
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
