package elberger.physics;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ProjectileGui extends JFrame implements PropertyChangeListener
{

	private JTextField angle;
	private JTextField velocity;
	private JTextField time;
	private JTextArea xCoordinate;
	private JTextArea yCoordinate;

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
		xCoordinate = new JTextArea("");
		yCoordinate = new JTextArea("");

		panel.add(new JLabel("Angle"));
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

		add(panel);

		xCoordinate.addPropertyChangeListener(this::propertyChange);
	}

	public void propertyChange(PropertyChangeEvent e) 
	{
		double ang = Double.parseDouble(angle.getText());
		double vel = Double.parseDouble(velocity.getText());
		double tim = Double.parseDouble(time.getText());
		
		Projectile pp = new Projectile(ang, vel);
		
		double xx = pp.getX(tim);
		String xVal = Double.toString(xx);	
		
		double yy = pp.getY(tim);
		String yVal = Double.toString(xx);
		
		String time = e.getPropertyName();
		if (!time.isEmpty()) 
		{
			xCoordinate.setText(xVal);
			yCoordinate.setText(yVal);			
		}
	}

	public static void main(String[] args)
	{
		new ProjectileGui().setVisible(true);
	}
}
