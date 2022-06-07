package role09;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

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
