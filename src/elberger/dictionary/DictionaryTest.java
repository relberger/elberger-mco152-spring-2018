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
		Dictionary dd = new Dictionary("src/elberger/dictionary/dictionary.txt");

		// when
		String word = "et";

		// then
		assertTrue(dd.contains(word));
	}

	@Test
	public void getDefinition() throws FileNotFoundException
	{
		// given
		Dictionary dd = new Dictionary("src/elberger/dictionary/dictionary.txt");

		// when
		String word = "4";

		// then
		assertEquals(null,
				dd.getDefinition(word));
	}

}
