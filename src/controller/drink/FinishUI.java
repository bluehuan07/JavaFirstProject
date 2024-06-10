package controller.drink;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import controller.LoginUI;
import dao.impl.DrinkDaoImpl;
import dao.impl.PeopleDaoImpl;
import model.Drink;
import model.People;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class FinishUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinishUI frame = new FinishUI();
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
	public FinishUI() {
		super("FinishUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension scrsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = 450;
		int height = 350;
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
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 10, 414, 63);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("感謝你的購買");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 25));
		lblNewLabel.setBounds(112, 10, 189, 43);
		panel.add(lblNewLabel);

		/* panel_1 */
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(10, 83, 416, 168);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JTextArea output = new JTextArea();
		output.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		output.setBounds(10, 10, 396, 111);
		output.setEditable(false);
		panel_1.add(output);
		List<Drink> lp = new DrinkDaoImpl().queryAllList();
		int n = lp.size() - 1;
		Drink[] d = lp.toArray(new Drink[n + 1]);
		People p = new PeopleDaoImpl().queryPeopleByUsername(d[n].getUsername());
		int sum = d[n].getPeach() * 60 + d[n].getMelon() * 65 + d[n].getBrown() * 75;
		String outputlevel = "";
		switch (p.getLevel()) {
		case "A": {
			sum = (int) Math.round(sum * 0.7);
			outputlevel = " 員工打 7 折";
			break;
		}
		case "B": {
			sum = (int) Math.round(sum * 0.8);
			outputlevel = " 白金會員打 8 折";
			break;
		}
		case "C": {
			sum = (int) Math.round(sum * 0.9);
			outputlevel = " 一般會員打 9 折";
			break;
		}
		}
		String outputDetail = " 密桃奶茶: " + d[n].getPeach() + " 杯\t60 元\n";
		outputDetail = outputDetail + " 冷露歐雷: " + d[n].getMelon() + " 杯\t65 元\n";
		outputDetail = outputDetail + " 黑糖鮮奶: " + d[n].getBrown() + " 杯\t75 元\n";
		outputDetail = outputDetail + outputlevel + " \n";
		outputDetail = outputDetail + " 共: " + sum + " 元";
		output.setText(outputDetail);

		JButton btnNewButton = new JButton("登出");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI frame = new LoginUI();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(39, 131, 85, 23);
		panel_1.add(btnNewButton);

		JTextArea outprint = new JTextArea();
		outprint.setBounds(0, 0, 0, 0);
		outprint.setText(printout(d[n].getPeach(), d[n].getMelon(), d[n].getBrown(), outputlevel, sum));
		panel_1.add(outprint);

		JButton btnNewButton_1 = new JButton("歷史紀錄");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DrinkHistoryUI frame = new DrinkHistoryUI(p.getUsername(), width);
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(163, 131, 87, 23);
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("列印明細");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Create a PrinterJob
				PrinterJob printerJob = PrinterJob.getPrinterJob();

				// Set the JTextArea as the Printable
				printerJob.setPrintable(outprint.getPrintable(null, null));

				// Show print dialog
				if (printerJob.printDialog()) {
					try {
						// Print the JTextArea content
						printerJob.print();
					} catch (PrinterException ex) {
						ex.printStackTrace();
					}
				}

			}
		});
		btnNewButton_2.setBounds(289, 131, 87, 23);
		panel_1.add(btnNewButton_2);

	}

	String printout(int peach, int melon, int brown, String peopleLevel, int sum) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY'年'MM'月'dd'日'");
		String nowTime = dateFormat.format(new Date());
		System.out.println("時間 = " + nowTime);
		String printdetail = "\n";
		printdetail += "\t\t　統一發票\n";
		printdetail += "\t\t　" + nowTime + "\n";
		printdetail += "  發票號碼：BL" + ((int) (Math.random() * 100000000)) + "\n";
		printdetail += "  ==============================================\n";
		printdetail += "  |  商品名稱" + "\t|  數量" + "\t|  單價" + "\t|  金額\t|\n";
		printdetail += "  －－－－－－－－－－－－－－－－－－－－－－－－－－－\n";
		printdetail += "  |  密桃奶茶：" + "\t|  " + peach + "\t" + "|  60\t|  " + peach * 60 + "\t|\n";
		printdetail += "  |  冷露歐雷：" + "\t|  " + melon + "\t" + "|  65\t|  " + melon * 65 + "\t|\n";
		printdetail += "  |  黑糖鮮奶：" + "\t|  " + brown + "\t" + "|  75\t|  " + brown * 75 + "\t|\n";
		printdetail += "  ==============================================\n";
		printdetail += "\t\t\t" + peopleLevel + "\n";
		printdetail += "\t\t\t 總計：$" + sum + " 元";

		return printdetail;
	}
}
