package bronze5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2914_Main {

    // (창영이 앨범에 수록된 곡에 포함되어 있는 저작권이 있는 멜로디의 개수) / (앨범에 수록된 곡의 개수)
    // 평균값은 항상 올림을 해서 정수
    // 앨범에 수록되어 있는 곡의 개수와 위에서 구한 평균값 이 주어질 때 저작권이 있는 멜로디의 최소 곡 수

    public static void main(String[] args) {

        try{
            StringTokenizer str = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
            // 앨범에 수록된 곡의 개수 * (평균값 - 1) + 1
            System.out.println(
                Integer.parseInt(str.nextToken()) * (Integer.parseInt(str.nextToken())-1) +1
            );
        } catch(Exception e){}

    }

}