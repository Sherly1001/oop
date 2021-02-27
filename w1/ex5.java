import javax.swing.JOptionPane;

class Calculation {
    public static void main(String[] args) {
        double num1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the first number:"));
        double num2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the second number:"));

        JOptionPane.showMessageDialog(null, "Sum of two number: " + (num1 + num2));
        JOptionPane.showMessageDialog(null, "Product of two number: " + (num1 * num2));
        JOptionPane.showMessageDialog(null, "Difference of two number: " + (num1 - num2));
        if (num2 != 0) JOptionPane.showMessageDialog(null, "Quotient of two number: " + (num1 / num2));
        else JOptionPane.showMessageDialog(null, "The Second number is 0, can't div by 0");
        System.exit(0);
    }
}
