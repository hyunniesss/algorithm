package bronze5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class B2338_Main {

    public static void main(String[] args) {
        // 입력 범위 > BigInteger
        // A+B, A-B, A*B
        BigInteger A, B;
        StringBuilder sb = new StringBuilder();
        try{
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           A = new BigInteger(br.readLine());
           B = new BigInteger(br.readLine());
           sb.append(A.add(B)).append("\n");
           sb.append(A.subtract(B)).append("\n");
           sb.append(A.multiply(B)); 
        } catch(Exception e){}
        System.out.println(sb.toString());
    }

}