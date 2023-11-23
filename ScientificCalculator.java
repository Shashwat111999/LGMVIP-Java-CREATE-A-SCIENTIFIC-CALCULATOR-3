import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScientificCalculator extends JFrame {
    private JTextField textField;
    private double num1, num2, result;
    private String operator;

    public ScientificCalculator() {
        setTitle("Scientific Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);

        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 24));
        textField.setHorizontalAlignment(SwingConstants.RIGHT);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4));

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "sin", "cos", "tan", "sqrt"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        add(textField, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            
            if ("0123456789.".contains(command)) {
                textField.setText(textField.getText() + command);
            } else if ("+-*/".contains(command)) {
                num1 = Double.parseDouble(textField.getText());
                operator = command;
                textField.setText("");
            } else if ("=" == command) {
                num2 = Double.parseDouble(textField.getText());
                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                }
                textField.setText(String.valueOf(result));
            } else if ("sin".equals(command)) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.sin(Math.toRadians(num1));
                textField.setText(String.valueOf(result));
            } else if ("cos".equals(command)) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.cos(Math.toRadians(num1));
                textField.setText(String.valueOf(result));
            } else if ("tan".equals(command)) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.tan(Math.toRadians(num1));
                textField.setText(String.valueOf(result));
            } else if ("sqrt".equals(command)) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.sqrt(num1);
                textField.setText(String.valueOf(result));
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ScientificCalculator());
    }
}
