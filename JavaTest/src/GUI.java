import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    int count = 0;
    JLabel label;
    JFrame frame;
    JPanel panel;
    JButton button2;
    JButton button;
    JButton button3;

    public GUI(){
        frame = new JFrame();

        button = new JButton("OK");
        button.setPreferredSize(new Dimension(100, 50));
        button.setBackground(Color.WHITE);
        button.setLocation(50,50);
        button.addActionListener(this);

        button2 = new JButton("New");
        button2.setPreferredSize(new Dimension(100, 50));
        button2.setBackground(Color.WHITE);
        button2.addActionListener(this);

        button3 = new JButton("Click2");
        button3.setPreferredSize(new Dimension(100, 50));
        button3.setBackground(Color.WHITE);

        label = new JLabel("OK Count");
        label.setForeground(Color.WHITE);
        label.setLayout(new GridLayout(2,1));

        JPanel sidePanel = new JPanel();
        sidePanel.setBackground(Color.darkGray);
        sidePanel.setPreferredSize(new Dimension(100,100));

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        //panel.setLayout(new GridLayout(0,1));
        panel.add(button);
        panel.add(button2);
        panel.add(button3);
        panel.add(label);
        panel.setBackground(Color.decode("#252525"));

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI");
        //frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(600, 400);
        frame.add(sidePanel,BorderLayout.WEST);
    }

    public static void main(String[] args){
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            count++;
            label.setText("OK Count: " + count);
            if (count >= 10) {
                count = 0;
            }
        } else if (e.getSource() == button2) {
            System.out.print("Pressed");
        }
    }
}
