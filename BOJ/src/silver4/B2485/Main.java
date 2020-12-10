package silver4.B2485;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author hyunhee 가로수의 수 : N(3≤N≤100,000) N개의 줄 : 각 줄마다 심어져 있는 가로수의 위치 (
 *         100,000,000 이하 )
 * 
 */
public class Main {

	static List<Integer> trees = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			trees.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(trees);
		while (true) {
			int dif = trees.get(1) - trees.get(0);
			int temp = trees.get(0);
			int size = trees.size();
			for (int i = 1; i < trees.size(); i++) {
				int difference = trees.get(i) - temp;
				temp = trees.get(i);
				dif = dif < difference ? dif : difference;
			}
			for (int i = 0; i < trees.size() - 1; i++) {
				int plusTree = trees.get(i) + dif;
				if (trees.contains(plusTree)) {
					continue;
				}
				trees.add(i, plusTree);
				i--;
			}
			Collections.sort(trees);
			if (size == trees.size()) {
				break;
			}
		}

		System.out.println(trees.size() - N);
	}

}
