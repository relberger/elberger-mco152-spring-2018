package elberger.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Dictionary
{
	HashMap<String, String> dictionary = new HashMap<String, String>();

	public Dictionary(String fName) throws FileNotFoundException
	{
		String fileName = fName;
		Scanner scanner = new Scanner(new FileReader(new File(fileName)));

		while (scanner.hasNext())
		{
			String word = scanner.next();
			String definition = scanner.nextLine();
			dictionary.put(word, definition);
		}

		scanner.close();
	}

	public boolean contains(String word)
	{
		if (dictionary.containsKey(word.toUpperCase()))
		{
			return true;
		}

		else
		{
			return false;
		}
	}

	public String getDefinition(String word)
	{
		if (contains(word) == true)
		{
			return dictionary.get(word.toUpperCase());
		} 
		else
		{
			return null;
		}
	}
}
