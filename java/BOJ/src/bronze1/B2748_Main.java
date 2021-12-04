package bronze1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2748_Main {

    static long[] arr = new long[3];

    public static void main(String[] args) {
        int N = -1;
        try{
            N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        } catch(Exception e){}

        arr[1] = 1; arr[2] = 1;
        if(N<2){
            System.out.println(N);
        } else {
            N-=2;
            while(N-- > 0){
                arr[0] = arr[1];
                arr[1] = arr[2];
                arr[2] = arr[0] + arr[1];
            }
            System.out.println(arr[2]);
        }
    }

}