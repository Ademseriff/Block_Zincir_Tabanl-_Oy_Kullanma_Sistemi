import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Blocklar_��z�m {
	

	public Blocklar_��z�m(String a) throws IOException {
		String a1= a;
		File file = new File("blocklar_�");
		if(!file.exists()) {
			file.createNewFile();
		}
		FileWriter F = new FileWriter(file, true);
		BufferedWriter bwriter = new BufferedWriter(F);
		bwriter.write("\n"+a1);
		bwriter.close();
		
	}

}
