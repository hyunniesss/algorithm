package bronze5;

import java.util.Scanner;

public class B8370_Main {
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            int n1, k1, n2, k2;
            // 입력
            n1 = sc.nextInt();
            k1 = sc.nextInt();
            n2 = sc.nextInt();
            k2 = sc.nextInt();
            // 출력
            System.out.println((n1 * k1) + (n2 * k2));
        }
    }
}