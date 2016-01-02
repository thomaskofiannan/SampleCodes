//******************************************************
// TelephonePanel.java
//
// Lays out a (functionless) GUI like a telephone keypad with a title.
// Illustrates use of BorderLayout and GridLayout.
//******************************************************
import java.awt.*;
import javax.swing.*;

public class TelephonePanel extends JPanel
{
    public TelephonePanel()
    {
	//set BorderLayout for this panel
	this.setLayout(new BorderLayout());

	//create a JLabel with "Your Telephone" title 
	JLabel title = new JLabel("Your Telephone!!");	

	//create panel to hold label; add label to panel
	JPanel titlePanel = new JPanel();
	titlePanel.add(title);

	//add title panel to north of this panel
	this.add(titlePanel, BorderLayout.NORTH);

	//create panel to hold keypad and give it a 4x3 GridLayout
	JPanel keys = new JPanel();
	keys.setLayout(new GridLayout(4,3));

	//add buttons representing keys to key panel
	keys.add(new JButton("1"));
	keys.add(new JButton("2"));
	keys.add(new JButton("3"));
	keys.add(new JButton("4"));
	keys.add(new JButton("5"));
	keys.add(new JButton("6"));
	keys.add(new JButton("7"));
	keys.add(new JButton("8"));
	keys.add(new JButton("9"));
	keys.add(new JButton("*"));
	keys.add(new JButton("0"));
	keys.add(new JButton("#"));

	//add key panel to center of this panel
	this.add(keys, BorderLayout.CENTER);
    }
}
