package GoodBye2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class refactorTest {

	public static void main(String[] args) {
		List<String> workspaceMemberAll = new ArrayList<>();
		workspaceMemberAll.add("a");
		workspaceMemberAll.add("a");
		workspaceMemberAll.add("a");
		workspaceMemberAll.add("a");
		String[] userIds = new String[] { "a" };
		// 1. workspaceMemberAll == userIds 면 true
		// 중복아이디에 대한 조건은 없는 듯

		workspaceMemberAll.removeAll(Arrays.asList(userIds));
		
		for (String userId : userIds) {
			while (workspaceMemberAll.contains(userId)) {
				workspaceMemberAll.remove(userId);
			}
		}
		boolean flag = workspaceMemberAll.isEmpty();

	}

}
