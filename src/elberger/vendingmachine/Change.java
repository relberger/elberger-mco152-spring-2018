package elberger.vendingmachine;

public class Change
{
	int quarters;
	int nickels; 
	int dimes;
	int pennies;

	public Change(int quarters, int dimes, int nickels, int pennies)
	{
		this.quarters = quarters;
		this.dimes = dimes;
		this.nickels = nickels;
		this.pennies = pennies;
	}
	
	
	public int getQuarters()
	{
		return quarters;
	}

	public int getNickels()
	{
		return nickels;
	}

	public int getDimes()
	{
		return dimes;
	}

	public int getPennies()
	{
		return pennies;
	}

}
