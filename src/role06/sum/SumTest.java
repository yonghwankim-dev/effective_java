package role06.sum;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SumTest {

	// ó�� �ӵ� : 11.690s
	@Test
	void sumTest() {
		System.out.println(Sum.sum());
	}
	
	// ó�� �ӵ� : 1.343s
	@Test
	void sum2Test() {
		System.out.println(Sum.sum2());	
	}

}