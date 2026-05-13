package partb;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import parta.ShippingStrategy;

public class SimpleShippingApp extends JFrame {

    private JTextField weightField, distanceField;
    private JComboBox<String> policyCombo;
    private JTextArea resultArea;

    public SimpleShippingApp() {

        setTitle("Shipping Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Standardized GUI layout
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        inputPanel.add(new JLabel("Weight (kg):"));

        weightField = new JTextField();
        inputPanel.add(weightField);

        inputPanel.add(new JLabel("Distance (km):"));

        distanceField = new JTextField();
        inputPanel.add(distanceField);

        inputPanel.add(new JLabel("Policy:"));

        policyCombo = new JComboBox<>(
                new String[]{
                        "Flat Rate",
                        "Weight-Based",
                        "Distance-Based",
                        "Carrier-Specific"
                });

        inputPanel.add(policyCombo);

        JButton calcButton = new JButton("Calculate Cost");
        inputPanel.add(calcButton);

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        // Refactored logic using patterns
        calcButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    double weight = Double.parseDouble(weightField.getText());
                    double distance = Double.parseDouble(distanceField.getText());

                    String policy =
                            (String) policyCombo.getSelectedItem();

                    // Factory Method Pattern
                    ShippingStrategy strategy =
                            ShippingPolicyFactory.getStrategy(policy, weight);

                    // Strategy + Decorator execution
                    double cost =
                            strategy.calculate(weight, distance);

                    String surchargeNote = "";

                    if (weight > 20) {
                        surchargeNote =
                                " (Includes $15 Heavy Surcharge)";
                    }

                    resultArea.append(
                            policy + ": $" +
                            cost +
                            surchargeNote +
                            "\n"
                    );

                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Please enter valid numbers."
                    );
                }
            }
        });
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->
                new SimpleShippingApp().setVisible(true));
    }
}