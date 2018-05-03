package elberger.wordcounter;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.FileNotFoundException;

import javax.swing.*;

public class WordCounterGUI extends JFrame
{
	private static final long serialVersionUID = 1L;

	private JTextField word = new JTextField();
	private JButton searchAll = new JButton("Search All Novels");
	private JButton searchEmma = new JButton("Search 'Emma'");
	private JButton searchLadySusan = new JButton("Search 'Lady Susan'");
	private JButton searchMansfieldPark = new JButton("Search 'Mansfield Park'");
	private JButton searchNorthangerAbbey = new JButton("Search 'Northanger Abbey'");
	private JButton searchPersuasion = new JButton("Search All 'Persuasion'");
	private JButton searchPrideAndPrejudice = new JButton("Search 'Pride and Prejusice'");
	private JButton searchSenseAndSensibility = new JButton("Search 'Sense and Sensibility'");
	private JTextField emma = new JTextField();
	private JTextField ladySusan = new JTextField();
	private JTextField mansfieldPark = new JTextField();
	private JTextField northangerAbbey = new JTextField();
	private JTextField persuasion = new JTextField();
	private JTextField prideAndPrejudice = new JTextField();
	private JTextField senseAndSensibility = new JTextField();

	public WordCounterGUI()
	{
		JLabel labelEmma = new JLabel("Number of times word appears in 'Emma':");
		JLabel labelLadySusan = new JLabel("Number of times word appears in 'Lady Susan':");
		JLabel labelMansfieldPark = new JLabel("Number of times word appears in 'Mansfield Park':");
		JLabel labelNorthangerAbbey = new JLabel("Number of times word appears in 'Northanger Abbey':");
		JLabel labelPersuasion = new JLabel("Number of times word appears in 'Persuasion':");
		JLabel labelPrideAndPrejudice = new JLabel("Number of times word appears in 'Pride and Prejudice':");
		JLabel labelSenseAndSensibility = new JLabel("Number of times word appears in 'Sense and Sensibility':");

		setTitle("Jane Austen Word Counter");
		setSize(850, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		JPanel northPanel = new JPanel();
		northPanel.setLayout(new BorderLayout());

		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.X_AXIS));
		JLabel instructions = new JLabel(
				"Enter a word to count how many times it appears in Jane Austen's novels:    ");
		searchPanel.add(instructions);
		searchPanel.add(word);
		northPanel.add(searchPanel, BorderLayout.NORTH);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2, 4));
		buttonPanel.add(searchAll);
		buttonPanel.add(searchEmma);
		buttonPanel.add(searchLadySusan);
		buttonPanel.add(searchMansfieldPark);
		buttonPanel.add(searchNorthangerAbbey);
		buttonPanel.add(searchPersuasion);
		buttonPanel.add(searchPrideAndPrejudice);
		buttonPanel.add(searchSenseAndSensibility);
		northPanel.add(buttonPanel, BoxLayout.Y_AXIS);

		panel.add(northPanel, BorderLayout.NORTH);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(8, 2));

		centerPanel.add(labelEmma);
		centerPanel.add(emma);
		centerPanel.add(labelLadySusan);
		centerPanel.add(ladySusan);
		centerPanel.add(labelMansfieldPark);
		centerPanel.add(mansfieldPark);
		centerPanel.add(labelNorthangerAbbey);
		centerPanel.add(northangerAbbey);
		centerPanel.add(labelPersuasion);
		centerPanel.add(persuasion);
		centerPanel.add(labelPrideAndPrejudice);
		centerPanel.add(prideAndPrejudice);
		centerPanel.add(labelSenseAndSensibility);
		centerPanel.add(senseAndSensibility);
		panel.add(centerPanel, BorderLayout.CENTER);

		emma.setEditable(false);
		ladySusan.setEditable(false);
		mansfieldPark.setEditable(false);
		northangerAbbey.setEditable(false);
		persuasion.setEditable(false);
		prideAndPrejudice.setEditable(false);
		senseAndSensibility.setEditable(false);

		searchAll.addActionListener(e ->
		{
			try
			{
				changeTextAll();
			} catch (FileNotFoundException e1)
			{
				e1.printStackTrace();
			}
		});

		searchEmma.addActionListener(e ->
		{
			try
			{
				clearAll();
				changeTextEmma();
			} catch (FileNotFoundException e1)
			{
				e1.printStackTrace();
			}
		});

		searchLadySusan.addActionListener(e ->
		{
			try
			{
				clearAll();
				changeTextLadySusan();
			} catch (FileNotFoundException e1)
			{
				e1.printStackTrace();
			}
		});

		searchMansfieldPark.addActionListener(e ->
		{
			try
			{
				clearAll();
				changeTextMansfieldPark();
			} catch (FileNotFoundException e1)
			{
				e1.printStackTrace();
			}
		});

		searchNorthangerAbbey.addActionListener(e ->
		{
			try
			{
				clearAll();
				changeTextNorthangerAbbey();
			} catch (FileNotFoundException e1)
			{
				e1.printStackTrace();
			}
		});

		searchPersuasion.addActionListener(e ->
		{
			try
			{
				clearAll();
				changeTextPersuasion();
			} catch (FileNotFoundException e1)
			{
				e1.printStackTrace();
			}
		});

		searchPrideAndPrejudice.addActionListener(e ->
		{
			try
			{
				clearAll();
				changeTextPrideAndPrejudice();

			} catch (FileNotFoundException e1)
			{
				e1.printStackTrace();
			}
		});

		searchSenseAndSensibility.addActionListener(e ->
		{
			try
			{
				clearAll();
				changeTextSenseAndSensibility();
			} catch (FileNotFoundException e1)
			{
				e1.printStackTrace();
			}
		});

		add(panel);
	}

	public int countOccurrences(String fileName, String wordInput) throws FileNotFoundException
	{
		WordCounter counter = new WordCounter(fileName);
		wordInput = word.getText().toLowerCase();
		int num = counter.count(wordInput);
		return num;
	}

	public void changeTextEmma() throws FileNotFoundException
	{
		String numEmma = String.valueOf(countOccurrences("src/elberger/wordcounter/Emma.txt", word.getText()));
		emma.setText(numEmma);
	}

	public void changeTextLadySusan() throws FileNotFoundException
	{
		String numLadySusan = String
				.valueOf(countOccurrences("src/elberger/wordcounter/LadySusan.txt", word.getText()));
		ladySusan.setText(numLadySusan);
	}

	public void changeTextMansfieldPark() throws FileNotFoundException
	{
		String numMansfieldPark = String
				.valueOf(countOccurrences("src/elberger/wordcounter/MansfieldPark.txt", word.getText()));
		mansfieldPark.setText(numMansfieldPark);
	}

	public void changeTextNorthangerAbbey() throws FileNotFoundException
	{
		String numNorthangerAbbey = String
				.valueOf(countOccurrences("src/elberger/wordcounter/NorthangerAbbey.txt", word.getText()));
		northangerAbbey.setText(numNorthangerAbbey);
	}

	public void changeTextPersuasion() throws FileNotFoundException
	{
		String numPersuasion = String
				.valueOf(countOccurrences("src/elberger/wordcounter/Persuasion.txt", word.getText()));
		persuasion.setText(numPersuasion);
	}

	public void changeTextPrideAndPrejudice() throws FileNotFoundException
	{
		String numPrideAndPrejudice = String
				.valueOf(countOccurrences("src/elberger/wordcounter/PrideAndPrejudice.txt", word.getText()));
		prideAndPrejudice.setText(numPrideAndPrejudice);
	}

	public void changeTextSenseAndSensibility() throws FileNotFoundException
	{
		String numSenseAndSensibility = String
				.valueOf(countOccurrences("src/elberger/wordcounter/SenseAndSensibility.txt", word.getText()));
		senseAndSensibility.setText(numSenseAndSensibility);
	}

	public void changeTextAll() throws FileNotFoundException
	{
		changeTextEmma();
		changeTextLadySusan();
		changeTextMansfieldPark();
		changeTextNorthangerAbbey();
		changeTextPersuasion();
		changeTextPrideAndPrejudice();
		changeTextSenseAndSensibility();
	}

	public void clearAll()
	{
		emma.setText("");
		ladySusan.setText("");
		mansfieldPark.setText("");
		northangerAbbey.setText("");
		persuasion.setText("");
		prideAndPrejudice.setText("");
		senseAndSensibility.setText("");
	}

	public static void main(String args[])
	{
		new WordCounterGUI().setVisible(true);
	}
}
