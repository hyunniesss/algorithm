package level1.내적;

/**
 * @author hyunhee
 * a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1]
 *
 */

public class Solution {
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4};
		int[] b = {-3,-1,0,2};
		System.out.println(solution(a,b));
		a = new int[] {-1,0,1};
		b = new int[] {1,0,-1};
		System.out.println(solution(a,b));
	}
	
	public static int solution(int[] a, int[] b) {
        int answer = 0;
        for(int idx=0;idx<a.length;idx++) {
        	answer += a[idx]*b[idx];
        }
        return answer;
    }

}
