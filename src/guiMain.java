import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guiMain {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Wetter GUI");

        JLabel wetterLabel = new JLabel("Wetter Station!");
        JTextField weatherLocation = new JTextField("");
        JButton wetterCommit = new JButton("OK");
        JButton closeButton = new JButton("Schließen");

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        closeButton.setBackground(Color.RED);
        closeButton.setForeground(Color.WHITE);

        weatherLocation.setMaximumSize(new Dimension(120, 30));
        wetterCommit.setMaximumSize(new Dimension(120, 25));

        wetterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        weatherLocation.setAlignmentX(Component.CENTER_ALIGNMENT);
        wetterCommit.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Zentrales Panel für obere Elemente
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(wetterLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(weatherLocation);
        panel.add(wetterCommit);

        // Neues Panel für resultLabel unten
        JLabel resultLabel = new JLabel("");
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        resultLabel.setPreferredSize(new Dimension(170, 300));
        bottomPanel.add(resultLabel);

        // Frame-Einstellungen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        topPanel.add(closeButton);

        wetterCommit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weatherAPI weather = new weatherAPI("48dd2fdd5546a0943cf81b7cf49f5c17", weatherLocation.getText().trim().toLowerCase());
                weather.getWeather();

                resultLabel.setText("<html>Temperatur: " + weather.getTemp() + " °C<br>" +
                        "Gefühlt: " + weather.getFeelsLike() + " °C<br>" +
                        "Luftfeuchtigkeit: " + weather.getHumidity() + " %<br>" +
                        "Wetter: " + weather.getDescription() + "</html>");
            }
        });

        closeButton.addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }
}
