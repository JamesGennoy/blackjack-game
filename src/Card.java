import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Card
{
	private int value;
	private int suit; //1=hearts 2=diamonds 3=spades 4=clubs
	private int position;
	private boolean isBack;

	private int [] heartX = new int [10];
	private int [] heartY = new int [10];
	private int [] diamondX = new int [4];
	private int [] diamondY = new int [4];
	private int [] spadeX = new int [11];
	private int [] spadeY = new int [11];
	private int [] clubX = new int [20];
	private int [] clubY = new int [20];

	private int translateX = 0;
	private int translateY = 0;

	public Card ()
	{
		position = 1;
		value = 1;
		suit = 1;
		calcShapes();
	}

	public void calcShapes ()
	{
		//Hearts
		heartX[0]=50;
		heartX[1]=48;
		heartX[2]=43;
		heartX[3]=45;
		heartX[4]=48;
		heartX[5]=50;
		heartX[6]=52;
		heartX[7]=55;
		heartX[8]=58;
		heartX[9]=52;

		heartY[0]=65;
		heartY[1]=62;
		heartY[2]=65;
		heartY[3]=75;
		heartY[4]=80;
		heartY[5]=85;
		heartY[6]=80;
		heartY[7]=75;
		heartY[8]=65;
		heartY[9]=62;

		//Diamonds
		diamondX[0]=50;
		diamondX[1]=43;
		diamondX[2]=50;
		diamondX[3]=58;

		diamondY[0]=62;
		diamondY[1]=75;
		diamondY[2]=88;
		diamondY[3]=75;

		//Spades
		spadeX[0]=50;
		spadeX[1]=45;
		spadeX[2]=40;
		spadeX[3]=45;
		spadeX[4]=48;
		spadeX[5]=48;
		spadeX[6]=52;
		spadeX[7]=52;
		spadeX[8]=55;
		spadeX[9]=60;
		spadeX[10]=55;

		spadeY[0]=60;
		spadeY[1]=68;
		spadeY[2]=75;
		spadeY[3]=82;
		spadeY[4]=80;
		spadeY[5]=88;
		spadeY[6]=88;
		spadeY[7]=80;
		spadeY[8]=82;
		spadeY[9]=75;
		spadeY[10]=68;

		//Clubs
		clubX[0]=47;
		clubX[1]=43;
		clubX[2]=48;
		clubX[3]=41;
		clubX[4]=37;
		clubX[5]=39;
		clubX[6]=41;
		clubX[7]=45;
		clubX[8]=48;
		clubX[9]=48;
		clubX[10]=52;
		clubX[11]=52;
		clubX[12]=55;
		clubX[13]=59;
		clubX[14]=61;
		clubX[15]=63;
		clubX[16]=59;
		clubX[17]=52;
		clubX[18]=57;
		clubX[19]=53;

		clubY[0]=60;
		clubY[1]=72;
		clubY[2]=75;
		clubY[3]=74;
		clubY[4]=77;
		clubY[5]=80;
		clubY[6]=85;
		clubY[7]=80;
		clubY[8]=75;
		clubY[9]=88;
		clubY[10]=88;
		clubY[11]=75;
		clubY[12]=80;
		clubY[13]=85;
		clubY[14]=80;
		clubY[15]=77;
		clubY[16]=74;
		clubY[17]=75;
		clubY[18]=72;
		clubY[19]=60;
	}

	public void setValue (int newValue)
	{
		value = newValue;
	}

	public int getValue ()
	{
		return value;
	}

	public void setSuit (int newSuit)
	{
		suit = newSuit;
	}

	public int getSuit ()
	{
		return suit;
	}

	public void setPosition (int newPosition)
	{
		position = newPosition;
	}

	public int getPosition ()
	{
		return position;
	}

	public void setIsBack (boolean newBack)
	{
		isBack = newBack;
	}

	public boolean getIsBack ()
	{
		return isBack;
	}

	private void calcPosition ()
	{
		switch (position)
		{
			case 1:
				translateX = 130;
				translateY = 10;
				break;
			case 2:
				translateX = 250;
				translateY = 10;
				break;
			case 3:
				translateX = 370;
				translateY = 10;
				break;
			case 4:
				translateX = 490;
				translateY = 10;
				break;
			case 5:
				translateX = 610;
				translateY = 10;
				break;
			case 6:
				translateX = 130;
				translateY = 300;
				break;
			case 7:
				translateX = 250;
				translateY = 300;
				break;
			case 8:
				translateX = 370;
				translateY = 300;
				break;
			case 9:
				translateX = 490;
				translateY = 300;
				break;
			case 10:
				translateX = 610;
				translateY = 300;
				break;
		}
	}

	public void paint (Graphics g)
	{
		calcPosition();
		g.translate(translateX,translateY);
		Color tempColor = new Color(1);
		tempColor = g.getColor();
		g.setColor(Color.white);

		if (isBack)
		{
			g.setColor(Color.darkGray);
			g.fillRoundRect(0, 0, 100, 150, 20, 20);
			g.setColor(Color.white);

			for (int x=5;x<=145;x+=10)
			{
				g.drawLine(3,x-2,7,x+2);
				g.drawLine(10,x+2,20,x-2);
				g.drawLine(20,x-2,30,x+2);
				g.drawLine(30,x+2,40,x-2);
				g.drawLine(40,x-2,50,x+2);
				g.drawLine(50,x+2,60,x-2);
				g.drawLine(60,x-2,70,x+2);
				g.drawLine(70,x+2,80,x-2);
				g.drawLine(80,x-2,90,x+2);
				g.drawLine(93,x+2,97,x-2);
			}
		}
		else
		{

			g.fillRoundRect(0, 0, 100, 150, 20, 20);

			switch (suit)
			{
				case 1:
					g.setColor(Color.red);
					g.fillPolygon(heartX, heartY, 10);
					break;
				case 2:
					g.setColor(Color.red);
					g.fillPolygon(diamondX, diamondY, 4);
					break;
				case 3:
					g.setColor(Color.black);
					g.fillPolygon(spadeX, spadeY, 11);
					break;
				case 4:
					g.setColor(Color.black);
					g.fillPolygon(clubX, clubY, 20);
					break;
			}

			if (value <= 10 && value > 1)
			{
				g.drawString(String.valueOf(value), 5, 15);
				g.drawString(String.valueOf(value), 83, 143);
			}
			else
			{
				switch (value)
				{
					case 1:
						g.drawString("A", 5, 15);
						g.drawString("A", 83, 143);
						break;
					case 11:
						g.drawString("J", 5, 15);
						g.drawString("J", 83, 143);
						break;
					case 12:
						g.drawString("Q", 5, 15);
						g.drawString("Q", 83, 143);
						break;
					case 13:
						g.drawString("K", 5, 15);
						g.drawString("K", 83, 143);
						break;
				}
			}
		}

		g.setColor(tempColor);
		g.translate(-translateX,-translateY);
	}
}