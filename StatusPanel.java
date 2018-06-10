import javax.swing.*;
import java.awt.*;
import java.lang.*;

public class StatusPanel extends JPanel
{
	private JLabel currentBet;
	private JLabel bank;
	private JFrame myGui;

	public StatusPanel (JFrame gui)
	{
		myGui = gui;

		currentBet = new JLabel("Bet: ");
		bank = new JLabel("Bank: ");

		setLayout(new GridLayout(0,2));

		add(bank);
		add(currentBet);
	}

	public void setCurrentBet (int newBet)
	{
		currentBet.setText("Bet: "+String.valueOf(newBet));
	}

	public void setBank (int newBank)
	{
		bank.setText("Bank: "+String.valueOf(newBank));
	}
}