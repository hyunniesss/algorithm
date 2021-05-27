package bronze3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B10250_Main {

	static int H, W, N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			str = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(str.nextToken());
			W = Integer.parseInt(str.nextToken());
			N = Integer.parseInt(str.nextToken());

			for (int w = 1; w <= W; w++) {
				for (int h = 1; h <= H; h++) {
					N--;
					if (N == 0) {
						String door = w + "";
						String floor = h + "";
						if (door.length() < 2) {
							door = "0" + door;
						}
						bw.write(floor + door);
						bw.newLine();
						break;
					}
				}
			}

		}

		bw.flush();

	}

}
