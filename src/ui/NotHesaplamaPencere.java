package ui;

import hesaplamalar.NotHesaplayici;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class NotHesaplamaPencere extends JFrame {

    private final JTextField vizeField;
    private final JTextField finalField;
    private final JLabel sonucLabel;

    public NotHesaplamaPencere() {
        setTitle("🎓 Harf Notu Robotu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(null);

        // 🔹 Renk tanımı
        Color arkaPlanRengi = new Color(230, 242, 255); // #e6f2ff

        // 🔹 Frame genel arka planı
        getContentPane().setBackground(arkaPlanRengi);

        // 🔹 Uygulama ikonunu ayarla
        setIconImage(new ImageIcon(
                Objects.requireNonNull(getClass().getResource("/ui/logo.jpg"))
        ).getImage());

        // 🔹 Form paneli
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 8, 8));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        formPanel.setBackground(arkaPlanRengi); // panel rengi

        formPanel.add(new JLabel("Vize Notu:"));
        vizeField = new JTextField();
        formPanel.add(vizeField);

        formPanel.add(new JLabel("Final Notu:"));
        finalField = new JTextField();
        formPanel.add(finalField);

        JButton hesaplaBtn = new JButton("Hesapla");
        sonucLabel = new JLabel("Sonuç: ");
        formPanel.add(hesaplaBtn);
        formPanel.add(sonucLabel);

        add(formPanel, BorderLayout.CENTER);

        ImageIcon logoIcon = new ImageIcon(
                Objects.requireNonNull(getClass().getResource("/ui/logo.jpg"))
        );
        Image scaled = logoIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(scaled));

        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        logoPanel.add(logoLabel);
        logoPanel.setBackground(arkaPlanRengi);

        add(logoPanel, BorderLayout.SOUTH);

        hesaplaBtn.addActionListener(e -> {
            try {
                double vize = Double.parseDouble(vizeField.getText());
                double fin = Double.parseDouble(finalField.getText());

                double ort = NotHesaplayici.ortalamaHesapla(vize, fin);
                String harf = NotHesaplayici.harfNotuHesapla(ort);

                sonucLabel.setText(String.format("Sonuç: %.2f → %s", ort, harf));

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Lütfen sayısal değer girin!");
            }
        });
    }

}
