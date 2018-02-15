package elberger.dictionary;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class DictionaryTest
{

	@Test
	public void contains() throws FileNotFoundException
	{
		// given
		File read = new File("C:/Users/chokl/Downloads/dictionary.txt");
		FileReader fReader = new FileReader(read);
		Scanner inputFile = new Scanner(fReader);
		Dictionary dd = new Dictionary("ET");

		// when
		String word = dd.word;

		// then
		assertEquals(true, dd.contains("ET", inputFile));
		
		inputFile.close();
	}

}
