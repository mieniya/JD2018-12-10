package by.it.yarmolenka.MyCalcUsingSwing_v1_simpleOperations_oneOperation;

import javax.swing.*;

public class Start {

    private Start() {
        int det = 10;
        int sizex = 60;
        int sizey = 50;
        JFrame window = new JFrame("Calculator");
        window.setSize(5*det+4*sizex+7, 8*det+7*sizey+27);
        window.add(new Panel());
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(Start::new);

    }

}
