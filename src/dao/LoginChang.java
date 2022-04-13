package dao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Visibility;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import db.ExDB;

public class LoginChang extends JFrame {

	private JPanel contentPane;
	private JTextField IDtextField;
	private JTextField PWtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginChang frame = new LoginChang();
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
	public LoginChang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("로그인");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(175, 12, 59, 18);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(101, 56, 59, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setBounds(90, 84, 59, 18);
		contentPane.add(lblNewLabel_1);
		
		IDtextField = new JTextField();
		IDtextField.setBounds(167, 54, 114, 22);
		contentPane.add(IDtextField);
		IDtextField.setColumns(10);
		
		PWtextField = new JTextField();
		PWtextField.setColumns(10);
		PWtextField.setBounds(167, 82, 114, 22);
		contentPane.add(PWtextField);
		
		JButton RegistBtn = new JButton("회원가입");
		RegistBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			 Regist re = new Regist();
			 re.setVisible(true);
				setVisible(false);
			}
		});
		RegistBtn.setBounds(175, 129, 105, 28);
		contentPane.add(RegistBtn);
		
		JButton LoginBtn = new JButton("로그인");
		LoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String loginID = IDtextField.getText();
				String loginPW = PWtextField.getText();
				
				
			   ExDB db = new ExDB();
			   
				int loginResult = db.login(loginID, loginPW);
				if(loginResult == 1000) {
					ExchangeRate ex = new ExchangeRate();
					ex.setVisible(true);
					setVisible(false);
					System.out.println("로그인 성공");
					
				}else {
					JOptionPane.showMessageDialog(getContentPane(), "아이디가 없습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				}
					
				
			}
		});
		LoginBtn.setBounds(301, 51, 105, 45);
		contentPane.add(LoginBtn);
	}
}
