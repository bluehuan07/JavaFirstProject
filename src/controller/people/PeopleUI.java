package controller.people;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.PeopleDaoImpl;
import model.People;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Font;
import java.awt.Toolkit;

public class PeopleUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ausername;
	private JTextField apassword;
	private JTextField aname;
	private JTextField aaddress1;
	private JTextField aaddress2;
	private JTextField abirthday;
	private JTextField atel;
	private JTextField uid;
	private JTextField uname;
	private JTextField upassword;
	private JTextField uaddress;
	private JTextField uphone;
	private JTextField did;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PeopleUI frame = new PeopleUI();
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
	public PeopleUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension scrsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = 800;
		int height = 800;
		int x = (int) ((scrsize.getWidth() - width) / 2);
		int y = (int) ((scrsize.getHeight() - height) / 2);
		setBounds(100, 100, width, height);
		setBounds(x, y, width, height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		/* panel */
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(126, 10, 530, 89);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("會員管理系統");
		lblNewLabel.setBounds(174, 24, 182, 41);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 30));
		panel.add(lblNewLabel);

		/* panel_1 */
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 128));
		panel_1.setBounds(18, 109, 750, 98);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("帳號：");
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(10, 12, 85, 31);
		panel_1.add(lblNewLabel_1_1);

		ausername = new JTextField();
		ausername.setBounds(95, 17, 96, 21);
		panel_1.add(ausername);
		ausername.setColumns(10);

		JLabel lblNewLabel_1_2 = new JLabel("密碼：");
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(191, 12, 85, 31);
		panel_1.add(lblNewLabel_1_2);

		apassword = new JTextField();
		apassword.setBounds(276, 17, 96, 21);
		panel_1.add(apassword);
		apassword.setColumns(10);

		JLabel lblNewLabel_1_3 = new JLabel("姓名：");
		lblNewLabel_1_3.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_1_3.setBounds(372, 12, 85, 31);
		panel_1.add(lblNewLabel_1_3);

		aname = new JTextField();
		aname.setBounds(457, 17, 96, 21);
		panel_1.add(aname);
		aname.setColumns(10);

		JLabel lblNewLabel_1_4 = new JLabel("戶籍地址：");
		lblNewLabel_1_4.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_1_4.setBounds(10, 55, 85, 31);
		panel_1.add(lblNewLabel_1_4);

		aaddress1 = new JTextField();
		aaddress1.setBounds(95, 60, 96, 21);
		panel_1.add(aaddress1);
		aaddress1.setColumns(10);

		JLabel lblNewLabel_1_5 = new JLabel("通訊地址：");
		lblNewLabel_1_5.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_1_5.setBounds(191, 55, 85, 31);
		panel_1.add(lblNewLabel_1_5);

		aaddress2 = new JTextField();
		aaddress2.setBounds(276, 60, 96, 21);
		panel_1.add(aaddress2);
		aaddress2.setColumns(10);

		JLabel lblNewLabel_1_6 = new JLabel("生日：");
		lblNewLabel_1_6.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_1_6.setBounds(553, 12, 85, 31);
		panel_1.add(lblNewLabel_1_6);

		abirthday = new JTextField();
		abirthday.setBounds(638, 17, 96, 21);
		panel_1.add(abirthday);
		abirthday.setColumns(10);

		JLabel lblNewLabel_1_7 = new JLabel("電話：");
		lblNewLabel_1_7.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_1_7.setBounds(372, 55, 85, 31);
		panel_1.add(lblNewLabel_1_7);

		atel = new JTextField();
		atel.setBounds(457, 60, 96, 21);
		panel_1.add(atel);
		atel.setColumns(10);

		JButton btnNewButton = new JButton("註冊");
		btnNewButton.setBounds(649, 59, 85, 23);
		panel_1.add(btnNewButton);

		/* panel_2 */
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 128, 128));
		panel_2.setBounds(18, 217, 750, 255);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(21, 20, 702, 189);
		panel_2.add(textArea);

		JButton btnNewButton_2_1 = new JButton("查詢");
		btnNewButton_2_1.setBounds(638, 219, 85, 23);
		panel_2.add(btnNewButton_2_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(128, 128, 128));
		panel_3.setBounds(18, 482, 750, 172);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("帳號：");
		lblNewLabel_6.setBounds(46, 24, 46, 15);
		panel_3.add(lblNewLabel_6);

		uid = new JTextField();
		uid.setBounds(138, 21, 96, 21);
		panel_3.add(uid);
		uid.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("姓名：");
		lblNewLabel_7.setBounds(280, 24, 46, 15);
		panel_3.add(lblNewLabel_7);

		uname = new JTextField();
		uname.setBounds(372, 21, 96, 21);
		panel_3.add(uname);
		uname.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("密碼：");
		lblNewLabel_8.setBounds(514, 24, 46, 15);
		panel_3.add(lblNewLabel_8);

		upassword = new JTextField();
		upassword.setBounds(606, 21, 96, 21);
		panel_3.add(upassword);
		upassword.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("地址：");
		lblNewLabel_9.setBounds(46, 74, 46, 15);
		panel_3.add(lblNewLabel_9);

		uaddress = new JTextField();
		uaddress.setBounds(138, 71, 96, 21);
		panel_3.add(uaddress);
		uaddress.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("電話：");
		lblNewLabel_10.setBounds(280, 74, 46, 15);
		panel_3.add(lblNewLabel_10);

		uphone = new JTextField();
		uphone.setBounds(372, 71, 96, 21);
		panel_3.add(uphone);
		uphone.setColumns(10);

		JButton btnNewButton_2 = new JButton("修改");
		btnNewButton_2.setBounds(617, 70, 85, 23);
		panel_3.add(btnNewButton_2);

		JLabel lblNewLabel_11 = new JLabel("ID：");
		lblNewLabel_11.setBounds(46, 129, 46, 15);
		panel_3.add(lblNewLabel_11);

		did = new JTextField();
		did.setBounds(138, 126, 96, 21);
		panel_3.add(did);
		did.setColumns(10);

		JButton btnNewButton_3 = new JButton("刪除");
		btnNewButton_3.setBounds(617, 125, 85, 23);
		panel_3.add(btnNewButton_3);

		/**/
		/* 註冊 */
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				People p = new PeopleDaoImpl().queryPeopleByUsername(ausername.getText());
				if(p==null) {
					if(!apassword.getText().equals("")) {
						p = new People(ausername.getText(), apassword.getText(), aname.getText(), aaddress1.getText(),
								aaddress2.getText(), abirthday.getText(), atel.getText());
						new PeopleDaoImpl().addPeople(p);
						textArea.setText(new PeopleDaoImpl().queryAllString());
					}
					else {
						textArea.setText("請輸入密碼");
					}
				}else {
					textArea.setText("已存在此帳號，請重新註冊");
				}
			}
		});
		/* 查詢全部 */
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea.setText(new PeopleDaoImpl().queryAllString());
			}
		});
		/* 修改ById */
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ID = Integer.parseInt(uid.getText());

				String Name = uname.getText();
				String Password = upassword.getText();
				String Address = uaddress.getText();
				String Phone = uphone.getText();

				People m = new PeopleDaoImpl().queryPeopleById(ID);
				m.setName(Name);
				m.setPassword(Password);

				new PeopleDaoImpl().updatePeopleById(m);

				uid.setText("");
				uname.setText("");
				upassword.setText("");
				uaddress.setText("");
				uphone.setText("");
				textArea.setText(new PeopleDaoImpl().queryAllString());
			}
		});
		/* 刪除ById */
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ID = Integer.parseInt(did.getText());
				new PeopleDaoImpl().deletePeopleById(ID);
				did.setText("");
				textArea.setText(new PeopleDaoImpl().queryAllString());
			}
		});

	}
}
