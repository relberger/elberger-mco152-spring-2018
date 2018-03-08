package elberger.dictionary;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

import elberger.physics.ProjectileGui;

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
		
		search.addActionListener(this::changeTextArea);

	}
	
	
	public void changeTextArea(ActionEvent listener)
	{
		DictionaryGui dg = new DictionaryGui();
		Dictionary dd = new Dictionary();
		
		String wrd = dg.word.getText();
				
		dd.getDefinition(wrd);
	}
	
	public static void main(String[] args)
	{
		new DictionaryGui().setVisible(true);
	}
}
