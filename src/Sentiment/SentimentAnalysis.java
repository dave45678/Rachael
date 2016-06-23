//based on this: https://gist.github.com/leomelzer/3075236

package Sentiment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class SentimentAnalysis {
	public static int getSentimentScore(String input) throws FileNotFoundException, IOException {
		// used to store positive and negative words for scoring
		List<String> posWords = new ArrayList<String>();
		List<String> negWords = new ArrayList<String>();
		
		// source: www.cs.uic.edu/~liub/FBS/sentiment-analysis.html
		BufferedReader negReader = new BufferedReader(new FileReader(new File(
				"./wordLists/negative-words.txt")));
		BufferedReader posReader = new BufferedReader(new FileReader(new File(
				"./wordLists/positive-words.txt")));

		// currently read word
		String word;

		// add words to comparison list
		while ((word = negReader.readLine()) != null) {
			negWords.add(word);
		}
		while ((word = posReader.readLine()) != null) {
			posWords.add(word);
		}

		// cleanup
		negReader.close();
		posReader.close();
		
		
		
		
		// normalize!
		input = input.toLowerCase();
		input = input.trim();
		// remove all non alpha-numeric non whitespace chars
		input = input.replaceAll("[^a-zA-Z0-9\\s]", "");

		int negCounter = 0;
		int posCounter = 0;

		// so what we got?
		String[] words = input.split(" ");

		// check if the current word appears in our reference lists...
		for (int i = 0; i < words.length; i++) {
			System.err.println(words[i]);
			if (posWords.contains(words[i])) {
				
				posCounter++;
			}
			if (negWords.contains(words[i])) {
				negCounter++;
			}
		}

		// positive matches MINUS negative matches
		int result = (posCounter - negCounter);

		// negative?
		if (result < 0) {
			return -1;
			// or positive?
		} else if (result > 0) {
			return 1;
		}

		// neutral to the rescue!
		return 0;
	}

}
