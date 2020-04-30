import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SimpleJButton {
    SimpleJButton() {
        JFrame frame = new JFrame("Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // submit button
        JButton mass_1 = new JButton("Enter (click)");
        mass_1.setBounds(150, 100, 140, 40);

        // enter name label
        JLabel label = new JLabel();
        label.setText("N: ");
        label.setBounds(10, 10, 100, 100);

        // empty label which will show event after button clicked
        JLabel label1 = new JLabel();
        label1.setBounds(10, 110, 200, 100);
        // textfield to enter name
        JTextField textfield = new JTextField();
        textfield.setBounds(110, 50, 200, 30);
        // add to frame
        frame.add(label1);
        frame.add(textfield);
        frame.add(label);
        frame.add(mass_1);
        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // action listener
        mass_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String textFieldValue = textfield.getText();
                label1.setText("N is:\t" + textFieldValue);
            }
        });
    }

    public static void main(String[] args) {
        new SimpleJButton();
    }
}