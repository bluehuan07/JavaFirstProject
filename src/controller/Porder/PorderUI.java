package controller.Porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.People;
import model.Porder;
import util.cal;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PorderUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField a;
	private JTextField b;
	private JTextField c;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PorderUI frame = new PorderUI();
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
	public PorderUI() {
		super("PorderUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(10, 25, 416, 37);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("輸入數量");
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(10, 72, 416, 181);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setBounds(10, 24, 46, 15);
		panel_1.add(lblNewLabel_1);

		JLabel memberShow = new JLabel("客人姓名");
		People m=(People)(cal.readFile("member.txt"));
		memberShow.setText(m.getName());
		memberShow.setBounds(99, 20, 96, 23);
		panel_1.add(memberShow);

		JLabel lblNewLabel_3 = new JLabel("A");
		lblNewLabel_3.setBounds(10, 63, 46, 15);
		panel_1.add(lblNewLabel_3);

		a = new JTextField();
		a.setBounds(99, 60, 96, 21);
		panel_1.add(a);
		a.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("B");
		lblNewLabel_4.setBounds(10, 102, 46, 15);
		panel_1.add(lblNewLabel_4);

		b = new JTextField();
		b.setBounds(99, 99, 96, 21);
		panel_1.add(b);
		b.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("C");
		lblNewLabel_5.setBounds(10, 141, 46, 15);
		panel_1.add(lblNewLabel_5);

		c = new JTextField();
		c.setBounds(99, 138, 96, 21);
		panel_1.add(c);
		c.setColumns(10);

		JButton btnNewButton = new JButton("確認");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int A=Integer.parseInt(a.getText());
				int B=Integer.parseInt(b.getText());
				int C=Integer.parseInt(c.getText());
				
				Porder p=new Porder(m.getName(),A,B,C);
				System.out.println("P new()");
				cal.saveFile("porder.txt", p);
				
				ConfirmUI c=new ConfirmUI();
				c.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(321, 137, 85, 23);
		panel_1.add(btnNewButton);
	}
}
