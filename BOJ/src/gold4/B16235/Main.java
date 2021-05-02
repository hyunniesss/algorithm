package gold4.B16235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer>[][] alive;
	static ArrayList<Integer>[][] dead;
	static int N, M, K;
	static int[][] MAP;
	static int[][] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		K = Integer.parseInt(str.nextToken());

		MAP = new int[N][N];
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(str.nextToken());
				MAP[i][j] = 5;
			}
		}

		alive = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				alive[i][j] = new ArrayList<>();
			}
		}
		dead = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dead[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < M; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(str.nextToken()) - 1;
			int c = Integer.parseInt(str.nextToken()) - 1;
			alive[r][c].add(Integer.parseInt(str.nextToken()));
		}

		// 1. 봄에는 양분을 먹어야해
		for (int i = 0; i < K; i++) {

			one();
			two();
			three();
			four();

		}
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				answer += alive[i][j].size();
			}
		}

		System.out.println(answer);

	}

	private static void four() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				MAP[i][j] += arr[i][j];
			}
		}
	}

	static int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

	private static void three() { // 번식

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int size = alive[i][j].size();
				for (int k = 0; k < size; k++) {
					if (alive[i][j].get(k) % 5 == 0) {
						int ni, nj;
						for (int d = 0; d < dirs.length; d++) {
							ni = i + dirs[d][0];
							nj = j + dirs[d][1];
							if (ni < 0 || ni >= N || nj < 0 || nj >= N) {
								continue;
							}
							alive[ni][nj].add(1);
						}

					}
				}
			}
		}

	}

	private static void two() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int size = dead[i][j].size();
				for (int k = 0; k < size; k++) {
					MAP[i][j] += (dead[i][j].remove(0) / 2);
				}
			}
		}

	}

	private static void one() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Collections.sort(alive[i][j]);
				int size = alive[i][j].size();
				for (int k = 0; k < size; k++) {
					int temp = alive[i][j].remove(0);
					if (MAP[i][j] - temp >= 0) {
						MAP[i][j] -= temp;
						alive[i][j].add(temp + 1);
					} else {
						dead[i][j].add(temp);
					}
				}

			}
		}

	}

}
