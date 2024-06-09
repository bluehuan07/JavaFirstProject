package controller.people;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginUI;
import dao.impl.PeopleDaoImpl;
import model.People;
import util.cal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class PeopleMemberUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
					PeopleMemberUI frame = new PeopleMemberUI();
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
	public PeopleMemberUI() {
		super("會員管理系統");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension scrsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = 450;
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
		panel.setBounds(20, 10, 391, 89);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("會員管理系統");
		lblNewLabel.setBounds(104, 24, 182, 41);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 30));
		panel.add(lblNewLabel);

		/* panel_3 修改 */
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(128, 128, 128));
		panel_3.setBounds(10, 109, 414, 308);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		People p = (People) (cal.readFile("peopleSuccess.txt"));

		JLabel lblNewLabel_3_1 = new JLabel("帳號：");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_3_1.setBounds(10, 10, 85, 31);
		panel_3.add(lblNewLabel_3_1);

		uusername = new JTextField();
		uusername.setBounds(105, 15, 96, 21);
		uusername.setText(p.getUsername());
		uusername.setEditable(false);
		panel_3.add(uusername);
		uusername.setColumns(10);

		JLabel lblNewLabel_3_2 = new JLabel("密碼：");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_3_2.setBounds(211, 10, 85, 31);
		panel_3.add(lblNewLabel_3_2);

		upassword = new JTextField();
		upassword.setBounds(306, 15, 96, 21);
		upassword.setText(p.getPassword());
		panel_3.add(upassword);
		upassword.setColumns(10);

		JLabel lblNewLabel_3_3 = new JLabel("姓名：");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_3_3.setBounds(77, 70, 85, 31);
		panel_3.add(lblNewLabel_3_3);

		uname = new JTextField();
		uname.setBounds(239, 75, 96, 21);
		uname.setText(p.getName());
		panel_3.add(uname);
		uname.setColumns(10);

		JLabel lblNewLabel_3_4 = new JLabel("通訊地址：");
		lblNewLabel_3_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_3_4.setBounds(10, 130, 85, 31);
		panel_3.add(lblNewLabel_3_4);

		uaddress1 = new JTextField();
		uaddress1.setBounds(105, 135, 96, 21);
		uaddress1.setText(p.getAddress1());
		panel_3.add(uaddress1);
		uaddress1.setColumns(10);

		JLabel lblNewLabel_3_5 = new JLabel("戶籍地址：");
		lblNewLabel_3_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_5.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_3_5.setBounds(211, 130, 85, 31);
		panel_3.add(lblNewLabel_3_5);

		uaddress2 = new JTextField();
		uaddress2.setBounds(306, 135, 96, 21);
		uaddress2.setText(p.getAddress2());
		panel_3.add(uaddress2);
		uaddress2.setColumns(10);

		JLabel lblNewLabel_3_6 = new JLabel("生日：");
		lblNewLabel_3_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_6.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_3_6.setBounds(10, 190, 85, 31);
		panel_3.add(lblNewLabel_3_6);

		ubirthday = new JTextField();
		ubirthday.setBounds(105, 195, 96, 21);
		ubirthday.setText(p.getBirthday());
		panel_3.add(ubirthday);
		ubirthday.setColumns(10);

		JLabel lblNewLabel_3_7 = new JLabel("電話：");
		lblNewLabel_3_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_7.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_3_7.setBounds(211, 190, 85, 31);
		panel_3.add(lblNewLabel_3_7);

		utel = new JTextField();
		utel.setBounds(306, 195, 96, 21);
		utel.setText(p.getTel());
		panel_3.add(utel);
		utel.setColumns(10);

		JButton btnNewButton_3_1 = new JButton("修改");
		btnNewButton_3_1.setBounds(164, 250, 85, 23);
		panel_3.add(btnNewButton_3_1);

		/* panel_4刪除 */
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(128, 128, 128));
		panel_4.setBounds(10, 427, 414, 48);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_4_1 = new JLabel("帳號：");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		lblNewLabel_4_1.setBounds(37, 8, 85, 31);
		panel_4.add(lblNewLabel_4_1);

		dusername = new JTextField();
		dusername.setBounds(159, 13, 96, 21);
		panel_4.add(dusername);
		dusername.setColumns(10);

		JButton btnNewButton_4_1 = new JButton("刪除");
		btnNewButton_4_1.setBounds(292, 12, 85, 23);
		panel_4.add(btnNewButton_4_1);

		/* panel_2 按鈕列 */
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(128, 128, 64));
		panel_5.setBounds(10, 485, 416, 57);
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
					JOptionPane.showMessageDialog(PeopleMemberUI.this, "修改成功");
				} else {
					JOptionPane.showMessageDialog(PeopleMemberUI.this, "無此帳號");
				}
			}
		});
		/* 刪除ByUsername */
		btnNewButton_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String dUsername = dusername.getText();
				People p = new PeopleDaoImpl().queryPeopleByUsername(dUsername);
				JOptionPane.showMessageDialog(PeopleMemberUI.this, "確認要刪除帳好？");
				if (p != null) {
					new PeopleDaoImpl().deletePeopleByUsernam(dUsername);
					dusername.setText("");
				} else {
					JOptionPane.showMessageDialog(PeopleMemberUI.this, "無此帳號");
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
