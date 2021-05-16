import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

class sort_array {
    public static void main(String[] args) {
        int n;
        while (true) {
            n = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter n:"));
            if (n <= 0) JOptionPane.showMessageDialog(null, "n must be geather than 0");
            else break;
        }
        JTextField[] tfarr = new JTextField[n];

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(n, 2));
        for (int i = 0; i < n; ++i) {
            panel.add(new JLabel("a[" + i + "] ="));
            tfarr[i] = new JTextField(5);
            panel.add(tfarr[i]);
        }
        int rs = JOptionPane.showConfirmDialog(null, panel, "Enter array", JOptionPane.OK_CANCEL_OPTION);
        double sum = 0;
        if (rs == JOptionPane.OK_OPTION) {
            for (int i = 0; i < n; ++i) {
                sum += Double.parseDouble(tfarr[i].getText());
            }
            JOptionPane.showMessageDialog(null, "Sum of array: " + sum + "\nAverage of array: " + sum / (double)n);
        }
        System.exit(0);
    }
}
