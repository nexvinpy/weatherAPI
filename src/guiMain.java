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

        closeButton.setBackground(Color.RED);
        closeButton.setForeground(Color.WHITE);

        weatherLocation.setMaximumSize(new Dimension(120, 30));
        wetterCommit.setMaximumSize(new Dimension(120, 25));

        wetterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        weatherLocation.setAlignmentX(Component.CENTER_ALIGNMENT);
        wetterCommit.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(wetterLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(weatherLocation);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(wetterCommit);



        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(panel);
        topPanel.add(closeButton);

        frame.setVisible(true);

        wetterCommit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weatherAPI weather = new weatherAPI("48dd2fdd5546a0943cf81b7cf49f5c17", weatherLocation.getText().trim().toLowerCase());
                weather.getWeather();
            }
        });

        closeButton.addActionListener(e -> System.exit(0));
    }
}
