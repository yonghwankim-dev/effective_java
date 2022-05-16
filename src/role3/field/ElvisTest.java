package role3.field;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ElvisTest {

	@Test
	void test() {
		Elvis e = Elvis.INSTANCE;
		e.leaveTheBuilding();
	}

}
