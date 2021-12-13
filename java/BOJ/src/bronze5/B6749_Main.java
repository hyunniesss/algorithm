package bronze5;

import java.util.Scanner;

public class B6749_Main {

    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            // 입력
            int youngest = sc.nextInt();
            int middle = sc.nextInt();
            // 출력
            System.out.println(middle + (middle - youngest));
        }
    }
}