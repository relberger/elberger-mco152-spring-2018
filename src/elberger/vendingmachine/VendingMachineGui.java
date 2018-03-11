package elberger.vendingmachine;

import java.awt.event.*;

import javax.swing.*;

public class VendingMachineGui extends JFrame
{
	private JTextField priceText = new JTextField();
	private JTextField paidText = new JTextField();
	private JTextArea quarters = new JTextArea();
	private JTextArea dimes = new JTextArea();
	private JTextArea nickels = new JTextArea();
	private JTextArea pennies = new JTextArea();

	public VendingMachineGui()
	{
		setTitle("Vending Machine viewer");
		setSize(200, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel priceLabel = new JLabel("Price:");
		JLabel paidLabel = new JLabel("Paid:");
		JLabel quartersLabel = new JLabel("Quarters:");
		JLabel dimesLabel = new JLabel("Dimes:");
		JLabel nickelsLabel = new JLabel("Nickels:");
		JLabel penniesLabel = new JLabel("Pennies:");
		JButton makeChange = new JButton("Make Change");
		
		panel.add(priceLabel);
		panel.add(priceText);
		panel.add(paidLabel);
		panel.add(paidText);
		panel.add(makeChange);
		panel.add(quartersLabel);
		panel.add(quarters);
		panel.add(dimesLabel);
		panel.add(dimes);
		panel.add(nickelsLabel);
		panel.add(nickels);
		panel.add(penniesLabel);
		panel.add(pennies);
		add(panel);
		
		quarters.setEditable(false);
		dimes.setEditable(false);
		nickels.setEditable(false);
		pennies.setEditable(false);
		
		makeChange.addActionListener(this::assignChange);
		
	}
	
	public void assignChange(ActionEvent e)
	{
		double price = Double.parseDouble(priceText.getText());
		double paid = Double.parseDouble(paidText.getText());
		VendingMachine vm = new VendingMachine();
		Change change = vm.pay(price, paid);
		String quartersStr = Integer.toString(change.getQuarters());
		quarters.setText(quartersStr);
		String dimesStr = Integer.toString(change.getDimes());
		dimes.setText(dimesStr);
		String nickelsStr = Integer.toString(change.getNickels());
		nickels.setText(nickelsStr);
		String penniesStr = Integer.toString(change.getPennies());
		pennies.setText(penniesStr);
	}
	
	public static void main(String[] args)
	{
		new VendingMachineGui().setVisible(true);
	}
}
