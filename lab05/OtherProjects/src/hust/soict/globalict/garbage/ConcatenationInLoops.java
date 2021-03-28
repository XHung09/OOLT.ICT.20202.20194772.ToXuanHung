package hust.soict.globalict.garbage;
import java.util.Random;

public class ConcatenationInLoops {
	public static void main(String[] args) {
		// using +
		String s = "" ;
		Random r = new Random(100) ;
		long startTime = System.currentTimeMillis() ;
		for(int i = 0 ;i < 65536 ;i++) {
			s += r.nextInt();
		}
		System.out.println(System.currentTimeMillis() - startTime);
		
		// using buffer
		StringBuffer strBuff= new StringBuffer("") ;
		r = new Random(123) ;
		startTime = System.currentTimeMillis() ;
		for(int i = 0 ;i < 65536; i++) {
			strBuff.append(r.nextInt()) ;
		}
		System.out.println(System.currentTimeMillis() - startTime);
		
		// using builder
		StringBuilder strBuild = new StringBuilder("") ;
		r = new Random(123) ;
		startTime = System.currentTimeMillis() ;
		for(int i = 0 ;i < 65536; i++) {
			strBuild.append(r.nextInt()) ;
		}
		System.out.println(System.currentTimeMillis() - startTime);
	}
}

