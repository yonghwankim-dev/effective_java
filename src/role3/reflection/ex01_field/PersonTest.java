package role3.reflection.ex01_field;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class PersonTest {

	private static List<String> getFieldNames(Field[] fields){
		List<String> fieldNames = new ArrayList<String>();
		for(Field field : fields) {
			fieldNames.add(field.getName());
		}
		return fieldNames;
		
	}
	
	/**
	 * title : �ν��Ͻ��� �־����� ��Ÿ�ӿ� �ʵ� ������� ����
	 * Class<?>.getDeclaredFields() : �ش� Ŭ������ ��� �ʵ���� �����Ͽ� �迭�� ��ȯ, ��� ���� �����ڸ� ������� �� 
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