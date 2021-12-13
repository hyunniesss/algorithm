package bronze5;

import java.util.Scanner;
import java.math.BigInteger;

public class B8437_Main {
    // 1. 두 소녀가 가진 사과의 합
    // 2. 클라우디가 더 가지고 있는 사과 개수
    // 계산 = 클라우디 = 클라우디 + ((합-클라우디)/2), 나탈리 = (합-클라우디)/2
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            BigInteger sum = new BigInteger(sc.nextLine());   // 전체 사과 수
            BigInteger k = new BigInteger(sc.nextLine());   // 클라우디가 가진 사과 수
            BigInteger both = sum.subtract(k).divide(new BigInteger("2"));
            System.out.println(k.add(both));
            System.out.println(both);
        }
    }
}