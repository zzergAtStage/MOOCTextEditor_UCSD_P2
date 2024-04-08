package textgen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * An implementation of the MTG interface that uses a list of lists.
 * @author UC San Diego Intermediate Programming MOOC team 
 */
public class MarkovTextGeneratorLoL implements MarkovTextGenerator  {

	public static final int FIRST_WORD = 0;
	// The list of words with their next words
	private List<ListNode> wordList; 
	
	// The starting "word"
	private String starter;
	
	// The random number generator
	private Random rnGenerator;

	// Already trained flag
	private boolean isTrained = false;
	
	public MarkovTextGeneratorLoL(Random generator)
	{
		wordList = new LinkedList<>();
		starter = "";
		rnGenerator = generator;
	}
	
	
	/** Train the generator by adding the sourceText */
	@Override
	public void train(String sourceText)
	{
		//if already trained - just return;
		if (isTrained) return;

		List<String> tokens = getTokens("[!?.]+|[a-zA-Z]+", sourceText);
		if (tokens.size() == 0) {
			this.starter = "";
			tokens.add("");
		} else {
			this.starter = tokens.get(FIRST_WORD);
		}
		String prevWord = this.starter;

		for (int i = 1; i < tokens.size(); i++) { //fow each "w"
			String word = tokens.get(i);

			// Check if prevWord is already a node in the list
			boolean found = false;
			for (ListNode node : wordList) {
				if (node.getWord().equals(prevWord)) {
					node.addNextWord(word);
					found = true;
					break;
				}
			}

			// If prevWord is not a node in the list, add it
			if (!found) {
				ListNode newNode = new ListNode(prevWord);
				newNode.addNextWord(word);
				wordList.add(newNode);
			}

			prevWord = word;
		}
		//as i see - the last word doesn't added to the List as Node word.
		boolean alreadyPresent = false;
		for (ListNode node: wordList) {
			if (node.getWord().equals(tokens.get(tokens.size() - 1))) alreadyPresent = true;
		}
		if (!alreadyPresent) wordList.add(new ListNode(tokens.get(tokens.size() - 1)));
		// Add starter to be a next word for the last word in the source text
		for (ListNode node : wordList) {
			if (node.getWord().equals(tokens.get(tokens.size() - 1))) {
				node.addNextWord(this.starter);
				break;
			}
		}
		isTrained = true;
		// TODO: Implement this method - it's already implemented?
	}
	
	/** 
	 * Generate the number of words requested.
	 */
	@Override
	public String generateText(int numWords) {
	    // TODO: Implement this method
		if (numWords == 0) return "";
		String currWord = this.starter;
		StringBuilder outputBuff = new StringBuilder();
		outputBuff.append(currWord).append(" ");
		int wordsAdded = 1; //as first word is already added
		int preventContLoop = 0;
		int maxIterations = 1000;
		while (wordsAdded < numWords) {
			for (ListNode node: wordList){
				if (node.getWord().equals(currWord)) {
					String randomWord = node.getRandomNextWord(rnGenerator);
					outputBuff.append(randomWord)
							.append(" ");
					currWord = randomWord;
					wordsAdded++;
				}
			}
			preventContLoop++;
			if (preventContLoop > maxIterations) break;
		}

		return outputBuff.toString();
	}
	
	
	// Can be helpful for debugging
	@Override
	public String toString()
	{
		StringBuilder toReturn = new StringBuilder();
		for (ListNode n : wordList)
		{
			toReturn.append(n.toString());
		}
		return toReturn.toString();
	}
	
	/** Retrain the generator from scratch on the source text */
	@Override
	public void retrain(String sourceText)
	{
		wordList = new ArrayList<>();
		starter = null;
		isTrained = false;
		train(sourceText);

	}
	
	// TODO: Add any private helper methods you need here.

	protected List<String> getTokens(String pattern, String text)
	{
		ArrayList<String> tokens = new ArrayList<String>();
		Pattern tokSplitter = Pattern.compile(pattern);
		Matcher m = tokSplitter.matcher(text);

		while (m.find()) {
			tokens.add(m.group());
		}

		return tokens;
	}
	/**
	 * This is a minimal set of tests.  Note that it can be difficult
	 * to test methods/classes with randomized behavior.   
	 * @param args
	 */
	public static void main(String[] args)
	{
		// feed the generator a fixed random value for repeatable behavior
		MarkovTextGeneratorLoL gen = new MarkovTextGeneratorLoL(new Random(42));
		String textString = "Hello.  Hello there.  This is a test.  Hello there.  Hello Bob.  Test again.";
		System.out.println(textString);
		gen.train(textString);
		System.out.println(gen);
		System.out.println(gen.generateText(20));
		String testString0_1 = "hi there hi Leo";
		System.out.println(testString0_1);
		gen.retrain(testString0_1);
		System.out.println(gen);
		System.out.println(gen.generateText(5));


		String textString2 = "You say yes, I say no, "+
				"You say stop, and I say go, go, go, "+
				"Oh no. You say goodbye and I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"I say high, you say low, "+
				"You say why, and I say I don't know. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"Why, why, why, why, why, why, "+
				"Do you say goodbye. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"You say yes, I say no, "+
				"You say stop and I say go, go, go. "+
				"Oh, oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello,";
		System.out.println(textString2);
		gen.retrain(textString2);
		System.out.println(gen);
		System.out.println(gen.generateText(20));
		MarkovTextGenerator emptyTester = new MarkovTextGeneratorLoL(new Random());
		String emptyString = "";
		emptyTester.train(emptyString);
	}

}

/** Links a word to the next words in the list 
 * You should use this class in your implementation. */
class ListNode
{
    // The word that is linking to the next words
	private String word;
	
	// The next words that could follow it
	private List<String> nextWords;
	
	ListNode(String word)
	{
		this.word = word;
		nextWords = new LinkedList<>();
	}
	
	public String getWord()
	{
		return word;
	}

	public void addNextWord(String nextWord)
	{
		nextWords.add(nextWord);
	}
	
	public String getRandomNextWord(Random generator)
	{
		int targetWord = generator.nextInt(nextWords.size());
		// TODO:done Implement this method
	    // The random number generator should be passed from 
	    // the MarkovTextGeneratorLoL class
	    return nextWords.get(targetWord);
	}

	public String toString()
	{
		StringBuilder toReturn = new StringBuilder(word + ": ");
		for (String s : nextWords) {
			toReturn.append(s).append(" -> ");
		}
		toReturn.append("\n");
		return toReturn.toString();
	}
	
}


