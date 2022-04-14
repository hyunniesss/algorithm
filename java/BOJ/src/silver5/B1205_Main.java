package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B1205_Main {

    static int N, jumsu, P;
    static Integer[] arr;

    public static void main(String[] args) {
        // 로직 1. 비오름차순인 N개의 수열을 내림차순으로 정렬
        // 로직 2. while(새로운점수<arr[n]) n++
        // 로직 3. n <= P 이면 출력 ㅇㅇ 아니면 -1

        // 입력 N, 새로운 점수, P
        initInput();

        // 로직
        Arrays.sort(arr, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o2, o1);	// 내림차순
			}
		});
        
        int n = 0;
        while(n<=N && arr[n]>= jumsu) {	// 내 새로운 점수보다 크거나 같을동안
        	n++;
        }
        n--;
        if(n+1<=P) {	// 랭킹 리스트 이내이면
        	while(n>=0 && arr[n]==jumsu) {	// 등수가 같은 경우 - 해준거거든
        		n--;
        	}
        	n++;
        	System.out.println(n+1);
        } else {
        	System.out.println(-1);
        }
        
        
    }

    private static void initInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = null;
        try{
            str = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(str.nextToken());
            arr = new Integer[N+1];
            jumsu = Integer.parseInt(str.nextToken());
            arr[0] = jumsu;
            P = Integer.parseInt(str.nextToken());
            if(N==0) {
            	return;
            }
            str = new StringTokenizer(br.readLine()," ");
            for(int i=1;i<=N;i++){
                arr[i] = Integer.parseInt(str.nextToken());
            }
        } catch(IOException | NumberFormatException e){}
    }

}