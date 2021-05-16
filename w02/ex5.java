import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class day_of_month {
    static int days(int month, int year) {
        int lead = year % 400 == 0 || (year % 100 != 0 && year % 4 == 0) ? 0x10 : 0;
        return 28 | 3 & (0x3bbeecc + lead) >> month * 2;
    }
    static int to_month(String month) {
        if ("January".equals(month) || "Jan.".equals(month) || "Jan".equals(month) || "1".equals(month)) {
            return 1;
        }
        if ("February".equals(month) || "Feb.".equals(month) || "Feb".equals(month) || "2".equals(month)) {
            return 2;
        }
        if ("March".equals(month) || "Mar.".equals(month) || "Mar".equals(month) || "3".equals(month)) {
            return 3;
        }
        if ("April".equals(month) || "Apr.".equals(month) || "Apr".equals(month) || "4".equals(month)) {
            return 4;
        }
        if ("May".equals(month) || "5".equals(month)) {
            return 5;
        }
        if ("June".equals(month) || "Jun".equals(month) || "6".equals(month)) {
            return 6;
        }
        if ("July".equals(month) || "Jul".equals(month) || "7".equals(month)) {
            return 7;
        }
        if ("August".equals(month) || "Aug.".equals(month) || "Aug".equals(month) || "8".equals(month)) {
            return 8;
        }
        if ("September".equals(month) || "Sept.".equals(month) || "Sep".equals(month) || "9".equals(month)) {
            return 9;
        }
        if ("October".equals(month) || "Oct.".equals(month) || "Oct".equals(month) || "10".equals(month)) {
            return 10;
        }
        if ("November".equals(month) || "Nov.".equals(month) || "Nov".equals(month) || "11".equals(month)) {
            return 11;
        }
        if ("December".equals(month) || "Dec.".equals(month) || "Dec".equals(month) || "12".equals(month)) {
            return 12;
        }
        return 0;
    }
    public static void main(String[] args) {
        JTextField month = new JTextField(5);
        JTextField year = new JTextField(5);
        JPanel panel = new JPanel();
        panel.add(new JLabel("Year: "));
        panel.add(year);
        panel.add(new JLabel(", Month: "));
        panel.add(month);

        while (true) {
            int rs = JOptionPane.showConfirmDialog(null, panel, "Enter month and year", JOptionPane.OK_CANCEL_OPTION);
            if (rs == JOptionPane.OK_OPTION) {
                int m = to_month(month.getText());
                int y = Integer.parseInt(year.getText());

                if (m == 0) {
                    JOptionPane.showMessageDialog(null, "Invalid month");
                    continue;
                }
                JOptionPane.showMessageDialog(null, "In year " + y + ", month " + month.getText() + " has " + days(m, y) + " days");
            }
            break;
        }
        System.exit(0);
    }
}
