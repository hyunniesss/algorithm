package silver5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1380_Main {

    static ArrayList<ArrayList<Integer>> input = new ArrayList<>();
    static ArrayList<ArrayList<String>> name = new ArrayList<>();

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        // 입력
        initInput();
        // 로직
        for(int i=0;i<input.size();i++){
            sb.append((i+1)+" ");
            ArrayList<Integer> a = input.get(i);
            ArrayList<String> b = name.get(i);
            boolean[] check = new boolean[b.size()];
            for(int j=0;j<a.size();j++){
                int next = a.get(j)-1;
                check[next] = !check[next];
            }
            for(int j=0;j<check.length;j++){
                if(check[j]){
                    sb.append(b.get(j)+"\n");
                    break;
                }
            }
        }
        // 출력
        System.out.println(sb.toString());
    }

    private static void initInput(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            int N = Integer.parseInt(br.readLine());
            while(N != 0){
                ArrayList<String> al = new ArrayList<>();
                for(int i=0;i<N;i++){
                    al.add(br.readLine());
                }
                name.add(al);
                ArrayList<Integer> ll = new ArrayList<>();
                for(int i=0;i<2*N-1;i++){
                    ll.add(Integer.parseInt(new StringTokenizer(br.readLine()," ").nextToken()));
                }
                input.add(ll);
                N = Integer.parseInt(br.readLine());
            }
        } catch(Exception e){}
    }

}