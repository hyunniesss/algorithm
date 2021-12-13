package bronze5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3046_Main {
// S = (R1 + R2) / 2
// R2 = S*2 - R1

    static int R1, S;
    public static void main(String[] args) {
        // 입력
        initInput();
        // 로직
        System.out.println(S*2 - R1);
    }

    private static void initInput() {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer str = new StringTokenizer(br.readLine()," ");
            R1 = Integer.parseInt(str.nextToken());
            S = Integer.parseInt(str.nextToken());
        }catch(Exception e){}
    }

}