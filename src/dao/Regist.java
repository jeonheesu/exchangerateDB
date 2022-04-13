package dao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.ExDB;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Regist extends JFrame {

	private JPanel contentPane;
	private JTextField IDtextField;
	private JTextField PWtextField;
	private JTextField PW1textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Regist frame = new Regist();
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
	public Regist() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회원가입");
		lblNewLabel.setBounds(169, 12, 59, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setBounds(94, 47, 59, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("비밀번호");
		lblNewLabel_1_1.setBounds(94, 75, 59, 18);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("비밀번호 확인");
		lblNewLabel_1_2.setBounds(75, 104, 88, 20);
		contentPane.add(lblNewLabel_1_2);
		
		IDtextField = new JTextField();
		IDtextField.setBounds(179, 45, 114, 22);
		contentPane.add(IDtextField);
		IDtextField.setColumns(10);
		
		PWtextField = new JTextField();
		PWtextField.setColumns(10);
		PWtextField.setBounds(179, 73, 114, 22);
		contentPane.add(PWtextField);
		
		PW1textField = new JTextField();
		PW1textField.setColumns(10);
		PW1textField.setBounds(179, 103, 114, 22);
		contentPane.add(PW1textField);
		
		JButton btnNewButton = new JButton("회원가입");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				boolean idboolean = false;
				boolean pwboolean = false;
				
				
			String ID = IDtextField.getText();
			String PW = PWtextField.getText();
			String resultID = ID.trim().replaceAll(" ", "");
			String resultPW = PW.trim().replaceAll(" ", "");
			String rePW = PW1textField.getText();
			
			 
			
			
			
			
			if(resultID == null || resultID.equals("")) {
				System.out.println("아이디 입력하세요");
				JOptionPane.showMessageDialog(contentPane, "아이디를 입력해주세요", "경고", JOptionPane.WARNING_MESSAGE);
			}
			
			else if (resultID.length() > 6) {
				System.out.println("6글자이하로 아이디를 만들어주세요.");
				JOptionPane.showMessageDialog(contentPane, "6글자 이하로 아이디를 만들어주세요", "경고", JOptionPane.WARNING_MESSAGE);
			
				} else {
				System.out.println("아이디 입력완료.");
				System.out.println("DB에 저장될 아이디 :" + resultID);
      			idboolean = true;
				}
			
			if(resultPW == null || resultPW.equals("") ) {
				System.out.println("비밀번호를 입력해주세요.");
				JOptionPane.showMessageDialog(contentPane, "비밀번호 입력하세요", "경고", JOptionPane.WARNING_MESSAGE);
			}else {
			
				if(resultPW.equals(rePW)) {
					System.out.println("비밀번호가 일치합니다");
					pwboolean = true;
				}else {
					System.out.println("비밀번호가 일치하지 않습니다");
					JOptionPane.showMessageDialog(contentPane, "비밀번호가 일치하지 않습니다.", "경고",	JOptionPane.WARNING_MESSAGE);
				}
				
			}
			if(idboolean == true || pwboolean == true) {
				ExDB db = new ExDB();
				db.insert(resultID, PW);
				System.out.println("insert 완료");
				setVisible(false);
				LoginChang lc = new LoginChang();
				lc.setVisible(pwboolean);
				
			}
		
		
					}
		
			
						
			
		});
		btnNewButton.setBounds(188, 137, 105, 28);
		contentPane.add(btnNewButton);
	}

}
