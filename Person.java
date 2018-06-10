import java.awt.*;

public class Person
{
	private String name;
	private int bank;
	private int bet;
	private Hand myHand;

	public Person ()
	{
		name = "New Person";
		bank = 1000;
		bet =0;
		myHand = new Hand();
	}

	public Person (String newName)
	{
		name = newName;
		bank = 1000;
		myHand = new Hand();
	}

	public void setName (String newName)
	{
		name = newName;
	}

	public String getName ()
	{
		return name;
	}

	public void setBank (int newBank)
	{
		bank = newBank;
	}

	public int getBank ()
	{
		return bank;
	}

	public void setBet (int newBet)
	{
		bet = newBet;
	}

	public int getBet ()
	{
		return bet;
	}

	public Hand getHand ()
	{
		return myHand;
	}

	public void newHand ()
	{
		myHand = new Hand();
	}

	public void paint (Graphics g)
	{
		myHand.paint(g);
	}
}