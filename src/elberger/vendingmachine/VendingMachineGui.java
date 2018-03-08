package elberger.vendingmachine;

import java.awt.event.*;

import javax.swing.*;

public class VendingMachineGui extends JFrame
{
	private JTextField price = new JTextField();
	private JTextField paid = new JTextField();
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
		panel.add(price);
		panel.add(paidLabel);
		panel.add(paid);
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
		
		makeChange.addActionListener(this::assignChange);
		
	}
	
	public void assignChange(ActionEvent e)
	{
		double prc = Double.parseDouble(price.getText());
		double pd = Double.parseDouble(paid.getText());
		VendingMachine vm = new VendingMachine();
		vm.calculateTotalChange(prc, pd);
		String qq = Integer.toString(vm.calculateQuarters());
		quarters.setText(qq);
		String dd = Integer.toString(vm.calculateDimes());
		dimes.setText(dd);
		String nn = Integer.toString(vm.calculateNickels());
		nickels.setText(nn);
		String pp = Integer.toString(vm.calculatePennies());
		pennies.setText(pp);
	}
	
	public static void main(String[] args)
	{
		new VendingMachineGui().setVisible(true);
	}
}
