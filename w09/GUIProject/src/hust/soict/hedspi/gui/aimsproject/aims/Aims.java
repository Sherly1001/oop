package hust.soict.hedspi.gui.aimsproject.aims;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;

import hust.soict.hedspi.gui.aimsproject.media.Book;
import hust.soict.hedspi.gui.aimsproject.media.CompactDisc;
import hust.soict.hedspi.gui.aimsproject.media.DigitalVideoDisc;
import hust.soict.hedspi.gui.aimsproject.media.Media;
import hust.soict.hedspi.gui.aimsproject.media.Track;
import hust.soict.hedspi.gui.aimsproject.order.Order;

public class Aims extends JFrame {
	private Order order = null;
	private boolean makedOrder = false;

	private JButton bt1 = new JButton("Create new order");
	private JButton bt2 = new JButton("Add an item to order");
	private JButton bt3 = new JButton("Delete item by id");
	private JButton bt4 = new JButton("Display the items list of order");

	private String[] options = { "Book", "Compact Disc", "Digital Video Disc" };

	public Aims() {
		Container cp = getContentPane();

		bt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				order = Order.getInstanceOrder();
				makedOrder = true;
				if (order != null)
					JOptionPane.showMessageDialog(cp, "Order created");
				else
					JOptionPane.showMessageDialog(cp, "Maximum of order");
			}
		});

		bt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!makedOrder) {
					JOptionPane.showMessageDialog(cp, "Please create an order");
					return;
				}

				int rs = JOptionPane.showOptionDialog(cp, "Enter type of media", "", JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
				System.out.println(rs);
				Media m = null;
				switch (rs) {
				case 0:
					JTextField btitleField = new JTextField();
					JTextField bcatTextField = new JTextField();
					JTextField bcosTextField = new JTextField();
					JPanel bJPanel = new JPanel();
					bJPanel.setLayout(new GridLayout(3, 2));
					bJPanel.add(new JLabel("Book title: "));
					bJPanel.add(btitleField);
					bJPanel.add(new JLabel("Category: "));
					bJPanel.add(bcatTextField);
					bJPanel.add(new JLabel("Cost: "));
					bJPanel.add(bcosTextField);
					int rss = JOptionPane.showConfirmDialog(cp, bJPanel, "", JOptionPane.OK_CANCEL_OPTION);
					if (rss == JOptionPane.CANCEL_OPTION) {
						break;
					}

					try {
						m = new Book(btitleField.getText(), bcatTextField.getText(),
								Float.parseFloat(bcosTextField.getText()));
					} catch (Exception e2) {
						m = null;
					}
					break;
				case 1:
					try {
						String ar = JOptionPane.showInputDialog(cp, "Enter artist:");
						m = new CompactDisc();
						((CompactDisc) m).setArtist(ar);

						JTextField tlenJTextField = new JTextField();
						JTextField ttitJTextField = new JTextField();
						JPanel tJPanel = new JPanel();
						tJPanel.setLayout(new GridLayout(2, 2));
						tJPanel.add(new JLabel("Track's title: "));
						tJPanel.add(ttitJTextField);
						tJPanel.add(new JLabel("Track's length: "));
						tJPanel.add(tlenJTextField);

						while (true) {
							int r0 = JOptionPane.showConfirmDialog(cp, tJPanel, "", JOptionPane.OK_CANCEL_OPTION);
							if (r0 == JOptionPane.CANCEL_OPTION)
								break;
							((CompactDisc) m).addTrack(
									new Track(ttitJTextField.getText(), Integer.parseInt(tlenJTextField.getText())));
							ttitJTextField.setText("");
							tlenJTextField.setText("");
						}
					} catch (Exception e2) {
						m = null;
					}
					break;
				case 2:
					JTextField dtitleField = new JTextField();
					JTextField dcatTextField = new JTextField();
					JTextField ddirJTextField = new JTextField();
					JTextField dlenJTextField = new JTextField();
					JTextField dcosTextField = new JTextField();
					JPanel dJPanel = new JPanel();
					dJPanel.setLayout(new GridLayout(5, 2));
					dJPanel.add(new JLabel("Disc title: "));
					dJPanel.add(dtitleField);
					dJPanel.add(new JLabel("Category: "));
					dJPanel.add(dcatTextField);
					dJPanel.add(new JLabel("Director: "));
					dJPanel.add(ddirJTextField);
					dJPanel.add(new JLabel("Length: "));
					dJPanel.add(dlenJTextField);
					dJPanel.add(new JLabel("Cost: "));
					dJPanel.add(dcosTextField);
					int r0 = JOptionPane.showConfirmDialog(cp, dJPanel, "", JOptionPane.OK_CANCEL_OPTION);
					if (r0 == JOptionPane.CANCEL_OPTION) {
						break;
					}

					try {
						m = new DigitalVideoDisc(dtitleField.getText(), dcatTextField.getText(),
								ddirJTextField.getText(), Integer.parseInt(dlenJTextField.getText()),
								Float.parseFloat(dcosTextField.getText()));
					} catch (Exception e2) {
						m = null;
					}
					break;
				}

				if (m != null) {
					order.addMedia(m);
					JOptionPane.showMessageDialog(cp, "Item added");
				} else {
					JOptionPane.showMessageDialog(cp, "Can't add item");
				}
			}
		});

		bt3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!makedOrder) {
					JOptionPane.showMessageDialog(cp, "Please create an order");
					return;
				}

				String rs = JOptionPane.showInputDialog(cp, "Enter item's id:");
				if (rs != null) {
					try {
						order.removeMedia(Integer.parseInt(rs));
						JOptionPane.showMessageDialog(cp, "Media deleted");
					} catch (Exception exception) {
						JOptionPane.showMessageDialog(cp, "Can't remove media with id: " + rs);
					}
				}
			}
		});

		bt4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!makedOrder) {
					JOptionPane.showMessageDialog(cp, "Please create an order");
					return;
				}
				JOptionPane.showMessageDialog(cp, order.toString());
			}
		});

		cp.setLayout(new GridLayout(4, 1));
		cp.add(bt1);
		cp.add(bt2);
		cp.add(bt3);
		cp.add(bt4);

		setLocation(500, 250);
		setSize(400, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Aims Project");
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Aims();
			}
		});
	}
}
