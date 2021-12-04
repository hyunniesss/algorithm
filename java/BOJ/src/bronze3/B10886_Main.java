package bronze3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B10886_Main {

public static void main(String[] args) {
    // 입력 - 한 사람의 수 N (1 ≤ N ≤ 101, N은 홀수)
    // 0 : Junhee is not cute!, 1 : Junhee is cute!

    solve();
}

private static void solve(){
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    try{
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[2];
        while(N-- >0){
            arr[Integer.parseInt(br.readLine())]++;
        }

        System.out.println(arr[0] > arr[1] ? "Junhee is not cute!" : "Junhee is cute!");
    } catch(Exception e){
        
    }
}

}