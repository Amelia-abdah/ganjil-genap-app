/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package genapganjilapp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Nur Amelia Abdah 2210010146
 */
public class GenapGanjilApp extends JFrame {
    private JTextField inputField;
    private JButton cekButton;
    private JLabel resultLabel;
    
    public GenapGanjilApp() {
        // Set up frame
        setTitle("Cek Nomor Genap/Ganjil & Bilangan Prima");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set up panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));

        // Input field
        inputField = new JTextField();
        inputField.setHorizontalAlignment(JTextField.CENTER);
        panel.add(inputField);

        // Add KeyAdapter for numeric input only
        inputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Masukkan hanya angka!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add FocusListener to clear input on focus
        inputField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                inputField.setText("");
                resultLabel.setText("");
            }
        });

        // Cek button
        cekButton = new JButton("Cek");
        panel.add(cekButton);

        // Result label
        resultLabel = new JLabel("", SwingConstants.CENTER);
        panel.add(resultLabel);

        // Add ActionListener to button
        cekButton.addActionListener(e -> {
            String input = inputField.getText();
            if (input.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Input tidak boleh kosong!", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                int number = Integer.parseInt(input);
                boolean isEven = number % 2 == 0;
                boolean isPrime = isPrime(number);
                String result = number + (isEven ? " adalah Genap" : " adalah Ganjil") +
                                (isPrime ? " dan Bilangan Prima." : " dan Bukan Bilangan Prima.");
                resultLabel.setText(result);
            }
        });

        // Add panel to frame
        add(panel);
    }

    // Method to check if a number is prime
    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GenapGanjilApp app = new GenapGanjilApp();
            app.setVisible(true);
        });
    }
    
}
