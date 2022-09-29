package role06.string;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class StringTest {

	/**
	 * �������� �ʴ� ���ڿ� �������
	 * - heap.StringPool�� �ִ� ���ڿ� "hello"�� ������ �ٽ� heap ������ �ν��Ͻ��� �����ϴ� ��
	 * - �ν��Ͻ��� 2�� �����ϴ� �� 
	 * String s = new String("hello");
	 * 
	 * �����ϴ� ���ڿ� �������
	 * - �������� s�� heap.StringPool ������ ��ϵ� ���ڿ� "hello"�� ����Ŵ
	 * - ���� ���� �ӽ� �ȿ��� �̿� �Ȱ��� ���ڿ� ���ͷ��� ����ϴ� ��� �ڵ尡 ���� ��ü�� �������� ������
	 * String s = "hello";
	 * 
	 */
	@Test
	void StringTest() {
		String s1 = "hello";	// heap.StringPool�� �ִ� hello�� ����Ŵ
		String s2 = "hello";	// heap.StringPool�� �ִ� hello�� ����Ŵ
		String s3 = new String("hello"); // heap ������ String �ν��Ͻ��� ������
		String s4 = new String("hello"); // heap ������ String �ν��Ͻ��� ������
		String s5 = new String("hello").intern(); // heap ������ ������ String �ν��Ͻ��� StringPool�� ���
		
		
		assertTrue(s1 == s2);
		assertFalse(s3 == s4);
		assertFalse(s1 == s3);
		assertTrue(s1 == s5);
		
	}

}
