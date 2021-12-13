package bronze5;

import java.util.Scanner;

public class B11382_Main {
// 1 ≤ A, B, C ≤ 10^12 Long 범위
// 3 ≤ A + B + C ≤ 3 * 10^12
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            long A = sc.nextLong();
            long B = sc.nextLong();
            long C = sc.nextLong();
            System.out.println(A+B+C);
        }
    }
}