package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cal extends JFrame implements ActionListener {

    private JTextField displayField;
    private JButton[] numberButtons;
    private double result;
    private String currentExpression;
    private boolean operatorPressed;

    public cal() {
        setTitle("Calculator(Normal)");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(100, 100, 250));

        displayField = new JTextField();
        displayField.setEditable(false);
        displayField.setPreferredSize(new Dimension(100, 100));
        panel.add(displayField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));
        buttonPanel.setBackground(new Color(250, 20, 110));

        String[] buttons = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "Clear", "0", "=", "+"};

        numberButtons = new JButton[buttons.length];
        for (int i = 0; i < buttons.length; i++) {
            numberButtons[i] = new JButton(buttons[i]);
            numberButtons[i].addActionListener(this);
            numberButtons[i].setPreferredSize(new Dimension(80, 80));
            buttonPanel.add(numberButtons[i]);
        }

        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(panel);

        currentExpression = "";
        result = 0;
        operatorPressed = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Clear")) {
            displayField.setText("");
            currentExpression = "";
            result = 0;
            operatorPressed = false;
        } else if (command.equals("=")) {
            try {
                currentExpression = displayField.getText();
                result = evaluateExpression(currentExpression);
                displayField.setText(currentExpression + "=" + result);
                currentExpression = String.valueOf(result);
            } catch (Exception ex) {
                displayField.setText("Error");
                currentExpression = "";
                result = 0;
            }
            operatorPressed = false;
        } else if ("+-*/".contains(command)) {
            if (!operatorPressed) {
                currentExpression += command;
                displayField.setText(currentExpression);
                operatorPressed = true;
            }
        } else {
            currentExpression += command;
            displayField.setText(currentExpression);
            operatorPressed = false;
        }
    }

    private double evaluateExpression(String expression) {
        String[] tokens = expression.split("(?<=[-+/])|(?=[-+/])");
        double result = Double.parseDouble(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            char operator = tokens[i].charAt(0);
            double operand = Double.parseDouble(tokens[i + 1]);
            switch (operator) {
                case '+':
                    result += operand;
                    break;
                case '-':
                    result -= operand;
                    break;
                case '*':
                    result *= operand;
                    break;
                case '/':
                    if (operand != 0)
                        result /= operand;
                    else
                        throw new ArithmeticException("Division by zero");
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            cal calc = new cal();
            calc.setVisible(true);
        });
    }
}