/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package samparivartan;

/**
 *
 * @author nisheeth
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.JTextArea.*;
import java.awt.event.*;

import javax.swing.filechooser.*;
public class Sampu extends JFrame
{

   int flaga=0;
   int pflag=0;
   JFrame jf;
   int wlength;
   int mFlag=0;
   String previous="";
   int x=2;
   int y=15;
   String words[];
   int findex;
   int lindex;
   String syl[];
   JLabel inst;
   String sampText;
   String lastWord=new String();
   String trans = new String();
     Phonify p=new Phonify();
     FetchData fd=new FetchData();
      int caretStart;
    int caretEnd;
    JLabel naam;
   JFrame  f;
   JMenuBar menuBar;
   JLabel statusbar;
   JMenuItem item1;
   JMenuItem item2,item3, item4,item5,item6,bold,italic,color,bi;
    JTextArea ta;
     JPopupMenu Pmenu;
    JMenuItem menuItem1,menuItem2,menuItem3,menuItem4,menuItem5;

  //----------------------------------------------------------------------------------------------------------------------
 public  Sampu()
   {
      gui();
      ButtonHandler handler=new ButtonHandler();
      bold.addActionListener(handler);
      italic.addActionListener(handler);
      bi.addActionListener(handler);
      item1.addActionListener(handler);
      item2.addActionListener(handler);
      item3.addActionListener(handler);
      item4.addActionListener(handler);
      item5.addActionListener(handler);
      item6.addActionListener(handler);
      ta.addMouseListener(handler);
      ta.addKeyListener(handler);
      ta.addFocusListener(handler);
      jf.addFocusListener(handler);
     menuItem1.addActionListener(handler);
     menuItem2.addActionListener(handler);
     menuItem3.addActionListener(handler);
     menuItem4.addActionListener(handler);
    menuItem5.addActionListener(handler);

}
//---------------------------------------------------------------------------------------------------------------------
      void gui( )
    {

               f =new JFrame("Samparivartan");
              f.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));
            //-------------MENU BAR------------------------------
              menuBar=new JMenuBar();
              f.setJMenuBar(menuBar);
              JMenu h2=new JMenu("Edit");
             JMenu h1=new JMenu("Help");
             JMenu h3=new JMenu("Format");
             JMenu h4=new JMenu("Typing Instruction");
              menuBar.add(h2);
              menuBar.add(h1);
              menuBar.add(h3);
              menuBar.add(h4);
              h3.setMnemonic('F');
              h1.setMnemonic('H');
              h2.setMnemonic('E');
              h4.setMnemonic('T');
             JMenuItem item;
             item1 =h1.add("About Samparivartan");
             item2 =h1.add("Samparivartan Help");
             item3 =h2.add("Cut");
             item4 =h2.add("Copy");
             item5 =h2.add("Paste");
             item6 =h4.add("Read Me");

               bold=h3.add("Bold");
               italic=h3.add("Italic");
               bi=h3.add("B&I");
               color=h3.add("Color");

//----------------------------------LABELS--------------------------------------------------------------
           //   String c="\u0938\u092E\u094D\u092A\u0930\u093F\u0935\u0930\u094D\u0924\u0928                                   ";
              String c=("Samparivartan");

             JLabel lbl1=new JLabel(c) ;
              f.getContentPane().add(lbl1);
              Font fo=new Font("SAMPARIVARTAN                 ",Font.ITALIC,70);
              lbl1.setFont(fo);
             String s=new String("\n\nA Word Based Predictive Input System for Hindi");
              naam=new JLabel(s);
               f.getContentPane().add(naam);

              JLabel lbl2=new JLabel("Enter your English transliterated text here          \n\n\n\n\n\n\n\n\n\n\n\n\n\n                                                                                                                                                                                                                                                                    ");

                f.getContentPane().add(lbl2);

//----------------------------------BUTTONS----------------------------------------------------------------





     //----------------------------------color palet -------------------------------------------------

             color.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent ae){
            Color c;
            c=JColorChooser.showDialog(((Component)ae.getSource()).getParent(),"Choose Color",Color.black);



             ta.setForeground(c);

              }});

               ta=new JTextArea(40,80);
               ta.setLineWrap(true);
               ta.setWrapStyleWord(true);
               ta.setBorder(BorderFactory.createLineBorder(Color.black));
              f.getContentPane().add(ta);





//--------------------------------------------------------------------



//---------------------------------------------------------------------------------------------------------

f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.pack();
f.setVisible(true);
}





String getLastWord()
 {

  lindex =sampText.lastIndexOf(' ');


 findex=lindex-1;
 while(( findex >= 0)&&(sampText.charAt(findex)!=' '))
{
       findex--;
}

int f=findex+1;
int l=lindex;





return sampText.substring(f,l);

}


String getLastLetters()
{
   System.out.println(sampText);
    lindex=sampText.length();
   findex=lindex-1;
 while(( findex >= 0)&&(sampText.charAt(findex)!=' '))
{
       findex--;
}

int f=findex+1;
int l=lindex;
return sampText.substring(f,l);

}


//---------------------------------------------MOUSE ACTIONS-----------------------------------------------
private class ButtonHandler  implements ActionListener,MouseListener,MouseMotionListener,KeyListener ,FocusListener // CaretListener

{


    public void focusGained(FocusEvent fe)
    {   }
    public void lostFocus(FocusEvent fe)
    {   }
      public void focusLost(FocusEvent fe)
    {
          if(fe.getSource()!=jf)
            ta.requestFocus();
          else
              jf.requestFocus();
                 }


     public void  keyTyped(KeyEvent ke)
 {
     wlength=0;
     char c;

      words=new String[5];

      Pmenu =new JPopupMenu();

    if((ke.getKeyChar()!=' '))
   {    mFlag=0;
        sampText=ta.getText();
       sampText.toLowerCase();
        c=ke.getKeyChar();
        sampText+=String.valueOf(c);
         lastWord=getLastLetters();
        System.out.println(lastWord);
     words=fd.highFreqWords(lastWord);

  }


 if((ke.getKeyChar()!=' '))
 {

     menuItem1 = new JMenuItem(words[0]);
    Pmenu.add(menuItem1);
       menuItem1.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
      int f=findex+1;
     int l=lindex;
      ta.replaceRange(null,f,l);
     ta.append(String.valueOf(words[0]));
     mFlag=1;
     wlength=String.valueOf(words[0]).length();
     x+=wlength*4;
    }
   });
    menuItem2 = new JMenuItem(words[1]);
    Pmenu.add(menuItem2);
     menuItem2.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
      int f=findex+1;
     int l=lindex;
      ta.replaceRange(null,f,l);
     ta.append(String.valueOf(words[1]));
    mFlag=1;
    wlength=String.valueOf(words[1]).length();
     x+=wlength*4;
    }
   });
    menuItem3 = new JMenuItem(words[2]);
    Pmenu.add(menuItem3);
     menuItem3.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
      int f=findex+1;
     int l=lindex;
      ta.replaceRange(null,f,l);
     ta.append(String.valueOf(words[2]));
    mFlag=1;
    wlength=String.valueOf(words[2]).length();
     x+=wlength*4;
    }
   });
    menuItem4 = new JMenuItem(words[3]);
    Pmenu.add(menuItem4);
     menuItem4.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
      int f=findex+1;
     int l=lindex;
      ta.replaceRange(null,f,l);
     ta.append(String.valueOf(words[3]));
     mFlag=1;
     wlength=String.valueOf(words[3]).length();
     x+=wlength*4;
    }
   });

    menuItem5 = new JMenuItem(words[4]);
    Pmenu.add(menuItem5);
    menuItem5.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
      int f=findex+1;
     int l=lindex;
      ta.replaceRange(null,f,l);
     ta.append(String.valueOf(words[4]));
     mFlag=1;
     wlength=String.valueOf(words[4]).length();
     x+=wlength*4;
}
      });


   Pmenu.show(ke.getComponent(),x,y);
   if((words[0]==null)&&(words[1]==null)&&(words[2]==null)&&(words[3]==null)&&(words[4]==null))
            Pmenu.setVisible(false);



   }





    if((ke.getKeyChar())==(' ')&&(mFlag==0))
     {                     c=ke.getKeyChar();
                    sampText=ta.getText();

                     if (sampText.charAt(sampText.length()-1)!=' ')
    {
                 sampText+=String.valueOf(c);


                lastWord=getLastWord();
                lastWord=  String.valueOf(lastWord.toLowerCase());
                    System.out.println( lastWord);
                   if ( (lastWord !=" ") && (lastWord !=null))
                     {

	    trans=p.phonify(lastWord);

                         int f=findex+1;
	       int l=lindex;

                        ta.replaceRange(null,f,l);
	      ta.append(String.valueOf(trans));
                    String s=ta.getText();

	  wlength=String.valueOf(trans).length();
                   x+=wlength*4;
        }
    }
     }

      x+=3;

    if(x>=880)
    {
      y+=15;
      x=2;
      System.out.println(wlength);
    }
}


   public void  keyPressed(KeyEvent ke) {


   }
   public void  keyReleased(KeyEvent ke) {


    }


public void mouseClicked(MouseEvent me) {


           System.out.println(me.getX());
            System.out.println(me.getY());


                                   }
 public void mouseEntered(MouseEvent me) { }
 public void mouseExited(MouseEvent me) { }
public void mouseMoved(MouseEvent e){}
public void mouseDragged(MouseEvent e)
{
      try{
 ta.getHighlighter().addHighlight(caretStart,caretEnd,DefaultHighlighter.DefaultPainter);
}
catch(BadLocationException ev)
{
}
}
 public void mouseReleased(MouseEvent me) {



         caretEnd=ta.getCaretPosition();
        }
public void mousePressed(MouseEvent me)
{

 caretStart=ta.getCaretPosition();

}

public void actionPerformed(ActionEvent ae)
{
   Font fn=ta.getFont();
    int fontStyle=fn.getStyle();
     Font newtextAreaFont;



     if (ae.getSource()==bold)
{
     if((fontStyle & Font.BOLD)== Font.BOLD)
         newtextAreaFont=new Font(ta.getFont().getName(),Font.PLAIN,ta.getFont().getSize());
    else
     newtextAreaFont=new Font(ta.getFont().getName(),Font.BOLD,ta.getFont().getSize());
      ta.setFont(newtextAreaFont);
}

 if (ae.getSource()==italic)
{
   if((fontStyle & Font.ITALIC)== Font.ITALIC)
         newtextAreaFont=new Font(ta.getFont().getName(),Font.PLAIN,ta.getFont().getSize());
    else
     newtextAreaFont=new Font(ta.getFont().getName(),Font.ITALIC,ta.getFont().getSize());
      ta.setFont(newtextAreaFont);
}



 if (ae.getSource()==bi)
{
   if((fn.isItalic())&&(fn.isBold()))
         newtextAreaFont=new Font(ta.getFont().getName(),Font.PLAIN,ta.getFont().getSize());
    else
     newtextAreaFont=new Font(ta.getFont().getName(),Font.ITALIC + Font.BOLD,ta.getFont().getSize());
      ta.setFont(newtextAreaFont);
}





int x;

//-------------------------help-------------------------------------------------------------
 if (ae.getSource()==item1)
 {
    String st=" Samparivartan Version 0.1\nCopyright  2012-2013\nNisheeth Joshi";

  JOptionPane.showMessageDialog(null, st,"About Samparivartan",JOptionPane.INFORMATION_MESSAGE);

 }


if (ae.getSource()==item2)
 {
   String st="Next";

  JOptionPane.showMessageDialog(null, st,"About Samparivartan",JOptionPane.INFORMATION_MESSAGE);
      jf=new JFrame("Samparivartan Help");
    jf.setVisible(true);
    jf.setSize(350,350);

    JTextArea txtArea;
    txtArea=new JTextArea(20,30);
     txtArea.setLineWrap(true);
     txtArea.setBackground(Color.black);
     txtArea.setForeground(Color.white);
     txtArea.setWrapStyleWord(true);
      jf.getContentPane().add(new JScrollPane(txtArea));



      txtArea.setText("Samparivartan  is a Hindi typing tool. Now it is very easy to type in Hindi. For example, type aap kaise hain in the text field below. Samparivartan will convert Roman characters to the Devanagri  characters used in Hindi.This lets you type Hindi words phonetically in English script and still have them appear in their correct alphabet. Note that this is not the same as translation , it is the sound of the words that are converted from one alphabet to the other, not their meaning.\n Samparivartan helps you intelligently in a way that it provides the user with a prediction list of hindi words.from which user can select his or her intended words.\n\nFrequently Asked Questions\n\n1 How do I use transliteration to type in Hindi?\nThe user starts tying a word in roman character sequence. After each character of the word, a prediction list of the possible words starting from the character typed is popped up.The user can select desired list from the list. If not found then as soon as you type a space or a punctuation mark, the letters will be converted to Devanagri characters.\n\n2  Does my system support transliteration?\n The transliteration feature is only supported higher on Windows (preferably Windows XP), UNIX and Linux.\n\n3 How do I install and view Hindi fonts correctly?\n The Transliteration page uses Unicode to encode the Hindi characters in your post. Unicode is a system of representing text and symbols and is supported by all modern browsers and operating systems.\n\n If the two images displayed below do not match, then you need to either enable complex script layout support or install Unicode fonts.\n\n4 Will transliteration work even without internet connectivity?\n Samparivartan is a software tool. Once installed in your system, it does NOT requires any internet connection.");




     txtArea.setEditable(false);
 }
//-----------------------cut,copy ,paste,select,select all--------------------------------------------
if (ae.getSource()==item3)
{

 ta.setCaretPosition(caretStart);
ta.moveCaretPosition(caretEnd);
if(caretStart<caretEnd)
ta.select(caretStart,caretEnd);
else
ta.select(caretEnd,caretStart);
ta.cut();

}
 if (ae.getSource()==item4)
{
ta.setCaretPosition(caretStart);
ta.moveCaretPosition(caretEnd);

if(caretStart<caretEnd)
ta.select(caretStart,caretEnd);
else
ta.select(caretEnd,caretStart);
ta.copy();
}
 if (ae.getSource()==item5)
{
ta.paste();
}
if (ae.getSource()==item6)
{
   String st=" aa=\u093E  \n i=\u093F \n ee=\u0940 \nu=\u0941 \noo=\u0942 \ne=\u0947 \nai=\u0948 \no=\u094B \nau=\u094C \nan=\u0902\nSome special characters like\nchha for \u091B\ntta for\u091F \nttha for \u0920\ndda for \u0921\nddha for \u0922\nssa for \u0937\nWrite x for writing half Hindi letter like satxya for \u0938\u0924\u094D\u092F";



  JOptionPane.showMessageDialog(null, st,"Instructions",JOptionPane.INFORMATION_MESSAGE);

}



//--------------------------------------------file--------------------------------------------




 }








}


}


