package line202103;

import java.util.HashSet;
import java.util.Set;

public class Q3 {

	public static void main(String[] args) {

	}

	public int[] solution(int[] enter, int[] leave) {

		Set<Integer> room = new HashSet<>();
		int[] answer = new int[enter.length];

		for (int i = 0, j = 0; i < enter.length; i++) {
			room.add(enter[i]);
			if (room.size() > 1) {
				for (int k = 0; k < i; k++) {
					if (room.contains(enter[k])) {
						answer[enter[k] - 1]++;
					}
				}
				answer[enter[i] - 1] += (room.size() - 1);
			}

			while (j < leave.length && room.contains(leave[j])) {
				room.remove(leave[j]);
				j++;
			}
		}

		return answer;

	}

}
