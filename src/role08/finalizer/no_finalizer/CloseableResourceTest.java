package role08.finalizer.no_finalizer;



import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


class CloseableResourceTest {

	@Test
	public void whenTryWResourcesExits_thenResourceClosed() throws IOException {
	    try (CloseableResource resource = new CloseableResource()) {
	        String firstLine = resource.readFirstLine();
	        assertEquals("baeldung.com", firstLine);
	    }
	}
}
