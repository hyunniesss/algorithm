package bronze2.B1100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] map = new char[8][8];
		int cnt = 0;
		for(int r=0;r<8;r++) {
			map[r] = br.readLine().toCharArray();
			if(r%2==0) {
				for(int c=0;c<8;c+=2) {
					if(map[r][c]=='F') {
						cnt++;
					}
				}
			} else {
				for(int c=1;c<8;c+=2) {
					if(map[r][c]=='F') {
						cnt++;
					}
				}
			}
		}
		
		System.out.println(cnt);
		
	}

}
