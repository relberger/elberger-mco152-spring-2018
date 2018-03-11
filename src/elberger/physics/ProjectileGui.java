package elberger.physics;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

public class ProjectileGui extends JFrame implements PropertyChangeListener
{

	private JFormattedTextField angle;
	private JFormattedTextField velocity;
	private JFormattedTextField time;
	private JFormattedTextField xCoordinate;
	private JFormattedTextField yCoordinate;

	public ProjectileGui()
	{
		setTitle("Projectile Viewer");
		setSize(100, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		angle = new JFormattedTextField("");
		velocity = new JFormattedTextField("");
		time = new JFormattedTextField("");
		xCoordinate = new JFormattedTextField("");
		yCoordinate = new JFormattedTextField("");

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

		angle.addPropertyChangeListener("value", this::propertyChange);
		velocity.addPropertyChangeListener("value", this::propertyChange);
		time.addPropertyChangeListener("value", this::propertyChange);
		
		add(panel);

	}

	public void propertyChange(PropertyChangeEvent event)
	{
		double angleDouble = Double.parseDouble(angle.getText());
		double velocityDouble = Double.parseDouble(velocity.getText());
		double timeDouble = Double.parseDouble(time.getText());
		
		Projectile pp = new Projectile (angleDouble, velocityDouble);
				
		xCoordinate.setValue(pp.getX(timeDouble));
		yCoordinate.setValue(pp.getY(timeDouble));			
	}

	public static void main(String[] args)
	{
		new ProjectileGui().setVisible(true);
	}

}
