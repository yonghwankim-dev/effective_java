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
 * title : try-finally ������
 * - try ��ϰ� finally ��Ͽ��� �Ѵ� ���ܰ� �߻��ϸ�
 * try������ �߻��� ���ܴ� ���õǰ� finally ������ �߻���
 * ���ܸ� ��µ˴ϴ�.
 * - �ڿ��� �� �̻��̸� try-finally ������ ����������.
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
			System.out.println("���� �߻� : " + e.getMessage());
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
		
		assertEquals("finally ������ ���ܹ߻�", result);
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

	// try-finally ������ Ȱ���� �Ϲ����� �ڿ� ȸ��
	static String firstLineOfFile(String path) throws IOException {
		
		// ȸ���ؾ��� �ڿ�
		BufferedReader br = new BufferedReader(new InputStreamReader(TryFinallyTest.class.getResourceAsStream(path)));
		
		try {
			return br.readLine();
		}finally {
			br.close();
		}
	}
	
	// try ���� finally ������ ���ܰ� �߻��� try ���� ���ܴ� ���õȴ�.
	static String throwDoubleMethod() throws IOException {		
		try {
			throw new IOException("try ������ ���ܹ߻�");
		}finally {
			throw new IOException("finally ������ ���ܹ߻�");	
		}
	}	

	// �ڿ��� �� �̻��̸� try-finally ����� �ʹ� ������������
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
