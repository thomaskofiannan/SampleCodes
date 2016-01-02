package edu.nsu.csc295.samples.hw4;

//********************************************************************
//  PieChart.java       Author: Lewis/Loftus
//
//  Solution to Programming Project 2.21
//********************************************************************

import javax.swing.JApplet;
import java.awt.*;

public class PieChart extends JApplet
{
   //-----------------------------------------------------------------
   //  Draws the pie chart with equal sections.
   //-----------------------------------------------------------------
   public void paint(Graphics page)
   {
      setBackground(Color.lightGray);

      page.setColor(Color.blue);
      page.fillArc(70, 25, 100, 100, 0, 45);
      page.setColor(Color.yellow);
      page.fillArc(70, 25, 100, 100, 45, 45);
      page.setColor(Color.black);
      page.fillArc(70, 25, 100, 100, 90, 45);
      page.setColor(Color.green);
      page.fillArc(70, 25, 100, 100, 135, 45);
      page.setColor(Color.red);
      page.fillArc(70, 25, 100, 100, 180, 45);
      page.setColor(Color.magenta);
      page.fillArc(70, 25, 100, 100, 225, 45);
      page.setColor(Color.cyan);
      page.fillArc(70, 25, 100, 100, 270, 45);
      page.setColor(Color.orange);
      page.fillArc(70, 25, 100, 100, 315, 45);
   }
}
