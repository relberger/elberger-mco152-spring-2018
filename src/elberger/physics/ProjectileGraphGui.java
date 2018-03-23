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

public class ProjectileGraphGui extends JFrame
{
	private ProjectileGraph projectileGraph;

	public ProjectileGraphGui() 
	{
		setTitle("Projectile Viewer");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		projectileGraph = new ProjectileGraph();
		panel.add(projectileGraph, BorderLayout.CENTER);

		setContentPane(panel);	
		
		Thread thread = new Thread(this::advanceGraph);
		thread.start();
	}

	public void advanceGraph()
	{
		while(true)
		{
			projectileGraph.repaint();
		}
	}
	
	public static void main(String[] args)
	{
		new ProjectileGraphGui().setVisible(true);
	}
}
