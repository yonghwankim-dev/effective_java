package role09;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;



import java.io.BufferedReader;

/**
 * title : try-finally 문제점
 * - try 블록과 finally 블록에서 둘다 예외가 발생하면
 * try블럭에서 발생한 예외는 무시되고 finally 블럭에서 발생한
 * 예외만 출력됩니다.
 * - 자원이 둘 이상이면 try-finally 구문이 복잡해진다.
 *
 */
public class TryFinallyTest {
	private static final int BUFFER_SIZE = 512;
	
	@Test
	void firstLineOfFileTest() {
		String line = null;
		try {
			line = firstLineOfFile("file.txt");
		} catch (IOException e) {
			System.out.println("예외 발생 : " + e.getMessage());
			e.printStackTrace();
		}
		assertEquals("hello world", line);
	}
	
	@Test
	void doubleThrowMethodTest() {
		String result = null;
		try {
			throwDoubleMethod();
		} catch (IOException e) {
			result = e.getMessage();
			e.printStackTrace();
		}
		
		assertEquals("finally 블럭에서 예외발생", result);
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

	// try-finally 구문을 활용한 일반적인 자원 회수
	static String firstLineOfFile(String path) throws IOException {
		
		// 회수해야할 자원
		BufferedReader br = new BufferedReader(new InputStreamReader(TryFinallyTest.class.getResourceAsStream(path)));
		
		try {
			return br.readLine();
		}finally {
			br.close();
		}
	}
	
	// try 블럭과 finally 블럭에서 예외가 발생시 try 블럭의 예외는 무시된다.
	static String throwDoubleMethod() throws IOException {		
		try {
			throw new IOException("try 블럭에서 예외발생");
		}finally {
			throw new IOException("finally 블럭에서 예외발생");	
		}
	}	

	// 자원이 둘 이상이면 try-finally 방식은 너무 지저분해진다
	static void copy(String src, String dst) throws IOException {
		
		InputStream in = TryFinallyTest.class.getResourceAsStream(src);
		try {
			OutputStream out = new FileOutputStream(dst);
			try {
				byte[] buf = new byte[BUFFER_SIZE];
				int n;
				while((n = in.read(buf)) >= 0) {
					out.write(buf, 0, n);
				}
			}finally {
				out.close();
			}
		}finally {
			in.close();
		}
	}
}
