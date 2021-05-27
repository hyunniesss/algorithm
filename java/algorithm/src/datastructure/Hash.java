package datastructure;

import java.util.HashMap;
import java.util.Hashtable;

public class Hash {

	public static void main(String[] args) {

		Hashtable<String, String> h = new Hashtable<>();
		String input = "길동";
		h.put("name", input);
		String s = h.get("name");
		System.out.println(s + " " + h.get("name"));

//		HashMap<String, String> hm = new HashMap<>();
//		hm.put(null, null);

//		System.out.println(hm.get(null));

	}

}
