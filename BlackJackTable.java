import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BlackJackTable extends JPanel
{
	private MainFrame myGui;
	private Person player;
	private Person dealer;
	private Deck theDeck;
	private boolean beforeDeal;

	public BlackJackTable (MainFrame gui)
	{
		myGui = gui;

		player = new Person();
		dealer = new Person("Dealer");
		dealer.getHand().setDealer(true);
		player.getHand().setDealer(false);
		theDeck = new Deck();
		theDeck.shuffle();
		beforeDeal=true;

		myGui.repaint();
	}

	public Person getPlayer ()
	{
		return player;
	}

	public Person getDealer ()
	{
		return dealer;
	}

	public Deck getDeck ()
	{
		return theDeck;
	}

	public void deal ()
	{
		dealer.getHand().addCard(theDeck.getFromTop());
		player.getHand().addCard(theDeck.getFromTop());
		dealer.getHand().addCard(theDeck.getFromTop());
		player.getHand().addCard(theDeck.getFromTop());
		dealer.getHand().getCardAt(0).setIsBack(true);
		beforeDeal=false;
		myGui.getStatus().setBank(player.getBank()-player.getBet());
		player.setBank(player.getBank()-player.getBet());

		if (player.getHand().getTotal() == 21)
		{
			beforeDeal = true;
			myGui.repaint();

			dealer.getHand().getCardAt(0).setIsBack(false);
			myGui.repaint();
			
			if (dealer.getHand().getTotal() == player.getHand().getTotal())
			{
				JOptionPane.showMessageDialog(this, "Push");
				myGui.getStatus().setBank(player.getBank()+player.getBet());
				player.setBank(player.getBank()+player.getBet());
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Black Jack");
				myGui.getStatus().setBank((int)(player.getBank()+2.5*(double)player.getBet()));
				player.setBank((int)(player.getBank()+2.5*(double)player.getBet()));
			}
		}

		myGui.repaint();
	}

	public void hitMe ()
	{
		if (theDeck.isEmpty())
		{
			theDeck.shuffle();
		}
		if (player.getHand().getCardAt(4) == null)
		{
			player.getHand().addCard(theDeck.getFromTop());
			myGui.repaint();
		}
		else
		{
			JOptionPane.showMessageDialog(this, "You can only have 5 cards");
		}

		if (player.getHand().getTotal() > 21)
		{
			JOptionPane.showMessageDialog(this, "You Bust");
			stay();
		}

		if (player.getHand().getCardAt(4) != null)
		{
			stay();
		}
	}

	public void stay ()
	{
		boolean temp = true;

		beforeDeal = true;
		myGui.repaint();

		dealer.getHand().getCardAt(0).setIsBack(false);
		myGui.repaint();

		while (dealer.getHand().getTotal() < 17 && temp && player.getHand().getTotal() < 22)
		{
			if (dealer.getHand().getCardAt(4) == null)
			{
				if (theDeck.isEmpty())
				{
					theDeck.shuffle();
				}
				dealer.getHand().addCard(theDeck.getFromTop());
				myGui.repaint();
			}
			else
			{
				temp = false;
			}
		}

		if (dealer.getHand().getTotal() > player.getHand().getTotal() && dealer.getHand().getTotal() < 22)
		{
			JOptionPane.showMessageDialog(this, "You Lose");
		}

		if (dealer.getHand().getTotal() > 21)
		{
			JOptionPane.showMessageDialog(this, "You Win");
			myGui.getStatus().setBank(player.getBank()+2*player.getBet());
			player.setBank(player.getBank()+2*player.getBet());
		}

		if (dealer.getHand().getTotal() < player.getHand().getTotal() && player.getHand().getTotal() < 22)
		{
			JOptionPane.showMessageDialog(this, "You Win");
			myGui.getStatus().setBank(player.getBank()+2*player.getBet());
			player.setBank(player.getBank()+2*player.getBet());
		}

		if (dealer.getHand().getTotal() == player.getHand().getTotal())
		{
			JOptionPane.showMessageDialog(this, "Push");
			myGui.getStatus().setBank(player.getBank()+player.getBet());
			player.setBank(player.getBank()+player.getBet());
		}
	}

	public void doubleDown ()
	{
		if (!beforeDeal)
		{
			if ((player.getHand().getTotal() == 10 || player.getHand().getTotal() == 11) && player.getHand().getNumCards() == 2)
			{
				player.setBet(2*myGui.getTable().getPlayer().getBet());
				myGui.getStatus().setCurrentBet(myGui.getTable().getPlayer().getBet());
				player.setBank(myGui.getTable().getPlayer().getBank()-(myGui.getTable().getPlayer().getBet()/2));
				myGui.getStatus().setBank(myGui.getTable().getPlayer().getBank());
				myGui.repaint();
				hitMe();
				stay();
				player.setBet(myGui.getTable().getPlayer().getBet()/2);
				myGui.getStatus().setCurrentBet(myGui.getTable().getPlayer().getBet());
				myGui.repaint();
			}
		}
	}

	public void newHand ()
	{
		player.newHand();
		dealer.newHand();
		dealer.getHand().setDealer(true);
		player.getHand().setDealer(false);
		myGui.repaint();
	}

	public boolean getBeforeDeal ()
	{
		return beforeDeal;
	}

	public void setBeforeDeal (boolean newBeforeDeal)
	{
		beforeDeal = newBeforeDeal;
	}

	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		g.drawString("Dealer", 5, 85);
		if (beforeDeal)
		{
			g.drawString("Total: "+dealer.getHand().getTotal(), 5, 100);
		}
		g.drawString(player.getName(), 5, 375);
		g.drawString("Total: "+player.getHand().getTotal(), 5, 390);
		player.paint(g);
		dealer.paint(g);
	}
}