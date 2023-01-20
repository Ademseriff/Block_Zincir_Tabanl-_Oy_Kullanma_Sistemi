import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OY_G�STER�M extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OY_G�STER�M frame = new OY_G�STER�M();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public OY_G�STER�M() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("SAYILAN OYLAR");
		label.setAlignment(Label.CENTER);
		label.setBounds(194, 0, 281, 61);
		contentPane.add(label);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(160, 94, 401, 77);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("ANA SAYFA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnaSayfa k1 = new AnaSayfa();
				k1.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(577, 202, 119, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("A_PART\u0130");
		lblNewLabel.setBounds(222, 71, 55, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("B_PART\u0130");
		lblNewLabel_1.setBounds(307, 71, 55, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("C_PART\u0130");
		lblNewLabel_2.setBounds(396, 71, 55, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("D_PART\u0130");
		lblNewLabel_3.setBounds(477, 71, 55, 13);
		contentPane.add(lblNewLabel_3);
		
		ConnectDB_11 conn = new ConnectDB_11();
		ResultSet rs_11 = conn.selectData();
		while(rs_11.next()) {
			String ge�ici1 = rs_11.getString("a_parti");
			String ge�ici2 = rs_11.getString("b_parti");
			String ge�ici3 = rs_11.getString("c_parti");
			String ge�ici4 = rs_11.getString("d_parti");
			textArea.append("\n");
			textArea.append("	"+ge�ici1+"	"+ge�ici2+"	"+ge�ici3+"	"+ge�ici4+"	"+"\n");
			textArea.append("\n");
			
		}
	}
}
