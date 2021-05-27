package level2.순위검색;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) {

		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };

		System.out.println(Arrays.toString(new Solution().solution(info, query)));

		ArrayList<Integer> al = new ArrayList<>();
//		for (int i = 1; i <= 10; i++) {
//			al.add(i * 2);
//		}
//		new Solution().upperBound(al, 22, 0, al.size() - 1);

	}

}
