package role08.finalizer;



import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


class FinalizableTest {

	@Test
	public void whenGC_thenFinalizerExecuted() throws IOException {
	    String firstLine = new Finalizable().readFirstLine();
	    assertEquals("baeldung.com", firstLine);
	    System.gc();
	}

}
