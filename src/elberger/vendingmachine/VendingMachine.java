package elberger.vendingmachine;

public class VendingMachine
{
	int quarters;
	int nickels; 
	int dimes;
	int pennies;
	double totalChange;
	double remainingChange;

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


	Change pay(double price, double paid)
	{
		VendingMachine vm = new VendingMachine();
		vm.calculateQuarters();
		vm.calculateDimes();
		vm.calculateNickels();
		vm.calculatePennies();
		vm.calculateTotalChange(price, paid);
		
		Change ch = new Change(vm.quarters, vm.dimes, vm.nickels, vm.pennies);
		return ch;
	}
}
