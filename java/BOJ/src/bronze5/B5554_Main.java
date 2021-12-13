package bronze5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class B5554_Main {

    public static void main(String[] args) {
        // 입력
        int[] seconds = initInput();
        // 로직
        int[] answer = solve(seconds);
        // 출력
        print(answer);
    }

    private static void print(int[] arr){
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try{
            for(int i : arr){
                bw.write(i+"\n");
            }
            bw.flush();
        } catch(Exception e){}
    }

    private static int[] solve(int[] input){
        int[] arr = new int[2];
        for(int i=0;i<input.length;i++){
            arr[1] += input[i];
        }
        arr[0] = arr[1]/60;
        arr[1] %= 60;
        return arr;
    }

    private static int[] initInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] seconds = new int[4];
        try {
            for(int i=0;i<4;i++){
                seconds[i] = Integer.parseInt(br.readLine());
            }
        } catch(Exception e){}
        return seconds;
    }

}