package elberger.physics;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class ProjectileGui extends JFrame implements DocumentListener
{

	private JTextField angle;
	private JTextField velocity;
	private JTextField time;
	private JTextField xCoordinate;
	private JTextField yCoordinate;

	public ProjectileGui()
	{
		setTitle("Projectile Viewer");
		setSize(100, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		angle = new JTextField("");
		velocity = new JTextField("");
		time = new JTextField("");
		xCoordinate = new JTextField("");
		yCoordinate = new JTextField("");
		

		panel.add(new JLabel("Angle:"));
		panel.add(angle);
		panel.add(new JLabel("Velocity:"));
		panel.add(velocity);
		panel.add(new JLabel("Time:"));
		panel.add(time);
		panel.add(new JLabel("Coordinates"));
		panel.add(new JLabel("X Coordinate:"));
		panel.add(xCoordinate);
		panel.add(new JLabel("Y Coordinate:"));
		panel.add(yCoordinate);

		xCoordinate.setEditable(false);
		yCoordinate.setEditable(false);

		angle.getDocument().addDocumentListener(this);
		angle.getDocument().putProperty("", "");
		velocity.getDocument().addDocumentListener(this);
		velocity.getDocument().putProperty("", "");
		time.getDocument().addDocumentListener(this);
		time.getDocument().putProperty("", "");

		add(panel);

	}

	@Override
	public void insertUpdate(DocumentEvent e)
	{
		Document angleDoc = (Document) e.getDocument();
		try
		{
			Double.parseDouble((angleDoc.getText(0, angleDoc.getLength())));
		} 
		catch (NumberFormatException | BadLocationException e1)
		{
			e1.printStackTrace();
		}
		Document velocityDoc = (Document) e.getDocument();
		try
		{
			Double.parseDouble((velocityDoc.getText(0, velocityDoc.getLength())));
		} 
		catch (NumberFormatException | BadLocationException e1)
		{
			e1.printStackTrace();
		}
		Document timeDoc = (Document) e.getDocument();
		try
		{
			Double.parseDouble((timeDoc.getText(0, timeDoc.getLength())));
		} 
		catch (NumberFormatException | BadLocationException e1)
		{
			e1.printStackTrace();
		}

		double angleDouble = Double.parseDouble(angle.getText());
		double velocityDouble = Double.parseDouble(velocity.getText());
		double timeDouble = Double.parseDouble(time.getText());

		Projectile pp = new Projectile(angleDouble, velocityDouble);

		String xCoo = String.valueOf(pp.getX(timeDouble));
		String yCoo = String.valueOf(pp.getY(timeDouble));

		xCoordinate.setText(xCoo);
		yCoordinate.setText(yCoo);

	}

	@Override
	public void changedUpdate(DocumentEvent e)
	{
		Document angleDoc = (Document) e.getDocument();
		try
		{
			Double.parseDouble((angleDoc.getText(0, angleDoc.getLength())));
		} 
		catch (NumberFormatException | BadLocationException e1)
		{
			e1.printStackTrace();
		}
		Document velocityDoc = (Document) e.getDocument();
		try
		{
			Double.parseDouble((velocityDoc.getText(0, velocityDoc.getLength())));
		} 
		catch (NumberFormatException | BadLocationException e1)
		{
			e1.printStackTrace();
		}
		Document timeDoc = (Document) e.getDocument();
		try
		{
			Double.parseDouble((timeDoc.getText(0, timeDoc.getLength())));
		} 
		catch (NumberFormatException | BadLocationException e1)
		{
			e1.printStackTrace();
		}

		double angleDouble = Double.parseDouble(angle.getText());
		double velocityDouble = Double.parseDouble(velocity.getText());
		double timeDouble = Double.parseDouble(time.getText());

		Projectile pp = new Projectile(angleDouble, velocityDouble);

		String xCoo = String.valueOf(pp.getX(timeDouble));
		String yCoo = String.valueOf(pp.getY(timeDouble));

		xCoordinate.setText(xCoo);
		yCoordinate.setText(yCoo);

	}

	@Override
	public void removeUpdate(DocumentEvent e)
	{
		Document angleDoc = (Document) e.getDocument();
		try
		{
			Double.parseDouble((angleDoc.getText(0, angleDoc.getLength())));
		} 
		catch (NumberFormatException | BadLocationException e1)
		{
			e1.printStackTrace();
		}
		Document velocityDoc = (Document) e.getDocument();
		try
		{
			Double.parseDouble((velocityDoc.getText(0, velocityDoc.getLength())));
		} 
		catch (NumberFormatException | BadLocationException e1)
		{
			e1.printStackTrace();
		}
		Document timeDoc = (Document) e.getDocument();
		try
		{
			Double.parseDouble((timeDoc.getText(0, timeDoc.getLength())));
		} 
		catch (NumberFormatException | BadLocationException e1)
		{
			e1.printStackTrace();
		}

		double angleDouble = Double.parseDouble(angle.getText());
		double velocityDouble = Double.parseDouble(velocity.getText());
		double timeDouble = Double.parseDouble(time.getText());

		Projectile pp = new Projectile(angleDouble, velocityDouble);

		String xCoo = String.valueOf(pp.getX(timeDouble));
		String yCoo = String.valueOf(pp.getY(timeDouble));

		xCoordinate.setText(xCoo);
		yCoordinate.setText(yCoo);
	}

	public static void main(String[] args)
	{
		new ProjectileGui().setVisible(true);
	}
}
