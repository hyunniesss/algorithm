package level2.N개의최소공배수;

public class Solution_GCD {
	
	public int solution(int[] arr) {
        int lcm = arr[0];
        for(int i=1;i<arr.length;i++){
            lcm = (lcm * arr[i]) / gcd(lcm, arr[i]);
        }

		return lcm;
    }
    
    public int gcd(int a, int b){   // a와 b의 최대공약수(gcd)는?
        int result = 1;
        if(a==0){
            return b;
        }
        if(b==0){
            return a;
        }
        if(a > b){
            result *= gcd(b, a%b);
        } else {
            result *= gcd(a, b%a);
        }
        return result;
    }

}
