package controller.people;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginUI;
import controller.drink.DrinkUI;
import model.People;
import util.cal;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class LoginSuccessUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSuccessUI frame = new LoginSuccessUI();
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
	public LoginSuccessUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension scrsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = 450;
		int height = 300;
		int x = (int) ((scrsize.getWidth() - width) / 2);
		int y = (int) ((scrsize.getHeight() - height) / 2);
		setBounds(100, 100, width, height);
		setBounds(x, y, width, height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 38, 414, 185);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("登入成功");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(141, 10, 132, 57);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(65, 64, 283, 57);
		panel.add(lblNewLabel_2);
		People p = (People) (cal.readFile("peopleSuccess.txt"));
		String outputlevel = "";
		switch (p.getLevel()) {
		case "A": {
			outputlevel = " 員工您好";
			break;
		}
		case "B": {
			outputlevel = " 白金會員您好";
			break;
		}
		case "C": {
			outputlevel = " 一般會員您好";
			break;
		}
		}
		lblNewLabel_2.setText(p.getName() + outputlevel);

		JButton btnNewButton = new JButton("回到登入畫面");
		btnNewButton.setBounds(19, 152, 126, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("進入商店");
		btnNewButton_1.setBounds(164, 152, 85, 23);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("修改會員資料");
		btnNewButton_2.setBounds(268, 152, 126, 23);
		panel.add(btnNewButton_2);

		/* 回到登入畫面 */
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI frame = new LoginUI();
				frame.setVisible(true);
				dispose();
			}
		});
		/* 進入商店 */
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DrinkUI frame = new DrinkUI();
				frame.setVisible(true);
				dispose();
			}
		});
		/* 修改會員資料 */
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switch (p.getLevel()) {
				case "A": {
					PeopleUI frame = new PeopleUI();
					frame.setVisible(true);
					dispose();
					break;
				}
				case "B": {
					PeopleMemberUI frame = new PeopleMemberUI();
					frame.setVisible(true);
					dispose();
					break;
				}
				case "C": {
					PeopleMemberUI frame = new PeopleMemberUI();
					frame.setVisible(true);
					dispose();
					break;
				}
				}
			}
		});
	}
}
