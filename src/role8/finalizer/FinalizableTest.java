package role8.finalizer;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class FinalizableTest {

	@Test
	public void whenGC_thenFinalizerExecuted() throws IOException {
	    String firstLine = new Finalizable().readFirstLine();
	    assertEquals("baeldung.com", firstLine);
	    System.gc();
	}

}
