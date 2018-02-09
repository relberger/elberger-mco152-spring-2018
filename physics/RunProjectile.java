package elberger.physics;

public class RunProjectile 
{
	public static void main(String[] args) 
	{
		Projectile proj = new Projectile(72, 23);

		for (double time = 0; time <= 10; time++) 
		{
			System.out.println(time + "\t" + proj.getX(time) + ", " + proj.getY(time));
		}
	}
}
