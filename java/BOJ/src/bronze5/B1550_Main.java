package bronze5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1550_Main {
    static final int HEXA = 16;
    public static void main(String[] args) throws Exception {
        
        int answer = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine()
            ,HEXA);
        System.out.println(answer);

    }

}