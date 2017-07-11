package A5;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
	public static boolean wordBreak(String s, List<String> wordDict) {

		boolean[] t = new boolean[s.length() + 1];
		t[0] = true;
		// initial state

		for (int i = 0; i < s.length(); i++) {
			// should continue from match position
			if (!t[i])
				continue;

			for (String a : wordDict) {
				int len = a.length();
				int end = i + len;
				if (end > s.length())
					continue;

				if (t[end])
					continue;

				if (s.substring(i, end).equals(a)) {
					t[end] = true;
				}
			}
		}

		return t[s.length()];
	}
	
	
	public static void main(String[] args) {
		String s = "abcdeefg";
		List<String> dict = new ArrayList<String>();
		dict.add("ab");
		dict.add("cde");
		dict.add("efg");
		//dict.add("cd");
		//dict.add("fg");
		
		System.out.print(wordBreak(s, dict));
	}
}
