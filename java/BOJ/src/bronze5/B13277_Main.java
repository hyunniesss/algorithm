package bronze5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class B13277_Main {
    public static void main(String[] args){
        try{
            StringTokenizer str = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
            BigInteger answer = new BigInteger(str.nextToken()).multiply(new BigInteger(str.nextToken()));
            System.out.println(answer);
        } catch(Exception e){}
    }
}