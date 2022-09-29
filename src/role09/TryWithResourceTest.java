package role09;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;



public class TryWithResourceTest {
	private static final int BUFFER_SIZE = 512;
	
	@Test
	void firstLineOfFileTest() {
		String line = null;
		
		try {
			line = firstLineOfFile("file.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals("hello world", line);
	}
	
	@Test
	void copyTest() {
		try {
			String src = "file.txt";
			String dst = "./src/role9/file_copy.txt";
			copy(src, dst);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String line = null;
		try {
			line = firstLineOfFile("file_copy.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals("hello world", line);
	}
	
	@Test
	void firstLineOfFileTest2() {
		String line = null;
		
		line = firstLineOfFile(null, "기본 내용");
		
		assertEquals("기본 내용", line);
	}
	
	// try-with-resources : 자원을 회수하는 최선책
	static String firstLineOfFile(String fileName) throws IOException {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(
												   TryWithResourceTest.class.getResourceAsStream(fileName)
												   ))
			){
			return br.readLine();
		}
	}
	
	// 복수의 자원을 처리하는 try-with-resources
	static void copy(String src, String dst) throws IOException {
		try(InputStream in = TryWithResourceTest.class.getResourceAsStream(src);
			OutputStream out = new FileOutputStream(dst)){
			
			byte[] buf = new byte[BUFFER_SIZE];
			int n;
			while((n = in.read(buf)) >= 0) {
				out.write(buf, 0, n);
			}
		}
	}
	
	// try-with-resources를 catch 절과 함께 쓰는 모습
	static String firstLineOfFile(String fileName, String defaultVal) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(
				   				TryWithResourceTest.class.getResourceAsStream(fileName)
				   				))){
			return br.readLine();
		}catch (IOException | NullPointerException e) {
			return defaultVal;
		}
	}
}
