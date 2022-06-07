package role06.sum;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SumTest {

	// 贸府 加档 : 11.690s
	@Test
	void sumTest() {
		System.out.println(Sum.sum());
	}
	
	// 贸府 加档 : 1.343s
	@Test
	void sum2Test() {
		System.out.println(Sum.sum2());	
	}

}
