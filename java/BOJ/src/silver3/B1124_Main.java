package silver3;

import java.util.Scanner;

public class B1124_Main {

    static int A, B;
    static boolean[] isPrime;

    public static void main(String[] args){

        // 1. 입력 ( A B )
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        sc.close();

        int answer = 0;

        isPrime = new boolean[B+1];

        // 2-1. 소수인지 판별
        makePrime();

        // 2. 소수 개수 찾기
        for(int i=A;i<=B;i++){

            int num = i, j= 2;
            int cnt = 0;
            while(num>1){
                if(!isPrime[j] && num%j==0){
                    cnt++;
                    num/=j;
                    j=2;
                    continue;
                }
                j++;
            }
            if(!isPrime[cnt]){
                answer++;
            }

        }
        System.out.println(answer);

    }

    private static void makePrime(){
        isPrime[0] = true;
        isPrime[1] = true;
        for(int i=2;i<=B/2;i++){
            if(!isPrime[i]){
                for(int j=i+i;j<B;j+=i){
                    isPrime[j] = true;
                }
            }
        }
    }


}
