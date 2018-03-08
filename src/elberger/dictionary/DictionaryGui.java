package elberger.dictionary;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

import javax.swing.*;

public class DictionaryGui extends JFrame
{
	private JTextArea definition = new JTextArea();
	private JTextField word = new JTextField();
	private JButton search = new JButton("Search");

	public DictionaryGui()
	{
		setTitle("Dictionary viewer");
		setSize(300, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		JPanel northPanel = new JPanel();
		northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.X_AXIS));
				
		northPanel.add(word);
		northPanel.add(search);
		
		panel.add(northPanel, BorderLayout.NORTH);
		panel.add(definition, BorderLayout.CENTER);
		
		add(panel);
		
		search.addActionListener(e ->
		{
			try
			{
				changeTextArea(e);
			} catch (FileNotFoundException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
	
	public void changeTextArea(ActionEvent event) throws FileNotFoundException
	{
		Dictionary dd = new Dictionary("src/elberger/dictionary/dictionary.txt");
		
		String wrd = word.getText();
				
		String def = dd.getDefinition(wrd);
		
		definition.setText(def);
	}
	
	public static void main(String[] args)
	{
		new DictionaryGui().setVisible(true);
	}
}
