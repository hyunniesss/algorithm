package silver5.B10158;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int dr = 1, dc = 1;
	static int R, C;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());

		str = new StringTokenizer(br.readLine(), " ");
		int sr = Integer.parseInt(str.nextToken());
		int sc = Integer.parseInt(str.nextToken());
		int r = sc, c= sc;
		int t = Integer.parseInt(br.readLine());
		int d = 0; // 우상, 좌상, 좌하, 우하

		while (t > 0) {
			if(sr==r && sc==c) {
				
			}
			int min = 0;
			switch (d) {
			case 0:
				min = Math.min(R - r, C - c); // 우상
				break;
			case 1:
				min = Math.min(r, C - c); // 좌상
				break;
			case 2:
				min = Math.min(r, c); // 좌하
				break;
			case 3:
				min = Math.min(R - r, c);
				break;
			}

			if (t <= min) {
				r += dr * t;
				c += dc * t;
				t = 0;
			} else {
				r += dr * min;
				c += dc * min;
				t -= min;
			}

			// 1. r== R
			if (r == R || r == 0) {
				dr = -dr;
			}
			if (c == C || c == 0) {
				dc = -dc;
			}
			// d를 처리해야해...
			d = dr > 0 && dc > 0 ? 0 : dr < 0 && dc > 0 ? 1 : dr < 0 && dc < 0 ? 2 : 3;
		}

		bw.write(r + " " + c);
		bw.flush();
	}

}
