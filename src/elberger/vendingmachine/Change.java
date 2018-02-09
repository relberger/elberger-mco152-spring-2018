package elberger.vendingmachine;

public class Change
{
	int quarters;
	int nickels; 
	int dimes;
	int pennies;
	double remainingChange;
	double price; 
	double paid; 
	double totalChange;

	public Change(int quarters, int dimes, int nickels, int pennies)
	{
		this.quarters = quarters;
		this.dimes = dimes;
		this.nickels = nickels;
		this.pennies = pennies;
	}
	
	public double calculateTotalChange(double price, double paid)
	{
		totalChange = paid - price;
		return totalChange;
	}
	public double calculateRemainingChange(int coin)
	{
		remainingChange = totalChange - coin;
		return remainingChange;
	}
	
	public int calculateQuarters()
	{
		quarters = (int) (totalChange / 25);
		return quarters;
	}

	public int calculateDimes()
	{
		dimes = (int) (calculateRemainingChange(quarters) / 10);
		return dimes;
	}

	public int calculateNickels()
	{
		nickels = (int) (calculateRemainingChange(dimes) / 5);
		return nickels;
	}

	public int calculatePennies()
	{
		pennies = (int) (calculateRemainingChange(nickels) / 1);
		return pennies;
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
