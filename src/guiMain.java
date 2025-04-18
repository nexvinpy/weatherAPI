import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class guiMain {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Wetter GUI");

        JLabel wetterLabel = new JLabel("Wetter Station!");
        JTextField wetter = new JTextField("");
        JButton wetterCommit = new JButton("OK");

        wetter.setMaximumSize(new Dimension(120, 30));
        wetterCommit.setMaximumSize(new Dimension(120, 50));

        wetterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        wetter.setAlignmentX(Component.CENTER_ALIGNMENT);
        wetterCommit.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(wetterLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(wetter);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(wetterCommit);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);

        frame.add(panel);

        frame.setVisible(true);

        wetterCommit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(wetter.getText());
            }
        });
    }
}
