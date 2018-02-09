package elberger.physics;

public class Physics 
{
	public static void main (String[] args)
	{
		double angle = 72.0;
		double velocity = 23.0;
		
		for (int time = 0; time <= 10; time++)
		{
			double x = Math.cos(Math.toRadians(angle)) * velocity * time;
			double y = Math.sin(Math.toRadians(angle)) * velocity * time -
					(.5 * 9.8 * time * time);
			
			System.out.println(time + "\t" + x + ", " + y);
		}
	}
}
