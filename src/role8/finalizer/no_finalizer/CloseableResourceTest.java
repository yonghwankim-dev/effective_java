package role8.finalizer.no_finalizer;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class CloseableResourceTest {

	@Test
	public void whenTryWResourcesExits_thenResourceClosed() throws IOException {
	    try (CloseableResource resource = new CloseableResource()) {
	        String firstLine = resource.readFirstLine();
	        assertEquals("baeldung.com", firstLine);
	    }
	}
}
