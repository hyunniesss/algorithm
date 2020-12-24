package silver1.B6581;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new StringReader(src));
		StringBuilder answer = new StringBuilder();
		String text = "";
//		String hr = "--------------------------------------------------------------------------------";
		boolean flag = true;
		while (flag) {
			try {
				StringTokenizer str = new StringTokenizer(br.readLine(), " ");
				while (str.countTokens() > 0) {
					String input = str.nextToken();
					if (input.contains("<")) { // br 또는 hr 태그 있음
						StringTokenizer st = new StringTokenizer(input, "<");
						while (st.countTokens() > 0) {
							String inp = st.nextToken();
							if (inp.contains("br>")) {
								answer.append(text).append("\n");

								if (inp.length() > 3) {
									text = new String(inp.substring(3) + " ");
								} else {
									text = new String("");
								}
							} else if (inp.contains("hr>")) {
								answer.append(text);
								if (answer.length() > 1 && !answer.substring(answer.length() - 1).equals("\n")) {
									answer.append("\n");
								}
//								answer.append(hr).append("\n");
								for (int i = 0; i < 80; i++) {
									answer.append("-");
								}
								answer.append("\n");
								if (inp.length() > 3) {
									text = new String(inp.substring(3) + " ");
								} else {
									text = new String("");
								}
							}
						}
					} else {
						text += input + " ";
						if (text.length() >= 80) {
							text = text.trim();
							int idx = text.lastIndexOf(" ");
							answer.append(text.substring(0, idx)).append("\n");
							text = new String(text.substring(idx + 1));
						}
					}
				}
			} catch (NullPointerException e) {
				flag = false;
				answer.append(text);
				break;
			}
		}

		System.out.println(answer);
	}

	static String src = "Hallo, dies ist eine \r\n" + "ziemlich lange Zeile, die in Html\r\n"
			+ "aber nicht umgebrochen wird.\r\n" + "<br>\r\n" + "Zwei <br> <br> produzieren zwei Newlines. \r\n"
			+ "Es gibt auch noch das tag <hr> was einen Trenner darstellt.\r\n"
			+ "Zwei <hr> <hr> produzieren zwei Horizontal Rulers.\r\n"
			+ "Achtung       mehrere Leerzeichen irritieren\r\n" + "\r\n" + "Html genauso wenig wie\r\n" + "\r\n"
			+ "\r\n" + "mehrere Leerzeilen.\r\n";

}
