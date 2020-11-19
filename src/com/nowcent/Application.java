package com.nowcent;

import com.nowcent.T14_11.Printer;
import com.nowcent.T14_14.NumberGame;

import javax.swing.*;

/**
 * @author orangeboy
 * @version 1.0
 * @date 2020/11/19 21:36
 */
public class Application {
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        Printer printer = new Printer();
        printer.show();

        NumberGame numberGame = new NumberGame();
        numberGame.show();
    }
}
