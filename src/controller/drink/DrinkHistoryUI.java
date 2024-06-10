package controller.drink;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.impl.DrinkDaoImpl;
import dao.impl.PeopleDaoImpl;
import model.Drink;
import model.People;
import util.cal;

public class DrinkHistoryUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrinkHistoryUI frame = new DrinkHistoryUI("", 0);
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
	public DrinkHistoryUI(String username, int moveRight) {
		super("購買的歷史紀錄");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension scrsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = 480;
		int height = 360;
		int x = (int) ((scrsize.getWidth() - width) / 2 + moveRight + 20);
		int y = (int) ((scrsize.getHeight() - height) / 2);
		setBounds(100, 100, width, height);
		setBounds(x, y, width, height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(164, 164, 164));
		panel_1.setBounds(10, 10, 444, 301);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("歷史紀錄");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(139, 10, 138, 44);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel();
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(10, 47, 267, 30);
		People p = (People) (cal.readFile("peopleSuccess.txt"));
		People ptmp = new PeopleDaoImpl().queryPeopleByUsername(p.getUsername());
		String outputlevel = "";
		switch (ptmp.getLevel()) {
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
		lblNewLabel_1_2.setText(ptmp.getName() + outputlevel);
		panel_1.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("以下為您的購買紀錄");
		lblNewLabel_1_3.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(10, 82, 146, 30);
		panel_1.add(lblNewLabel_1_3);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 122, 424, 169);
		textArea.setEditable(false);
		panel_1.add(textArea);
		textArea.setText(new DrinkDaoImpl().queryHistoryByUsername(username));

		JButton btnNewButton = new JButton("結束");
		btnNewButton.setBounds(349, 90, 85, 23);
		panel_1.add(btnNewButton);
		/* 結束 */
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});

	}

}
