import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class OptionFrame extends JFrame
{
	private MainFrame myGui;
	private JPanel myPanel;
	private JLabel numDecks;
	
	public OptionFrame (MainFrame gui)
	{
		myGui = gui;
		
		initComponents();
        this.setSize(400,300);
	}

	private void initComponents ()
	{
		myPanel = new JPanel();
		
		numDecks = new JLabel("Number of Decks: ");
		
		getContentPane().add(myPanel, BorderLayout.NORTH);

		myPanel.setLayout(new GridLayout(0,2));
		myPanel.add(numDecks);
		
		setDefaultCloseOperation(HIDE_ON_CLOSE);

		setTitle("Options");
	}
}
