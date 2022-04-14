package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2310_Main {

	static ArrayList<ArrayList<Integer>> connectedRoom; // 연결된 방을 저장해둘 자료구조
	static int[] map; // 통행료를 저장해둘 자료구조
	static int N = -1; // 미로 방의 개수
	static int[] isChecked; // 저장해둔 값보다 크게 들어오면 갈 수 있음
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		while (true) {
			if (!initInput()) {
				break;
			}

			goMiro(1, 0);
			sb.append(canGo ? "Yes" : "No").append("\n");
		}
		System.out.println(sb.toString());

	}

	static boolean canGo;

	private static void goMiro(int room, int price) {
		// 기저 1.
		if(canGo) {
			return;
		}
		// 기저 2.
		if(room == N && price >= 0) {
			canGo = true;
			return;
		}
		// 기저 3.
		if(isChecked[room] >= price) {
			return;
		}
		isChecked[room] = price;
		
		ArrayList<Integer> nextRoom = connectedRoom.get(room);
		for(int next : nextRoom) {
			if(map[next] == 0) {	// 빈 방
				if(isChecked[next] < price) {
					goMiro(next, price);
				}
			} else if(map[next] > 0) {	/// L일 때
				if(price <= map[next]) {
					goMiro(next, map[next]);
				} else if(price > map[next]) {
					goMiro(next, price);
				}
			} else {	// T일 때
				if(price + map[next] >= 0) {
					goMiro(next, price + map[next]);
				}
			}
			
		}
	}

	private static boolean initInput() {
		StringTokenizer str = null;
		try {
			N = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
		}
		canGo = false;
		if (N == 0) {
			return false;
		}
		connectedRoom = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			connectedRoom.add(new ArrayList<>());
		}
		isChecked = new int[N + 1];
		Arrays.fill(isChecked, -1);
		map = new int[N + 1];
		int room;
		for (int i = 1; i <= N; i++) { // N개의 방
			try {
				str = new StringTokenizer(br.readLine(), " ");
			} catch (IOException e) {
			}
			int isTroll = "T".equals(str.nextToken()) ? -1 : 1;
			map[i] = isTroll * (Integer.parseInt(str.nextToken()));
			while ((room = Integer.parseInt(str.nextToken())) != 0) {
				connectedRoom.get(i).add(room);
			}
		}
		return true;
	}

}
