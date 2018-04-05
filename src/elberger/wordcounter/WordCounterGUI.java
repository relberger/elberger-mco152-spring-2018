package elberger.wordcounter;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

import javax.swing.*;

public class WordCounterGUI extends JFrame
{
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
		JLabel instructions = new JLabel("Enter a word to count how many times it appears in Jane Austen's novels:    ");
		searchPanel.add(instructions);
		searchPanel.add(word);
		northPanel.add(searchPanel, BorderLayout.NORTH);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2,4));
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
		centerPanel.setLayout(new GridLayout(8,2));
		
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
				changeTextAll(e);
			} 
			catch (FileNotFoundException e1)
			{
				e1.printStackTrace();
			}
		});	
		
		searchEmma.addActionListener(e ->
		{
			try
			{
				changeTextEmma(e);
			} 
			catch (FileNotFoundException e1)
			{
				e1.printStackTrace();
			}
		});
		
		searchLadySusan.addActionListener(e ->
		{
			try
			{
				changeTextLadySusan(e);
			} 
			catch (FileNotFoundException e1)
			{
				e1.printStackTrace();
			}
		});
		
		searchMansfieldPark.addActionListener(e ->
		{
			try
			{
				changeTextMansfieldPark(e);
			} 
			catch (FileNotFoundException e1)
			{
				e1.printStackTrace();
			}
		});
		
		searchNorthangerAbbey.addActionListener(e ->
		{
			try
			{
				changeTextNorthangerAbbey(e);
			} 
			catch (FileNotFoundException e1)
			{
				e1.printStackTrace();
			}
		});

		searchPersuasion.addActionListener(e ->
		{
			try
			{
				changeTextPersuasion(e);
			} 
			catch (FileNotFoundException e1)
			{
				e1.printStackTrace();
			}
		});

		searchPrideAndPrejudice.addActionListener(e ->
		{
			try
			{
				changeTextPrideAndPrejudice(e);
			} 
			catch (FileNotFoundException e1)
			{
				e1.printStackTrace();
			}
		});

		searchSenseAndSensibility.addActionListener(e ->
		{
			try
			{
				changeTextSenseAndSensibility(e);
			} 
			catch (FileNotFoundException e1)
			{
				e1.printStackTrace();
			}
		});

		add(panel);
	}

	public void changeTextAll(ActionEvent e) throws FileNotFoundException
	{
		WordCounter countEmma = new WordCounter("src/elberger/wordcounter/Emma.txt");
		String searchingEmma = word.getText().toLowerCase();
		String numEmma = String.valueOf(countEmma.Count(searchingEmma));
		emma.setText(numEmma);
		
		WordCounter countLadySusan = new WordCounter("src/elberger/wordcounter/LadySusan.txt");
		String searching = word.getText().toLowerCase();
		String count = String.valueOf(countLadySusan.Count(searching));
		ladySusan.setText(count);
		
		WordCounter countMansfieldPark = new WordCounter("src/elberger/wordcounter/MansfieldPark.txt");
		String searchingMansfieldPark = word.getText().toLowerCase();
		String numMansfieldPark = String.valueOf(countMansfieldPark.Count(searchingMansfieldPark));
		mansfieldPark.setText(numMansfieldPark);
		
		WordCounter countNorthangerAbbey = new WordCounter("src/elberger/wordcounter/NorthangerAbbey.txt");
		String searchingNorthangerAbbey = word.getText().toLowerCase();
		String numNorthangerAbbey = String.valueOf(countNorthangerAbbey.Count(searchingNorthangerAbbey));
		northangerAbbey.setText(numNorthangerAbbey);
		
		WordCounter countPersuasion = new WordCounter("src/elberger/wordcounter/Persuasion.txt");
		String searchingPersuasion = word.getText().toLowerCase();
		String numPersuasion = String.valueOf(countPersuasion.Count(searchingPersuasion));
		persuasion.setText(numPersuasion);
		
		WordCounter countPrideAndPrejudice = new WordCounter("src/elberger/wordcounter/PrideAndPrejudice.txt");
		String searchingPrideAndPrejudice = word.getText().toLowerCase();
		String numPrideAndPrejudice = String.valueOf(countPrideAndPrejudice.Count(searchingPrideAndPrejudice));
		prideAndPrejudice.setText(numPrideAndPrejudice);
		
		WordCounter countSenseAndSensibility = new WordCounter("src/elberger/wordcounter/SenseAndSensibility.txt");
		String searchingSenseAndSensibility = word.getText().toLowerCase();
		String numSenseAndSensibility = String.valueOf(countSenseAndSensibility.Count(searchingSenseAndSensibility));
		senseAndSensibility.setText(numSenseAndSensibility);
	}
	
	public void changeTextEmma(ActionEvent e) throws FileNotFoundException
	{
		WordCounter countEmma = new WordCounter("src/elberger/wordcounter/Emma.txt");
		String searchingEmma = word.getText().toLowerCase();
		String numEmma = String.valueOf(countEmma.Count(searchingEmma));
		emma.setText(numEmma);
	}

	public void changeTextLadySusan(ActionEvent e) throws FileNotFoundException
	{
		WordCounter countLadySusan = new WordCounter("src/elberger/wordcounter/LadySusan.txt");
		String searchingLadySusan = word.getText().toLowerCase();
		String numLadySusan = String.valueOf(countLadySusan.Count(searchingLadySusan));
		ladySusan.setText(numLadySusan);
	}

	public void changeTextMansfieldPark(ActionEvent e) throws FileNotFoundException
	{
		WordCounter countMansfieldPark = new WordCounter("src/elberger/wordcounter/MansfieldPark.txt");
		String searchingMansfieldPark = word.getText().toLowerCase();
		String numMansfieldPark = String.valueOf(countMansfieldPark.Count(searchingMansfieldPark));
		mansfieldPark.setText(numMansfieldPark);
	}

	public void changeTextNorthangerAbbey(ActionEvent e) throws FileNotFoundException
	{
		WordCounter countNorthangerAbbey = new WordCounter("src/elberger/wordcounter/NorthangerAbbey.txt");
		String searchingNorthangerAbbey = word.getText().toLowerCase();
		String numNorthangerAbbey = String.valueOf(countNorthangerAbbey.Count(searchingNorthangerAbbey));
		northangerAbbey.setText(numNorthangerAbbey);
	}

	public void changeTextPersuasion(ActionEvent e) throws FileNotFoundException
	{
		WordCounter countPersuasion = new WordCounter("src/elberger/wordcounter/Persuasion.txt");
		String searchingPersuasion = word.getText().toLowerCase();
		String numPersuasion = String.valueOf(countPersuasion.Count(searchingPersuasion));
		persuasion.setText(numPersuasion);
	}

	public void changeTextPrideAndPrejudice(ActionEvent e) throws FileNotFoundException
	{
		WordCounter countPrideAndPrejudice = new WordCounter("src/elberger/wordcounter/PrideAndPrejudice.txt");
		String searchingPrideAndPrejudice = word.getText().toLowerCase();
		String numPrideAndPrejudice = String.valueOf(countPrideAndPrejudice.Count(searchingPrideAndPrejudice));
		prideAndPrejudice.setText(numPrideAndPrejudice);
	}

	public void changeTextSenseAndSensibility(ActionEvent e) throws FileNotFoundException
	{
		WordCounter countSenseAndSensibility = new WordCounter("src/elberger/wordcounter/SenseAndSensibility.txt");
		String searchingSenseAndSensibility = word.getText().toLowerCase();
		String numSenseAndSensibility = String.valueOf(countSenseAndSensibility.Count(searchingSenseAndSensibility));
		senseAndSensibility.setText(numSenseAndSensibility);
	}

	public static void main(String args[])
	{
		new WordCounterGUI().setVisible(true);
	}
}
