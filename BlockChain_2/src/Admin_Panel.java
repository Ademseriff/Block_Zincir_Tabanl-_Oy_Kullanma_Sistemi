import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Admin_Panel extends JFrame {

	private JPanel contentPane;
	private JTextField text_kullanici_ad;
	private JTextField text_pasword;
    static String kullanici_ad;
    static String sifre;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Panel frame = new Admin_Panel();
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
	@SuppressWarnings("deprecation")
	public Admin_Panel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADM\u0130N G\u0130R\u0130\u015E PANEL");
		lblNewLabel.setForeground(new Color(0, 64, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(194, 39, 314, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("KULLANICI_ADI");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(63, 156, 134, 42);
		contentPane.add(lblNewLabel_1);
		
		text_kullanici_ad = new JTextField();
		text_kullanici_ad.setBounds(241, 164, 179, 29);
		contentPane.add(text_kullanici_ad);
		text_kullanici_ad.setColumns(10);
		
		text_pasword = new JPasswordField();
		text_pasword.setBounds(241, 265, 179, 25);
		contentPane.add(text_pasword);
		
		JLabel lblNewLabel_2 = new JLabel("\u015E\u0130FRE");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(61, 262, 110, 29);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("G\u0130R\u0130\u015E");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				kullanici_ad=text_kullanici_ad.getText();
				sifre =  text_pasword.getText();
				try {
					ConnectDB_4 conn = new ConnectDB_4();
					ResultSet rs = conn.selectData();
					
					while(rs.next()) {
							//System.out.println(rs.getString("Kullanici_Sifre"));
							String kontrol_adi = rs.getString("Kullanici_adi");
					    	String	kontrol_sifre = rs.getString("Kullanici_sifre");
					    	//System.out.println(kullanici_ad);
							if(kontrol_adi.equals(kullanici_ad)) {
								
							
							if(kontrol_sifre.equals(sifre)) {
								Kullanici_Ekleme k1 = new Kullanici_Ekleme();
								setVisible(false);
								k1.setVisible(true);
							}}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnNewButton.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		btnNewButton.setBounds(298, 339, 122, 42);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ana_Sayfa");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnaSayfa ana_sayfa = new AnaSayfa();
				ana_sayfa.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(531, 378, 122, 21);
		contentPane.add(btnNewButton_1);
	}
}
