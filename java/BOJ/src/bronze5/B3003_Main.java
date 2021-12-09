package bronze5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B3003_Main {

    // 총 16개=킹 1개, 퀸 1개, 룩 2개, 비숍 2개, 나이트 2개, 폰 8개, 
    // 각 말들의 수가 주어질 때 올바른 개수가 되기 위해 추가빼는 각각의 개수
    public static void main(String[] args){
        
        int[] arr1 = {1, 1, 2, 2, 2, 8};
        int[] answer = new int[6];
        try{
            // 입력
            StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine()," ");
            // 로직
            for(int i=0;i<6;i++){
                answer[i] = arr1[i] - Integer.parseInt(st.nextToken());
            }
            // 출력
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for(int i : answer){
                bw.write(i+" ");
            }
            bw.flush();
        } catch(Exception e){}
    }

}