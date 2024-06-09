package controller;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import controller.people.AddPeopleUI;
import controller.people.LoginErrorUI;
import controller.people.LoginSuccessUI;
import dao.impl.PeopleDaoImpl;
import model.People;
import util.cal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
		super("LoginUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension scrsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = 900;
		int height = 800;
		int x = (int) ((scrsize.getWidth() - width) / 2);
		int y = (int) ((scrsize.getHeight() - height) / 2);
		setBounds(100, 100, width, height);
		setBounds(x, y, width, height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 128));
		panel_1.setBounds(232, 130, 430, 141);
		panel_1.setLayout(null);
		contentPane.add(panel_1);

		JLabel lblNewLabel_1_1 = new JLabel("登入畫面", SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(151, 23, 120, 41);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("帳號：abc", SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(59, 84, 120, 41);
		panel_1.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("密碼：001", SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(238, 84, 120, 41);
		panel_1.add(lblNewLabel_1_3);

		/* 隱藏游標 */
		textField = new JTextField();
		textField.setBounds(0, 0, 0, 0);
		panel_1.add(textField);
		textField.setColumns(0);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 128, 128));
		panel_2.setBounds(232, 281, 430, 205);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2_1 = new JLabel("帳號", SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setFont(new Font("微軟正黑體", Font.PLAIN, 25));
		lblNewLabel_2_1.setBounds(10, 57, 125, 45);
		panel_2.add(lblNewLabel_2_1);

		username = new JTextField();
		username.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		username.setColumns(10);
		if (cal.existsFile("peopleRemember.txt")) {
			People p = (People) (cal.readFile("peopleRemember.txt"));
			System.out.println(p.getUsername());
			if (p.getUsername().equals("")) {
				System.out.println(p.getPassword());
				username.setText("輸入帳號");
				username.setForeground(Color.gray);
				username.setHorizontalAlignment(JTextField.CENTER);
			} else {
				username.setText(p.getUsername());
			}
		} else {
			username.setText("輸入帳號");
			username.setForeground(Color.gray);
			username.setHorizontalAlignment(JTextField.CENTER);
		}
		username.setBounds(153, 60, 149, 45);
		panel_2.add(username);

		JLabel lblNewLabel_2_2 = new JLabel("密碼");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_2.setFont(new Font("微軟正黑體", Font.PLAIN, 25));
		lblNewLabel_2_2.setBounds(10, 112, 125, 45);
		panel_2.add(lblNewLabel_2_2);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(153, 112, 149, 45);
		panel_2.add(panel_2_1);
		panel_2_1.setLayout(new BorderLayout(0, 0));

		password = new JPasswordField();
		password.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		password.setColumns(6);
		if (cal.existsFile("peopleRemember.txt")) {
			People p = (People) (cal.readFile("peopleRemember.txt"));
			if (p.getPassword().equals("")) {
				System.out.println(p.getPassword());
				password.setText("輸入密碼");
				password.setForeground(Color.gray);
				password.setHorizontalAlignment(JTextField.CENTER);
			} else {
				password.setText(p.getPassword());
			}
		} else {
			password.setText("輸入密碼");
			password.setForeground(Color.gray);
			password.setHorizontalAlignment(JTextField.CENTER);
		}

		panel_2_1.add(password);

		JCheckBox chckbxNewCheckBox = new JCheckBox();

		ImageIcon image = new ImageIcon(LoginUI.class.getResource("/img/show.png"));
		Image img = image.getImage();
		img = img.getScaledInstance(33, 33, Image.SCALE_DEFAULT);
		image.setImage(img);

		ImageIcon image2 = new ImageIcon(LoginUI.class.getResource("/img/hide.png"));
		Image img2 = image2.getImage();
		img2 = img2.getScaledInstance(33, 33, Image.SCALE_DEFAULT);
		image2.setImage(img2);

		chckbxNewCheckBox.setIcon(image2);
		panel_2_1.add(chckbxNewCheckBox, BorderLayout.LINE_END);

		JButton btnNewButton_2_1 = new JButton("登入");
		btnNewButton_2_1.setFont(new Font("微軟正黑體", Font.PLAIN, 26));
		btnNewButton_2_1.setBounds(316, 74, 87, 67);
		panel_2.add(btnNewButton_2_1);

		JButton btnNewButton_2_2 = new JButton("註冊");
		btnNewButton_2_2.setBounds(316, 172, 87, 23);
		panel_2.add(btnNewButton_2_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(157, 79, 79));
		panel_3.setBounds(232, 496, 430, 84);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JButton btnNewButton_3_1 = new JButton("記住帳號");
		btnNewButton_3_1.setBounds(44, 30, 90, 23);
		panel_3.add(btnNewButton_3_1);
		JButton btnNewButton_3_2 = new JButton("忘記帳號");
		btnNewButton_3_2.setBounds(169, 30, 90, 23);
		panel_3.add(btnNewButton_3_2);
		JButton btnNewButton_3_3 = new JButton("忘記密碼");
		btnNewButton_3_3.setBounds(294, 30, 90, 23);
		panel_3.add(btnNewButton_3_3);

		/****************************************/
		/* 再輸入框中顯示提示字串 */
		username.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (username.getText().equals("輸入帳號")) {
					username.setText("");
					username.setForeground(Color.black);
					username.setHorizontalAlignment(JTextField.LEFT);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (username.getText().equals("")) {
					username.setText("輸入帳號");
					username.setForeground(Color.gray);
					username.setHorizontalAlignment(JTextField.CENTER);
				}
			}
		});
		password.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (String.valueOf(password.getPassword()).equals("輸入密碼")) {
					password.setText("");
					password.setForeground(Color.black);
					password.setHorizontalAlignment(JTextField.LEFT);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (String.valueOf(password.getPassword()).equals("")) {
					password.setText("輸入密碼");
					password.setForeground(Color.gray);
					password.setHorizontalAlignment(JTextField.CENTER);
				}
			}
		});

		/* 密碼顯示開關 */
		chckbxNewCheckBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					password.setEchoChar((char) 0);
					chckbxNewCheckBox.setIcon(image);
				} else {
					password.setEchoChar('*');
					chckbxNewCheckBox.setIcon(image2);
				}
			}
		});

		/* 登入 */
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String un = username.getText();
				String pw = new String(password.getPassword());
				People p = new PeopleDaoImpl().queryPeopleByUsername(un);
				if (p != null) {
					System.out.println(p.getPassword());
					if (p.getPassword().equals(pw)) {
						if(cal.existsFile("peopleRemember.txt")) {
							People pr = (People) (cal.readFile("peopleRemember.txt"));
							if (!pr.getUsername().equals(p.getUsername())) {
								cal.deletdFile("peopleRemember.txt");
								System.out.println("刪除peopleRemember");
							}
						}
						cal.saveFile("peopleSuccess.txt", p);
						LoginSuccessUI frame = new LoginSuccessUI();
						frame.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(LoginUI.this, "密碼錯誤");
					}

				} else {
					p.setUsername(un);
					p.setPassword(pw);
					cal.saveFile("peopleError.txt", p);
					LoginErrorUI frame = new LoginErrorUI();
					frame.setVisible(true);
					dispose();
				}

			}
		});

		/* 註冊 */
		btnNewButton_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddPeopleUI frame = new AddPeopleUI();
				frame.setVisible(true);
				dispose();
			}
		});

		/* 跳出提示視窗 */
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String un = username.getText();
				String pw = new String(password.getPassword());
				if (un.equals("") || un.equals("輸入帳號") || pw.equals("輸入密碼") || pw.equals("")) {
					JOptionPane.showMessageDialog(LoginUI.this, "帳號或密碼未輸入");
				} else {
					People p = new People();
					p.setUsername(un);
					p.setPassword(pw);
					cal.saveFile("peopleRemember.txt", p);
					JOptionPane.showMessageDialog(LoginUI.this, "已記住");
				}
			}
		});
		btnNewButton_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(LoginUI.this, "abc");
			}
		});
		btnNewButton_3_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(LoginUI.this, "001");
			}
		});
	}

}
