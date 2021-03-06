import javax.swing.JOptionPane;

class triangle {
    static String make_triangle(int n) {
        String s = "";
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n - i; ++j) s += "  ";
            for (int j = 0; j < 2 * i + 1; ++j) s += "*";
            s += "\n";
        }
        return s;
    }
    public static void main(String[] args) {
        String rs = JOptionPane.showInputDialog("Enter n: ");
        JOptionPane.showMessageDialog(null, make_triangle(Integer.parseInt(rs)));
        System.exit(0);
    }
}
