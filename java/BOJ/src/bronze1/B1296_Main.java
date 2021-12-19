package bronze1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1296_Main {

    // ((L+O) × (L+V) × (L+E) × (O+V) × (O+E) × (V+E)) mod 100
    // 위 공식의 결과가 가장 큰 팀이 우승
    // 같은 값이 있으면 사전순 -> class 만들어서 compareTo 함수 오버라이드

    static class Team implements Comparable<Team> {
    	
        String name;
        int point;
        
        public Team(String name){
            this.name = name;
        }

        @Override
        public int compareTo(Team o){
            if(this.point != o.point){
                return Integer.compare(o.point,this.point); // 점수 내림차순
            }
            return this.name.compareTo(o.name);   // 이름 사전순
        }

		@Override
		public String toString() {
			return "Team [name=" + name + ", point=" + point + "]";
		}
        
    }

    static Team[] input;
    static int[] 연두 = new int[26];

    public static void main(String[] args) {

        initInput();
        for(Team a : input){
            // ((L+O) × (L+V) × (L+E) × (O+V) × (O+E) × (V+E)) mod 100
            int[] alpha = new int[26];
            for(char ch : a.name.toCharArray()){
                alpha[ch-'A']++;
            }

            int point = (alpha['L'-'A'] + 연두['L'-'A'] + alpha['O'-'A'] + 연두['O'-'A']) 
                * (alpha['L'-'A'] + 연두['L'-'A'] + alpha['V'-'A'] + 연두['V'-'A'])
                * (alpha['L'-'A'] + 연두['L'-'A'] + alpha['E'-'A'] + 연두['E'-'A'])
                * (alpha['O'-'A'] + 연두['O'-'A'] + alpha['V'-'A'] + 연두['V'-'A'])
                * (alpha['O'-'A'] + 연두['O'-'A'] + alpha['E'-'A'] + 연두['E'-'A'])
                * (alpha['V'-'A'] + 연두['V'-'A'] + alpha['E'-'A'] + 연두['E'-'A'])
                % 100;
            a.point = point;
        }
        Arrays.sort(input);
        
        System.out.println(input[0].name);

    }

    private static void initInput(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            for(char c : br.readLine().toCharArray()){
                연두[c-'A']++;
            }
            int N = Integer.parseInt(br.readLine());
            input = new Team[N];
            for(int i=0;i<N;i++){
                input[i] = new Team(br.readLine());
            }
        } catch(Exception e){}

    }

}