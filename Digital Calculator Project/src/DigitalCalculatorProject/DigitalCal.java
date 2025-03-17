package DigitalCalculatorProject;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

class DigitalCalculator extends JFrame{
    final String Version = "1.0.1";
    double result;
    JLabel l1,History, Memory;
    JTextField t1;
    JTextPane HistoryText;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21;

    Font f1 = new Font("Times New Roman",Font.BOLD,17);
    Font f2 = new Font("Algerian",Font.BOLD,22);
    Font f3 = new Font("Bernard MT Condensed",Font.BOLD,38);
    Font f4 = new Font("Bernard MT Condensed",Font.BOLD,32);
    LineBorder border1 = new LineBorder(Color.black);
    List<String> historyList = new ArrayList<>();

    DigitalCalculator(String s1){
        super(s1);
        ImageIcon i1 = new ImageIcon("C:\\Program Files (x86)\\Digital Calculator\\icon1.png");
        setIconImage(i1.getImage());
        setLayout(null);
        l1 = new JLabel("Digital Calculator");
        add(l1);
        l1.setFont(f2);
        l1.setForeground(Color.black);
        l1.setBounds(71,0,300,100);

            History = new JLabel("History");
            add(History);
            History.setBounds(380,-2,100,50);
            History.setForeground(Color.BLACK);
            History.setFont(f1);
            History.addMouseListener(new History());

            HistoryText = new JTextPane();
        HistoryText.setContentType("text/html"); // Enable HTML formatting
        HistoryText.setEditable(false); // Make it read-only
        HistoryText.setBackground(Color.lightGray);
        HistoryText.setText("<html>There's no history yet</html>");


        // Wrap JTextArea in a JScrollPane
        JScrollPane scrollPane = new JScrollPane(HistoryText);
        scrollPane.setBounds(380, 40, 290, 450); // Adjust size as needed
        add(scrollPane);

            Memory = new JLabel("Memory");
            add(Memory);
            Memory.setBounds(450,-2,100,50);
            Memory.setForeground(Color.black);
            Memory.setFont(f1);
            Memory.addMouseListener(new Memory());



        t1 = new JTextField();
        add(t1);
        t1.setBounds(5,80,350,90);
        t1.setBackground(Color.lightGray);
        t1.setBorder(border1);
        t1.setFont(f3);

        //First Row of Button
        b1 = new JButton("AC");
        add(b1);
        b1.setBounds(20,200,60,50);
        b1.setBackground(Color.ORANGE);
        b1.setForeground(Color.white);
        b1.addActionListener(new Ac());

        b2 = new JButton("DEL");
        add(b2);
        b2.setBounds(110,200,60,50);
        b2.setBackground(Color.ORANGE);
        b2.setForeground(Color.white);
        b2.addActionListener(new Del());


        b3 = new JButton("%");
        add(b3);
        b3.setBounds(200,200,60,50);
        b3.setBackground(Color.ORANGE);
        b3.setForeground(Color.white);
        b3.addActionListener(new Percentage());

        b4 = new JButton("/");
        add(b4);
        b4.setBounds(290,200,60,50);
        b4.setBackground(Color.ORANGE);
        b4.setForeground(Color.WHITE);
        b4.addActionListener(new Division());
        b4.addMouseListener(new MED());

        //Second Row of Button
        b5 = new JButton("7");
        add(b5);
        b5.setBounds(20,270,60,50);
        b5.addActionListener(new Seven());
        b5.addMouseListener(new ME7());

        b6 = new JButton("8");
        add(b6);
        b6.setBounds(110,270,60,50);
        b6.addActionListener(new Eight());
        b6.addMouseListener(new ME8());

        b7 = new JButton("9");
        add(b7);
        b7.setBounds(200,270,60,50);
        b7.addActionListener(new Nine());
        b7.addMouseListener(new ME9());

        b8 = new JButton("*");
        add(b8);
        b8.setBounds(290,270,60,50);
        b8.setBackground(Color.ORANGE);
        b8.setForeground(Color.WHITE);
        b8.addActionListener(new Multiply());
        b8.addMouseListener(new MEM());


        //Third Row of Button
        b9 = new JButton("4");
        add(b9);
        b9.setBounds(20,340,60,50);
        b9.addActionListener(new Four());
        b9.addMouseListener(new ME4());

        b10 = new JButton("5");
        add(b10);
        b10.setBounds(110,340,60,50);
        b10.addActionListener(new Five());
        b10.addMouseListener(new ME5());

        b11= new JButton("6");
        add(b11);
        b11.setBounds(200,340,60,50);
        b11.addActionListener(new Six());
        b11.addMouseListener(new ME6());

        b12 = new JButton("-");
        add(b12);
        b12.setBounds(290,340,60,50);
        b12.setBackground(Color.ORANGE);
        b12.setForeground(Color.WHITE);
        b12.addActionListener(new Substraction());
        b12.addMouseListener(new MES());

        //Fourth Row of Button
        b13 = new JButton("1");
        add(b13);
        b13.setBounds(20,410,60,50);
        b13.addActionListener(new One());
        b13.addMouseListener(new ME1());

        b14 = new JButton("2");
        add(b14);
        b14.setBounds(110,410,60,50);
        b14.addActionListener(new Two());
        b14.addMouseListener(new ME2());

        b15= new JButton("3");
        add(b15);
        b15.setBounds(200,410,60,50);
        b15.addActionListener(new Three());
        b15.addMouseListener(new ME3());

        b16 = new JButton("+");
        add(b16);
        b16.setBounds(290,410,60,50);
        b16.setBackground(Color.ORANGE);
        b16.setForeground(Color.WHITE);
        b16.addActionListener(new Addition());
        b16.addMouseListener(new MEA());

        //Fifth Row of Button
        b17 = new JButton("00");
        add(b17);
        b17.setBounds(20,480,60,50);
        b17.addActionListener(new ZeroZero());
        b17.addMouseListener(new ME00());

        b18 = new JButton("0");
        add(b18);
        b18.setBounds(110,480,60,50);
        b18.addActionListener(new Zero());
        b18.addMouseListener(new ME0());

        b19= new JButton(".");
        add(b19);
        b19.setBounds(200,480,60,50);
        b19.addActionListener(new FullStop());
        b19.addMouseListener(new MEFullStop());

        b20 = new JButton("=");
        add(b20);
        b20.setBounds(290,480,60,50);
        b20.setBackground(Color.orange);
        b20.setForeground(Color.white);
        b20.addActionListener(new EqualTo());

        b21 = new JButton("Clear");
        add(b21);
        b21.setBounds(560,520,100,30);
        b21.setBackground(Color.orange);
        b21.setForeground(Color.white);
        b21.addActionListener(new Clear());

        bindKeyboardKeys();

        setVisible(true);
        setSize(700,600);
        setLocation(300,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.GRAY);

        // Request focus for the text field
        t1.requestFocusInWindow();
    }
    class Clear implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // Clear the history list
            historyList.clear();
            // Update the HistoryText label to indicate no history
            HistoryText.setText("<html>There's no history yet</html>");
        }
    }

    class History implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            if (historyList.isEmpty()) {
                HistoryText.setText("<html>There's no history yet</html>");
            } else {
                StringBuilder history = new StringBuilder("<html>");
                for (String entry : historyList) {
                    history.append(entry).append("<br>");
                }
                history.append("</html>");
                HistoryText.setText(history.toString());
            }


        }
        @Override
        public void mouseEntered(MouseEvent e) {
            History.setForeground(Color.green);

        }
        @Override
        public void mouseExited(MouseEvent e) {
        History.setForeground(Color.black);
        }
        @Override
        public void mouseReleased(MouseEvent e) {


        }
        @Override
        public void mousePressed(MouseEvent e) {

        }
    }
    class Memory implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
 HistoryText.setText("<html>There's nothing saved in your memory</html>");
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            Memory.setForeground(Color.green);

        }
        @Override
        public void mouseExited(MouseEvent e) {
            Memory.setForeground(Color.black);
        }
        @Override
        public void mouseReleased(MouseEvent e) {

        }
        @Override
        public void mousePressed(MouseEvent e) {

        }
    }
    class MEFullStop implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            String str = t1.getText();
            t1.setText(str+".");
        }
        @Override
        public void mouseEntered(MouseEvent e) {

        }
        @Override
        public void mouseExited(MouseEvent e) {

        }
        @Override
        public void mouseReleased(MouseEvent e) {

        }
        @Override
        public void mousePressed(MouseEvent e) {

        }
    }
    class MEM implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            String str = t1.getText();
            t1.setText(str+"*");
        }
        @Override
        public void mouseEntered(MouseEvent e) {

        }
        @Override
        public void mouseExited(MouseEvent e) {

        }
        @Override
        public void mouseReleased(MouseEvent e) {

        }
        @Override
        public void mousePressed(MouseEvent e) {

        }
    }
    class MES implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            String str = t1.getText();
            t1.setText(str+"-");
        }
        @Override
        public void mouseEntered(MouseEvent e) {

        }
        @Override
        public void mouseExited(MouseEvent e) {

        }
        @Override
        public void mouseReleased(MouseEvent e) {

        }
        @Override
        public void mousePressed(MouseEvent e) {

        }
    }
    class MEA implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            String str = t1.getText();
            t1.setText(str+"+");
        }
        @Override
        public void mouseEntered(MouseEvent e) {

        }
        @Override
        public void mouseExited(MouseEvent e) {

        }
        @Override
        public void mouseReleased(MouseEvent e) {

        }
        @Override
        public void mousePressed(MouseEvent e) {

        }
    }
    class MED implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            String str = t1.getText();
            t1.setText(str+"/");
        }
        @Override
        public void mouseEntered(MouseEvent e) {

        }
        @Override
        public void mouseExited(MouseEvent e) {

        }
        @Override
        public void mouseReleased(MouseEvent e) {

        }
        @Override
        public void mousePressed(MouseEvent e) {

        }
    }
    class ME7 implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            String str = t1.getText();
            t1.setText(str+"7");
        }
        @Override
        public void mouseEntered(MouseEvent e) {

        }
        @Override
        public void mouseExited(MouseEvent e) {

        }
        @Override
        public void mouseReleased(MouseEvent e) {

        }
        @Override
        public void mousePressed(MouseEvent e) {

        }
    }

    class ME8 implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            String str = t1.getText();
            t1.setText(str+"8");
        }
        @Override
        public void mouseEntered(MouseEvent e) {

        }
        @Override
        public void mouseExited(MouseEvent e) {

        }
        @Override
        public void mouseReleased(MouseEvent e) {

        }
        @Override
        public void mousePressed(MouseEvent e) {

        }
    }
    class ME9 implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            String str = t1.getText();
            t1.setText(str+"9");
        }
        @Override
        public void mouseEntered(MouseEvent e) {

        }
        @Override
        public void mouseExited(MouseEvent e) {

        }
        @Override
        public void mouseReleased(MouseEvent e) {

        }
        @Override
        public void mousePressed(MouseEvent e) {

        }
    }
    class ME4 implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            String str = t1.getText();
            t1.setText(str+"4");
        }
        @Override
        public void mouseEntered(MouseEvent e) {

        }
        @Override
        public void mouseExited(MouseEvent e) {

        }
        @Override
        public void mouseReleased(MouseEvent e) {

        }
        @Override
        public void mousePressed(MouseEvent e) {

        }
    }
    class ME5 implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            String str = t1.getText();
            t1.setText(str+"5");
        }
        @Override
        public void mouseEntered(MouseEvent e) {

        }
        @Override
        public void mouseExited(MouseEvent e) {

        }
        @Override
        public void mouseReleased(MouseEvent e) {

        }
        @Override
        public void mousePressed(MouseEvent e) {

        }
    }
    class ME6 implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            String str = t1.getText();
            t1.setText(str+"6");
        }
        @Override
        public void mouseEntered(MouseEvent e) {

        }
        @Override
        public void mouseExited(MouseEvent e) {

        }
        @Override
        public void mouseReleased(MouseEvent e) {

        }
        @Override
        public void mousePressed(MouseEvent e) {

        }
    }
    class ME1 implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            String str = t1.getText();
            t1.setText(str+"1");
        }
        @Override
        public void mouseEntered(MouseEvent e) {

        }
        @Override
        public void mouseExited(MouseEvent e) {

        }
        @Override
        public void mouseReleased(MouseEvent e) {

        }
        @Override
        public void mousePressed(MouseEvent e) {

        }
    }
    class ME2 implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            String str = t1.getText();
            t1.setText(str+"2");
        }
        @Override
        public void mouseEntered(MouseEvent e) {

        }
        @Override
        public void mouseExited(MouseEvent e) {

        }
        @Override
        public void mouseReleased(MouseEvent e) {

        }
        @Override
        public void mousePressed(MouseEvent e) {

        }
    }
    class ME3 implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            String str = t1.getText();
            t1.setText(str+"3");
        }
        @Override
        public void mouseEntered(MouseEvent e) {

        }
        @Override
        public void mouseExited(MouseEvent e) {

        }
        @Override
        public void mouseReleased(MouseEvent e) {

        }
        @Override
        public void mousePressed(MouseEvent e) {

        }
    }
    class ME00 implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            String str = t1.getText();
            t1.setText(str+"00");
        }
        @Override
        public void mouseEntered(MouseEvent e) {

        }
        @Override
        public void mouseExited(MouseEvent e) {

        }
        @Override
        public void mouseReleased(MouseEvent e) {

        }
        @Override
        public void mousePressed(MouseEvent e) {

        }
    }
    class ME0 implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            String str = t1.getText();
            t1.setText(str+"0");
        }
        @Override
        public void mouseEntered(MouseEvent e) {

        }
        @Override
        public void mouseExited(MouseEvent e) {

        }
        @Override
        public void mouseReleased(MouseEvent e) {

        }
        @Override
        public void mousePressed(MouseEvent e) {

        }
    }

    private void bindKeyboardKeys() {
        // Bind keyboard keys to buttons
        bindKey(KeyEvent.VK_0, b18); // Bind '0' key to the '0' button
        bindKey(KeyEvent.VK_1, b13); // Bind '1' key to the '1' button
        bindKey(KeyEvent.VK_2, b14); // Bind '2' key to the '2' button
        bindKey(KeyEvent.VK_3, b15); // Bind '3' key to the '3' button
        bindKey(KeyEvent.VK_4, b9);  // Bind '4' key to the '4' button
        bindKey(KeyEvent.VK_5, b10); // Bind '5' key to the '5' button
        bindKey(KeyEvent.VK_6, b11); // Bind '6' key to the '6' button
        bindKey(KeyEvent.VK_7, b5);  // Bind '7' key to the '7' button
        bindKey(KeyEvent.VK_8, b6);  // Bind '8' key to the '8' button
        bindKey(KeyEvent.VK_9, b7);  // Bind '9' key to the '9' button
        bindKey(KeyEvent.VK_PERIOD, b19); // Bind '.' key to the '.' button
        bindKey(KeyEvent.VK_ENTER, b20); // Bind '=' key to the '=' button
        bindKey(KeyEvent.VK_ADD, b16);    // Bind '+' key to the '+' button
        bindKey(KeyEvent.VK_SUBTRACT, b12); // Bind '-' key to the '-' button
        bindKey(KeyEvent.VK_MULTIPLY, b8); // Bind '*' key to the '*' button
        bindKey(KeyEvent.VK_DIVIDE, b4);   // Bind '/' key to the '/' button
        bindKey(KeyEvent.VK_BACK_SPACE, b2); // Bind 'Backspace' key to the 'DEL' button
        bindKey(KeyEvent.VK_ESCAPE, b1);   // Bind 'Esc' key to the 'AC' button
        bindKey(KeyEvent.VK_UNDO,b21);
    }

    private void bindKey(int keyCode, JButton button) {
        // Get the InputMap and ActionMap for the button
        InputMap inputMap = button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = button.getActionMap();

        // Create a KeyStroke for the key
        KeyStroke keyStroke = KeyStroke.getKeyStroke(keyCode, 0);

        // Bind the key to the button's action
        inputMap.put(keyStroke, keyStroke.toString());
        actionMap.put(keyStroke.toString(), new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.doClick(); // Simulate a button click
            }
        });
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
            t1.setForeground(Color.black);


        }
    }

    class Eight implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
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
            t1.setForeground(Color.black);
        }
    }

    class Nine implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            t1.setForeground(Color.black);
        }
    }

    class Multiply implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            t1.setForeground(Color.black);
        }
    }

    class Four implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            t1.setForeground(Color.black);
        }
    }

    class Five implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            t1.setForeground(Color.black);
        }
    }

    class Six implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            t1.setForeground(Color.black);
        }
    }

    class Substraction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            t1.setForeground(Color.black);
        }
    }

    class One implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            t1.setForeground(Color.black);
        }
    }

    class Two implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            t1.setForeground(Color.black);
        }
    }

    class Three implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            t1.setForeground(Color.black);
        }
    }
    class Addition implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            t1.setForeground(Color.black);
        }
    }

    class ZeroZero implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            t1.setForeground(Color.black);
        }
    }

    class Zero implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            t1.setForeground(Color.black);
        }
    }

    class FullStop implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
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
                result = exp.evaluate();
                t1.setText(Double.toString(result));
                t1.setForeground(Color.blue);

                // Add the expression and result to the history list
                String historyEntry = expression + " = <b>" + result + "</b>";
                historyList.add(historyEntry);

                // Update the HistoryText label with the history
                StringBuilder history = new StringBuilder("<html>");
                for (String entry : historyList) {
                    history.append(entry).append("<br>");
                }
                history.append("</html>");
                HistoryText.setText(history.toString());

            } catch (IllegalArgumentException ex) {
                t1.setText("Error: Invalid Expression");
                t1.setFont(f4);
                JOptionPane.showMessageDialog(null,"Error: Invalid Expression");
            } catch (ArithmeticException ex) {
                t1.setText("Error: Math Error");
                JOptionPane.showMessageDialog(null,"Error: Math Error");
            }
        }

    }

}

public class DigitalCal {
    public static void main(String[] args) {
        DigitalCalculator user = new DigitalCalculator("Digital Calculator by Ansh Girdher");
    }
}
