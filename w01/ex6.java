import javax.swing.*;
import java.awt.GridLayout;
import java.lang.Math;

public class ex6 {
    public static void main(String[] args) {
        String[] choices = new String[]{
            "The first degree equation with one variable",
            "The first degree equation with two variables",
            "The second degree equation with one variable"
        };
        Object selected = JOptionPane.showInputDialog(null, "Select:", "Selection", JOptionPane.DEFAULT_OPTION, null, choices, null);
        if (selected == null) System.exit(0);

        if (selected == choices[0]) {
            JTextField aField = new JTextField(5);
            JTextField bField = new JTextField(5);
      
            JPanel myPanel = new JPanel();
            myPanel.add(aField);
            myPanel.add(new JLabel(" * x"));
            // myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel(" = "));
            myPanel.add(bField);
      
            int result = JOptionPane.showConfirmDialog(null, myPanel, 
                     "Enter equation:", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                Double numa = Double.parseDouble(aField.getText());
                Double numb = Double.parseDouble(bField.getText());

                if (numa == 0) {
                    if (numb == 0) JOptionPane.showMessageDialog(null, "Solution is: 0");
                    else JOptionPane.showMessageDialog(null, "No solution");
                } else {
                    JOptionPane.showMessageDialog(null, "Solution is: " + (numb / numa));
                }
            }
        } else if (selected == choices[1]) {
            JTextField a1Field = new JTextField(5);
            JTextField b1Field = new JTextField(5);
            JTextField a2Field = new JTextField(5);
            JTextField b2Field = new JTextField(5);
            JTextField c1Field = new JTextField(5);
            JTextField c2Field = new JTextField(5);

            JPanel myPanel = new JPanel();
            myPanel.setLayout(new GridLayout(2, 5));
            myPanel.add(a1Field);
            myPanel.add(new JLabel(" * x +"));
            myPanel.add(b1Field);
            myPanel.add(new JLabel(" * y = "));
            myPanel.add(c1Field);
            
            myPanel.add(a2Field);
            myPanel.add(new JLabel(" * x +"));
            myPanel.add(b2Field);
            myPanel.add(new JLabel(" * y = "));
            myPanel.add(c2Field);

            int result = JOptionPane.showConfirmDialog(null, myPanel, 
                     "Enter equation:", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                Double a1 = Double.parseDouble(a1Field.getText());
                Double b1 = Double.parseDouble(b1Field.getText());
                Double c1 = Double.parseDouble(c1Field.getText());
                Double a2 = Double.parseDouble(a2Field.getText());
                Double b2 = Double.parseDouble(b2Field.getText());
                Double c2 = Double.parseDouble(c2Field.getText());

                Double det = a1 * b2 - b1 * a2;
                if (det == 0) {
                    JOptionPane.showMessageDialog(null, "No solution");
                } else {
                    Double x = (b2 * c1 - b1 * c2) / det;
                    Double y = (a1 * c2 - a2 * c1) / det;
                    JOptionPane.showMessageDialog(null, "x = " + x + ", y = " + y);
                }
            }
        } else {
            JTextField aField = new JTextField(5);
            JTextField bField = new JTextField(5);
            JTextField cField = new JTextField(5);

            JPanel myPanel = new JPanel();
            myPanel.add(aField);
            myPanel.add(new JLabel(" * x ^2 + "));
            myPanel.add(bField);
            myPanel.add(new JLabel(" * x + "));
            myPanel.add(cField);
            myPanel.add(new JLabel(" = 0"));

            int result = JOptionPane.showConfirmDialog(null, myPanel, 
                     "Enter equation:", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                Double a = Double.parseDouble(aField.getText());
                Double b = Double.parseDouble(bField.getText());
                Double c = Double.parseDouble(cField.getText());

                Double delta = b * b - 4 * a * c;
                if (delta < 0) JOptionPane.showMessageDialog(null, "No solution");
                else if (delta == 0) JOptionPane.showMessageDialog(null, "x = " + (-b / (2 * a)));
                else {
                    Double s_delta = Math.sqrt(delta);
                    Double x1 = (s_delta - b) / (2 * a);
                    Double x2 = (-s_delta - b) / (2 * a);
                    JOptionPane.showMessageDialog(null, "x1 = " + x1 + ", x2 = " + x2);
                }
            }
        }
        System.exit(0);
    }
}
