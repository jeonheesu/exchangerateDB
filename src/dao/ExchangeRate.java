package dao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExchangeRate extends JFrame {

	private JPanel contentPane;
	private JTextField moneytextField;
	private double america = 1226.76;
	private double japan = 9.77;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExchangeRate frame = new ExchangeRate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ExchangeRate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		moneytextField = new JTextField();
		moneytextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		moneytextField.setBounds(31, 91, 114, 22);
		contentPane.add(moneytextField);
		moneytextField.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.addItem("달러");
		comboBox.addItem("엔화");

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		comboBox.setBounds(157, 89, 64, 27);
		contentPane.add(comboBox);

		JLabel exchangeRate = new JLabel("New label");
		exchangeRate.setBounds(256, 93, 59, 18);
		contentPane.add(exchangeRate);

		JButton btnNewButton = new JButton("환전");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String money = moneytextField.getText();
				int resultmoney = Integer.parseInt(money);
				double result1 = resultmoney * america;
				double result2 = resultmoney * japan;
				String com = (String) comboBox.getSelectedItem();

				if (com == ("달러")) {
					exchangeRate.setText(Double.toString(result1));
				} else if (com == ("엔화")) {
					exchangeRate.setText(Double.toString(result2));

				}

			}
		});
		btnNewButton.setBounds(243, 134, 105, 28);
		contentPane.add(btnNewButton);
	}
}
