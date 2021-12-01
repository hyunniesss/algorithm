package silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1120_Main {
	
	static  char[] A, B;

    public static void main(String[] args) {

        // 1. 입력(A B)
        initInput();

        // 2. A의 시작위치 찾기(차이가 최소인 게 정답)
        int min = 50;
        for(int i=0;i<=B.length-A.length;i++){
            int count = 0;
            for(int j=0;j<A.length;j++){
                count = A[j]==B[i+j] ? count : count+1;
            }
            min = count < min ?  count : min;
        }

        // 3. 차이 출력
        System.out.println(min);
    }

    private static void initInput() {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            StringTokenizer str = new StringTokenizer(br.readLine()," ");
            A = str.nextToken().toCharArray();
            B = str.nextToken().toCharArray();
        } catch(Exception e){

        }
    }

}
