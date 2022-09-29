package role09;



import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


class CloseableResourceTest {

	@Test
	void tryWithResourceTest() {
		String line = null;
		
		try(CloseableResource cr = new CloseableResource("file.txt")){
			line = cr.readFirstLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		assertEquals("hello world", line);
	}

}
