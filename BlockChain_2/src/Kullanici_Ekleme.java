import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Kullanici_Ekleme extends JFrame {

	private JPanel contentPane;
	private JTextField txtAd;
	private JTextField textSoyad;
	private JTextField txt_tc;
	private JTextField txt_sifre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kullanici_Ekleme frame = new Kullanici_Ekleme();
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
	public Kullanici_Ekleme() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAd = new JLabel("AD");
		lblAd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAd.setBounds(38, 122, 93, 20);
		contentPane.add(lblAd);
		
		JLabel lblSoyad = new JLabel("SOYAD");
		lblSoyad.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoyad.setBounds(38, 177, 93, 20);
		contentPane.add(lblSoyad);
		
		JLabel lblTcKmlk = new JLabel("T.C K\u0130ML\u0130K");
		lblTcKmlk.setHorizontalAlignment(SwingConstants.CENTER);
		lblTcKmlk.setBounds(38, 233, 93, 20);
		contentPane.add(lblTcKmlk);
		
		JLabel lbsifre = new JLabel("\u015E\u0130FRE");
		lbsifre.setHorizontalAlignment(SwingConstants.CENTER);
		lbsifre.setBounds(38, 286, 93, 20);
		contentPane.add(lbsifre);
		
		txtAd = new JTextField();
		txtAd.setBounds(179, 123, 96, 19);
		contentPane.add(txtAd);
		txtAd.setColumns(10);
		
		textSoyad = new JTextField();
		textSoyad.setBounds(179, 178, 96, 19);
		contentPane.add(textSoyad);
		textSoyad.setColumns(10);
		
		txt_tc = new JTextField();
		txt_tc.setBounds(179, 234, 96, 19);
		contentPane.add(txt_tc);
		txt_tc.setColumns(10);
		
		txt_sifre = new JTextField();
		txt_sifre.setBounds(179, 287, 96, 19);
		contentPane.add(txt_sifre);
		txt_sifre.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("K\u0130\u015E\u0130 EKLE");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(136, 36, 166, 37);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("EKLE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  String ekle_ad = txtAd.getText();
				  String ekle_soyad = textSoyad.getText();
				  String ekle_tc = txt_tc.getText();
				  String ekle_sifre = txt_sifre.getText();
				  
				try {
					ConnectDB_5 conn = new ConnectDB_5();
					conn.insertData(ekle_tc, ekle_sifre, ekle_ad, ekle_soyad);
					
					JOptionPane.showMessageDialog(btnNewButton, "kiþi eklendi");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(163, 354, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ana_Sayfa");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnaSayfa ana_sayfa = new AnaSayfa();
				ana_sayfa.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(317, 450, 113, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("KULANICILAR OY SAYIMI IZIN VER");
		btnNewButton_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					ConnectDB_4 conn = new ConnectDB_4();
					ResultSet rs = conn.selectData();
					while(rs.next()) {
						//System.out.println(rs.getString("Kullanici_Sifre"));
						String kontrol = rs.getString("kullanici_oy_say_onay");
				    	if(kontrol.equals("0")) {
				    		conn.executeUpdate_1();
				    		JOptionPane.showMessageDialog(btnNewButton, "KULANICILARA OY SAYMA ÝZNÝ VERÝLDÝ");
				    	}
				    	else {
				    		JOptionPane.showMessageDialog(btnNewButton, "ÝZÝNLER ZATEN AKTÝF");
				    	}
				    	//System.out.println(kullanici_ad);
						
				}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(77, 391, 283, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("IZINLERI KAPAT");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ConnectDB_4 conn = new ConnectDB_4();
					ResultSet rs = conn.selectData();
					while(rs.next()) {
						//System.out.println(rs.getString("Kullanici_Sifre"));
						String kontrol = rs.getString("kullanici_oy_say_onay");
				    	 if(kontrol.equals("1")) {
				    		conn.executeUpdate_2();
				    		JOptionPane.showMessageDialog(btnNewButton, "KULANICILARA OY SAYMA ÝZNÝ KAPATILDI");
				    	}
				    	 else {
				    		 JOptionPane.showMessageDialog(btnNewButton, "ÝZÝNLER ZATEN KAPALI");
				    	 }
				    	//System.out.println(kullanici_ad);
						
				}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_3.setBounds(146, 425, 151, 21);
		contentPane.add(btnNewButton_3);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(442, 114, 283, 298);
		contentPane.add(textArea);
		
		JLabel lblNewLabel = new JLabel("KULLANICILARIN SAYDIGI OYLAR");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(471, 40, 204, 32);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_4 = new JButton("Onayla");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ConnectDB_10 conn_10 = new ConnectDB_10();
					ConnectDB_11 conn_11 = new ConnectDB_11();
					ResultSet rs_10 = conn_10.selectData();
					String a_parti,b_parti,c_parti,d_parti;
					while(rs_10.next()) {
						//System.out.println(rs.getString("Kullanici_Sifre"));
						a_parti = rs_10.getString("a_parti");
						b_parti = rs_10.getString("b_parti");
						c_parti = rs_10.getString("c_parti");
						d_parti = rs_10.getString("d_parti");
						conn_11.update_data(a_parti, b_parti, c_parti, d_parti);
						
				    }
					conn_10.DeleteData();
					JOptionPane.showMessageDialog(btnNewButton, "ONAYLAMA ÝÞLEMÝ TAMALANDI");
					setVisible(false);
					setVisible(true);
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(523, 425, 151, 20);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_1 = new JLabel("A_PART\u0130");
		lblNewLabel_1.setBounds(446, 91, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("B_PART\u0130");
		lblNewLabel_2.setBounds(501, 91, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("C_PART\u0130");
		lblNewLabel_3.setBounds(556, 91, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("D_PART\u0130");
		lblNewLabel_5.setBounds(611, 91, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u0130D_NO");
		lblNewLabel_6.setBounds(666, 91, 45, 13);
		contentPane.add(lblNewLabel_6);
		try {
			ConnectDB_10 conn_10 = new ConnectDB_10();
			ResultSet rs_10 = conn_10.selectData();
			while(rs_10.next()) {
				String a = rs_10.getString("a_parti");
				String b = rs_10.getString("b_parti");
				String c = rs_10.getString("c_parti");
				String d = rs_10.getString("d_parti");
				String id = rs_10.getString("id");
				textArea.append("       "+a+"               "+b+"              "+c+"               "+d+"               "+id+"\n");
				textArea.append("\n");
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
}
