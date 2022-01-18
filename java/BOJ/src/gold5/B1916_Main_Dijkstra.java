package gold5;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1916_Main_Dijkstra {
    
    static int N, M, start, end;
    static ArrayList<ArrayList<Bus>> list;
    
    static class Bus implements Comparable<Bus> {
        int dest;
        int price;
        
        public Bus(int dest, int price){
            this.dest = dest;
            this.price = price;
        }

		@Override
		public int compareTo(Bus o) {
			return 0;
		}
    }
    
    public static void main(String[] args) {
        initInput();
        int answer = findRoute(start, end);
        System.out.println(answer);
    }
    
    private static int findRoute(int start, int end){
        int[] d = new int[N+1];
        Arrays.fill(d, Integer.MAX_VALUE);
        Queue<Bus> queue = new LinkedList<>();
        queue.offer(new Bus(start, 0));    // 시작점에서 비용 0원으로 출발
        while(!queue.isEmpty()){
            Bus cur = queue.poll();
            for(Bus next : list.get(cur.dest)){    // 현재 위치에서 갈 수 있는 도착지
                if(d[next.dest] > next.price + cur.price){
                    queue.offer(new Bus(next.dest, d[next.dest] = next.price + cur.price));
                }
            }
        }
        return d[end];
    }
    
    private static void initInput(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = null;
        try {
            str = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(str.nextToken());    // 도시 개수
            M = Integer.parseInt(str.nextToken());    // 버스 개수
            list = new ArrayList<>();    // 인접 리스트 초기화
            for(int i=0;i<=N;i++){
                list.add(new ArrayList<Bus>());
            }
            for(int i=0;i<M;i++){
                str = new StringTokenizer(br.readLine()," ");
                int s = Integer.parseInt(str.nextToken());
                int e = Integer.parseInt(str.nextToken());
                int price = Integer.parseInt(str.nextToken());
                list.get(s).add(new Bus(e, price));    // 버스 연결
            }
            str = new StringTokenizer(br.readLine()," ");
            start = Integer.parseInt(str.nextToken());
            end = Integer.parseInt(str.nextToken());
        } catch(Exception e){}
    }
}
