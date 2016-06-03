import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; 
 
public class WriteResult {     

    public static void writen(String reMgs) throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter("D:/Result.txt", true));
		bw.write(reMgs + "\r\n");
		bw.close();
		
		}
    }
