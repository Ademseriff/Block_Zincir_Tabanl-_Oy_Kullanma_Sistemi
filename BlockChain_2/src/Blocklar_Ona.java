import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Blocklar_Ona extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Blocklar_Ona frame = new Blocklar_Ona();
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
	public Blocklar_Ona() throws SQLException {
		setResizable(false);
		AnaSayfa k1 = new AnaSayfa();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("BLOCK ONAY SAYFASI");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(274, 10, 203, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lbl_ad = new JLabel(k1.ad_soyad);
		lbl_ad.setBounds(274, 81, 89, 13);
		contentPane.add(lbl_ad);
		
		JLabel lbl_tc_kimlik = new JLabel(k1.tc_kimlik_no);
		lbl_tc_kimlik.setBounds(60, 81, 134, 13);
		contentPane.add(lbl_tc_kimlik);
		  
		JButton btnNewButton = new JButton("ONAY VER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					ConnectDB conn_block_onay = new ConnectDB();
					ResultSet rs_block_onay = conn_block_onay.selectData(k1.tc_kimlik_no);
					ConnectDB_6 conn = new ConnectDB_6();
					ResultSet rs = conn.selectData();
					ResultSet rs1 = conn.selectData();
					ConnectDB_9 conn_9 = new ConnectDB_9();
					ResultSet rs_9 = conn_9.selectData();
					rs_block_onay.next();
					String block_onay = rs_block_onay.getString("Kullanici_onay");
	            if(block_onay.equals("1")) {
					while(rs1.next()) {
						String geçici = rs1.getString("Block_onay_sayisi");
						int a = Integer.parseInt(geçici);
						if(a==3) {
							  String f = rs1.getString("Block");
							  conn.insertData_1(f);
							  conn.DeleteData();
						}
						
					}
					while(rs.next()) {
						String geçici1 = rs.getString("Block_onay_sayisi");
						int a1 = Integer.parseInt(geçici1);
						if(a1==0) {
							conn.update_data();
						}
						else if(a1==1) {
							conn.update_data_1();
						}
                         else if(a1==2) {
                        	 conn.update_data_2();
						}
						
						//a1++;
						//geçici1=Integer.toString(a1);
						//conn.update_data(geçici1);
					}
					while(rs_9.next()) {
						String geçici1 = rs_9.getString("block_sayim");
						int a1 = Integer.parseInt(geçici1);
						if(a1==0) {
							conn_9.update_data();
						}
						else if(a1==1) {
							conn_9.update_data_1();
						}
						else if(a1==2) {
							conn_9.update_data_2();
						}
						else if(a1==3) {
							conn_9.update_data_3();
						}
					}
					conn_block_onay.update_data(k1.tc_kimlik_no);
					JOptionPane.showMessageDialog(btnNewButton, "BLOCKLARI BAÞARI ÝLE ONAYLADINIZ !! ");
					
				}
	            else {
	            	JOptionPane.showMessageDialog(btnNewButton, "BU KÝÞÝ BLOCK ONAYI YAPMIÞ ");
	            }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(294, 381, 162, 21);
		contentPane.add(btnNewButton);
		
		ConnectDB_6 conn = new ConnectDB_6();
		ResultSet rs = conn.selectData();
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 125, 721, 208);
		contentPane.add(textArea);
		
		JButton btnNewButton_1 = new JButton("ANA SAYFA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnaSayfa K1 = new AnaSayfa();
				K1.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(639, 404, 108, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("YEN\u0130LE");
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Blocklar_Ona K1;
				try {
					K1 = new Blocklar_Ona();
					K1.setVisible(true);
					setVisible(false);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_2.setBounds(658, 14, 89, 20);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("!!! 4 ONAYA ULA\u015EAN BLOCKLAR BLOCK Z\u0130NC\u0130RE EKLEN\u0130R !!!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(229, 343, 439, 28);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("OY SAYIMI G\u00D6NDER");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ConnectDB_4 conn_4 = new ConnectDB_4();
					ConnectDB_9 conn_9 = new ConnectDB_9();
					ConnectDB_10 conn_10 =new ConnectDB_10();
					ResultSet rs_9 = conn_9.selectData();
					ResultSet rs = conn_4.selectData();
					while(rs.next()) {
						String kontrol =rs.getString("kullanici_oy_say_onay");
						if(kontrol.equals("1")) {
							int a_sayaç=0,b_sayaç=0,c_sayaç=0,d_sayaç=0;
							while(rs_9.next()) {
								String geçici = rs_9.getString("partiler_þifreli");
								String kontrol_2 = rs_9.getString("block_sayim");
								if(kontrol_2.equals("4")) {
								
								    if(geçici.equals("78fa856d4dbe0d2d8cab75d734fdfb064d9c7d5c")) {
									a_sayaç++;
								   }
								    else if(geçici.equals("ea2895e220232089a113e521a734acf41842636")) {
									b_sayaç++;
								   }
								   else if(geçici.equals("a61eea2642ba3c941d43936438bc8485cf60163b")) {
									c_sayaç++;
								   }
								   else if(geçici.equals("64f2f5977671e24189b5b087d692326d88dcf8dc")) {
									d_sayaç++;
								   }
						       }
								
							}
							String a_string,b_string,c_string,d_string;
							a_string=Integer.toString(a_sayaç);b_string=Integer.toString(b_sayaç);
							c_string=Integer.toString(c_sayaç);d_string=Integer.toString(d_sayaç);
							conn_10.insertData(a_string, b_string, c_string, d_string);
							JOptionPane.showMessageDialog(btnNewButton, "OY SAYIMINIZ GÖNDERÝLDÝ");
						}
						else {
							
							JOptionPane.showMessageDialog(btnNewButton, "ADMÝN OY SAYIM ÝZNÝ AÇMADI","HATA", JOptionPane.ERROR_MESSAGE);
						}
						
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(28, 404, 166, 21);
		contentPane.add(btnNewButton_3);
		
		
		while(rs.next()) {
		String block = rs.getString("Block");
		String block_onay = rs.getString("Block_onay_sayisi");
		//textArea.append(block+"*ONAYLIYAN KÝÞÝ SAYISI= "+block_onay+"\n");
		textArea.append(block+"\n");
		textArea.append("ONAYLIYAN KÝÞÝ SAYISI= " +block_onay+"\n");
	   }
		//JScrollPane scroll = new JScrollPane(textArea , JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//contentPane.add(scroll);
		
}	
}
