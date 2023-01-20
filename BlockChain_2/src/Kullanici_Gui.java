import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Statement;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;


public class Kullanici_Gui extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kullanici_Gui frame = new Kullanici_Gui();
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
	public Kullanici_Gui() {
		setResizable(false);
		AnaSayfa k =new AnaSayfa();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0130S\u0130M-SOY\u0130S\u0130M");
		lblNewLabel.setBounds(24, 109, 109, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lbl_isim = new JLabel(k.ad_soyad);
		lbl_isim.setBounds(220, 113, 109, 27);
		contentPane.add(lbl_isim);
		
		JLabel lblNewLabel_2 = new JLabel("Oy Kullanma ALANI");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(220, 10, 218, 55);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblTcKimlikno = new JLabel("T.C kÝMLÝK NO:");
		lblTcKimlikno.setBounds(24, 168, 109, 34);
		contentPane.add(lblTcKimlikno);
		
		JLabel lbl_tc = new JLabel(k.tc_kimlik_no);
		lbl_tc.setBounds(220, 168, 109, 34);
		contentPane.add(lbl_tc);
		
		JLabel lblNewLabel_3 = new JLabel("A-PART\u0130S\u0130");
		lblNewLabel_3.setBounds(76, 262, 58, 34);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("B-PART\u0130S\u0130");
		lblNewLabel_4.setBounds(197, 268, 73, 23);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("C-PART\u0130S\u0130");
		lblNewLabel_4_1.setBounds(321, 268, 73, 23);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5 = new JLabel("D-PART\u0130S\u0130");
		lblNewLabel_5.setBounds(462, 268, 73, 23);
		contentPane.add(lblNewLabel_5);
		
		JRadioButton aradiobutton = new JRadioButton("");
		aradiobutton.setBounds(86, 302, 58, 21);
		contentPane.add(aradiobutton);
		
		JRadioButton bradiobutton = new JRadioButton("");
		bradiobutton.setBounds(207, 297, 52, 21);
		contentPane.add(bradiobutton);
		
		JRadioButton cradiobutton = new JRadioButton("");
		cradiobutton.setBounds(331, 297, 52, 21);
		contentPane.add(cradiobutton);
		
		JRadioButton dradiobutton = new JRadioButton("");
		dradiobutton.setBounds(472, 297, 52, 21);
		contentPane.add(dradiobutton);
	
		JButton btnNewButton = new JButton("OY KULLAN");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(aradiobutton);
		bg.add(bradiobutton);
		bg.add(cradiobutton);
		bg.add(dradiobutton);
		btnNewButton.setBounds(250, 362, 144, 55);
		contentPane.add(btnNewButton);
		
		JButton btnCikis = new JButton("\u00C7\u0131k\u0131\u015F");
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnaSayfa v = new AnaSayfa();
				v.setVisible(true);
				setVisible(false);
			}
		});
		btnCikis.setBounds(558, 426, 85, 21);
		contentPane.add(btnCikis);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ConnectDB_1 conn = new ConnectDB_1();
					ResultSet rs = conn.selectData();
					ConnectDB_2 conn_1 = new ConnectDB_2();
					ConnectDB_3 conn_2 = new ConnectDB_3();
					ConnectDB_8 conn_8 = new ConnectDB_8();
					ConnectDB_9 conn_9 = new ConnectDB_9();
					//ConnectDB_6 conn_6 = new ConnectDB_6();
					int a = 1;
					while(rs.next()) {
						String kontrol =rs.getString("A_parti");
						String kontrol_1 =rs.getString("B_parti");
						String kontrol_2 =rs.getString("C_parti");
						String kontrol_3 =rs.getString("D_parti");
						if(aradiobutton.isSelected()) {
							int kontrolint = Integer.parseInt(kontrol);
							kontrolint++;
							kontrol = Integer.toString(kontrolint);
							String sql = "UPDATE kullanici_oy Set A_parti = "+kontrol+" where idkullanici_oy = 1" ;
							conn.executeUpdate_1(sql);
							sifreleme aes_encryption = new sifreleme();
							aes_encryption.init();
							//String gizli = aes_encryption.encrypt(k.ad_soyad+"a_partisine oy vermiþtir");
							SHA_1 sha_1 = new SHA_1();
							String sha_1_sifrelenmiþ = "a partisine oy vermiþtir";
							sha_1_sifrelenmiþ=sha_1.encryptThisString(sha_1_sifrelenmiþ);
							String gizli = aes_encryption.encrypt(k.tc_kimlik_no);
							String birleþtirilmiþ = gizli + "->"+  sha_1_sifrelenmiþ;
							String acik = aes_encryption.decrypt(gizli);
							String b = acik+" "+gizli; 
							PreviousHash_Çekme f = new PreviousHash_Çekme();
							String c = f.PreviousHash_Çekme_1();
							conn_1.insertData(birleþtirilmiþ);
							conn_2.insertData(b);
							conn_9.insertData(sha_1_sifrelenmiþ);
							//conn_6.insertData(gizli);
							new Block(birleþtirilmiþ,c,a);
							conn_8.executeUpdate_1(k.tc_kimlik_no);
							setVisible(false);
							
						}
						if(bradiobutton.isSelected()) {
							int kontrolint = Integer.parseInt(kontrol_1);
							kontrolint++;
							kontrol_1 = Integer.toString(kontrolint);
							String sql = "UPDATE kullanici_oy Set B_parti = "+kontrol_1+" where idkullanici_oy = 1" ;
							conn.executeUpdate_1(sql);
							sifreleme aes_encryption = new sifreleme();
							aes_encryption.init();
							//String gizli = aes_encryption.encrypt(k.ad_soyad+"b_partisine oy vermiþtir");
							
							SHA_1 sha_1 = new SHA_1();
							String sha_1_sifrelenmiþ = "b partisine oy vermiþtir";
							sha_1_sifrelenmiþ=sha_1.encryptThisString(sha_1_sifrelenmiþ);
							String gizli = aes_encryption.encrypt(k.tc_kimlik_no);
							String birleþtirilmiþ = gizli + "->"+  sha_1_sifrelenmiþ;
							String acik = aes_encryption.decrypt(gizli);
							String b = acik+" "+gizli; 
							PreviousHash_Çekme f = new PreviousHash_Çekme();
							String c = f.PreviousHash_Çekme_1();
							conn_1.insertData(birleþtirilmiþ);
							conn_2.insertData(b);
							conn_9.insertData(sha_1_sifrelenmiþ);
							//conn_6.insertData(gizli);
							new Block(birleþtirilmiþ,c,a);
							conn_8.executeUpdate_1(k.tc_kimlik_no);
							setVisible(false);
							
						
						
						}
						if(cradiobutton.isSelected()) {
							int kontrolint = Integer.parseInt(kontrol_2);
							kontrolint++;
							kontrol_2 = Integer.toString(kontrolint);
							String sql = "UPDATE kullanici_oy Set C_parti = "+kontrol_2+" where idkullanici_oy = 1" ;
							conn.executeUpdate_1(sql);
							sifreleme aes_encryption = new sifreleme();
							aes_encryption.init();
							//String gizli = aes_encryption.encrypt(k.ad_soyad+"c_partisine oy vermiþtir");
							SHA_1 sha_1 = new SHA_1();
							String sha_1_sifrelenmiþ = "c partisine oy vermiþtir";
							sha_1_sifrelenmiþ=sha_1.encryptThisString(sha_1_sifrelenmiþ);
							String gizli = aes_encryption.encrypt(k.tc_kimlik_no);
							String birleþtirilmiþ = gizli + "->"+  sha_1_sifrelenmiþ;
							String acik = aes_encryption.decrypt(gizli);
							String b = acik+" "+gizli; 
							PreviousHash_Çekme f = new PreviousHash_Çekme();
							String c = f.PreviousHash_Çekme_1();
							conn_1.insertData(birleþtirilmiþ);
							conn_2.insertData(b);
							conn_9.insertData(sha_1_sifrelenmiþ);
							//conn_6.insertData(gizli);
							new Block(birleþtirilmiþ,c,a);
							conn_8.executeUpdate_1(k.tc_kimlik_no);
							setVisible(false);
						
						
						}
						if(dradiobutton.isSelected()) {
							int kontrolint = Integer.parseInt(kontrol_3);
							kontrolint++;
							kontrol_3 = Integer.toString(kontrolint);
							String sql = "UPDATE kullanici_oy Set D_parti = "+kontrol_3+" where idkullanici_oy = 1" ;
							conn.executeUpdate_1(sql);
							sifreleme aes_encryption = new sifreleme();
							aes_encryption.init();
							//String gizli = aes_encryption.encrypt(k.ad_soyad+"d_partisine oy vermiþtir");
							SHA_1 sha_1 = new SHA_1();
							String sha_1_sifrelenmiþ = "d partisine oy vermiþtir";
							sha_1_sifrelenmiþ=sha_1.encryptThisString(sha_1_sifrelenmiþ);
							String gizli = aes_encryption.encrypt(k.tc_kimlik_no);
							String birleþtirilmiþ = gizli + "->"+  sha_1_sifrelenmiþ;
							String acik = aes_encryption.decrypt(gizli);
							String b = acik+" "+gizli; 
							PreviousHash_Çekme f = new PreviousHash_Çekme();
							String c = f.PreviousHash_Çekme_1();
							conn_1.insertData(birleþtirilmiþ);
							conn_2.insertData(b);
							conn_9.insertData(sha_1_sifrelenmiþ);
							//conn_6.insertData(gizli);
							new Block(birleþtirilmiþ,c,a);
							conn_8.executeUpdate_1(k.tc_kimlik_no);
							setVisible(false);
						
						
							
						
						
						}
						
							
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
			
		}
	}
