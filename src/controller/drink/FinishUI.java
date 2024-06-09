package controller.drink;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
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
		int height = 300;
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
		panel.setBounds(10, 10, 416, 243);
		contentPane.add(panel);
		panel.setLayout(null);

		JTextArea output = new JTextArea();
		output.setBounds(36, 21, 343, 170);
		output.setEditable(false);
		panel.add(output);
		List<Drink> lp = new DrinkDaoImpl().queryAllList();
		int n = lp.size() - 1;
		Drink[] d = lp.toArray(new Drink[n + 1]);
		People p = new PeopleDaoImpl().queryPeopleByUsername(d[n].getUsername());
		int sum = d[n].getPeach() * 60 + d[n].getMelon() * 65 + d[n].getBrown() * 75;
		String outputlevel="";
		switch (p.getLevel()) {
		case "A": {
			sum = (int) Math.round(sum * 0.7);
			outputlevel="員工打7折";
			break;
		}
		case "B": {
			sum = (int) Math.round(sum * 0.8);
			outputlevel="白金會員打8折";
			break;
		}
		case "C": {
			sum = (int) Math.round(sum * 0.9);
			outputlevel="一般會員打9折";
			break;
		}
		}
		String outputDetail = "密桃奶茶:" + d[n].getPeach() + "杯\n";
		outputDetail = outputDetail + "冷露歐雷:" + d[n].getMelon() + "杯\n";
		outputDetail = outputDetail + "黑糖鮮奶:" + d[n].getBrown() + "杯\n";
		outputDetail = outputDetail + outputlevel;
		outputDetail = outputDetail + "共:" + sum + " 元";
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
		btnNewButton.setBounds(39, 205, 85, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("歷史紀錄");
		btnNewButton_1.setBounds(163, 205, 87, 23);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("列印明細");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Create a PrinterJob
				PrinterJob printerJob = PrinterJob.getPrinterJob();

				// Set the JTextArea as the Printable
				printerJob.setPrintable(output.getPrintable(null, null));

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
		btnNewButton_2.setBounds(289, 205, 87, 23);
		panel.add(btnNewButton_2);
	}
}
