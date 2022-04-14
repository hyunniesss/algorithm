package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16198_Main {
	
	static int N;
	static int[] ball;
	static boolean[] checked;
	
	public static void main(String[] args) {
		initInput();
		int max = countEnergy(N-2, 0);
		System.out.println(max);
	}

	private static int countEnergy(int cnt, int energy) {
		if(cnt==0) {
			return energy;
		}
		int max = energy;
		for(int i=1;i<N-1;i++) {
			if(checked[i]) {
				continue;
			}
			checked[i] = true;
			int pref = i-1, ahead = i+1;
			while(checked[pref]) {
				pref--;
			}
			while(checked[ahead]) {
				ahead++;
			}
			max = Math.max(max, countEnergy(cnt-1, energy + (ball[pref] * ball[ahead])));
			checked[i] = false;
		}
		return max;
	}

	private static void initInput() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		try {
			N = Integer.parseInt(br.readLine());
			ball = new int[N];
			checked = new boolean[N];
			str = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++) {
				ball[i] = Integer.parseInt(str.nextToken());
			}
		} catch (NumberFormatException | IOException e) {
		}
		
	}

}
