package bronze5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B2845_Main {

    static int[] arr;
    static int N;

    public static void main(String[] args) {
        // 입력
        initInput();
        // 로직
        solve();
    }

    private static void solve(){
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try{
            for(int i : arr){
                bw.write(i-N+" ");
            }
            bw.flush();
        } catch(Exception e){}

    }

    private static void initInput() {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = null;
        try {
            str = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(str.nextToken()) * Integer.parseInt(str.nextToken());
            str = new StringTokenizer(br.readLine()," ");
            arr = new int[str.countTokens()];
            for(int i=0;i<arr.length;i++){
                arr[i] = Integer.parseInt(str.nextToken());
            }
        } catch(Exception e){}
    }

}