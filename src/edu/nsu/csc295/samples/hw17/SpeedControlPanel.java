package edu.nsu.csc295.samples.hw17;

// ******************************************************************
//   SpeedControlPanel.java
//
//   The panel for the bouncing ball applet.  Similar to 
//   ReboundPanel.java in Listing 8.16 in the text, except a circle
//   rather than a happy face is rebounding off the edges of the
//   applet window.
// ******************************************************************


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class SpeedControlPanel extends JPanel
{
    private final int WIDTH = 600;
    private final int HEIGHT = 400;
    private final int BALL_SIZE = 50;
    
    private Circle bouncingBall;   // the object that moves
    private Timer timer;
    private int moveX, moveY;      // increment to move each time

    JSlider speedSlider;
    JPanel sliderPanel;

    // ---------------------------------------------
    //  Sets up the panel, including the timer 
    //  for the animation
    // ---------------------------------------------
    public SpeedControlPanel ()
    {
	timer = new Timer(30, new ReboundListener());
      
	this.setLayout (new BorderLayout());

	bouncingBall = new Circle(BALL_SIZE);

	moveX = moveY = 5;   

	// Set up a slider object here
	speedSlider = new JSlider(JSlider.HORIZONTAL, 0, 200, 30);
	speedSlider.setMajorTickSpacing(40);
	speedSlider.setMinorTickSpacing(10);
	speedSlider.setPaintTicks(true);
	speedSlider.setPaintLabels(true);
	speedSlider.setAlignmentX(Component.LEFT_ALIGNMENT);

	speedSlider.addChangeListener(new SlideListener());

	JLabel speedLabel = new JLabel("Delay control");
	speedLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

	sliderPanel = new JPanel();
	sliderPanel.add(speedLabel);
	sliderPanel.add(speedSlider);

	this.add(sliderPanel, BorderLayout.SOUTH);

	setBackground(Color.black);
	setPreferredSize (new Dimension (WIDTH, HEIGHT));
	timer.start();
    }

    // --------------------
    // Draw the ball
    // --------------------
    public void paintComponent (Graphics page)
    {
	super.paintComponent (page);
        bouncingBall.draw(page);
    }


    // ***************************************************
    //   An action listener for the timer
    // ***************************************************
    public class ReboundListener implements ActionListener 
    {
	// ----------------------------------------------------
	// actionPerformed is called by the timer -- it updates
	// the position of the bouncing ball
	// ----------------------------------------------------
	public void actionPerformed(ActionEvent action)
	{
	    bouncingBall.move(moveX, moveY);
	    
  	    int sliderPanelHt = sliderPanel.getSize().height;

	    // change direction if ball hits a side
	    int x = bouncingBall.getX();
	    int y = bouncingBall.getY();
	    if (x < 0 || x >= WIDTH - BALL_SIZE)
		moveX = moveX * -1;
	
	    if (y <= 0 || y >= HEIGHT - BALL_SIZE - sliderPanelHt)
		moveY = moveY * -1;  
	    repaint();
	}
    }

    
    // *****************************************************
    //   A change listener for the slider.
    // *****************************************************
    private class SlideListener implements ChangeListener
    {
	// -------------------------------------------------
	//  Called when the state of the slider has changed;
	//  resets the delay on the timer.
	// -------------------------------------------------
	public void stateChanged (ChangeEvent event)
	{
	    timer.setDelay(speedSlider.getValue());
	}
    }
    

}
