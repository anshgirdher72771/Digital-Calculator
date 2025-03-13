package DigitalCalculatorProject;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
class DigitalCalculator extends JFrame{
    JLabel l1;
    JTextField t1;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20;

    Font f1 = new Font("Times New Roman",Font.BOLD,15);
    Font f2 = new Font("Algerian",Font.BOLD,22);
    Font f3 = new Font("Bernard MT Condensed",Font.BOLD,25);
    LineBorder border1 = new LineBorder(Color.black);

    DigitalCalculator(String s1){
        super(s1);
        setLayout(null);
        l1 = new JLabel("Digital Calculaor");
        add(l1);
        l1.setFont(f2);
        l1.setForeground(Color.black);
        l1.setBounds(80,0,300,100);

        t1 = new JTextField();
        add(t1);
        t1.setBounds(0,80,400,100);
        t1.setBackground(Color.lightGray);
        t1.setBorder(border1);
        t1.setFont(f3);

        //First Row of Button
        b1 = new JButton("AC");
        add(b1);
        b1.setBounds(20,200,60,50);
        b1.setBackground(Color.white);
        b1.setForeground(Color.orange);
        b1.addActionListener(new Ac());

        b2 = new JButton("DEL");
        add(b2);
        b2.setBounds(110,200,60,50);
        b2.setBackground(Color.white);
        b2.setForeground(Color.orange);
        b2.addActionListener(new Del());


        b3 = new JButton("%");
        add(b3);
        b3.setBounds(200,200,60,50);
        b3.setBackground(Color.white);
        b3.setForeground(Color.orange);
        b3.addActionListener(new Percentage());

        b4 = new JButton("/");
        add(b4);
        b4.setBounds(290,200,60,50);
        b4.setBackground(Color.white);
        b4.setForeground(Color.orange);
        b4.addActionListener(new Division());

        //Second Row of Button
        b5 = new JButton("7");
        add(b5);
        b5.setBounds(20,270,60,50);
        b5.addActionListener(new Seven());

        b6 = new JButton("8");
        add(b6);
        b6.setBounds(110,270,60,50);
        b6.addActionListener(new Eight());

        b7 = new JButton("9");
        add(b7);
        b7.setBounds(200,270,60,50);
        b7.addActionListener(new Nine());

        b8 = new JButton("*");
        add(b8);
        b8.setBounds(290,270,60,50);
        b8.setBackground(Color.white);
        b8.setForeground(Color.orange);
        b8.addActionListener(new Multiply());


        //Third Row of Button
        b9 = new JButton("4");
        add(b9);
        b9.setBounds(20,340,60,50);
        b9.addActionListener(new Four());

        b10 = new JButton("5");
        add(b10);
        b10.setBounds(110,340,60,50);
        b10.addActionListener(new Five());

        b11= new JButton("6");
        add(b11);
        b11.setBounds(200,340,60,50);
        b11.addActionListener(new Six());

        b12 = new JButton("-");
        add(b12);
        b12.setBounds(290,340,60,50);
        b12.setBackground(Color.white);
        b12.setForeground(Color.orange);
        b12.addActionListener(new Substraction());

        //Fourth Row of Button
        b13 = new JButton("1");
        add(b13);
        b13.setBounds(20,410,60,50);
        b13.addActionListener(new One());

        b14 = new JButton("2");
        add(b14);
        b14.setBounds(110,410,60,50);
        b14.addActionListener(new Two());

        b15= new JButton("3");
        add(b15);
        b15.setBounds(200,410,60,50);
        b15.addActionListener(new Three());

        b16 = new JButton("+");
        add(b16);
        b16.setBounds(290,410,60,50);
        b16.setBackground(Color.white);
        b16.setForeground(Color.orange);
        b16.addActionListener(new Addition());

        //Fifth Row of Button
        b17 = new JButton("00");
        add(b17);
        b17.setBounds(20,480,60,50);
        b17.addActionListener(new ZeroZero());

        b18 = new JButton("0");
        add(b18);
        b18.setBounds(110,480,60,50);
        b18.addActionListener(new Zero());

        b19= new JButton(".");
        add(b19);
        b19.setBounds(200,480,60,50);
        b19.addActionListener(new FullStop());

        b20 = new JButton("=");
        add(b20);
        b20.setBounds(290,480,60,50);
        b20.setBackground(Color.orange);
        b20.setForeground(Color.white);
        b20.addActionListener(new EqualTo());



        setVisible(true);
        setSize(400,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.GRAY);

        // Request focus for the text field
        t1.requestFocusInWindow();
    }

