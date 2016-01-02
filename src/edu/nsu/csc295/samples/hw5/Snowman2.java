package edu.nsu.csc295.samples.hw5;

//********************************************************************
//  Snowman2.java       Author: Lewis/Loftus
//
//  Solution to Programming Project 2.14
//********************************************************************

import javax.swing.JApplet;
import java.awt.*;

public class Snowman2 extends JApplet
{
   //-----------------------------------------------------------------
   //  Draws a snowman with added features.
   //-----------------------------------------------------------------
   public void paint(Graphics page)
   {
      final int MID = 130;
      final int TOP = 50;

      setBackground(Color.cyan);

      page.setColor(Color.blue);
      page.fillRect(0, 175, 300, 50);  // ground

      page.setColor(Color.yellow);
      page.fillOval(260, -40, 80, 80);  // sun

      page.setColor(Color.white);
      page.fillOval(MID-20, TOP, 40, 40);      // head
      page.fillOval(MID-35, TOP+35, 70, 50);   // upper torso
      page.fillOval(MID-50, TOP+80, 100, 60);  // lower torso

      page.setColor(Color.red);
      page.fillOval(MID-3, TOP+50, 6, 6);  // button
      page.fillOval(MID-3, TOP+60, 6, 6);  // button

      page.setColor(Color.black);
      page.fillOval(MID-10, TOP+10, 5, 5);   // left eye
      page.fillOval(MID+5, TOP+10, 5, 5);    // right eye

      page.drawArc(MID-10, TOP+20, 20, 10, 10, 160);   // frown

      page.drawLine(MID-25, TOP+60, MID-50, TOP+40);  // left arm
      page.drawLine(MID+25, TOP+60, MID+55, TOP+60);  // right arm

      page.drawLine(MID-20, TOP+5, MID+20, TOP+5);  // brim of hat
      page.fillRect(MID-15, TOP-20, 30, 25);        // top of hat

      page.drawString("John Lewis", 20, 20);  // artist
   }
}
