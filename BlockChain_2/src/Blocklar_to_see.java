import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Blocklar_to_see extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Blocklar_to_see frame = new Blocklar_to_see();
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
	public Blocklar_to_see() throws SQLException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 962, 617);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(84, 47, 854, 523);
		contentPane.add(textArea);
		
		JLabel lblNewLabel = new JLabel("Block Zinciri");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(107, 10, 522, 27);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("A. SAYFA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnaSayfa K1 = new AnaSayfa();
				K1.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(701, 0, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("1.BLOCK");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 50, 62, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("2.BLOCK");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(12, 81, 62, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("3.BLOCK");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(12, 116, 62, 13);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("4.BLOCK");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setBounds(12, 147, 62, 13);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("5.BLOCK");
		lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1.setBounds(12, 180, 62, 13);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("6.BLOCK");
		lblNewLabel_2_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_2.setBounds(12, 209, 62, 13);
		contentPane.add(lblNewLabel_2_1_1_2);
		
		JLabel lblNewLabel_7_BLOCK = new JLabel("7.BLOCK");
		lblNewLabel_7_BLOCK.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_BLOCK.setBounds(12, 241, 62, 13);
		contentPane.add(lblNewLabel_7_BLOCK);
		
		JLabel lblNewLabel_8_BLOCK = new JLabel("8.BLOCK");
		lblNewLabel_8_BLOCK.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_BLOCK.setBounds(12, 273, 62, 13);
		contentPane.add(lblNewLabel_8_BLOCK);
		
		JLabel lblNewLabel_9_BLOCK_1 = new JLabel("9.BLOCK");
		lblNewLabel_9_BLOCK_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_BLOCK_1.setBounds(12, 305, 62, 13);
		contentPane.add(lblNewLabel_9_BLOCK_1);
		
		JLabel lblNewLabel_10_BLOCK_1_1 = new JLabel("10.BLOCK");
		lblNewLabel_10_BLOCK_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10_BLOCK_1_1.setBounds(12, 338, 62, 13);
		contentPane.add(lblNewLabel_10_BLOCK_1_1);
		
		JLabel lblNewLabel_11_BLOCK_1_1_1 = new JLabel("11.BLOCK");
		lblNewLabel_11_BLOCK_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11_BLOCK_1_1_1.setBounds(12, 369, 62, 13);
		contentPane.add(lblNewLabel_11_BLOCK_1_1_1);
		
		JLabel lblNewLabel_12_BLOCK_1_1_2 = new JLabel("12.BLOCK");
		lblNewLabel_12_BLOCK_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12_BLOCK_1_1_2.setBounds(12, 401, 62, 13);
		contentPane.add(lblNewLabel_12_BLOCK_1_1_2);
		
		JLabel lblNewLabel_12_BLOCK_1_1_2_1 = new JLabel("13.BLOCK");
		lblNewLabel_12_BLOCK_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12_BLOCK_1_1_2_1.setBounds(12, 435, 62, 13);
		contentPane.add(lblNewLabel_12_BLOCK_1_1_2_1);
		
		JLabel lblNewLabel_12_BLOCK_1_1_2_2 = new JLabel("14.BLOCK");
		lblNewLabel_12_BLOCK_1_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12_BLOCK_1_1_2_2.setBounds(12, 466, 62, 13);
		contentPane.add(lblNewLabel_12_BLOCK_1_1_2_2);
		
		JLabel lblNewLabel_12_BLOCK_1_1_2_3 = new JLabel("15.BLOCK");
		lblNewLabel_12_BLOCK_1_1_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12_BLOCK_1_1_2_3.setBounds(12, 497, 62, 13);
		contentPane.add(lblNewLabel_12_BLOCK_1_1_2_3);
		
		JLabel lblNewLabel_12_BLOCK_1_1_2_4 = new JLabel("16.BLOCK");
		lblNewLabel_12_BLOCK_1_1_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12_BLOCK_1_1_2_4.setBounds(12, 529, 62, 13);
		contentPane.add(lblNewLabel_12_BLOCK_1_1_2_4);
		
		
		
		
		ConnectDB_7 conn = new ConnectDB_7();
		ResultSet rs = conn.selectData();
		while(rs.next()) {
			String gecici1 = rs.getString("Block");
			textArea.append(gecici1+"\n");
			textArea.append("\n");
			
		}
	}
}
