package elberger.wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class WordCounter
{
	private Collection<String> words = new ArrayList<>();

	public WordCounter(String book) throws FileNotFoundException
	{
		String bookTitle = book;
		String word = null;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(new FileReader(new File(bookTitle)));
		scanner.useDelimiter("[^a-zA-Z'-]+");

		while (scanner.hasNext())
		{
			word = scanner.next();
			word = word.toLowerCase();
			words.add(word);
		}
	}

	public int count(String word)
	{
		int frequency = Collections.frequency(words, word);
		return frequency;
	}
}
