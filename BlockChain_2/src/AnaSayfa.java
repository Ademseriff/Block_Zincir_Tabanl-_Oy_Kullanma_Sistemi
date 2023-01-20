import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Statement;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import java.sql.*;
public class AnaSayfa extends JFrame {

	private JPanel contentPane;
	private JTextField txtkimlik;
	private JTextField txtþifre;
    static  String tc_kimlik_no;
    static  String sifre;
    static  String ad_soyad;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnaSayfa frame = new AnaSayfa();
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
	public AnaSayfa() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 838, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("OY KULLANMA S\u0130STEM\u0130");
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(250, 39, 351, 80);
		contentPane.add(lblNewLabel);
		
		txtkimlik = new JTextField();
		txtkimlik.setBounds(421, 167, 132, 19);
		contentPane.add(txtkimlik);
		txtkimlik.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("T.C kimlik numara:");
		lblNewLabel_1.setBounds(237, 162, 107, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u015Eifre:");
		lblNewLabel_1_1.setBounds(237, 250, 107, 29);
		contentPane.add(lblNewLabel_1_1);
		
		txtþifre = new JPasswordField();
		txtþifre.setColumns(10);
		txtþifre.setBounds(427, 255, 132, 19);
		contentPane.add(txtþifre);
		
		JButton btnNewButton = new JButton("G\u0130R\u0130\u015E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tc_kimlik_no = txtkimlik.getText();
				sifre = txtþifre.getText();
				
				try {
					ConnectDB conn = new ConnectDB();
					ResultSet rs = conn.selectData();
					
					while(rs.next()) {
							//System.out.println(rs.getString("Kullanici_Sifre"));
							String kontrol_sifre = rs.getString("Kullanici_Sifre");
					    	String	kontrol_tc_kimlik_no = rs.getString("Kulanici_tc");
							if(kontrol_tc_kimlik_no.equals(tc_kimlik_no)) {
								
							
							if(sifre.equals(kontrol_sifre)) {
								ad_soyad = rs.getString("Kullanici_ad");
								String giriþ_yaptimi = rs.getString("Kullanici_bool");
								Kullanici_Gui k1 = new Kullanici_Gui();
								Blocklar_Ona k2 = new Blocklar_Ona();
								String a="1";
								if(giriþ_yaptimi.equals(a)) {
									k1.setVisible(true);
									k2.setVisible(true);
									setVisible(false);
								}
								else{
									setVisible(false);
									k2.setVisible(true);
									JOptionPane.showMessageDialog(btnNewButton, "Bu Kullanici oy Kulanmýþ");
								}
								
							}}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(362, 321, 174, 58);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ADM\u0130N G\u0130R\u0130\u015E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_Panel k1 = new Admin_Panel();
				k1.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton_1.setBounds(396, 389, 114, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Block Zinciri");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Blocklar_to_see k1;
				try {
					k1 = new Blocklar_to_see();
					k1.setVisible(true);
					setVisible(false);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setBounds(379, 420, 152, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("SAYILAN VE ONAYLANAN OYLAR");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OY_GÖSTERÝM k1;
				try {
					k1 = new OY_GÖSTERÝM();
					k1.setVisible(true);
					setVisible(false);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_3.setBounds(337, 451, 225, 21);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("TIKLAYINIZ");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Desktop.getDesktop().browse(new URI("https://bulutistan.com/blog/blockchain/#:~:text=Blockchain%20yani%20blok%20zinciri%2C%20halka,depolamaya%20%E2%80%9Cdijital%20defter%E2%80%9D%20denir."));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(63, 451, 93, 19);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_2 = new JLabel("BLOCKCHA\u0130N  TEK. \u0130LE DETAYLI B\u0130LG\u0130 ALMAK \u0130\u00C7\u0130N ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblNewLabel_2.setBounds(21, 424, 263, 13);
		contentPane.add(lblNewLabel_2);
	}
}
