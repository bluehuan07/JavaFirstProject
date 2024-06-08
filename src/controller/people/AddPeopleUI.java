package controller.people;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginUI;
import dao.impl.PeopleDaoImpl;
import model.People;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;

public class AddPeopleUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address1;
	private JTextField tel;
	private JTextField address2;
	private JTextField birthday;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPeopleUI frame = new AddPeopleUI();
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
	public AddPeopleUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension scrsize = Toolkit.getDefaultToolkit().getScreenSize();	
		int width = 450;
		int height = 500;
		int x = (int)((scrsize.getWidth()-width)/2);
		int y = (int)((scrsize.getHeight()-height)/2);
		setBounds(100, 100, width, height);
		setBounds(x, y, width, height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 10, 416, 30);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("註冊");
		lblNewLabel.setBounds(144, 2, 127, 25);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(10, 50, 416, 401);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setBounds(10, 37, 46, 15);
		panel_1.add(lblNewLabel_1);

		name = new JTextField();
		name.setBounds(119, 34, 96, 21);
		panel_1.add(name);
		name.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("帳號");
		lblNewLabel_2.setBounds(10, 89, 46, 15);
		panel_1.add(lblNewLabel_2);

		username = new JTextField();
		username.setBounds(119, 86, 96, 21);
		panel_1.add(username);
		username.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("密碼");
		lblNewLabel_3.setBounds(10, 141, 46, 15);
		panel_1.add(lblNewLabel_3);

		password = new JTextField();
		password.setBounds(119, 138, 96, 21);
		panel_1.add(password);
		password.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("戶籍地址");
		lblNewLabel_4.setBounds(10, 193, 85, 15);
		panel_1.add(lblNewLabel_4);

		address1 = new JTextField();
		address1.setBounds(119, 190, 96, 21);
		panel_1.add(address1);
		address1.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("通訊地址");
		lblNewLabel_6.setBounds(10, 245, 85, 15);
		panel_1.add(lblNewLabel_6);

		address2 = new JTextField();
		address2.setBounds(119, 242, 96, 21);
		panel_1.add(address2);
		address2.setColumns(10);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("同戶籍地址");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					address2.setText(address1.getText());
				}else {
					address2.setText("");
				}		
			}
		});
		rdbtnNewRadioButton.setBounds(221, 241, 107, 23);
		panel_1.add(rdbtnNewRadioButton);

		JLabel lblNewLabel_7 = new JLabel("出生日期");
		lblNewLabel_7.setBounds(10, 297, 85, 15);
		panel_1.add(lblNewLabel_7);

		birthday = new JTextField();
		birthday.setBounds(119, 294, 96, 21);
		panel_1.add(birthday);
		birthday.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("電話");
		lblNewLabel_5.setBounds(10, 349, 46, 15);
		panel_1.add(lblNewLabel_5);

		tel = new JTextField();
		tel.setBounds(119, 346, 96, 21);
		panel_1.add(tel);
		tel.setColumns(10);

		JButton btnNewButton = new JButton("註冊");
		btnNewButton.setBounds(321, 33, 85, 23);
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("回到登入畫面");
		btnNewButton_1.setBounds(279, 352, 127, 39);
		panel_1.add(btnNewButton_1);

		/* 註冊 */
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username = username.getText();
				People p = new PeopleDaoImpl().queryPeopleByUsername(Username);
				if (p != null) {
					AddPeopleErrorUI frame = new AddPeopleErrorUI();
					frame.setVisible(true);
					dispose();
				} else {
					String Password = password.getText();
					String Name = name.getText();
					String Address1 = address1.getText();
					String Address2 = address2.getText();
					String Birthday = birthday.getText();
					String Tel = tel.getText();
					People p2 = new People(Username, Password, Name, Address1, Address2, Birthday, Tel);
					new PeopleDaoImpl().addPeople(p2);
					AddPeopleSuccessUI frame = new AddPeopleSuccessUI();
					frame.setVisible(true);
					dispose();
				}
			}
		});

		/*回到登入畫面 */
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI frame = new LoginUI();
				frame.setVisible(true);
				dispose();
			}
		});

	}
}
