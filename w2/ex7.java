import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

class add_matrix {
    public static void main(String[] args) {
        int m, n;
        JTextField tm = new JTextField(5), tn = new JTextField(5);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        panel.add(new JLabel("m:"));
        panel.add(tm);
        panel.add(new JLabel("n:"));
        panel.add(tn);
        while (true) {
            JOptionPane.showConfirmDialog(null, panel, "Enter matrix size", JOptionPane.OK_CANCEL_OPTION);
            m = Integer.parseInt(tm.getText());
            n = Integer.parseInt(tn.getText());
            if (m < 0 || n < 0) JOptionPane.showMessageDialog(null, "m and n must be geather than 0");
            else break;
        }
        JTextField[][] matrix_a = new JTextField[m][n];
        JTextField[][] matrix_b = new JTextField[m][n];
        panel = new JPanel();
        panel.setLayout(new GridLayout(m, 2 * n + 1));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix_a[i][j] = new JTextField(5);
                panel.add(matrix_a[i][j]);
            }
            panel.add(new JLabel("|"));
            for (int j = 0; j < n; ++j) {
                matrix_b[i][j] = new JTextField(5);
                panel.add(matrix_b[i][j]);
            }
        }
        int rs = JOptionPane.showConfirmDialog(null, panel, "Enter matrix", JOptionPane.OK_CANCEL_OPTION);
        if (rs ==  JOptionPane.OK_OPTION) {
            panel = new JPanel();
            panel.setLayout(new GridLayout(m, n));
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    panel.add(new JLabel("" + (
                        Double.parseDouble(matrix_a[i][j].getText())
                      + Double.parseDouble(matrix_b[i][j].getText()))));
                }
            }
            JOptionPane.showMessageDialog(null, panel, "Result", JOptionPane.INFORMATION_MESSAGE);
        }
        System.exit(0);
    }
}
