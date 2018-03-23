package elberger.physics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class AnimatedProjectileGraph extends JComponent
{
	double time = 0;

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Projectile projectile = new Projectile(72, 100);
		g.setColor(Color.RED);
		g.translate(0, getHeight());

		double x = projectile.getX(time);
		double y = -projectile.getY(time);
		g.drawOval((int) x, (int) y, 5, 5);

		time += .005;
	}
}
