package elberger.vendingmachine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VendingMachineChangeTest
{

	@Test
	void testPayQuarters()
	{
		//given 
		VendingMachine vm = new VendingMachine();
		vm.pay(1.34, 2);
		
		//when
		Change ch = new Change(2, 1, 1, 1);
		
		//then
		assertEquals(ch.quarters, 2);
	}
	
	@Test
	void testPayDimes()
	{
		//given 
		VendingMachine vm = new VendingMachine();
		vm.pay(1.05, 1.50);
		
		//when
		Change ch = new Change(1, 1, 1, 0);
		
		//then
		assertEquals(ch.dimes, 1);
	}
	
	@Test
	void testPayNickels()
	{
		//given 
		VendingMachine vm = new VendingMachine();
		vm.pay(1.80, 2);
		
		//when
		Change ch = new Change(0, 2, 0, 0);
		
		//then
		assertEquals(ch.nickels, 0);
	}
	
	@Test
	void testPayPennies()
	{
		//given 
		VendingMachine vm = new VendingMachine();
		vm.pay(1.99, 2);
		
		//when
		Change ch = new Change(0, 0, 0, 1);
		
		//then
		assertEquals(ch.pennies, 1);
	}
}
