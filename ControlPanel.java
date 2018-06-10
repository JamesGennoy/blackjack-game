import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ControlPanel extends JPanel
{
	private JButton betButton;
	private JButton dealButton;
	private JButton hitButton;
	private JButton stayButton;
	private JButton doubleButton;
	private MainFrame myGui;

	public ControlPanel (MainFrame gui)
	{
		myGui = gui;

		betButton = new JButton("Bet");
		betListener myBetListener = new betListener ();
		betButton.addActionListener(myBetListener);
		dealButton = new JButton("Deal");
		dealListener myDealListener = new dealListener ();
		dealButton.addActionListener(myDealListener);
		hitButton = new JButton("Hit Me");
		hitListener myHitListener = new hitListener ();
		hitButton.addActionListener(myHitListener);
		stayButton = new JButton("Stay");
		stayListener myStayListener = new stayListener ();
		stayButton.addActionListener(myStayListener);
		doubleButton = new JButton("Double");
		doubleListener myDoubleListener = new doubleListener ();
		doubleButton.addActionListener(myDoubleListener);

		setLayout(new GridLayout(1,6));

		add(betButton);
		add(dealButton);
		add(hitButton);
		add(stayButton);
		add(doubleButton);
	}

	private class betListener implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			if (myGui.getTable().getBeforeDeal())
			{
				String inString = JOptionPane.showInputDialog("Please Enter Bet Amount");
				int tempBet = Integer.parseInt(inString);
				if (tempBet <= myGui.getTable().getPlayer().getBank())
				{
					myGui.getTable().getPlayer().setBet(tempBet);
					myGui.getStatus().setCurrentBet(tempBet);
					myGui.repaint();
				}
				else
				{
					JOptionPane.showMessageDialog(myGui, "You cannot bet more than what is in your Bank");
				}
			}
		}
	}

	private class dealListener implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			if (myGui.getTable().getBeforeDeal())
			{
				myGui.getTable().newHand();
				myGui.getTable().deal();
			}
		}
	}

	private class hitListener implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			if (!myGui.getTable().getBeforeDeal())
			{
				myGui.getTable().hitMe();
			}
		}
	}

	private class stayListener implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			if (!myGui.getTable().getBeforeDeal())
			{
				myGui.getTable().stay();
			}
		}
	}

	private class doubleListener implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			myGui.getTable().doubleDown();
		}
	}
}