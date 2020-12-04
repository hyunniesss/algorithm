package silver5.B10867;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author hyunhee
 * 중복제거하고 오름차순 정렬 ( Arrays.sort )
 *
 */
public class Main_intArray {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		int[] temp = new int[cnt];
		StringTokenizer str = new StringTokenizer(br.readLine()," ");
		for(int n=0;n<N;n++) {
			int num = Integer.parseInt(str.nextToken());
			int idx = 0;
			while(idx < cnt) {
				if(temp[idx] == num ) {
					break;
				}
				idx++;
			}
			if(idx == cnt) {
				int[] cast = new int[++cnt];
				for(int i=0;i<cnt-1;i++) {
					cast[i] = temp[i];
				}
				cast[idx] = num;
				temp = cast;
			}
		}
		
		Arrays.sort(temp);
		for(int i=0;i<cnt;i++) {
			sb.append(temp[i]).append(" ");
		}
		System.out.println(sb);
	}

}
