package edu.westga.greeting.presentation;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import edu.westga.greeting.presentation.GreetingGUI;
import edu.westga.greeting.application.PropStorage;
import edu.westga.greeting.model.GreetingFactory;
import edu.westga.greeting.model.IGreeting;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GreetingGUI extends JFrame{

private static final long serialVersionUID = 1L;
	
	private static final String FRAME_TITLE = "Greeting Application";
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 200;
	JFrame frame;
	JComboBox mycombo;
	private GreetingFactory theGreeting;
	private IGreeting theGreetingBean;
	String selectedLanguage;
	
	public GreetingGUI(GreetingFactory theGreeting)
	{
		this.theGreeting = theGreeting;
		//this.theGreeting.addObsever(this);
		
		this.setFrameProperties();
		JComboBox comboBox = this.combo();
		this.add(comboBox, BorderLayout.NORTH);
		
		PropStorage thePropStorage = new PropStorage();
		this.selectedLanguage = thePropStorage.getStoredLanguage();
		comboBox.setSelectedItem(selectedLanguage);
		System.out.println(this.selectedLanguage);
		
		JPanel buttonPanel = buildButtonPanel();		
		this.add(buttonPanel, BorderLayout.CENTER);
	}
	
	private JPanel buildButtonPanel() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.CYAN);
		buttonPanel.setLayout(new BorderLayout());
		
		JPanel operatorPanel = ShowDialogBox();				
		buttonPanel.add(operatorPanel, BorderLayout.NORTH);
		
		return buttonPanel;
	}

	private JComboBox combo()
	{
		mycombo = new JComboBox();
		//comboBox.setLayout(new FlowLayout());
		mycombo.setPreferredSize(new Dimension(40,34));
		mycombo.setMaximumSize(new Dimension(30,20));
		String[] arr = {"English", "French", "German", "Spanish"};
		for ( int i= 0; i< arr.length; ++i)
			mycombo.addItem(arr[i]);
		return mycombo;
	}	
	
	private class GreetingListener implements ActionListener
    {
		public void actionPerformed(ActionEvent e) {
			selectedLanguage = (String) mycombo.getSelectedItem();				
				try {
					
					theGreetingBean = theGreeting.getGreetingBean(selectedLanguage);
					JOptionPane.showMessageDialog(frame,theGreetingBean.getGreeting());
					
				} 
				catch (ClassNotFoundException e1) {
					
					e1.printStackTrace();
				} 
				catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
    } 
	
	private void setFrameProperties() {
		frame = new JFrame("Show Message Dialog");
		setTitle(GreetingGUI.FRAME_TITLE);		
		
		frame.addWindowListener(new MyWindowListener());			
		System.out.println("add listener");
		System.out.println(frame.getDefaultCloseOperation());
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(GreetingGUI.FRAME_WIDTH, GreetingGUI.FRAME_HEIGHT);
		setLayout(new BorderLayout());
	}
	
	class MyWindowListener implements WindowListener {
			  @Override
			  public void windowClosing(WindowEvent arg0) {
				  System.out.println("window close");
				  PropStorage thePropStorage = new PropStorage(selectedLanguage);
					thePropStorage.storeLanguage();
					System.out.println("language stored");
			    System.exit(0);
			  }

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("window closed");
				  PropStorage thePropStorage = new PropStorage(selectedLanguage);
					thePropStorage.storeLanguage();
					System.out.println("language stored");
			}
	}
	
	public JPanel ShowDialogBox(){
		JPanel operatorPanel = new JPanel();
	    //frame = new JFrame("Show Message Dialog");
	    JButton button = new JButton("Click Me");
	    button.addActionListener(new GreetingListener());
	    operatorPanel.add(button);	   
	    return operatorPanel;
	  }
}
