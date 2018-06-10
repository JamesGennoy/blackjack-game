import java.util.*;
import java.awt.*;

public class Hand
{
	private Card [] cards;
	private int numCards;
	private boolean isDealer;

	public Hand ()
	{
		cards = new Card [5];
		numCards = 0;
	}

	public void setDealer (boolean dealer)
	{
		isDealer = dealer;
	}

	public void addCard (Card newCard)
	{
		int tempPosition = 1;

		if (!isDealer)
			tempPosition += 5;
		tempPosition += numCards;
		newCard.setPosition(tempPosition);
		cards[numCards] = newCard;
		numCards++;
	}

	public void paint (Graphics g)
	{
		for (int x=0;x<numCards;x++)
		{
			cards[x].paint(g);
		}
	}

	public Card getCardAt (int index)
	{
		return cards[index];
	}

	public int getTotal ()
	{
		int tempTotal = 0;

		for (int x=0;x<numCards;x++)
		{
			if (cards[x].getValue() > 9)
			{
				tempTotal += 10;
			}
			else
			{
				tempTotal += cards[x].getValue();
			}
		}

		for (int y=0;y<numCards;y++)
		{
			if (cards[y].getValue() == 1)
			{
				if (tempTotal < 12)
				{
					tempTotal += 10;
				}
			}
		}

		return tempTotal;
	}

	public int getNumCards ()
	{
		return numCards;
	}
}