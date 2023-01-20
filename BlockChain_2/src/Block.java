import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Block {
	private String previousHash;
	private String Hash;
	static  List<String> Block = new ArrayList<String>();
	static int a=1;
	
	public Block(String Hash, String previousHash,int a) throws IOException, SQLException {
		this.Hash= Hash;
		this.previousHash=previousHash;
		this.a = a;
		ConnectDB_6 conn_6 = new ConnectDB_6();
		if(a%2==0) {
			String birlesen_deger = Hash+"  "+previousHash;
			Block.add(birlesen_deger);
			conn_6.insertData(birlesen_deger);
			File file = new File("blocklar");
			if(!file.exists()) {
				file.createNewFile();
			}
			FileWriter F = new FileWriter(file, true);
			BufferedWriter bwriter = new BufferedWriter(F);
			bwriter.write("\n"+birlesen_deger);
			bwriter.close();
			a++;
		}
		else if(a%2==1) {
			String birlesen_deger = previousHash+" "+Hash;
			Block.add(birlesen_deger);
			conn_6.insertData(birlesen_deger);
			File file = new File("blocklar");
			if(!file.exists()) {
				file.createNewFile();
			}
			FileWriter F = new FileWriter(file, true);
			BufferedWriter bwriter = new BufferedWriter(F);
			bwriter.write("\n"+birlesen_deger);
			bwriter.close();
			a++;
		}
		  for (int i = 0 ; i < Block.size();i++) {
	            
	            System.out.println(Block.get(i));
	            
	        }
		  System.out.println("*****************");
		
		
	
		/*
		File file = new File("blocklar");
		if(!file.exists()) {
			file.createNewFile();
		}
		FileWriter F = new FileWriter(file, true);
		BufferedWriter bwriter = new BufferedWriter(F);
		bwriter.write("\n"+birlesen_deger);
		bwriter.close();*/
		
	}
	

}