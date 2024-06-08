package controller.drink;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.LoginUI;
import model.Drink;

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
	Drink d;
	private JTextField money;
	private JTextField textField;

	public DrinkUI() {
		super("結帳畫面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 692);
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
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel.setBounds(85, 21, 195, 26);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(34, 106, 366, 200);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		/* 隱藏游標 */
		textField = new JTextField();
		textField.setBounds(0, 0, 0, 0);
		panel_1.add(textField);
		textField.setColumns(0);

		JLabel lblNewLabel_1 = new JLabel("姓名:");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 10, 75, 28);
		panel_1.add(lblNewLabel_1);

		name = new JTextField();
		name.setText("名字");
		name.setBounds(85, 14, 150, 21);
		name.setHorizontalAlignment(JTextField.CENTER);
		name.setForeground(Color.gray);
		panel_1.add(name);
		name.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("密桃奶茶：");// 60元
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 48, 75, 28);
		panel_1.add(lblNewLabel_1_1);

		peach = new JTextField();
		peach.setText("1杯60元");
		peach.setBounds(85, 52, 150, 21);
		peach.setHorizontalAlignment(JTextField.CENTER);
		peach.setForeground(Color.gray);
		panel_1.add(peach);

		JLabel lblNewLabel_1_2 = new JLabel("冷露歐雷：");// 65元
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(10, 86, 75, 28);
		panel_1.add(lblNewLabel_1_2);

		melon = new JTextField();
		melon.setText("1杯65元");
		melon.setColumns(10);
		melon.setBounds(85, 90, 150, 21);
		melon.setHorizontalAlignment(JTextField.CENTER);
		melon.setForeground(Color.gray);
		panel_1.add(melon);

		JLabel lblNewLabel_1_3 = new JLabel("黑糖鮮奶：");
		lblNewLabel_1_3.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(10, 124, 75, 28);
		panel_1.add(lblNewLabel_1_3);

		brown = new JTextField();
		brown.setText("1杯75元");
		brown.setColumns(10);
		brown.setBounds(85, 128, 150, 21);
		brown.setHorizontalAlignment(JTextField.CENTER);
		brown.setForeground(Color.gray);
		panel_1.add(brown);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(128, 128, 128));
		panel_3.setBounds(245, 86, 111, 66);
		panel_1.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_2 = new JLabel("是否為會員");
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 14));
		panel_3.add(lblNewLabel_2);

		JRadioButton mebert = new JRadioButton("是", true);
		panel_3.add(mebert);

		JRadioButton meberf = new JRadioButton("否");
		panel_3.add(meberf);

		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(mebert);
		genderGroup.add(meberf);

		JButton btnNewButton = new JButton("確定");
		btnNewButton.setBounds(85, 167, 150, 23);
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("重新輸入");
		btnNewButton_1.setBounds(245, 167, 111, 23);
		panel_1.add(btnNewButton_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 128, 64));
		panel_2.setBounds(34, 316, 366, 327);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JTextArea show = new JTextArea();
		show.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		show.setBounds(27, 10, 312, 231);
		show.setEditable(false);
		panel_2.add(show);

		JButton btnNewButton_4 = new JButton("計算");
		btnNewButton_4.setBounds(27, 294, 87, 23);
		panel_2.add(btnNewButton_4);

		JButton btnNewButton_3 = new JButton("列印");
		btnNewButton_3.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
		btnNewButton_3.setBounds(139, 292, 87, 23);
		panel_2.add(btnNewButton_3);

		JButton btnNewButton_2 = new JButton("結束");
		btnNewButton_2.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
		btnNewButton_2.setBounds(252, 292, 87, 23);
		panel_2.add(btnNewButton_2);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(26, 251, 313, 32);
		panel_2.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("付款金額：");
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(29, 8, 130, 15);
		panel_4.add(lblNewLabel_3);

		money = new JTextField();
		money.setBounds(188, 5, 96, 21);
		panel_4.add(money);
		money.setColumns(10);

		/**** Button 計算 *****/
		/* 提示文字消失 */
		name.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (name.getText().equals("名字")) {
					name.setText("");
					name.setForeground(Color.black);
					name.setHorizontalAlignment(JTextField.LEFT);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (name.getText().equals("")) {
					name.setText("名字");
					name.setForeground(Color.gray);
					name.setHorizontalAlignment(JTextField.CENTER);
				}
			}
		});
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

		/* 計算價格 */
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (name.getText().equals("")) {
					show.setText("未輸入資料，或資料不完全");
				}
				if (peach.getText().equals("")) {
					show.setText("未輸入資料，或資料不完全");
				}
				if (melon.getText().equals("")) {
					show.setText("未輸入資料，或資料不完全");
				}
				if (brown.getText().equals("")) {
					show.setText("未輸入資料，或資料不完全");
				}

				String Name = name.getText();
				String Peach = peach.getText();
				String Melon = melon.getText();
				String Brown = brown.getText();

				Integer P = Integer.parseInt(Peach);// Boxing
				Integer M = Integer.parseInt(Melon);
				Integer B = Integer.parseInt(Brown);

				d = new Drink(Name, P, M, B);

				if (mebert.isSelected()) {
					int sum =d.getMelon()*55+d.getMelon()*60+d.getBrown();
//					show.setText(sum);
				} else {
//					show.setText(sum+"");
				}
			}
		});

		/* 清除輸入資料 */
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				name.setText("名字");
				name.setHorizontalAlignment(JTextField.CENTER);
				name.setForeground(Color.gray);
				peach.setText("1杯60元");
				peach.setHorizontalAlignment(JTextField.CENTER);
				peach.setForeground(Color.gray);
				melon.setText("1杯65元");
				melon.setHorizontalAlignment(JTextField.CENTER);
				melon.setForeground(Color.gray);
				brown.setText("1杯75元");
				brown.setHorizontalAlignment(JTextField.CENTER);
				brown.setForeground(Color.gray);
				show.setText("");
				money.setText("");
				mebert.setSelected(true);
			}
		});

		/* 標示滑鼠進到選擇會員 */
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_3.setBackground(new Color(128, 100, 128));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_3.setBackground(new Color(128, 128, 128));
			}
		});
		mebert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!show.getText().equals("")) {
					show.setText("請重新按確認鍵");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panel_3.setBackground(new Color(128, 100, 128));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_3.setBackground(new Color(128, 100, 128));
			}
		});
		meberf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!show.getText().equals("")) {
					show.setText("請重新按確認鍵");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panel_3.setBackground(new Color(128, 100, 128));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_3.setBackground(new Color(128, 100, 128));
			}
		});

		/** 限定只能輸入數字 **/
		peach.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				int temp = e.getKeyChar();
				System.out.println(temp);
				show.setText("");
				if (temp == 10) {// 按回車時

				} else if (temp != 46) { // 沒有按小數點時
					if (temp != 8) { // 沒有按backspace時
						// 下面檢查是不是在0~9之間；
						if (temp > 57) {
							e.consume();
							show.setText("請輸入數字");// 如果不是則消除key事件,也就是按了鍵盤以後沒有反應;
						} else if (temp < 48) {
							e.consume();
							show.setText("請輸入數字");
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
				show.setText("");
				if (temp == 10) {// 按回車時

				} else if (temp != 46) { // 沒有按小數點時
					if (temp != 8) { // 沒有按backspace時
						// 下面檢查是不是在0~9之間；
						if (temp > 57) {
							e.consume();
							show.setText("請輸入數字");// 如果不是則消除key事件,也就是按了鍵盤以後沒有反應;
						} else if (temp < 48) {
							e.consume();
							show.setText("請輸入數字");
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
				show.setText("");
				if (temp == 10) {// 按回車時

				} else if (temp != 46) { // 沒有按小數點時
					if (temp != 8) { // 沒有按backspace時
						// 下面檢查是不是在0~9之間；
						if (temp > 57) {
							e.consume();
							show.setText("請輸入數字");// 如果不是則消除key事件,也就是按了鍵盤以後沒有反應;
						} else if (temp < 48) {
							e.consume();
							show.setText("請輸入數字");
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

		/* 找零 */
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				int sum = (int) Math.round(s.getSum());
//				Integer P = Integer.parseInt(money.getText()) - Integer.valueOf(sum);
//				if (true) {
////					show.setText(s.show() + "\n付款：" + money.getText() + "\n找零：" + P);
//					money.setText("");
//				} else {
////					show.setText(s.show() + "\n錢不夠~~");
//					money.setText("");
//				}

			}
		});

		/* 列印 */
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Create a PrinterJob
				PrinterJob printerJob = PrinterJob.getPrinterJob();

				// Set the JTextArea as the Printable
				printerJob.setPrintable(show.getPrintable(null, null));

				// Show print dialog
				if (printerJob.printDialog()) {
					try {
						// Print the JTextArea content
						printerJob.print();
					} catch (PrinterException ex) {
						ex.printStackTrace();
					}
				}

//				Printable printable = new Printable() {
//					@Override
//					public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) 
//							throws PrinterException {
//						if (pageIndex > 0) {
//							return NO_SUCH_PAGE;
//						}
//						Graphics2D g2d = (Graphics2D) graphics;
//						g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
//						g2d.drawString(show.getText(), 100, 100);
//						graphics.drawString(show.getText(), 0, 0);
//						return PAGE_EXISTS;
//					}
//				};
//				PageFormat pageFormat = new PageFormat();
//				pageFormat.setOrientation(PageFormat.PORTRAIT);
//				pageFormat.setPaper(new Paper());
//
//				PrinterJob myPrtJob = PrinterJob.getPrinterJob();
//				myPrtJob.setPrintable(printable , pageFormat );
////				PrintRequestAttributeSet att = new HashPrintRequestAttributeSet();
//				if (myPrtJob.printDialog()) {
//					try {
//						myPrtJob.print();
//					} catch (PrinterException pe) {
//						pe.printStackTrace();
//					}
//				}
				/*
				 * try { show.print(); } catch (PrinterException pe) { pe.printStackTrace(); }
				 */

			}
		});

		/* 結束程式 */
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
	}
}
