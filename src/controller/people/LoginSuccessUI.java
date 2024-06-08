package controller.people;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginUI;
import controller.Porder.PorderUI;
import model.People;
import util.cal;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

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
		panel.setBounds(33, 10, 375, 185);
		contentPane.add(panel);

		JLabel memberShow = new JLabel("New label");
		panel.add(memberShow);
		People m = (People) (cal.readFile("people.txt"));
		memberShow.setText(m.getName());

		JLabel lblNewLabel = new JLabel("登入成功");
		panel.add(lblNewLabel);

		JButton btnNewButton = new JButton("回到登入畫面");
		btnNewButton.setBounds(145, 113, 127, 39);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("進入商店");
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("修改會員資料");
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
				PorderUI frame = new PorderUI();
				frame.setVisible(true);
				dispose();
			}
		});
		/* 修改會員資料 */
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PeopleUI frame = new PeopleUI();
				frame.setVisible(true);
				dispose();
			}
		});
	}
}
