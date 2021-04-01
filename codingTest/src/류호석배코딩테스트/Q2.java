package 류호석배코딩테스트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author hyunhee
 * 
 *         입력
 * 
 *         7 daeil sangdo yuri hoseok minji doha haeun 7 hoseok sangdo yuri
 *         minji hoseok daeil daeil sangdo haeun doha doha minji haeun minji
 *
 *         출력 2 minji sangdo daeil 1 hoseok doha 1 haeun haeun 0 hoseok 0 minji
 *         2 doha yuri sangdo 1 daeil yuri 0
 * 
 */

public class Q2 {

	static Map<Integer, String> whatIsName = new HashMap<>();
	static Map<String, Integer> whoIsIt = new HashMap<>();
//	static List<String>[] jokbo;
	static List<String>[] leaf;
	static String[] names;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		names = new String[N];

		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			String name = str.nextToken();
			whatIsName.put(i, name);
			whoIsIt.put(name, i);
			names[i] = name;
		}

//		jokbo = new ArrayList[N];
//
//		for (int i = 0; i < N; i++) {
//			jokbo[i] = new ArrayList<>();
//		}
		leaf = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			leaf[i] = new ArrayList<>();
		}

		boolean[] check = new boolean[N];

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			String son = str.nextToken();
			String parent = str.nextToken();
//			jokbo[whoIsIt.get(son)].add(parent); // 부모 노드 저장
			leaf[whoIsIt.get(parent)].add(son); // 자식 노드 저장
			check[whoIsIt.get(son)] = true;
		}

		// 1. 루트 노드가 몇 개 인가
		int answer = 0;
		String rootParent = "";
//		for (int i = 0; i < N; i++) {
//			if (jokbo[i].size() == 0) { // 루트 노드
//				answer++;
//				rootParent += (whatIsName.get(i) + " ");
//			}
//		}
		for (int i = 0; i < N; i++) {
			if (!check[i]) { // 루트노드
				answer++;
				rootParent += (whatIsName.get(i) + " ");
			}
		}
		
		sb.append(answer + "\n");
		str = new StringTokenizer(rootParent, " ");
		String[] arrParent = new String[str.countTokens()];
		for (int i = 0; i < arrParent.length; i++) {
			arrParent[i] = str.nextToken();
		}
		Arrays.sort(arrParent);
		for (int i = 0; i < arrParent.length; i++) {
			sb.append(arrParent[i] + " ");
		}
		sb.append("\n");

		// 자식을 두 군데서 가지고 있으면 하나 빼야돼
		for (int i = 0; i < leaf.length; i++) {
			for (int j = 0; j < leaf[i].size(); j++) {
				String sonName = leaf[i].get(j);
				int sonIdx = whoIsIt.get(sonName);
				for (int k = i + 1; k < leaf.length; k++) {
					if (k == sonIdx) {
						continue;
					}

					if (leaf[k].contains(sonName)) {
						int sizeA = leaf[i].size();
						int sizeB = leaf[k].size();
						if (sizeA < sizeB) {
							leaf[k].remove(sonName);
						} else {
							leaf[i].remove(sonName);
						}
						j--;
						break;
					}
				}
			}
		}

		// 이름의 사전순 대로 사람의 이름과 자식의 수, 그리고 사전순으로 자식들의 이름
		Arrays.sort(names);
		for (int i = 0; i < names.length; i++) {
			int idx = whoIsIt.get(names[i]);
			sb.append(names[i] + " " + leaf[idx].size() + " ");
			String[] sons = new String[leaf[idx].size()];
			for (int j = 0; j < leaf[idx].size(); j++) {
				sons[j] = leaf[idx].get(j);
			}

			Arrays.sort(sons);
			for (int j = 0; j < sons.length; j++) {
				sb.append(sons[j] + " ");
			}

			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();

	}

}
