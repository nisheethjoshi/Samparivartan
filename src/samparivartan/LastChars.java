/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package samparivartan;

/**
 *
 * @author nisheeth
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LastChars implements KeyListener
{
    static JTextArea ta;
    static JFrame f;
   public static void main(String args[])
  {
            f=new JFrame("Test");
            f.getContentPane();
            ta=new JTextArea();
             f.add(ta);
//              ta.addKeyListener(this);
              f.setVisible(true);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 }
             public void keyTyped(KeyEvent ke)
              {
                String match;
                 String last;
                   match=ta.getText();
                 last=getLastLetters(match);
               System.out.println(last);
          }
           public void keyPressed(KeyEvent ke)
              {}

               public void keyReleased(KeyEvent ke)
              {}

static String getLastLetters(String sampText)
{
   int findex=0;
    int lindex=0;

  lindex=sampText.length()-1;
  findex=lindex;
   while((findex>=0)&&(sampText.charAt(findex)!=' '))
   findex--;
   return(sampText.substring(findex,lindex));
}
}