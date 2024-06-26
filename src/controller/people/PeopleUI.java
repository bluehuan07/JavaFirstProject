package controller.people;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginUI;
import dao.impl.PeopleDaoImpl;
import model.People;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

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
	private JTextField alevel;

	private JTextField uusername;
	private JTextField upassword;
	private JTextField uname;
	private JTextField uaddress1;
	private JTextField uaddress2;
	private JTextField ubirthday;
	private JTextField utel;
	private JTextField ulevel;

	private JTextField dusername;

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
		super("會員管理系統");
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

		/* panel 標題 */
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(177, 10, 530, 89);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("會員管理系統");
		lblNewLabel.setBounds(174, 24, 182, 41);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 30));
		panel.add(lblNewLabel);

		/* panel_1 新增 */
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 128));
		panel_1.setBounds(18, 109, 856, 101);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("帳號：");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(10, 12, 85, 31);
		panel_1.add(lblNewLabel_1_1);

		ausername = new JTextField();
		ausername.setBounds(95, 17, 96, 21);
		panel_1.add(ausername);
		ausername.setColumns(10);

		JLabel lblNewLabel_1_2 = new JLabel("密碼：");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(191, 12, 85, 31);
		panel_1.add(lblNewLabel_1_2);

		apassword = new JTextField();
		apassword.setBounds(276, 17, 96, 21);
		panel_1.add(apassword);
		apassword.setColumns(10);

		JLabel lblNewLabel_1_3 = new JLabel("姓名：");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_1_3.setBounds(372, 12, 85, 31);
		panel_1.add(lblNewLabel_1_3);

		aname = new JTextField();
		aname.setBounds(457, 17, 96, 21);
		panel_1.add(aname);
		aname.setColumns(10);

		JLabel lblNewLabel_1_4 = new JLabel("戶籍地址：");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_1_4.setBounds(10, 55, 85, 31);
		panel_1.add(lblNewLabel_1_4);

		aaddress1 = new JTextField();
		aaddress1.setBounds(95, 60, 96, 21);
		panel_1.add(aaddress1);
		aaddress1.setColumns(10);

		JLabel lblNewLabel_1_5 = new JLabel("通訊地址：");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_1_5.setBounds(191, 55, 85, 31);
		panel_1.add(lblNewLabel_1_5);

		aaddress2 = new JTextField();
		aaddress2.setBounds(276, 60, 96, 21);
		panel_1.add(aaddress2);
		aaddress2.setColumns(10);

		JLabel lblNewLabel_1_6 = new JLabel("生日：");
		lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_6.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_1_6.setBounds(553, 12, 85, 31);
		panel_1.add(lblNewLabel_1_6);

		abirthday = new JTextField();
		abirthday.setBounds(638, 17, 96, 21);
		panel_1.add(abirthday);
		abirthday.setColumns(10);

		JLabel lblNewLabel_1_7 = new JLabel("電話：");
		lblNewLabel_1_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_7.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_1_7.setBounds(372, 55, 85, 31);
		panel_1.add(lblNewLabel_1_7);

		atel = new JTextField();
		atel.setBounds(457, 60, 96, 21);
		panel_1.add(atel);
		atel.setColumns(10);

		JLabel lblNewLabel_1_8 = new JLabel("等級：");
		lblNewLabel_1_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_8.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_1_8.setBounds(553, 55, 85, 31);
		panel_1.add(lblNewLabel_1_8);

		alevel = new JTextField();
		alevel.setBounds(638, 60, 96, 21);
		panel_1.add(alevel);
		alevel.setColumns(10);

		JButton btnNewButton = new JButton("註冊");
		btnNewButton.setBounds(761, 59, 85, 23);
		panel_1.add(btnNewButton);

		/* panel_2 查詢 */
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 128, 128));
		panel_2.setBounds(18, 220, 856, 277);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 836, 214);
		panel_2.add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		textArea.setEditable(false);

		JButton btnNewButton_2_1 = new JButton("查詢");
		btnNewButton_2_1.setBounds(761, 244, 85, 23);
		panel_2.add(btnNewButton_2_1);

		/* panel_3 修改 */
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(128, 128, 128));
		panel_3.setBounds(18, 507, 856, 95);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_3_1 = new JLabel("帳號：");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_3_1.setBounds(2, 10, 85, 31);
		panel_3.add(lblNewLabel_3_1);

		uusername = new JTextField();
		uusername.setBounds(89, 15, 96, 21);
		panel_3.add(uusername);
		uusername.setColumns(10);

		JLabel lblNewLabel_3_2 = new JLabel("密碼：");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_3_2.setBounds(187, 10, 85, 31);
		panel_3.add(lblNewLabel_3_2);

		upassword = new JTextField();
		upassword.setBounds(274, 15, 96, 21);
		panel_3.add(upassword);
		upassword.setColumns(10);

		JLabel lblNewLabel_3_3 = new JLabel("姓名：");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_3_3.setBounds(372, 10, 85, 31);
		panel_3.add(lblNewLabel_3_3);

		uname = new JTextField();
		uname.setBounds(459, 15, 96, 21);
		panel_3.add(uname);
		uname.setColumns(10);

		JLabel lblNewLabel_3_4 = new JLabel("通訊地址：");
		lblNewLabel_3_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_3_4.setBounds(2, 51, 85, 31);
		panel_3.add(lblNewLabel_3_4);

		uaddress1 = new JTextField();
		uaddress1.setBounds(89, 56, 96, 21);
		panel_3.add(uaddress1);
		uaddress1.setColumns(10);

		JLabel lblNewLabel_3_5 = new JLabel("戶籍地址：");
		lblNewLabel_3_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_5.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_3_5.setBounds(187, 51, 85, 31);
		panel_3.add(lblNewLabel_3_5);

		uaddress2 = new JTextField();
		uaddress2.setBounds(274, 56, 96, 21);
		panel_3.add(uaddress2);
		uaddress2.setColumns(10);

		JLabel lblNewLabel_3_6 = new JLabel("生日：");
		lblNewLabel_3_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_6.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_3_6.setBounds(557, 10, 85, 31);
		panel_3.add(lblNewLabel_3_6);

		ubirthday = new JTextField();
		ubirthday.setBounds(644, 15, 96, 21);
		panel_3.add(ubirthday);
		ubirthday.setColumns(10);

		JLabel lblNewLabel_3_7 = new JLabel("電話：");
		lblNewLabel_3_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_7.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_3_7.setBounds(372, 51, 85, 31);
		panel_3.add(lblNewLabel_3_7);

		utel = new JTextField();
		utel.setBounds(459, 56, 96, 21);
		panel_3.add(utel);
		utel.setColumns(10);

		JLabel lblNewLabel_3_8 = new JLabel("等級：");
		lblNewLabel_3_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_8.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_3_8.setBounds(557, 51, 85, 31);
		panel_3.add(lblNewLabel_3_8);

		ulevel = new JTextField();
		ulevel.setBounds(644, 56, 96, 21);
		panel_3.add(ulevel);
		ulevel.setColumns(10);

		JButton btnNewButton_3_1 = new JButton("修改");
		btnNewButton_3_1.setBounds(761, 55, 85, 23);
		panel_3.add(btnNewButton_3_1);

		/* panel_4刪除 */
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(128, 128, 128));
		panel_4.setBounds(18, 612, 856, 48);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_4_1 = new JLabel("帳號：");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_4_1.setBounds(147, 8, 85, 31);
		panel_4.add(lblNewLabel_4_1);

		dusername = new JTextField();
		dusername.setBounds(379, 13, 96, 21);
		panel_4.add(dusername);
		dusername.setColumns(10);

		JButton btnNewButton_4_1 = new JButton("刪除");
		btnNewButton_4_1.setBounds(622, 12, 85, 23);
		panel_4.add(btnNewButton_4_1);

		/* panel_2 按鈕列 */
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(128, 128, 64));
		panel_5.setBounds(229, 677, 416, 57);
		contentPane.add(panel_5);
		panel_5.setLayout(null);

		JButton btnNewButton_5_1 = new JButton("登出");
		btnNewButton_5_1.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
		btnNewButton_5_1.setBounds(38, 17, 87, 23);
		panel_5.add(btnNewButton_5_1);

		JButton btnNewButton_5_2 = new JButton("回上一頁");
		btnNewButton_5_2.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
		btnNewButton_5_2.setBounds(163, 17, 87, 23);
		panel_5.add(btnNewButton_5_2);

		JButton btnNewButton_5_3 = new JButton("結束");
		btnNewButton_5_3.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
		btnNewButton_5_3.setBounds(288, 17, 87, 23);
		panel_5.add(btnNewButton_5_3);

		/*************************************************/
		/* 註冊 */
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				People p = new PeopleDaoImpl().queryPeopleByUsername(ausername.getText());
				if (p == null) {
					if (!apassword.getText().equals("")) {
						p = new People(ausername.getText(), apassword.getText(), aname.getText(), aaddress1.getText(),
								aaddress2.getText(), abirthday.getText(), atel.getText(), alevel.getText());
						new PeopleDaoImpl().addPeople(p);
						textArea.setText(new PeopleDaoImpl().queryAllString());
					} else {
						textArea.setText("請輸入密碼");
					}
				} else {
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
		/* 修改ByUsername */
		btnNewButton_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String uUsername = uusername.getText();
				People p = new PeopleDaoImpl().queryPeopleByUsername(uUsername);
				if (p != null) {
					String uPassword = upassword.getText();
					p.setPassword(uPassword);
					String uName = uname.getText();
					p.setName(uName);
					String uAddress1 = uaddress1.getText();
					p.setAddress1(uAddress1);
					String uAddress2 = uaddress2.getText();
					p.setAddress2(uAddress2);
					String uBirthday = ubirthday.getText();
					p.setBirthday(uBirthday);
					String uTel = utel.getText();
					p.setTel(uTel);
					String uLevel = ulevel.getText();
					p.setLevel(uLevel);
					new PeopleDaoImpl().updatePeopleByUsername(p);
					JOptionPane.showMessageDialog(PeopleUI.this, "修改成功");
					uusername.setText("");
					upassword.setText("");
					uname.setText("");
					uaddress1.setText("");
					uaddress2.setText("");
					ubirthday.setText("");
					utel.setText("");
					ulevel.setText("");
					textArea.setText(new PeopleDaoImpl().queryAllString());
				} else {
					JOptionPane.showMessageDialog(PeopleUI.this, "無此帳號");
				}
			}
		});
		/* 刪除ByUsername */
		btnNewButton_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String dUsername = dusername.getText();
				People p = new PeopleDaoImpl().queryPeopleByUsername(dUsername);
				if (p != null) {
					new PeopleDaoImpl().deletePeopleByUsernam(dUsername);
					dusername.setText("");
					textArea.setText(new PeopleDaoImpl().queryAllString());
				} else {
					JOptionPane.showMessageDialog(PeopleUI.this, "無此帳號");
				}
			}
		});
		/* 下方按鈕列 */
		/* 登出 */
		btnNewButton_5_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI frame = new LoginUI();
				frame.setVisible(true);
				dispose();
			}
		});
		/* 上一頁 */
		btnNewButton_5_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginSuccessUI frame = new LoginSuccessUI();
				frame.setVisible(true);
				dispose();
			}
		});
		/* 結束程式 */
		btnNewButton_5_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

	}
}
