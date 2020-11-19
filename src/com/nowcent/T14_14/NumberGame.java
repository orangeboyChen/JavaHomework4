package com.nowcent.T14_14;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.util.Random;

/**
 * @author orangeboy
 * @version 1.0
 * @date 2020/11/19 22:22
 */
public class NumberGame {
    public void show() throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        JFrame frame = new JFrame("NumberGame");
        frame.setContentPane(new NumberGame().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel root;
    private JLabel titleLabel;
    private JTextField textField1;
    private JButton submitButton;
    private JButton restartButton;

    private final String HELP_MESSAGE = "<html><body>I have a number between 1 and 1000. <br>Can you guess my number? Please enter your first guess.</body></html>";
    private final String WIN_MESSAGE = "";
    private final String BIGGER_MESSAGE = "";
    private final String LOSER_MESSAGE = "";
    private final String INVALID_MESSAGE = "";

    private int correctNumber = -1;
    private int minDistance = 1000;

    public NumberGame(){
        //initialize the random number
        Random r = new Random();
        correctNumber = r.nextInt(1000);

        //set click listener
        submitButton.addActionListener(e -> {
            //convey the type of number
            int guessingNumber = -1;
            try {
                guessingNumber = getNumber(textField1.getText());
            } catch (NumberFormatException numberFormatException) {
                titleLabel.setText("The input is not valid.");
                return;
            }

            //start judging
            if(correctNumber == guessingNumber){
                titleLabel.setText("You win!");
                textField1.setEnabled(false);
                submitButton.setEnabled(false);
                return;
            }

            //change the display of the label
            if(correctNumber > guessingNumber){
                titleLabel.setText("Your number is smaller than my number!");
            }
            else{
                titleLabel.setText("Your number is bigger than my number!");
            }

            //switch the background color
            int distance = Math.abs(correctNumber - guessingNumber);

            if(distance > minDistance){
                root.setBackground(Color.CYAN);
            }
            else{
                minDistance = distance;
                root.setBackground(Color.PINK);
            }
        });

        restartButton.addActionListener(e -> {
            //set the title message
            titleLabel.setText(HELP_MESSAGE);

            //revert the setting
            textField1.setText("");
            textField1.setEnabled(true);
            submitButton.setEnabled(true);

            //set another random number
            Random r2 = new Random();
            correctNumber = r2.nextInt(1000);

        });
    }

    private int getNumber(String str) throws NumberFormatException{
        if(!str.matches("^[0-9]*$")){
            throw new NumberFormatException();
        }
        int number = Integer.parseInt(str);
        if(number > 1000 || number < 1){
            throw new NumberFormatException();
        }
        return Integer.parseInt(str);
    }
}
