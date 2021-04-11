package hust.soict.globalict.garbage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
	
	public static void main(String[] args) throws IOException {
		String filename = "src/hust/soict/globalict/garbage/input.txt" ;
		long startTime, endTime;
		
		byte[] inputBytes = Files.readAllBytes(Paths.get(filename));
		startTime = System.currentTimeMillis();
		StringBuilder outputString = new StringBuilder("") ;
		for(byte b : inputBytes) {
			outputString.append((char)b);
		}
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);	
	}
	
}