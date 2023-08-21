import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Test implements ActionListener {
    final static String BUTTONPANEL = "Click Counter";
    final static String TEXTPANEL = "Disemvowel";
    final static int extraWindowWidth = 100;
    private static JButton button1, button2;
    private static JLabel label, label2, label3, label4;
    private static JTextField tf, textOutput;
    int count = 0, tenthsCount = 0;

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

        button2 = new JButton("Enter");
        button2.setPreferredSize(new Dimension(80, 30));
        button2.setBackground(Color.WHITE);
        button2.addActionListener(this);

        label = new JLabel("Click Count: 0");
        label.setForeground(Color.WHITE);
        label.setLayout(new GridLayout(2,1));

        label4 = new JLabel();
        label4.setForeground(Color.white);
        label4.setLayout(new GridLayout(3,1));

        card1.setBackground(Color.decode("#252525"));
        card1.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        card1.setLayout(new GridLayout(3,1));
        card1.add(button1);
        card1.add(label);
        card1.add(label4);

        label2 = new JLabel("Enter a string");
        label2.setForeground(Color.WHITE);
        //label2.setLayout(new GridLayout(1,1));

        tf = new JTextField(20);
        //tf.setBounds(90,90,200,25);

        label3 = new JLabel("Output:");
        label3.setForeground(Color.white);

        textOutput = new JTextField("",20);
        textOutput.setEditable(false);

        JPanel card2 = new JPanel();
        card2.add(label2);
        card2.add(tf);
        card2.add(button2);
        card2.add(label3);
        card2.add(textOutput);
        card2.setBackground(Color.decode("#252525"));
        card2.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));

        tabbedPane.addTab(BUTTONPANEL, card1);
        tabbedPane.addTab(TEXTPANEL, card2);

        pane.add(tabbedPane, BorderLayout.CENTER);
    }
    private static void createAndShowGUI() {
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
            label.setText("Click Count: " + count);
            if (count >= 10) {
                tenthsCount++;
                label4.setText("Tenths: "+tenthsCount);
                count = 0;
            }
        } else if (e.getSource() == button2) {
            System.out.println("Pressed");
            String text = tf.getText();
            String textOut = text.replaceAll("[aeiouAEIOU]", "");
            textOutput.setText(textOut);
            System.out.println(textOut);
        }
    }
}