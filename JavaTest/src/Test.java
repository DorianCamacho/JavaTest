import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Test implements ActionListener {
    final static String BUTTONPANEL = "Click Counter";
    final static String TEXTPANEL = "Disemvowel";
    final static int extraWindowWidth = 100;
    JButton button1;
    JLabel label, label2;
    int count = 0;

    public void addComponentToPane(Container pane) {
        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel card1 = new JPanel() {
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width += extraWindowWidth;
                return size;
            }
        };

        button1 = new JButton("Click");
        button1.setPreferredSize(new Dimension(100, 50));
        button1.setBackground(Color.WHITE);
        button1.addActionListener(this);

        label = new JLabel("OK Count: 0");
        label.setForeground(Color.WHITE);
        label.setLayout(new GridLayout(2,1));

        card1.setBackground(Color.decode("#252525"));
        card1.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        card1.setLayout(new GridLayout(2,1));
        card1.add(button1);
        card1.add(label);

        label2 = new JLabel("Enter a string");
        label2.setForeground(Color.WHITE);
        //label2.setLayout(new GridLayout(1,1));

        JTextField tf = new JTextField();
        tf.setBounds(90,90,200,25);

        JPanel card2 = new JPanel();
        card2.add(label2);
        card2.add(tf);
        card2.setBackground(Color.decode("#252525"));
        card2.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));

        tabbedPane.addTab(BUTTONPANEL, card1);
        tabbedPane.addTab(TEXTPANEL, card2);

        pane.add(tabbedPane, BorderLayout.CENTER);
    }
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("JavaTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Test demo = new Test();
        demo.addComponentToPane(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(300, 300);
    }
    public static void main(String[] args) {
        createAndShowGUI();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            count++;
            label.setText("OK Count: " + count);
            if (count >= 10) {
                count = 0;
            }
        }
    }
}