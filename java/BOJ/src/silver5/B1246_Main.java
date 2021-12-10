package silver5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class B1246_Main {

    static int N, M;
    static int[] arr;   // Pi

    public static void main(String[] args) {
        
        // 입력
        initInput();

        Arrays.sort(arr);
        // 최대수익과 가격
        int price = -1, maxVal = -1;
        for(int i=0;i<M;i++){
            int temp = arr[i] * Math.min((M-i), N);
            if(maxVal < temp){
                price = arr[i];
                maxVal = temp;
            } 
        }
        System.out.println(price+" "+maxVal);
    }

    private static void initInput() {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = null;
        try{
            str = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(str.nextToken());
            M = Integer.parseInt(str.nextToken());
            arr = new int[M];
            for(int i=0;i<M;i++){
                arr[i] = Integer.parseInt(br.readLine());
            }
        } catch(Exception e){}

    }

}