import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame
{
	private ControlPanel bjControl;
	private BlackJackTable bjTable;
	private StatusPanel bjStatus;
	private JMenuBar myMenuBar;
	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenuItem newMenuItem;
	//private JMenuItem saveMenuItem;
	private JMenuItem exitMenuItem;
	private JMenuItem optionsMenuItem;
	private OptionFrame myOptionFrame;

	public MainFrame()
	{
		initComponents();
        this.setSize(800,600);

        String inString = "James";
		bjTable.getPlayer().setName(inString);
		bjStatus.setCurrentBet(10);
		bjTable.getPlayer().setBet(10);
		bjStatus.setBank(1000);
		bjTable.getPlayer().setBank(1000);
		bjTable.getDeck().shuffle();
	}

	public BlackJackTable getTable()
	{
		return bjTable;
	}

	public StatusPanel getStatus()
	{
		return bjStatus;
	}

	public ControlPanel getControl()
	{
		return bjControl;
	}

    public void initComponents()
    {
		bjControl = new ControlPanel((MainFrame)this);
		bjStatus = new StatusPanel(this);
		bjTable = new BlackJackTable((MainFrame)this);
		myMenuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		newMenuItem = new JMenuItem("New");
		newListener myNewListener = new newListener ();
		newMenuItem.addActionListener(myNewListener);
		//saveMenuItem = new JMenuItem("Save");
		//saveListener mySaveListener = new saveListener ();
		//saveMenuItem.addActionListener(mySaveListener);
        exitMenuItem = new JMenuItem("Exit");
        exitListener myExitListener = new exitListener ();
		exitMenuItem.addActionListener(myExitListener);
        optionsMenuItem = new JMenuItem("Options");
        optionsListener myOptionsListener = new optionsListener ();
		optionsMenuItem.addActionListener(myOptionsListener);

		bjTable.setBorder(BorderFactory.createLoweredBevelBorder());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setTitle("BlackJack 0.1");

		getContentPane().add(bjControl, BorderLayout.SOUTH);
		getContentPane().add(bjStatus, BorderLayout.NORTH);
		getContentPane().add(bjTable, BorderLayout.CENTER);

		fileMenu.add(newMenuItem);
		//fileMenu.add(saveMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);
		editMenu.add(optionsMenuItem);
		myMenuBar.add(fileMenu);
		myMenuBar.add(editMenu);
        setJMenuBar(myMenuBar);
	}

	private void initOptionFrame ()
	{
		myOptionFrame = new OptionFrame ((MainFrame)this);
		myOptionFrame.show();
	}

	private class newListener implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			String inString = JOptionPane.showInputDialog("Please Enter Your Name");
			bjTable.getPlayer().setName(inString);
			bjStatus.setCurrentBet(10);
			bjTable.getPlayer().setBet(10);
			bjStatus.setBank(1000);
			bjTable.getPlayer().setBank(1000);
			bjTable.getDeck().shuffle();
			bjTable.newHand();
			bjTable.setBeforeDeal(true);
		}
	}

	//private class saveListener implements ActionListener
	//{
	//	public void actionPerformed (ActionEvent e)
	//	{
	//
	//	}
	//}

	private class exitListener implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			System.exit(0);
		}
	}

	private class optionsListener implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			initOptionFrame ();
		}
	}
}