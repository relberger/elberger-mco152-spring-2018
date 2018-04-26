package elberger.earthquake.net;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class EarthquakeGUI extends JFrame
{
	private JButton button = new JButton("Find largest earthquakes in past month, week, day, and hour");
	private JTextField monthMag = new JTextField();
	private JTextField monthLoc = new JTextField();
	private JTextField weekMag = new JTextField();
	private JTextField weekLoc = new JTextField();
	private JTextField dayMag = new JTextField();
	private JTextField dayLoc = new JTextField();
	private JTextField hourMag = new JTextField();
	private JTextField hourLoc = new JTextField();
	
	public EarthquakeGUI()
	{
		setTitle("Largest Earthquakes");
		setSize(400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		panel.add(button, BorderLayout.NORTH);
		
		JPanel earthquakePanel = new JPanel();
		earthquakePanel.setLayout(new GridLayout(4, 5));
		
		JLabel monthLabel = new JLabel("Past month:");
		JLabel monthMagLabel = new JLabel("Magnitude:");
		JLabel monthLocLabel = new JLabel("    Location:");
		JLabel weekLabel = new JLabel("Past week:");
		JLabel weekMagLabel = new JLabel("Magnitude:");
		JLabel weekLocLabel = new JLabel("    Location:");
		JLabel dayLabel = new JLabel("Past day:");
		JLabel dayMagLabel = new JLabel("Magnitude:");
		JLabel dayLocLabel = new JLabel("    Location:");
		JLabel hourLabel = new JLabel("Past hour:");
		JLabel hourMagLabel = new JLabel("Magnitude:");
		JLabel hourLocLabel = new JLabel("    Location:");

		earthquakePanel.add(monthLabel);
		earthquakePanel.add(monthMagLabel);
		earthquakePanel.add(monthMag);
		earthquakePanel.add(monthLocLabel);
		earthquakePanel.add(monthLoc);

		earthquakePanel.add(weekLabel);
		earthquakePanel.add(weekMagLabel);
		earthquakePanel.add(weekMag);
		earthquakePanel.add(weekLocLabel);
		earthquakePanel.add(weekLoc);

		earthquakePanel.add(dayLabel);
		earthquakePanel.add(dayMagLabel);
		earthquakePanel.add(dayMag);
		earthquakePanel.add(dayLocLabel);
		earthquakePanel.add(dayLoc);		

		earthquakePanel.add(hourLabel);
		earthquakePanel.add(hourMagLabel);
		earthquakePanel.add(hourMag);
		earthquakePanel.add(hourLocLabel);
		earthquakePanel.add(hourLoc);		
		
		monthMag.setEditable(false);
		monthLoc.setEditable(false);		
		weekMag.setEditable(false);
		weekLoc.setEditable(false);
		dayMag.setEditable(false);
		dayLoc.setEditable(false);
		hourMag.setEditable(false);
		hourLoc.setEditable(false);
		
		panel.add(earthquakePanel, BorderLayout.CENTER);
		
		add(panel);

	}

	public static void main(String[] args)
	{
		new EarthquakeGUI().setVisible(true);
	}

}
