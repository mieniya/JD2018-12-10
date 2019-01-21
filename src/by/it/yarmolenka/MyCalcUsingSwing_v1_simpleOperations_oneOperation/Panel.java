package by.it.yarmolenka.MyCalcUsingSwing_v1_simpleOperations_oneOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Panel extends JPanel {

    private Scalar buff = null;
    private char operation = '=';
    private JButton[] numbers = new JButton[10];
    private Font font = new Font("SanSerif", Font.BOLD, 18), fontBuffer = new Font("SansSerif", Font.ITALIC, 20);
    private JTextField output = new JTextField(), buffer = new JTextField();
    private JButton equ = new JButton("="), backspace = new JButton("<"), cancel = new JButton("C"), del = new JButton(","), cancele = new JButton("CE");
    private JButton plus = new JButton("+"), minus = new JButton("-"), multiple = new JButton("*"), div = new JButton("/");

    Panel() {
        int det = 10;
        int sizex = 60;
        int sizey = 50;


        setLayout(null);
        setFocusable(true);
        grabFocus();

        backspace.setBounds(det, 3 * det + 2 * sizey, sizex, sizey);
        backspace.setFont(font);
        add(backspace);

        cancele.setBounds(2 * det + sizex, 3 * det + 2 * sizey, sizex, sizey);
        cancele.setFont(font);
        add(cancele);

        cancel.setBounds(3 * det + 2 * sizex, 3 * det + 2 * sizey, sizex, sizey);
        cancel.setFont(font);
        add(cancel);

        del.setBounds(2 * det + sizex, 7 * det + 6 * sizey, sizex, sizey);
        del.setFont(font);
        add(del);

        equ.setBounds(3 * det + 2 * sizex, 7 * det + 6 * sizey, det + 2 * sizex, sizey);
        equ.setFont(font);
        add(equ);

        plus.setBounds(4 * det + 3 * sizex, 3 * det + 2 * sizey, sizex, sizey);
        plus.setFont(font);
        add(plus);

        minus.setBounds(4 * det + 3 * sizex, 4 * det + 3 * sizey, sizex, sizey);
        minus.setFont(font);
        add(minus);

        multiple.setBounds(4 * det + 3 * sizex, 5 * det + 4 * sizey, sizex, sizey);
        multiple.setFont(font);
        add(multiple);

        div.setBounds(4 * det + 3 * sizex, 6 * det + 5 * sizey, sizex, sizey);
        div.setFont(font);
        add(div);

        numbers[0] = new JButton("0");
        numbers[0].setBounds(det, 7 * det + 6 * sizey, sizex, sizey);
        numbers[0].setFont(font);
        add(numbers[0]);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                numbers[x * 3 + y + 1] = new JButton(String.valueOf(x * 3 + y + 1));
                numbers[x * 3 + y + 1].setBounds(y * (sizex + det) + det, x * (sizey + det) + 4 * det + 3 * sizey, sizex, sizey);
                numbers[x * 3 + y + 1].setFont(font);
                add(numbers[x * 3 + y + 1]);
            }
        }

        output.setBounds(det, 2 * det + sizey, 3 * det + 4 * sizex, sizey);
        output.setEditable(false);
        output.setFont(font);
        add(output);

        buffer.setBounds(det, det, 3 * det + 4 * sizex, sizey);
        buffer.setEditable(false);
        buffer.setFont(fontBuffer);
        add(buffer);

        ActionListener listenButton = (ActionEvent e) -> {
            if (operation == '=') {
                buffer.setText("");
                buff = null;
            }

            JButton b = (JButton) e.getSource();
            output.setText(output.getText() + b.getText());
        };

        ActionListener listenDelimiter = (ActionEvent e) -> {
            if (operation == '=') {
                buffer.setText("");
                buff = null;
            }
            if (!output.getText().contains(","))
                output.setText(output.getText() + ",");
        };

        ActionListener listenBackspace = (ActionEvent e) -> {
            if (output.getText().length() > 0)
                output.setText(output.getText().substring(0, output.getText().length() - 1));
        };

        ActionListener listenCancel = (ActionEvent e) -> {
            output.setText("");
            buff = null;
            operation = '=';
            buffer.setText("");
        };

        ActionListener listenCancelE = (ActionEvent e) -> output.setText("");

        ActionListener listenPlus = (ActionEvent e) -> {
            if (!output.getText().isEmpty()) {
                if (buff == null) {
                    buff = new Scalar(output.getText());
                    operation = '+';
                    buffer.setText(output.getText() + " + ");
                    output.setText("");
                } else {
                    try {
                        buff = Scalar.operation(operation, buff, new Scalar(output.getText()));
                    } catch (CalcException e1) {
                        buffer.setText(e1.getMessage());
                    }
                    operation = '+';
                    buffer.setText(buff.toString() + " + ");
                    output.setText("");
                }
            } else{
                if (buff != null){
                    operation = '+';
                    buffer.setText(buff.toString() + " + ");
                }
            }
        };

        ActionListener listenMinus = (ActionEvent e) -> {
            if (!output.getText().isEmpty()) {
                if (buff == null) {
                    buff = new Scalar(output.getText());
                    operation = '-';
                    buffer.setText(output.getText() + " - ");
                    output.setText("");
                } else {
                    try {
                        buff = Scalar.operation(operation, buff, new Scalar(output.getText()));
                    } catch (CalcException e1) {
                        buffer.setText(e1.getMessage());
                    }
                    operation = '-';
                    buffer.setText(buff.toString() + " - ");
                    output.setText("");
                }
            } else{
                if (buff != null){
                    operation = '-';
                    buffer.setText(buff.toString() + " - ");
                }
            }
        };

        ActionListener listenMultiple = (ActionEvent e) -> {
            if (!output.getText().isEmpty()) {
                if (buff == null) {
                    buff = new Scalar(output.getText());
                    operation = '*';
                    buffer.setText(output.getText() + " * ");
                    output.setText("");
                } else {
                    try {
                        buff = Scalar.operation(operation, buff, new Scalar(output.getText()));
                    } catch (CalcException e1) {
                        buffer.setText(e1.getMessage());
                    }
                    operation = '*';
                    buffer.setText(buff.toString() + " * ");
                    output.setText("");
                }
            } else{
                if (buff != null){
                    operation = '*';
                    buffer.setText(buff.toString() + " * ");
                }
            }
        };

        ActionListener listenDiv = (ActionEvent e) -> {
            if (!output.getText().isEmpty()) {
                if (buff == null) {
                    buff = new Scalar(output.getText());
                    operation = '/';
                    buffer.setText(output.getText() + " / ");
                    output.setText("");
                } else {
                    try {
                        buff = Scalar.operation(operation, buff, new Scalar(output.getText()));
                    } catch (CalcException e1) {
                        buffer.setText(e1.getMessage());
                    }
                    operation = '/';
                    buffer.setText(buff.toString() + " / ");
                    output.setText("");
                }
            } else{
                if (buff != null){
                    operation = '/';
                    buffer.setText(buff.toString() + " / ");
                }
            }
        };

        ActionListener listenEqu = (ActionEvent e) -> {
            if (!output.getText().isEmpty()) {
                if (buff == null) {
                    buff = new Scalar(output.getText());
                    operation = '=';
                    buffer.setText(output.getText());
                    output.setText("");
                } else {
                    try {
                        buff = Scalar.operation(operation, buff, new Scalar(output.getText()));
                    } catch (CalcException e1) {
                        buffer.setText(e1.getMessage());
                    }
                    operation = '=';
                    buffer.setText(buff.toString());
                    output.setText("");
                }
            } else{
                if (buff != null){
                    operation = '=';
                    buffer.setText(buff.toString());
                }
            }
        };

        for (JButton number : numbers) {
            number.addActionListener(listenButton);
        }

        backspace.addActionListener(listenBackspace);

        del.addActionListener(listenDelimiter);

        cancel.addActionListener(listenCancel);

        cancele.addActionListener(listenCancelE);

        plus.addActionListener(listenPlus);

        minus.addActionListener(listenMinus);

        multiple.addActionListener(listenMultiple);

        div.addActionListener(listenDiv);

        equ.addActionListener(listenEqu);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char symbol = e.getKeyChar();

                if (!Character.isDigit(symbol))
                    return;

                output.setText(output.getText() + symbol);
            }
        });
    }
}
