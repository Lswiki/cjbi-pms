package com.cjbi.erp.pms.util;
/*
 * @(#)JCalculator.java 1.00 12/29/2009
 *
 * Email: light_warm@163.com
 */
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
/**
 * A simple calculator program.
 * <p>I saw this program in a QQ group, and help a friend correct it.</p>
 *
 * @author CJB
 * @version 1.00 10/29/2015
 * @see JFrame
 * @see ActionListener
 */
public class JCalculator extends JFrame implements ActionListener {
    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = -169068472193786457L;
    /**
     * This class help close the Window.
     * @author Singyuen Yip
     *
     */
    
 
    int i;
    // Strings for Digit & Operator buttons.
    private final String[] str = { "7", "8", "9", "/", "4", "5", "6", "*", "1",
           "2", "3", "-", ".", "0", "=", "+" };
    // Build buttons.
    JButton[] buttons = new JButton[str.length];
    // For cancel or reset.
    JButton reset = new JButton("CE");
    // Build the text field to show the result.
    JTextField display = new JTextField("0");
   
    /**
     * Constructor without parameters.
     */
    public JCalculator() {
       super("Calculator");
       // Add a panel.
       JPanel panel1 = new JPanel(new GridLayout(4, 4));
       // panel1.setLayout(new GridLayout(4,4));
       for (i = 0; i < str.length; i++) {
           buttons[i] = new JButton(str[i]);
           panel1.add(buttons[i]);
       }
       JPanel panel2 = new JPanel(new BorderLayout());
       // panel2.setLayout(new BorderLayout());
       panel2.add("Center", display);
       panel2.add("East", reset);
       // JPanel panel3 = new Panel();
       getContentPane().setLayout(new BorderLayout());
       getContentPane().add("North", panel2);
       getContentPane().add("Center", panel1);
       // Add action listener for each digit & operator button.
       for (i = 0; i < str.length; i++)
           buttons[i].addActionListener(this);
       // Add listener for "reset" button.
       reset.addActionListener(this);
       // Add listener for "display" button.
       display.addActionListener(this);
       // The "close" button "X".
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       // Initialize the window size.
       setLocationRelativeTo(null);
       // Show the window.
       // show(); Using show() while JDK version is below 1.5.
       setVisible(true);
       // Fit the certain size.
       pack();
    }  
   
    public void actionPerformed(ActionEvent e) {
       Object target = e.getSource();
       String label = e.getActionCommand();
       if (target == reset)
           handleReset();
       else if ("0123456789.".indexOf(label) > 0)
           handleNumber(label);
       else
           handleOperator(label);
    }
    // Is the first digit pressed?
    boolean isFirstDigit = true;
    /**
     * Number handling.
     * @param key the key of the button.
     */
    public void handleNumber(String key) {
       if (isFirstDigit)
           display.setText(key);
       else if ((key.equals(".")) && (display.getText().indexOf(".") < 0))
           display.setText(display.getText() + ".");
       else if (!key.equals("."))
           display.setText(display.getText() + key);
       isFirstDigit = false;
    }
   
    /**
     * Reset the calculator.
     */
    public void handleReset() {
       display.setText("0");
       isFirstDigit = true;
       operator = "=";
    }
 
    double number = 0.0;
    String operator = "=";
   
    /**
     * Handling the operation.
     * @param key pressed operator's key.
     */
    public void handleOperator(String key) {
       if (operator.equals("+"))
           number += Double.valueOf(display.getText());
       else if (operator.equals("-"))
           number -= Double.valueOf(display.getText());
       else if (operator.equals("*"))
           number *= Double.valueOf(display.getText());
       else if (operator.equals("/"))
           number /= Double.valueOf(display.getText());
       else if (operator.equals("="))
           number = Double.valueOf(display.getText());
       display.setText(String.valueOf(number));
       operator = key;
       isFirstDigit = true;
    }
   
}