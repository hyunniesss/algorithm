package level1.다트게임;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hyunhee
 * 다트를 세 차례 던져 그 점수의 합계로 실력을 겨루는 게임
 * 0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성
 * 
 */

public class Solution {
	
	public static void main(String[] args) {
		System.out.println(solution("1S2D*3T"));
		System.out.println(solution("1D2S#10S"));
		System.out.println(solution("1D2S0T"));
		System.out.println(solution("1S*2T*3S"));
		System.out.println(solution("1D#2S*3S"));
		System.out.println(solution("1T2D3D#"));
		System.out.println(solution("1D2S3T*"));
	}
	
	public static int solution(String dartResult) {
        int answer = 0;
        char[] dart = dartResult.toCharArray();
        List<Integer> result = new ArrayList<>();
        String number = "0123456789";
        for(int i=0;i<dart.length;i++) {
        	if(number.contains(dart[i]+"")) {
        		if(number.contains(dart[i+1]+"")) {	// 이건 두자리 수
        			result.add(Integer.parseInt(dartResult.substring(i,i+2)));
        			i++;
        		} else {
        			result.add(dart[i]-'0');
        		}
        	} else {
        		switch(dart[i]) {
        		case 'S':
        			break;
        		case 'D':
        			int temp = result.remove(result.size()-1);
        			result.add(temp*temp);
        			break;
        		case 'T':
        			temp = result.remove(result.size()-1);
        			result.add(temp*temp*temp);
        			break;
        		case '*':
        			if(result.size()==1) {
        				temp = result.remove(result.size()-1);
        				result.add(temp*2);
        			} else {
        				temp = result.remove(result.size()-2);
        				result.add(temp*2);
        				temp = result.remove(result.size()-2);
        				result.add(temp*2);
        			}
        			break;
        		case '#':
        			temp = result.remove(result.size()-1);
        			result.add(-temp);
        		}
        	}
        }
        for(int i=0;i<result.size();i++) {
        	answer += result.get(i);
        }
        return answer;
    }

}
