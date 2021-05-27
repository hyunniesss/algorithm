import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class floyd_warshall {
	
	static int[][] map;
	static int V;
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());	// 노드의 갯수
		int E = Integer.parseInt(br.readLine());	// 간선의 갯수
		
		map = new int[V][V];	// 그래프 선언
		for(int v=0;v<V;v++) { // 그래프 초기화
			Arrays.fill(map[v], INF);
			map[v][v] = 0;	// 자기자신으로 가는 거리는 0
		}
		
		for(int i=0;i<E;i++) {
			StringTokenizer str = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(str.nextToken());
			int end = Integer.parseInt(str.nextToken());
			int price = Integer.parseInt(str.nextToken());
			
			map[start][end] = price;
			
		}
		
		folydwarshall();
		
	}

	private static void folydwarshall() {
		
		for(int k=0;k<V;k++) {	// 중간정점
			for(int i=0;i<V;i++) { // 시작정점
				if(i==k) {
					continue;	// 시작정점과 중간정점이 같으면 의미 없으니 패스
				}
				for(int j=0;j<V;j++) {	// 도착정점
					if(i==j || j==k) {	// 도착정점이 시작정점이거나 중간정점이면 의미 없으니 패스
						continue;
					}
					if(map[i][k]==INF || map[k][j]==INF) {	// 시작 정점 -> 중간 정점, 중간 정점 -> 도착 정점 증 하나라도 연결되지 않았다면 갈 수 없으니 패스
						continue;
					}
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);	// 중간에 거쳐 가는 게 더 저렴하면 값 갱신
				}
			}
		}
		
	}

}
