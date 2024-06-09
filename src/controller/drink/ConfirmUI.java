package controller.drink;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import controller.LoginUI;
import dao.impl.DrinkDaoImpl;
import dao.impl.PeopleDaoImpl;
import model.Drink;
import model.People;
import util.cal;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ConfirmUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmUI frame = new ConfirmUI();
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
	public ConfirmUI() {
		super("ConfirmUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension scrsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = 450;
		int height = 400;
		int x = (int) ((scrsize.getWidth() - width) / 2);
		int y = (int) ((scrsize.getHeight() - height) / 2);
		setBounds(100, 100, width, height);
		setBounds(x, y, width, height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(164, 164, 164));
		panel_1.setBounds(10, 10, 416, 243);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("購物車");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(139, 10, 138, 44);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel();
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(10, 47, 267, 30);
		Drink d = (Drink) (cal.readFile("drink.txt"));
		People p = new PeopleDaoImpl().queryPeopleByUsername(d.getUsername());
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
		lblNewLabel_1_2.setText(d.getName() + outputlevel);
		panel_1.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("請確認您的資料");
		lblNewLabel_1_3.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(10, 82, 146, 30);
		panel_1.add(lblNewLabel_1_3);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 122, 396, 111);
		textArea.setEditable(false);
		panel_1.add(textArea);
		int sum = d.getPeach() * 60 + d.getMelon() * 65 + d.getBrown() * 75;
		switch (p.getLevel()) {
		case "A": {
			sum = (int) Math.round(sum * 0.7);
			break;
		}
		case "B": {
			sum = (int) Math.round(sum * 0.8);
			break;
		}
		case "C": {
			sum = (int) Math.round(sum * 0.9);
			break;
		}
		}
		String outputDetail = "密桃奶茶: " + d.getPeach() + " 杯\n";
		outputDetail = outputDetail + "冷露歐雷: " + d.getMelon() + " 杯\n";
		outputDetail = outputDetail + "黑糖鮮奶: " + d.getBrown() + " 杯\n";
		outputDetail = outputDetail + "共: " + sum + " 元";
		textArea.setText(outputDetail);

		JButton btnNewButton = new JButton("確認");
		btnNewButton.setBounds(321, 86, 85, 23);
		panel_1.add(btnNewButton);
		
		/* panel_2 按鈕列 */
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 128, 64));
		panel_2.setBounds(10, 281, 416, 57);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JButton btnNewButton_2_1 = new JButton("登出");
		btnNewButton_2_1.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
		btnNewButton_2_1.setBounds(38, 17, 87, 23);
		panel_2.add(btnNewButton_2_1);

		JButton btnNewButton_2_2 = new JButton("回上一頁");
		btnNewButton_2_2.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
		btnNewButton_2_2.setBounds(163, 17, 87, 23);
		panel_2.add(btnNewButton_2_2);

		JButton btnNewButton_2_3 = new JButton("結束");
		btnNewButton_2_3.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
		btnNewButton_2_3.setBounds(288, 17, 87, 23);
		panel_2.add(btnNewButton_2_3);

		/* 確認 */
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new DrinkDaoImpl().addDrink(d);
				FinishUI f = new FinishUI();
				f.setVisible(true);
				dispose();
			}
		});

		/* 下方按鈕列 */
		/* 登出 */
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI frame = new LoginUI();
				frame.setVisible(true);
				dispose();
			}
		});
		/* 上一頁 */
		btnNewButton_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DrinkUI frame = new DrinkUI();
				frame.setVisible(true);
				dispose();
			}
		});
		/* 結束程式 */
		btnNewButton_2_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
	}

}
