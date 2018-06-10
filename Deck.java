import java.util.*;

public class Deck
{
	private Card [] myDeck;
	private int numDecks;
	private int top;

	public Deck()
	{
		numDecks = 1;
		myDeck = new Card [numDecks*52];
		top = 0;

		int a=0;

		for (int z=1;z<=numDecks;z++)
		{
			for (int x=1;x<=13;x++)
			{
				for (int y=1;y<=4;y++)
				{
					Card tempCard = new Card();
					tempCard.setSuit(y);
					tempCard.setValue(x);
					myDeck[a] = tempCard;
					a++;
				}
			}
		}
	}

	public int getNumDecks ()
	{
		return numDecks;
	}

	public void setNumDecks (int newNumDecks)
	{
		numDecks = newNumDecks;
	}

	public Card getFromTop ()
	{
		top++;
		return myDeck[top-1];
	}

	public void shuffle ()
	{
		Random rand = new Random(System.currentTimeMillis());
		Card tempCard = new Card();

		for (int x=0;x<1000;x++)
		{
			int a = rand.nextInt(numDecks*51);
			int b = rand.nextInt(numDecks*51);
			tempCard = myDeck[b];
			myDeck[b] = myDeck[a];
			myDeck[a] = tempCard;
		}

		top = 0;
	}

	public boolean isEmpty ()
	{
		return (top >= 51);
	}
}