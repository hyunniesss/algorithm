package bronze4;

import java.util.Arrays;
import java.util.Scanner;

public class B2752_Main {

	static final int LEN = 3;
    public static void main(String[] args) {
        int[] arr = new int[LEN];
        try(Scanner sc = new Scanner(System.in)){
            for(int i=0;i<LEN;i++){
                arr[i] = sc.nextInt();
            }
        }
        Arrays.sort(arr);
        String answer = Arrays.toString(arr).replace("[","").replaceAll(",","").replace("]","");
        System.out.println(answer);
    }
}
