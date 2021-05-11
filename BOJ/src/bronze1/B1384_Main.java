package bronze1;

/*
그룹 번호를 "Group 1"과 같이 출력함으로써 출력을 시작합니다. 
그 다음 줄부터 누가(A) 누구(B)에게 나쁜 말을 했는지 "A was nasty about B"로 한 줄씩 출력합니다. 
나쁜 말이 여러 개라면, 입력받은 순서대로─첫 번째 종이부터, 왼쪽에서 오른쪽으로─출력합니다. 
아무도 나쁜 말을 하지 않았다면 "Nobody was nasty"를 출력합니다.
입력 n명의 아이들, 마지막은 0
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1384_Main {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = null;
        int N;
        char[][] message;
        String[] names;
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        while((N=Integer.parseInt(br.readLine()))!=0){
            message = new char[N][N-1];
            names = new String[N];
            for(int i=0;i<N;i++){
                str = new StringTokenizer(br.readLine()," ");
                names[i] = str.nextToken();
                for(int j=0;j<N-1;j++){
                    message[i][j] = str.nextToken().charAt(0);
                }
            }
            boolean flag = false;
            sb.append("Group ").append(cnt).append("\n");
            for(int i=0;i<N;i++){
                for(int j=0;j<N-1;j++){
                    if(message[i][j]=='N'){
                        flag = true;
                        int idx = i;
                        for(int k=0;k<=j;k++){
                            idx = idx == 0 ? N-1 : idx-1;
                        }
                        sb.append(names[idx]).append(" was nasty about ").append(names[i]).append("\n");
                    }
                }
            }
            if(!flag){
                sb.append("Nobody was nasty\n");
            }
            sb.append("\n");
            cnt++;
        }
        
        System.out.println(sb.toString());
    }
}
