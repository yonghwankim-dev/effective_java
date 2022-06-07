package role03.staticfactory;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

class ElvisTest {

	@Test
	void test() {
		Elvis e = Elvis.getInstance();
		e.leaveTheBuilding();
		
	}
	
	@Test
	void supplierTest() {
		Supplier<Elvis> sup = new Supplier<Elvis>() {
			
			@Override
			public Elvis get() {
				return Elvis.getInstance();
			}
		};
		
		Elvis e = sup.get();
		
	}

}
