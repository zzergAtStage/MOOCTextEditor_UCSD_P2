package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import document.BasicDocument;
import document.Document;

public class TestText {
	public static void main(String[] args) {
		String s = "happy";
		System.out.printf("Original: %s result: %s", s, replace(s, 'a','i'));
		String м = "2314511167";
		String[] nums = м.split("____________");
		
		System.out.println(Arrays.toString(nums));
		
		 //String doc = "Splitting a string, it's as easy as 1 2 33!  Right?";
		String doc = "this is a test.23,54,390."; 
		
		List<String> tokens = new ArrayList<>();
		 tokens = getTokens("[a-zA-Z0-9 ]+", doc);
		 
		System.out.println("res of regexp: " + tokens + " array lenght = " + tokens.size());
		
	}

	public static String replace(String word, char gone, char here) {
		char[] cArray = word.toCharArray();
		char[] cArrayMod = new char[cArray.length];
		int i = 0;
		for (char c : cArray) {
			if (c == gone)
				cArrayMod[i] = here;
			else
				cArrayMod[i] = c;
			i++;
		}
		return new String(cArrayMod);
	}
	
	protected static List<String> getTokens(String pattern, String doc)
	{
		ArrayList<String> tokens = new ArrayList<String>();
		Pattern tokSplitter = Pattern.compile(pattern);
		Matcher m = tokSplitter.matcher(doc);
		
		while (m.find()) {
			tokens.add(m.group());
		}
		
		return tokens;
	}
}
