package bronze3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2953_Main {

    public static void main(String[] args) throws Exception {

        // 입력 : 다섯 개 줄에 각 참가자가 얻은 네 개의 평가 점수가 공백으로 구분되어 주어진다.
        // StringTokenizer로 구분
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = null;
        int maxIdx = -1, max = -1;
        for(int i=1;i<=5;i++){
            str = new StringTokenizer(br.readLine()," ");
            int sum = 0;
            // 각 참가자별 점수합을 구하고
            while(str.hasMoreTokens()){
                sum += Integer.parseInt(str.nextToken());
            }
            // 현재 최고점과 비교해서 큰 값으로 업데이트 및 참가자번호도 수정
            if(max < sum){
                maxIdx = i;
                max = sum;
            }
        }
        System.out.println(maxIdx + " " + max);

    }

}