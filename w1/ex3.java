import javax.swing.JOptionPane;

class HelloNameDialog {
    public static void main(String[] args) {
        String rs = JOptionPane.showInputDialog(null, "Zit?");
        JOptionPane.showMessageDialog(null, "zit zit, " + rs);
        System.exit(0);
    }
}
