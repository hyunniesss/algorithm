package bronze3;

import java.util.Scanner;

public class B2163_Main {

    public static void main(String[] args) {

        // 1*1 = 0
        // 2*1 = 1
        // 2*2 = 3
        // 3*1 = 2
        // 3*2 = 5
        // 3*3 = 8
        // 4*1 = 3
        // 4*2 = 7
        // 4*3 = 11
        // 4*4 = 15

        Scanner sc = new Scanner(System.in);
        System.out.println(sc.nextInt()*sc.nextInt() - 1);
        sc.close();

    }

}