package gold4.B1300;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				list.add(i*j);
			}
		}
		Collections.sort(list);
		System.out.println(list.get(K));
		
	}

}
