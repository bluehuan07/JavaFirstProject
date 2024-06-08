package controller.Porder;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.PorderDaoImpl;
import model.People;
import model.Porder;
import util.cal;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(164, 164, 164));
		panel.setBounds(10, 10, 416, 243);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(10, 10, 46, 15);
		Porder p = (Porder) (cal.readFile("porder.txt"));
		lblNewLabel.setText(p.getName());
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("請確認您的資料");
		lblNewLabel_1.setBounds(10, 35, 121, 15);
		panel.add(lblNewLabel_1);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 60, 396, 173);
		panel.add(textArea);
		int sum = p.getA() * 30 + p.getB() * 40 + p.getC();
		String outputDetail = "A:" + p.getA() + "\n";
		outputDetail = outputDetail + "B:" + p.getB() + "\n";
		outputDetail = outputDetail + "C:" + p.getC() + "\n";
		outputDetail = outputDetail + "共:" + sum + " 元";
		textArea.setText(outputDetail);

		JButton btnNewButton = new JButton("確認");
		btnNewButton.setBounds(321, 6, 85, 23);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new PorderDaoImpl().addPorder(p);
				FinishUI f = new FinishUI();
				f.setVisible(true);
				dispose();
			}
		});
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("回上一頁");
		btnNewButton_1.setBounds(226, 6, 85, 23);
		panel.add(btnNewButton_1);
	}
}
