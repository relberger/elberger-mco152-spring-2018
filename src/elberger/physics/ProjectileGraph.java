package elberger.physics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class ProjectileGraph extends JComponent
{
	private Image projectileImage;
	
	@Override
	protected void paintComponent(Graphics g1)
	{
		super.paintComponent(g1);
		
		g1.translate(0, getHeight());	
		
		g1.setColor(Color.LIGHT_GRAY);
		drawGrid(g1);
		
		try
		{
			projectileImage = ImageIO.read(new File("src/elberger/physics/football.png"));
		} 
		catch (IOException e2)
		{
			e2.printStackTrace();
		}
		
		Projectile projectile1 = new Projectile(40, 85);
		Projectile projectile2 = new Projectile(50, 95);
		Projectile projectile3 = new Projectile(60, 105);

		g1.setColor(Color.MAGENTA);
		drawProjectilePath(g1, projectile1);
		g1.setColor(Color.ORANGE);
		drawProjectilePath(g1, projectile2);
		g1.setColor(Color.BLUE);
		drawProjectilePath(g1, projectile3);
		
	}
	
	public void drawProjectilePath(Graphics g2, Projectile pp)
	{
		ArrayList <Integer> xVals = new ArrayList<Integer>();
		ArrayList <Integer> yVals = new ArrayList<Integer>();

		for (int ii = 0; ii < 15; ii++)
		{
			int xx = (int) pp.getX(ii);
			int yy = -(int) pp.getY(ii);
			
			g2.fillOval(xx, yy, 10, 10);
			
			xVals.add(xx);
			yVals.add(yy);
			
			g2.drawImage(projectileImage, xx - 15, yy + 15, null);
			
			g2.drawString(xx + ", " + yy, xx - 15, yy - 15);
		}
		
		for (int xy = 0; xy < xVals.size() - 1; xy++)
		{
			g2.drawLine(xVals.get(xy), -yVals.get(xy), xVals.get(xy + 1), -yVals.get(xy + 1));				
		}		
	}
	
	public void drawGrid(Graphics g3)
	{
		for (int ii = 0; ii < getWidth(); ii+=20)
		{
			g3.drawLine(0, -ii, getWidth(), -ii);
			g3.drawLine(ii, 0, ii, -getHeight());
		}

	}

}
