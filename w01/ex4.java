import javax.swing.JOptionPane;

class ShowTwoNumber {
    public static void main(String[] args) {
        String num1 = JOptionPane.showInputDialog(null, "Enter the first number:");
        String num2 = JOptionPane.showInputDialog(null, "Enter the second number:");

        JOptionPane.showMessageDialog(null, "You just ented " + num1 + " and " + num2, "Show two number", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
