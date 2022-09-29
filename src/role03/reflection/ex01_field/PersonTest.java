package role03.reflection.ex01_field;



import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class PersonTest {

	private static List<String> getFieldNames(Field[] fields){
		List<String> fieldNames = new ArrayList<String>();
		for(Field field : fields) {
			fieldNames.add(field.getName());
		}
		return fieldNames;
		
	}
	
	/**
	 * title : 인스턴스가 주어질때 런타임에 필드 멤버들을 참조
	 * Class<?>.getDeclaredFields() : 해당 클래스의 모든 필드들을 참조하여 배열로 반환, 모든 접근 제어자를 대상으로 함 
	 */
	@Test
	void givenObject_whenGetsFieldNamesAtRuntime_thenCorrect() {
		Object person = new Person();
		Field[] fields = person.getClass().getDeclaredFields();
		
		List<String> actualFieldNames = getFieldNames(fields);
	
		assertTrue(Arrays.asList("name", "age")
				         .containsAll(actualFieldNames));
		
	}

}
