package elberger.dictionary;

import java.util.*;

public class Dictionary
{
	public Dictionary(String word)
	{
		this.word = word;
	}

	String word;
	String[] entries;

	//test if word exists in dictionary
	public boolean contains(String word, Scanner inputFile)
	{
		//read each dictionary entry into array
		while (inputFile.hasNext())
		{
			String entry;
			entry = inputFile.next();

			entries = entry.split("[\\r\\n]+");
		}
		

		//loop through arrays by first word
		boolean isTrue = true;
		for (int ii = 0; ii < entries.length; ii++)
		{
			if (entries[ii].split(" ", 2).equals(word))
			{
				isTrue = true;
			}
			else
			{
				isTrue = false;
			}
		}
		return isTrue;
	}

	//get definition as end of array
	public String getDefinition(String word)
	{
		if (contains(word, null) == true)
		{
			int location = word.indexOf(word);
			String definition;
			definition = entries[location + 1];
			return definition;
		} 
		else
		{
			return null;
		}
	}
}
