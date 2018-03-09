package elberger.physics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class ProjectileGraph extends JComponent
{

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		g.drawLine(10, 80, 400, 260);

		g.drawOval(50, 100, 200, 80);

		g.setColor(Color.RED);

		g.fillRect(400, 100, 50, 150);

		g.drawString("Here's a String", 125, 300);

		Projectile pp = new Projectile(50, 100);
		
		g.translate(0, getHeight());	//height of graph
		
		for (int ii = 0; ii < 15; ii++)
		{
			int xx = (int) pp.getX(ii);
			int yy = -(int) pp.getY(ii);
			g.drawOval(xx, yy, 10, 10);
		}
		
		
	}

}
