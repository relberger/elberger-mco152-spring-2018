package elberger.physics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class ProjectionActionListener implements ActionListener
{

	private JTextField xCoordinate;
	private JTextField yCoordinate;

	ProjectionActionListener(JTextField xCoordinate)
	{
		this.xCoordinate = xCoordinate;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
//		xCoordinate.setText(getX(time));
	}
	
	
}
