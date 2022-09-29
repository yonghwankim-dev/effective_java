package role03.staticfactory;



import org.junit.Test;

import java.util.function.Supplier;



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
