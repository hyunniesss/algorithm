package L1296;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Divide_Array_in_Sets_of_K_Consecutive_Numbers {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 3, 4, 4, 5, 6 };
//		int K = 4;
		System.out.println(new Solution().isPossibleDivide(nums, 4));

		nums = new int[] { 3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11 };
		System.out.println(new Solution().isPossibleDivide(nums, 3));

		nums = new int[] { 3, 3, 2, 2, 1, 1 };
		System.out.println(new Solution().isPossibleDivide(nums, 3));

		nums = new int[] { 1, 2, 3, 4 };
		System.out.println(new Solution().isPossibleDivide(nums, 3));

	}

	static class Solution {
		public boolean isPossibleDivide(int[] nums, int K) {
			if (nums.length % K != 0) {
				return false;
			}
			Arrays.sort(nums);
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				int count = map.getOrDefault(nums[i], 0);
				map.put(nums[i], count + 1);
			}
			for (int i = 0; i < nums.length; i++) {
				int min = map.get(nums[i]);	// 얘가 시작하는 숫자
				if (min > 0) {
					for (int k = 1; k < K; k++) {
						min = Math.min(map.getOrDefault(nums[i] + k, -1), min);
						if(min<=0) {
							return false;
						}
					}
					if (min > 0) {
						for (int k = 0; k < K; k++) {
							map.put(nums[i] + k, map.get(nums[i] + k) - min);
						}
					}
				}
			}
			for (int i = 0; i < nums.length; i++) {
				if (map.get(nums[i]) != 0) {
					return false;
				}
			}
			return true;
		}
	}

}
