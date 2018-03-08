package elberger.dictionary;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JTextField;

public class DictionaryActionListener
{
	private JTextField def;
	private JButton bb;
	
	DictionaryActionListener(JButton bb)
	{
		this.bb = bb;
	}

	public void actionPerformed(ActionEvent e)
	{
//		def.setText(Dictionary.getDefinition(wrd));
	}
}
