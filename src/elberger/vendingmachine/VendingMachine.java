package elberger.vendingmachine;

public class VendingMachine
{

	Change pay(double price, double paid)
	{
		Change tmp = new Change (0,0,0,0);	
		tmp.calculateQuarters();
		tmp.calculateDimes();
		tmp.calculateNickels();
		tmp.calculatePennies();
		tmp.calculateTotalChange(price, paid);
		
		Change ch = new Change(tmp.getQuarters(), tmp.getDimes(), tmp.getNickels(), tmp.getPennies());
		return ch;
	}
}
