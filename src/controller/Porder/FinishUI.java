package controller.Porder;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import dao.impl.PorderDaoImpl;
import model.People;
import model.Porder;
import util.cal;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 10, 416, 243);
		contentPane.add(panel);
		panel.setLayout(null);

		JTextArea output = new JTextArea();
		output.setBounds(41, 25, 343, 170);
		panel.add(output);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(143, 205, 85, 23);
		panel.add(btnNewButton);
		
		People m = (People) (cal.readFile("member.txt"));
		List<Porder> lp = new PorderDaoImpl().selectAll();
		int n = lp.size()-1;
		Porder[] p = lp.toArray(new Porder[n+1]);
		int sum = p[n].getA() * 30 + p[n].getB() * 40 + p[n].getC();
		String outputDetail="訂單號碼:"+p[n].getId()+
				"\n客戶:"+p[n].getName()+"\t地址:"+m.getAddress1()+"\t電話:"+m.getTel()+
				"\nA:"+p[n].getA()+
				"\nB:"+p[n].getB()+
				"\nC:"+p[n].getC()+
				"\n=================================="+
				"\n小計:"+sum+"元";	
		output.setText(outputDetail);
	}

}
