package elberger.physics;

import java.awt.Color;
import java.awt.Graphics;

import java.util.ArrayList;

import javax.swing.JComponent;

public class ProjectileGraph extends JComponent
{

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		//g.drawLine(10, 80, 400, 260);

		//g.drawOval(50, 100, 200, 80);

		///g.setColor(Color.RED);

		//g.fillRect(400, 100, 50, 150);

		//g.drawString("Here's a String", 125, 300);

		Projectile projectile1 = new Projectile(50, 85);
		
		g.translate(0, getHeight());	//height of graph
		drawProjectilePath(g, projectile1);


		}
		
		public void drawProjectilePath(Graphics gg, Projectile pp)
		{
			ArrayList <Integer> xVals = new ArrayList<Integer>();
			ArrayList <Integer> yVals = new ArrayList<Integer>();

			for (int ii = 0; ii < 15; ii++)
			{
				int xx = (int) pp.getX(ii);
				int yy = -(int) pp.getY(ii);
				
				gg.setColor(Color.MAGENTA);
				gg.fillOval(xx, yy, 10, 10);
				
				xVals.add(xx);
				yVals.add(yy);
				
				gg.setColor(Color.BLUE);
				gg.drawString(xx + ", " + yy, xx - 15, yy - 15);
							
			}
			
			for (int xy = 0; xy < xVals.size(); xy++)
			{
				gg.setColor(Color.YELLOW);
				gg.drawLine(xVals.get(xy), -yVals.get(xy), xVals.get(xy + 1), -yVals.get(xy + 1));				
			}
		
	}

}
