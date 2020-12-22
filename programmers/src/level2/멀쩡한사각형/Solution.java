package level2.멀쩡한사각형;

public class Solution {

	public static void main(String[] args) {
		System.out.println(solution(8,12));
	}

	public static long solution(int w, int h) {
		return (long)w*h-(w+h - gcd(w,h));
	}

	private static long gcd(int w, int h) {
		if (h == 0) {
			return w;
		}
		return gcd(h, w % h);
	}

}
