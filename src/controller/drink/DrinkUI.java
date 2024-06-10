package controller.drink;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.LoginUI;
import controller.people.LoginSuccessUI;
import model.Drink;
import model.People;
import util.cal;
import javax.swing.SwingConstants;

public class DrinkUI extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrinkUI frame = new DrinkUI();
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
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField peach;
	private JTextField melon;
	private JTextField brown;
	private JTextField textField;
	Drink d = null;
	People p = null;

	public DrinkUI() {
		super("訂購畫面");
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

		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		panel.setBounds(34, 39, 366, 57);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("JAVA雲端課程訂飲料系統");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		p = (People) (cal.readFile("peopleSuccess.txt"));
		lblNewLabel.setText(p.getName() + "  歡迎來到訂飲料系統");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel.setBounds(56, 15, 254, 26);
		panel.add(lblNewLabel);

		/* panel_1 購買數量 */
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(34, 106, 366, 165);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		/* 隱藏游標 */
		textField = new JTextField();
		textField.setBounds(0, 0, 0, 0);
		panel_1.add(textField);
		textField.setColumns(0);

		JLabel lblNewLabel_1_1 = new JLabel("姓名:");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 10, 75, 28);
		panel_1.add(lblNewLabel_1_1);

		p = (People) (cal.readFile("peopleSuccess.txt"));
		name = new JTextField();
		name.setText(p.getName());
		name.setBounds(85, 14, 150, 21);
		name.setHorizontalAlignment(JTextField.CENTER);
		name.setEditable(false);
		panel_1.add(name);
		name.setColumns(10);

		JLabel lblNewLabel_1_2 = new JLabel("是否為會員");
		String outputlevel = "";
		switch (p.getLevel()) {
		case "A": {
			outputlevel = "員工您好";
			break;
		}
		case "B": {
			outputlevel = "白金會員您好";
			break;
		}
		case "C": {
			outputlevel = "一般會員您好";
			break;
		}
		}
		lblNewLabel_1_2.setText(outputlevel);
		lblNewLabel_1_2.setBounds(245, 14, 111, 21);
		panel_1.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.BOLD, 14));

		JLabel lblNewLabel_1_3 = new JLabel("密桃奶茶：");// 60元
		lblNewLabel_1_3.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(10, 48, 75, 28);
		panel_1.add(lblNewLabel_1_3);

		peach = new JTextField();
		if (cal.existsFile("drink.txt")) {
			Drink d = (Drink) (cal.readFile("drink.txt"));
			peach.setText("" + d.getPeach());
		} else {
			peach.setText("1杯60元");
			peach.setHorizontalAlignment(JTextField.CENTER);
			peach.setForeground(Color.gray);
		}
		peach.setColumns(10);
		peach.setBounds(85, 52, 150, 21);
		panel_1.add(peach);

		JLabel lblNewLabel_1_4 = new JLabel("冷露歐雷：");// 65元
		lblNewLabel_1_4.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(10, 86, 75, 28);
		panel_1.add(lblNewLabel_1_4);

		melon = new JTextField();
		if (cal.existsFile("drink.txt")) {
			Drink d = (Drink) (cal.readFile("drink.txt"));
			melon.setText("" + d.getMelon());
		} else {
			melon.setText("1杯65元");
			melon.setHorizontalAlignment(JTextField.CENTER);
			melon.setForeground(Color.gray);
		}
		melon.setColumns(10);
		melon.setBounds(85, 90, 150, 21);
		panel_1.add(melon);

		JLabel lblNewLabel_1_5 = new JLabel("黑糖鮮奶：");
		lblNewLabel_1_5.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_1_5.setBounds(10, 124, 75, 28);
		panel_1.add(lblNewLabel_1_5);

		brown = new JTextField();
		if (cal.existsFile("drink.txt")) {
			Drink d = (Drink) (cal.readFile("drink.txt"));
			brown.setText("" + d.getBrown());
		} else {
			brown.setText("1杯75元");
			brown.setHorizontalAlignment(JTextField.CENTER);
			brown.setForeground(Color.gray);
		}
		brown.setColumns(10);
		brown.setBounds(85, 128, 150, 21);
		panel_1.add(brown);

		JButton btnNewButton = new JButton("購物車");
		btnNewButton.setBounds(245, 127, 111, 23);
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("重新輸入");
		btnNewButton_1.setBounds(245, 89, 111, 23);
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("歷史紀錄");
		btnNewButton_2.setBounds(245, 51, 111, 23);
		panel_1.add(btnNewButton_2);

		/* panel_2 按鈕列 */
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 128, 64));
		panel_2.setBounds(34, 281, 366, 57);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JButton btnNewButton_2_1 = new JButton("登出");
		btnNewButton_2_1.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
		btnNewButton_2_1.setBounds(26, 17, 87, 23);
		panel_2.add(btnNewButton_2_1);

		JButton btnNewButton_2_2 = new JButton("回上一頁");
		btnNewButton_2_2.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
		btnNewButton_2_2.setBounds(139, 17, 87, 23);
		panel_2.add(btnNewButton_2_2);

		JButton btnNewButton_2_3 = new JButton("結束");
		btnNewButton_2_3.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
		btnNewButton_2_3.setBounds(252, 17, 87, 23);
		panel_2.add(btnNewButton_2_3);

		/**** Button 計算 *****/
		/* 提示文字消失 */
		peach.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (peach.getText().equals("1杯60元")) {
					peach.setText("");
					peach.setForeground(Color.black);
					peach.setHorizontalAlignment(JTextField.LEFT);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (peach.getText().equals("")) {
					peach.setText("1杯60元");
					peach.setForeground(Color.gray);
					peach.setHorizontalAlignment(JTextField.CENTER);
				}
			}
		});
		melon.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (melon.getText().equals("1杯65元")) {
					melon.setText("");
					melon.setForeground(Color.black);
					melon.setHorizontalAlignment(JTextField.LEFT);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (melon.getText().equals("")) {
					melon.setText("1杯65元");
					melon.setForeground(Color.gray);
					melon.setHorizontalAlignment(JTextField.CENTER);
				}
			}
		});
		brown.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (brown.getText().equals("1杯75元")) {
					brown.setText("");
					brown.setForeground(Color.black);
					brown.setHorizontalAlignment(JTextField.LEFT);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (brown.getText().equals("")) {
					brown.setText("1杯75元");
					brown.setForeground(Color.gray);
					brown.setHorizontalAlignment(JTextField.CENTER);
				}
			}
		});

		/* 跳到購物車 */
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String Peach = peach.getText();
				if (Peach.equals("1杯60元")) {
					Peach = "0";
				}
				String Melon = melon.getText();
				if (Melon.equals("1杯65元")) {
					Melon = "0";
				}
				String Brown = brown.getText();
				if (Brown.equals("1杯75元")) {
					Brown = "0";
				}

				Integer P = Integer.parseInt(Peach);// Boxing
				Integer M = Integer.parseInt(Melon);
				Integer B = Integer.parseInt(Brown);
				Integer tmp = P + M + B;
				if (tmp == 0) {
					JOptionPane.showMessageDialog(DrinkUI.this, "未選任何一杯");
				} else {
					d = new Drink(p.getUsername(), p.getName(), P, M, B);
					cal.saveFile("drink.txt", d);
					ConfirmUI frame = new ConfirmUI();
					frame.setVisible(true);
					dispose();
				}
			}
		});

		/* 清除輸入資料 */
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				peach.setText("1杯60元");
				peach.setHorizontalAlignment(JTextField.CENTER);
				peach.setForeground(Color.gray);
				melon.setText("1杯65元");
				melon.setHorizontalAlignment(JTextField.CENTER);
				melon.setForeground(Color.gray);
				brown.setText("1杯75元");
				brown.setHorizontalAlignment(JTextField.CENTER);
				brown.setForeground(Color.gray);
			}
		});

		/* 歷史紀錄 */ {
			btnNewButton_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					DrinkHistoryUI frame = new DrinkHistoryUI(p.getUsername(), width);
					frame.setVisible(true);
				}
			});
		}

		/** 限定只能輸入數字 **/
		peach.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				int temp = e.getKeyChar();
				System.out.println(temp);
				if (temp == 10) {// 按回車時

				} else if (temp != 46) { // 沒有按小數點時
					if (temp != 8) { // 沒有按backspace時
						// 下面檢查是不是在0~9之間；
						if (temp > 57) {
							e.consume();// 如果不是則消除key事件,也就是按了鍵盤以後沒有反應;
						} else if (temp < 48) {
							e.consume();
						}
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});
		melon.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				int temp = e.getKeyChar();
				System.out.println(temp);
				if (temp == 10) {// 按回車時
				} else if (temp != 46) { // 沒有按小數點時
					if (temp != 8) { // 沒有按backspace時
						// 下面檢查是不是在0~9之間；
						if (temp > 57) {
							e.consume();// 如果不是則消除key事件,也就是按了鍵盤以後沒有反應;
						} else if (temp < 48) {
							e.consume();
						}
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});
		brown.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				int temp = e.getKeyChar();
				System.out.println(temp);
				if (temp == 10) {// 按回車時

				} else if (temp != 46) { // 沒有按小數點時
					if (temp != 8) { // 沒有按backspace時
						// 下面檢查是不是在0~9之間；
						if (temp > 57) {
							e.consume();// 如果不是則消除key事件,也就是按了鍵盤以後沒有反應;
						} else if (temp < 48) {
							e.consume();
						}
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});

		/* 下方按鈕列 */
		/* 登出 */
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (cal.existsFile("drink.txt")) {
					cal.deletdFile("drink.txt");
				}
				LoginUI frame = new LoginUI();
				frame.setVisible(true);
				dispose();
			}
		});
		/* 上一頁 */
		btnNewButton_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (cal.existsFile("drink.txt")) {
					cal.deletdFile("drink.txt");
				}
				LoginSuccessUI frame = new LoginSuccessUI();
				frame.setVisible(true);
				dispose();
			}
		});
		/* 結束程式 */
		btnNewButton_2_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (cal.existsFile("drink.txt")) {
					cal.deletdFile("drink.txt");
				}
				System.exit(0);
			}
		});
	}
}
