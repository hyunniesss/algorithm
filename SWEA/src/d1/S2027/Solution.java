package d1.S2027;

public class Solution {
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				sb.append(i==j ? "#" : "+");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
