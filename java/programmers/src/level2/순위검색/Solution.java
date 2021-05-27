package level2.순위검색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {
	public int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];

		ArrayList<Integer>[][][][] infoList = new ArrayList[4][3][3][3];

		for (int i = 0; i < infoList.length; i++) {
			for (int j = 0; j < infoList[i].length; j++) {
				for (int k = 0; k < infoList[i][j].length; k++) {
					for (int l = 0; l < infoList[i][j][k].length; l++) {
						infoList[i][j][k][l] = new ArrayList<>();
					}
				}
			}
		}

		Map<String, Integer> map = new HashMap<>();
		map.put("cpp", 0);
		map.put("java", 1);
		map.put("python", 2);
		map.put("backend", 0);
		map.put("frontend", 1);
		map.put("junior", 0);
		map.put("senior", 1);
		map.put("chicken", 0);
		map.put("pizza", 1);

		int w, x, y, z, score;
		for (int i = 0; i < info.length; i++) {
			StringTokenizer str = new StringTokenizer(info[i], " ");
			w = map.get(str.nextToken());
			x = map.get(str.nextToken());
			y = map.get(str.nextToken());
			z = map.get(str.nextToken());
			score = Integer.parseInt(str.nextToken());
			infoList[w][x][y][z].add(score);
			infoList[3][x][y][z].add(score);
			infoList[3][x][2][z].add(score);
			infoList[3][x][y][2].add(score);
			infoList[3][2][y][z].add(score);
			infoList[3][x][2][2].add(score);
			infoList[3][2][y][2].add(score);
			infoList[3][2][2][z].add(score);
			infoList[3][2][2][2].add(score);
			infoList[w][2][y][z].add(score);
			infoList[w][2][2][z].add(score);
			infoList[w][2][y][2].add(score);
			infoList[w][2][2][2].add(score);
			infoList[w][x][2][z].add(score);
			infoList[w][x][2][2].add(score);
			infoList[w][x][y][2].add(score);
		}

		for (ArrayList[][][] alist : infoList) {
			for (ArrayList[][] alis : alist) {
				for (ArrayList[] ali : alis) {
					for (ArrayList<Integer> al : ali) {
						Collections.sort(al);
					}
				}
			}
		}

		for (int i = 0; i < query.length; i++) {
			StringTokenizer str = new StringTokenizer(query[i], " ");
			w = map.getOrDefault(str.nextToken(), 3);
			str.nextToken();
			x = map.getOrDefault(str.nextToken(), 2);
			str.nextToken();
			y = map.getOrDefault(str.nextToken(), 2);
			str.nextToken();
			z = map.getOrDefault(str.nextToken(), 2);
			score = Integer.parseInt(str.nextToken());
			int size = infoList[w][x][y][z].size();
			if (size==0 || infoList[w][x][y][z].get(size - 1) < score) {
				answer[i] = 0;
			} else if (infoList[w][x][y][z].get(0) >= score) {
				answer[i] = size;
			} else {
				int idx = upperBound(infoList[w][x][y][z], score, 0, size);
				answer[i] = size - idx;
			}
		}

		return answer;
	}

	public int upperBound(ArrayList<Integer> al, int score, int left, int right) {
		int mid;
		while (left < right) {
			mid = (left + right) / 2;
			if (al.get(mid) < score) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return right;
	}
}
