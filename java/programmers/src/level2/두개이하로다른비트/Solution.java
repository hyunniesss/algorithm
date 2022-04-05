package level2.두개이하로다른비트;

public class Solution {

	public static void main(String[] args) {

	}

	public long[] solution(long[] numbers) {
		long[] answer = new long[numbers.length];
		int idx = 0;
		for (long numb : numbers) {
			StringBuilder numStr = new StringBuilder(Long.toBinaryString(numb));

			int lastIdx = numStr.lastIndexOf("0");
			if (lastIdx < 0) {
				numStr.replace(0, 1, "0");
				numStr.insert(0, "1");
			} else {
				numStr.replace(lastIdx, lastIdx + 1, "1");
				if (lastIdx != numStr.length() - 1) {
					numStr.replace(lastIdx + 1, lastIdx + 2, "0");
				}
			}

			answer[idx++] = Long.parseLong(numStr.toString(), 2);
		}

		return answer;
	}

}
