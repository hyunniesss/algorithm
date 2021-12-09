package bronze5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B1271_Main {

    public static void main(String[] args) {
        // 입력 : 최백준 조교가 가진 돈 n과 돈을 받으러 온 생명체의 수 m
        // 1 ≤ m ≤ n ≤ 10^1000 => BigInteger
        BigInteger M, N;
        try{
            StringTokenizer str = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine()," ");
            N = new BigInteger(str.nextToken());
            M = new BigInteger(str.nextToken());

            System.out.println(N.divide(M));
            System.out.println(N.remainder(M));
        } catch(Exception e){}

    }

}