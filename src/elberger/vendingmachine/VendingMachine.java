package elberger.vendingmachine;

public class VendingMachine
{
	int quarters;
	int nickels;
	int dimes;
	int pennies;
	double totalChange;

	public double calculateTotalChange(double price, double paid)
	{
		totalChange = paid - price;
		return totalChange;
	}

	Change pay(double price, double paid)
	{
		double change = calculateTotalChange(price, paid);
		
		quarters = (int) (change / .25);
		double afterQuarters = (change - (quarters * .25));
		dimes = (int) (afterQuarters / .10);
		double afterDimes = (afterQuarters - (dimes * .1));
		nickels = (int) (afterDimes / .05);
		double afterNickels = (afterDimes - (nickels * .05));
		pennies = (int) Math.round(afterNickels / .01);

		Change ch = new Change(quarters, dimes, nickels, pennies);
		return ch; 
	}
}