    class Ac implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            t1.setText(" ");
        }
    }

    class Del implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String currentText = t1.getText(); // Get the current text from the text field
            if (!currentText.isEmpty()) { // Check if the text is not empty
                // Remove the last character
                String newText = currentText.substring(0, currentText.length() - 1);
                t1.setText(newText); // Update the text field
            }
        }
    }
    class Seven implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String str1 = t1.getText();
            t1.setText(str1+"7");
            t1.setForeground(Color.black);


        }
    }

    class Eight implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String str1 = t1.getText();
            t1.setText(str1+"8");
            t1.setForeground(Color.black);


        }
    }
    class Percentage implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String str1 = t1.getText();
            t1.setText(str1+"%");
            t1.setForeground(Color.black);
        }
    }

    class Division implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String str1 = t1.getText();
            t1.setText(str1+"/");
            t1.setForeground(Color.black);
        }
    }

    class Nine implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String str1 = t1.getText();
            t1.setText(str1+"9");
            t1.setForeground(Color.black);
        }
    }

    class Multiply implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String str1 = t1.getText();
            t1.setText(str1+"*");
            t1.setForeground(Color.black);
        }
    }

    class Four implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String str1 = t1.getText();
            t1.setText(str1+"4");
            t1.setForeground(Color.black);
        }
    }

    class Five implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String str1 = t1.getText();
            t1.setText(str1+"5");
            t1.setForeground(Color.black);
        }
    }

    class Six implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String str1 = t1.getText();
            t1.setText(str1+"6");
            t1.setForeground(Color.black);
        }
    }

    class Substraction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String str1 = t1.getText();
            t1.setText(str1+"-");
            t1.setForeground(Color.black);
        }
    }

    class One implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String str1 = t1.getText();
            t1.setText(str1+"1");
            t1.setForeground(Color.black);
        }
    }

    class Two implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String str1 = t1.getText();
            t1.setText(str1+"2");
            t1.setForeground(Color.black);
        }
    }

    class Three implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String str1 = t1.getText();
            t1.setText(str1+"3");
            t1.setForeground(Color.black);
        }
    }
    class Addition implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String str1 = t1.getText();
            t1.setText(str1+"+");
            t1.setForeground(Color.black);
        }
    }

    class ZeroZero implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String str1 = t1.getText();
            t1.setText(str1+"00");
            t1.setForeground(Color.black);
        }
    }

    class Zero implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String str1 = t1.getText();
            t1.setText(str1+"0");
            t1.setForeground(Color.black);
        }
    }

    class FullStop implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String str1 = t1.getText();
            t1.setText(str1+".");
            t1.setForeground(Color.black);
        }
    }

    class EqualTo implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String expression = t1.getText();
            try {
                // Use exp4j to evaluate the expression
                Expression exp = new ExpressionBuilder(expression).build();
                double result = exp.evaluate();
                t1.setText(Double.toString(result));
                t1.setForeground(Color.green);
            } catch (IllegalArgumentException ex) {
                t1.setText("Error: Invalid Expression");
            } catch (ArithmeticException ex) {
                t1.setText("Error: Math Error");
            }
        }

    }

}

public class DigitalCal {
    public static void main(String[] args) {
        DigitalCalculator user = new DigitalCalculator("Digital Calculator by Ansh Girdher");

    }
}
