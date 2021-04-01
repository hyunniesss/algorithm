package level2.메뉴리뉴얼;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {

		String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
		int[] course = { 2, 3, 4 };
		System.out.println(Arrays.toString(new Solution().solution(orders, course)));
		
		orders = new String[] {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		course = new int[] {2,3,5};
		System.out.println(Arrays.toString(new Solution().solution(orders, course)));

		orders = new String[] {"XYZ", "XWY", "WXA"};
		course = new int[] {2,3,4};
		System.out.println(Arrays.toString(new Solution().solution(orders, course)));
		

	}

}
