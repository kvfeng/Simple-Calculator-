/**
 * @author Kevin Feng
 * @version 10/29/16
 * This program is a simple GUI calculator which helps the user perform basic
 * arithmetic operations, exponents, and square root functions. 
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class SimpleCalc extends JApplet 
{
   public void init() 
   {
      SimpleCalcPanel calc = new SimpleCalcPanel();
      getContentPane().add(calc);
   }
}

   class SimpleCalcPanel extends JPanel implements ActionListener {
      JButton n0,n1,n2,n3,n4,n5,n6,n7,n8,n9,reset,square,root,percent,divide,plus,minus,multiply,dot,equal;
      
      static JTextField result = new JTextField("0",45);
      
      static String lastCommand = null;
      
      JOptionPane p = new JOptionPane();
      
      double firstval = 0, secVal = 0, res;
      
     
      private static void assign(String no)
        {
         if((result.getText()).equals("0"))
            result.setText(no);
          else if(lastCommand=="=")
           {
            result.setText(no);
            lastCommand=null;
           }
          else
            result.setText(result.getText()+no);
         }

      public SimpleCalcPanel() {
         setLayout(new BorderLayout());
         result.setEditable(false);
         result.setSize(300,200);
         add(result,BorderLayout.NORTH);
         JPanel panel=new JPanel();
         panel.setLayout(new GridLayout(5,4));
         Color num = Color.GRAY;
         Color ops = Color.ORANGE;
         
         n7=new JButton("7");
         n7.setBackground(num);
         n7.setOpaque(true);
         panel.add(n7);
         n7.addActionListener(this);
         n8=new JButton("8");
         n8.setBackground(num);
         n8.setOpaque(true);
         panel.add(n8);
         n8.addActionListener(this);
         n9=new JButton("9");
         n9.setBackground(num);
         n9.setOpaque(true);
         panel.add(n9);
         n9.addActionListener(this);
         divide=new JButton("/");
         divide.setBackground(ops);
         divide.setOpaque(true);
         panel.add(divide);
         divide.addActionListener(this);
         
         n4=new JButton("4");
         n4.setBackground(num);
         n4.setOpaque(true);
         panel.add(n4);
         n4.addActionListener(this);
         n5=new JButton("5");
         n5.setBackground(num);
         n5.setOpaque(true);
         panel.add(n5);
         n5.addActionListener(this);
         n6=new JButton("6");
         n6.setBackground(num);
         n6.setOpaque(true);
         panel.add(n6);
         n6.addActionListener(this);
         multiply=new JButton("*");
         multiply.setBackground(ops);
         multiply.setOpaque(true);
         panel.add(multiply);
         multiply.addActionListener(this);

         n1=new JButton("1");
         n1.setBackground(num);
         n1.setOpaque(true);
         panel.add(n1);
         n1.addActionListener(this);
         n2=new JButton("2");
         n2.setBackground(num);
         n2.setOpaque(true);
         panel.add(n2);
         n2.addActionListener(this);
         n3=new JButton("3");
         n3.setBackground(num);
         n3.setOpaque(true);
         panel.add(n3);
         n3.addActionListener(this);
         minus=new JButton("-");
         minus.setBackground(ops);
         minus.setOpaque(true);
         panel.add(minus);
         minus.addActionListener(this);

         dot=new JButton(".");
         dot.setBackground(num);
         dot.setOpaque(true);
         panel.add(dot);
         dot.addActionListener(this);
         n0=new JButton("0");
         n0.setBackground(num);
         n0.setOpaque(true);
         panel.add(n0);
         n0.addActionListener(this);
         equal=new JButton("=");
         equal.setBackground(num);
         equal.setOpaque(true);
         panel.add(equal);
         equal.addActionListener(this);
         plus=new JButton("+");
         plus.setBackground(ops);
         plus.setOpaque(true);
         panel.add(plus);
         plus.addActionListener(this);
         
         reset = new JButton("Reset");
         reset.setBackground(num);
         reset.setOpaque(true);
         panel.add(reset);
         reset.addActionListener(this);
         
         square = new JButton("x^2");
         square.setBackground(num);
         square.setOpaque(true);
         panel.add(square);
         square.addActionListener(this);
         
         root = new JButton("√x");
         root.setBackground(num);
         root.setOpaque(true);
         panel.add(root);
         root.addActionListener(this);
         
         percent = new JButton("%");
         percent.setBackground(ops);
         percent.setOpaque(true);
         panel.add(percent);
         percent.addActionListener(this);
         
         add(panel,BorderLayout.CENTER);
         
         
      }
      public void actionPerformed(ActionEvent execute)
      {
          if(execute.getSource()==n1)
                assign("1");
            else if(execute.getSource()==n2) 
                assign("2");
            else if(execute.getSource()==n3)
                assign("3");
            else if(execute.getSource()==n4)
                assign("4");
            else if(execute.getSource()==n5)
                assign("5");
            else if(execute.getSource()==n6)
                assign("6");
            else if(execute.getSource()==n7)
                assign("7");
            else if(execute.getSource()==n8)
                assign("8");
            else if(execute.getSource()==n9)
                assign("9");
            else if(execute.getSource()==n0)
                assign("0");
            else if(execute.getSource()==dot)
            {
                if(((result.getText()).indexOf("."))==-1)
                    result.setText(result.getText()+".");
            }
            else if(execute.getSource()==minus)
             {
                 firstval=Double.parseDouble(result.getText());
                 lastCommand="-";
                 result.setText("0");
             }
            else if(execute.getSource()==divide)
             {
                 firstval=Double.parseDouble(result.getText());
                 lastCommand="/";
                 result.setText("0");
             }
            else if(execute.getSource()==equal)
             {
               secVal=Double.parseDouble(result.getText());
                 if(lastCommand.equals("/"))
                    res=firstval/secVal;
                    else if(lastCommand.equals("*"))
                        res=firstval*secVal;
                    else if(lastCommand.equals("-"))
                        res=firstval-secVal;
                    else if(lastCommand.equals("+"))
                        res=firstval+secVal;
               result.setText(" "+res);
               lastCommand="=";
             }
            else if(execute.getSource()==multiply)
             {
              firstval=Double.parseDouble(result.getText());
              lastCommand="*";
              result.setText("0");
              }
            else if(execute.getSource()==plus)
              {
              firstval=Double.parseDouble(result.getText());
              lastCommand = "+";
              result.setText("0");
              }
            else if (execute.getSource()==reset)
              {
              lastCommand = "";
              result.setText("0");
              }
            else if (execute.getSource()==square)
              {
                firstval=Double.parseDouble(result.getText()); 
                firstval *= firstval;
                result.setText(firstval + "");
              }
            else if (execute.getSource()==root)
              {
               firstval=Double.parseDouble(result.getText());
               firstval = Math.sqrt(firstval);
               result.setText(firstval + "");
              }
            else if (execute.getSource()==percent)
              { 
                  firstval=Double.parseDouble(result.getText());
                  firstval = firstval/100.0;
                  result.setText(firstval + "");
              }
       }
 }
