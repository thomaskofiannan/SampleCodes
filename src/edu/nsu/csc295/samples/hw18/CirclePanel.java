package edu.nsu.csc295.samples.hw18;

// ******************************************************************
//   CirclePanel.java
//
//   A panel with a circle drawn in the center and buttons on the 
//   bottom that move the circle.
// ******************************************************************
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CirclePanel extends JPanel
{
    private final int CIRCLE_SIZE = 50;
    private int x,y;
    private Color c;

    JButton choose;

    int panelWidth, panelHeight;

    //---------------------------------------------------------------
    // Set up circle and buttons to move it.
    //---------------------------------------------------------------
    public CirclePanel(int width, int height)
    {
	// Store in instance variables so they'll be visible in MoveListener
	panelWidth = width;
	panelHeight = height;

	// Set coordinates so circle starts in middle
	x = (width/2)-(CIRCLE_SIZE/2);
	y = (height/2)-(CIRCLE_SIZE/2); 

	c = Color.green;

	// Need a border layout to get the buttons on the bottom
	this.setLayout(new BorderLayout());

	// Create buttons to move the circle
	JButton left = new JButton("Left");
	JButton right = new JButton("Right");
	JButton up = new JButton("Up");
	JButton down = new JButton("Down");

	// Create buttons to change circle's color; color them appropriately
	JButton yellow = new JButton("Yellow");
	JButton blue = new JButton("Blue");
	JButton red = new JButton("Red");
	JButton green = new JButton("Green");
	choose = new JButton("Choose Color");

	yellow.setBackground(Color.yellow);
	blue.setBackground(Color.blue);
	red.setBackground(Color.red);
	green.setBackground(Color.green);

	// Add listeners to the buttons
	left.addActionListener(new MoveListener(-20,0));
	right.addActionListener(new MoveListener(20,0));
	up.addActionListener(new MoveListener(0,-20));
	down.addActionListener(new MoveListener(0,20));

	yellow.addActionListener(new ColorListener(Color.yellow));
	blue.addActionListener(new ColorListener(Color.blue));
	red.addActionListener(new ColorListener(Color.red));
	green.addActionListener(new ColorListener(Color.green));
	choose.addActionListener(new ColorListener(null));

	// Need panels to put the buttons on or they'll be on
	// top of each other.
	JPanel buttonPanel = new JPanel();
	buttonPanel.add(left);
	buttonPanel.add(right);
	buttonPanel.add(up);
	buttonPanel.add(down);

	JPanel colorPanel = new JPanel();
	colorPanel.add(yellow);
	colorPanel.add(blue);
	colorPanel.add(choose);
	colorPanel.add(red);
	colorPanel.add(green);


	// Add the button panel to the bottom of the main panel,
	// the color panel to the top
	this.add(buttonPanel, "South");
	this.add(colorPanel, "North");
    }


    //---------------------------------------------------------------
    // Draw circle on CirclePanel
    //---------------------------------------------------------------
    public void paintComponent(Graphics page)
    {
	super.paintComponent(page);

	page.setColor(c);
	page.fillOval(x,y,CIRCLE_SIZE,CIRCLE_SIZE);
    }



    //---------------------------------------------------------------
    // Class to listen for button clicks that move circle.
    //---------------------------------------------------------------
    private class MoveListener implements ActionListener
    {
	private int dx;
	private int dy;

	//---------------------------------------------------------------
	// Parameters tell how to move circle at click.
	//---------------------------------------------------------------
	public MoveListener(int dx, int dy)
	{
	    this.dx = dx;
	    this.dy = dy;
	}

	//---------------------------------------------------------------
	// Change x and y coordinates and repaint.
	//---------------------------------------------------------------
	public void actionPerformed(ActionEvent e)
	{
	    x += dx;
	    y += dy;
	    repaint();
	}
    }


    //---------------------------------------------------------------
    // Class to listen for button clicks that change circle's color
    //---------------------------------------------------------------
    private class ColorListener implements ActionListener
    {

	Color circleColor;

	//---------------------------------------------------------------
	// Parameters tell how to color the circle.
	//---------------------------------------------------------------
	public ColorListener(Color color)
	{
	    circleColor = color;
	}

	//---------------------------------------------------------------
	// Change x and y coordinates and repaint.
	//---------------------------------------------------------------
	public void actionPerformed(ActionEvent e)
	{
	    if (circleColor == null)
		c = JColorChooser.showDialog(choose, "Pick a Color!", c);
	    else
		c = circleColor;
	    repaint();
	}
    }

}
