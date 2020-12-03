package silver4.B1026;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author hyunhee
 * S = A[0]*B[0] + ... + A[N-1]*B[N-1]
 * S의 값을 가장 작게 만들기 위해 A의 수를 재배열하자. 단, B에 있는 수는 재배열하면 안 된다 
 * 결과 : S의 최솟값
 * 
 * B에 있는 수를 재배열하지 말라는 게 함정.
 * 완탐으로 찾을 필요가 없는 문제.
 */

public class Main {
	
	static int N;
	static int[] A, B;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		B = new int[N];
		StringTokenizer a = new StringTokenizer(br.readLine()," ");
		StringTokenizer b = new StringTokenizer(br.readLine()," ");
		for(int n=0;n<N;n++) {
			A[n] = Integer.parseInt(a.nextToken());
			B[n] = Integer.parseInt(b.nextToken());
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		int sum = 0;
		for(int i=0;i<N;i++) {
			sum += A[i] * B[(N-1)-i];
		}
		System.out.println(sum);
	}

}
