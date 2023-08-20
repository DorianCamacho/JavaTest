import javax.swing.*;
import java.awt.*;

public class DisemvowelGUI {
    JLabel label;
    JFrame frame;
    JPanel panel;
    JTextField textField;
    JButton textFieldButton;
    public DisemvowelGUI (){
        frame = new JFrame();

        label = new JLabel("String: ");
        label.setForeground(Color.WHITE);
        label.setBounds(10,90,80,25);

        textField = new JTextField();
        textField.setBounds(60,90,280,25);

        textFieldButton = new JButton("OK");
        textFieldButton.setBounds(370,90,80,25);
        textFieldButton.setBackground(Color.WHITE);

        JPanel sidePanel = new JPanel();
        sidePanel.setBackground(Color.darkGray);
        sidePanel.setPreferredSize(new Dimension(100,100));

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        panel.setLayout(null);
        panel.add(label);
        panel.add(textField);
        panel.add(textFieldButton);
        panel.setBackground(Color.decode("#252525"));

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI");
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(600, 400);
        frame.add(sidePanel,BorderLayout.WEST);
    }

    public static void main(String[] args){
        new DisemvowelGUI();
    }

}
