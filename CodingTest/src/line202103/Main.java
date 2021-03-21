package line202103;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Q13 solution = new Q13();
		String program = "line";
		String[] flag_rules = { "-s STRING", "-num NUMBER", "-e NULL", "-n ALIAS -num" };
		String[] commands = { "line -n 100 -e -num 150" };
		System.out.println(Arrays.toString(solution.solution(program, flag_rules, commands)));
	}

}
