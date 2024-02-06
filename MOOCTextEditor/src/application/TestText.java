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
		
		String test = "My ";
		String s1 = "text";
		test = test + s1;
		System.out.println(test);
		
		String text = "My ";
		text.concat("String");
		System.out.println(text);
		String[] res = "%one%%two%%%three%%%%".split("[a-z]+");
		System.out.println(Arrays.toString(res));
		System.out.println(getTokens("[^, ]+", "one (1), two (2), three (3)"));
		
//		StringBuilder qi = new StringBuilder();
//		qi.append("11231");
//		qi.delete(start, end)
		
		
		//sorting selection
		int[] arr = {79,23,43,56,2,2,76};
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length - 1; i++) {
			
			int minIdx = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[minIdx]) {
					//minIdx = j;
					swap(j,arr, i, j );
				}
			}
 
			
		
		}
		System.out.println(Arrays.toString(arr));
		//sorting bubble
		int[] arr2 = {79,23,43,56,2,3,76};
		int currPos; 
		for (int pos = 1; pos < arr2.length; pos++) {
			currPos = pos;
			while(currPos > 0 &&
					arr2[currPos] < arr2[currPos-1]) {
				swap(pos, arr2, currPos, currPos-1);
				currPos -= 1;
			}
				
		}
		System.out.println(Arrays.toString(arr2));
		
	}

	private static void swap(int j, int[] arr, int leftValueMin, int rightValueMin) {
		System.out.printf("%d-jj Swap: arr[%d]:%d and arr[%d]:%d\n",j,leftValueMin,arr[leftValueMin],rightValueMin,arr[rightValueMin]);
		int tmp = arr[rightValueMin];
		arr[rightValueMin] = arr[leftValueMin];
		arr[leftValueMin] = tmp;
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
