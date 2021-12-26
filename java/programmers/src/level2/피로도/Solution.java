package level2.피로도;

import java.util.Arrays;

class Solution {
    static int[] arr;
    
    public static void main(String[] args) {
		solution(80, new int[][] {{80,20},{50,40},{30,10},{20,10}});
	}
	
	public static int solution(int k, int[][] dungeons) {
        int answer = 0;
        int N = dungeons.length;
        arr = new int[N];
        for(int i=0;i<N;i++) {
        	arr[i] = i;
        }
        do {
        	// arr 순서대로 던전 탐색
        	int temp = k;
        	int i =0;
        	while(i<N && temp >= dungeons[arr[i]][0]) {
        		temp -= dungeons[arr[i]][1];
        		i++;
        	}
//        	System.out.println(Arrays.toString(arr));
        	answer = i > answer ? i : answer;
        } while(nextP(N));
        
        
        return answer;
    }
	
	private static boolean nextP(int N) {
		// 꼭짓점 찾기(i-1)
		int i = N-1;
		while(i>0 && arr[i-1] > arr[i]) {
			i--;
		}
		if(i==0) {
			return false;
		}
		// 뒤에서 교환할 j 찾기(j)
		int j = N-1;
		while(arr[j] < arr[i-1]) {
			j--;
		}
		
		int temp = arr[i-1];
		arr[i-1] = arr[j];
		arr[j] = temp;
		
		int k = N-1;
		while(k>i) {
			temp = arr[i];
			arr[i] = arr[k];
			arr[k] = temp;
			i++; k--;
		}
		return true;
	}
}