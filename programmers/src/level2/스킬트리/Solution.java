package level2.스킬트리;

public class Solution {
	
	public static void main(String[] args) {
		
		String skill = "CBD";
		String[] skill_trees = {
				"BACDE", "CBADF", "AECB", "BDA"
		};
		System.out.println(solution(skill, skill_trees));
		
	}
	
	private static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String s : skill_trees) {
        	boolean[] check = new boolean[skill.length()];
        	boolean flag = true;
        	for(char c : s.toCharArray()) {
        		if(skill.contains(c+"")) {
        			int idx = skill.indexOf(c);
        			for(int i=0;i<idx;i++) {
        				if(!check[i]) {
        					flag = false;
        					break;
        				}
        			}
        			check[idx] = true;
        			if(!flag) {
        				break;
        			} 
        		}
        	}
        	answer = flag ? answer+1 : answer;
        }
        return answer;
    }

}
