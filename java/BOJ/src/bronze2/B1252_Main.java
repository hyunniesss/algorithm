package bronze2;

import java.io.*;
import java.util.*;

public class B1252_Main {
    static String[] input = new String[2];  // �엯�젰諛쏆쓣 硫붾え由�
    static int temp;
    public static void main(String[] args) {
        // 1. �엯�젰 諛쏄린
        initInput();
        int aLen = input[0].length();   //泥� 踰덉㎏ �엯�젰 湲몄씠
        int bLen = input[1].length();   //�몢 踰덉㎏ �엯�젰 湲몄씠
        int cLen = aLen < bLen ? aLen : bLen;
        StringBuilder answer = new StringBuilder();
        temp = 0;   // �삱由�
        for(int i=0;i<cLen;i++){
            int plus = plusOp(i);
            answer.append(plus%2+"");
        }
        for(int i=cLen;i<aLen;i++){ //bLen�씠 �뜑 吏㏃쓣 �븣
            int plus = plusOp(i, 0);
            answer.append(plus%2+"");
        }
        for(int i=cLen;i<bLen;i++){ // aLen�씠 �뜑 吏㏃쓣 �븣
            int plus = plusOp(i, 1);
            answer.append(plus%2+"");
        }
        if(temp==1){
            answer.append(temp+"");
        }

        System.out.println(answer.reverse());
    }

    private static int plusOp(int i, int j){
        int plus = (input[j].charAt(i)-'0')+temp;
        if(plus>=2){
            temp = 1;
        } else {
            temp = 0;
        }
        return plus;
    }

    private static int plusOp(int i){
        int plus = (input[0].charAt(i)-'0') + (input[1].charAt(i)-'0') + temp;
        if(plus>=2){
            temp = 1;
        } else {
            temp = 0;
        }
        return plus;
    }

    private static void initInput(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
        StringTokenizer str  = new StringTokenizer(br.readLine()," ");
        String temp = str.nextToken();
        int i=0;
        while(i<temp.length()-1 && temp.charAt(i)=='0'){
            i++;
        }
        input[0] = new StringBuilder(temp.substring(i)).reverse().toString();
        temp = str.nextToken();
        i=0;
        while(i<temp.length()-1 && temp.charAt(i)=='0'){
            i++;
        }
        input[1] = new StringBuilder(temp.substring(i)).reverse().toString();
    } catch(Exception e){
        }
    }

}