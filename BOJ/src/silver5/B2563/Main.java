package silver5.B2563;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	
	// 색종이의 변 길이는 10
	// 제일 높은 위치랑 제일 낮은 위치 & 제일 왼쪽과 제일 오른쪽 -> 큰 직사각형
	// 비어있는 공간을 어떻게 찾지..?
	// 스택으로 해볼깤ㅋㅋㅋ
	
//	static TreeSet<int[]> ts = new TreeSet<>();
	static List<Integer>[] list = new ArrayList[101];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 색종이 수
		for(int i=0;i<list.length;i++) {
			list[i] = new ArrayList<>();
		}
		for(int n=0;n<N;n++) {
			StringTokenizer str = new StringTokenizer(br.readLine()," ");
			int R = Integer.parseInt(str.nextToken());
			int C = Integer.parseInt(str.nextToken());
			for(int r=R;r<R+10;r++) {
				for(int c=C;c<C+10;c++) {
					if(list[r].contains(c)) {
						continue;
					}
					list[r].add(c);
				}
			}
		}
		int sum = 0;
		for(int i=0;i<101;i++) {
			sum += list[i].size();
		}
		System.out.println(sum);
	}

}
