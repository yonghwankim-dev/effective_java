package role3.reflection.ex02_reflection;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class GoatTest {
 
	/**
	 * title : Field �迭�� ���ҵ��� ����Ʈ�� �̰����� ��ȯ�� 
	 * @param fields � Ŭ������ �ʵ����� ����ִ� �迭
	 * @return �ʵ� ��� �̸����� �ִ� ���ڿ� ����Ʈ
	 */
	private static List<String> getFieldNames(Field[] fields){
		List<String> fieldNames = new ArrayList<String>();
		for(Field field : fields) {
			fieldNames.add(field.getName());
		}
		return fieldNames;
		
	}

	/**
	 * title : Method �迭�� ���ҵ��� ����Ʈ�� �̰����� ��ȯ�� 
	 * @param methods � Ŭ������ �޼��尡 ����ִ� �迭
	 * @return �޼��� ��� �̸����� �ִ� ���ڿ� ����Ʈ
	 */
	private List<String> getMethodNames(Method[] methods) {
		List<String> methodNames = new ArrayList<String>();
		for(Method method : methods) {
			methodNames.add(method.getName());
		}
		return methodNames;
	}

	/**
	 * title : �ν��Ͻ��� �־������� �ν��Ͻ��� Ŭ���� �̸��� ��ü ��θ� Ȯ��
	 * Object.getClass() : �ν��Ͻ��� Ŭ���� ���� ���� (Class<?> Ÿ��)
	 * Class<?>.getSimpleName() : Ŭ���� ��ü �̸��� ����, �͸��� ��� �� ���ڿ� ����
	 * Class<?>.getName() : Ŭ������ ��Ű�� ��θ� ������ �̸��� ����
	 * Class<?>.getCanonicalName() : Java ��� ��翡�� ������ ��Ű�� ��θ� ������ �⺻ Ŭ������ ǥ�� �̸� ���� 
	 */
	@Test
	void givenObject_whenGetsClassName_thenCorrect() {
		Object goat = new Goat("goat");
		Class<?> clazz = goat.getClass();
		
		assertEquals("Goat", clazz.getSimpleName());
		assertEquals("role3.reflection.ex02.Goat", clazz.getName());
		assertEquals("role3.reflection.ex02.Goat", clazz.getCanonicalName());	
	}

	/**
	 * title : �ν��Ͻ��� �������� �ʰ� Class.forName ���� ��� �޼ҵ带 ȣ���Ͽ� Ŭ������ �̸��� ��� Ȯ��
	 * Class.forName �޼��� Ŭ���� �̸� �ۼ��� ��Ű�� ��θ� �����ؾ���
	 * Class.forName �޼��� ȣ��� Ŭ������ �������� ������ ClassNotFoundException ���� �߻���  
	 * @throws ClassNotFoundException Ŭ������ ã�� ����
	 */
	@Test
	void givenClassName_whenCreatesObject_thenCorrect() throws ClassNotFoundException {
		Class<?> clazz = Class.forName("role3.reflection.ex02.Goat");
	
		assertEquals("Goat", clazz.getSimpleName());
		assertEquals("role3.reflection.ex02.Goat", clazz.getName());
		assertEquals("role3.reflection.ex02.Goat", clazz.getCanonicalName());
	}
	
	/**
	 * title : ���÷�Ʈ Modifier�� Ȱ���Ͽ� Ŭ������ ���������ڸ� Ȯ��
	 * Class.forName�� Ȱ���Ͽ� ����� ���� ��� �ν��Ͻ��� �����ϴ� ��� Ȯ���� �� ����
	 * Modifier.isPublic(Class<?>) : ������ Ŭ���� ���������ڰ� public���� ����
	 * Modifier.isAbstract(Class<?>) : ������ Ŭ���� ���������ڰ� abstract Ŭ�������� ���� 
	 * @throws ClassNotFoundException Ŭ������ ã�� ����
	 */
	@Test
	void givenClass_whenRecognisesModifiers_thenCorrect() throws ClassNotFoundException {
		Class<?> goatClass = Class.forName("role3.reflection.ex02.Goat");
		Class<?> animalClass = Class.forName("role3.reflection.ex02.Animal");
		
		int goatMods = goatClass.getModifiers();
		int animalMods = animalClass.getModifiers();
		
		assertTrue(Modifier.isPublic(goatMods));
		assertTrue(Modifier.isAbstract(animalMods));
		assertTrue(Modifier.isPublic(animalMods));
	}
	

	/**
	 * title : Ŭ������ �־������� �ش� Ŭ������ ��Ű�� ��θ� ����
	 * Class<?>.getPackage() : �ش� Ŭ������ ��Ű�� ��� ����(Ŭ���� �̸� ����) 
	 */
	@Test
	void givenClass_whenGetsPackageInfo_thenCorrect() {
		Goat goat = new Goat("goat");
		Class<?> goatClass = goat.getClass();
		Package pkg = goatClass.getPackage();
		
		assertEquals("role3.reflection.ex02", pkg.getName());
	}
	
	// 
	/**
	 * title : Ŭ������ �־������� �ش� Ŭ������ ���� Ŭ������ ����
	 * Class<?>.getSuperClass() : �ش� Ŭ������ ���� Ŭ������ ����.
	 *                            �ش� Ŭ������ Object, Interface, �⺻Ÿ��, void�� ��� null ����
	 */
	@Test
	void givenClass_whenGetsSuperClass_thenCorrect() {
		Goat goat = new Goat("goat");
		String str = "any string";
		
		Class<?> goatClass = goat.getClass();
		Class<?> goatSuperClass = goatClass.getSuperclass();
		
		assertEquals("Animal", goatSuperClass.getSimpleName());
		assertEquals("Object", str.getClass().getSuperclass().getSimpleName());
	}
	
	/**
	 * title : Ŭ������ �־������� �ش� Ŭ������ ������ �������̽��� ����
	 * Class<?>.getInterfaces() : �ش� Ŭ������ ������ �������̽��� ����
	 * 
	 * �� Goat Ŭ������ Eating �������̽�(Animal �߻� Ŭ������ ��ӹ��� ����)�� 
	 * �����ϰ� Locomotion �������̽��� �����Կ��� Class<?>.getInterfaces() �������� 
	 * Locomotion �������̽����� �����Ǵ°�?
	 * => getInterfaces() �޼���� Ŭ������ ��������� implements Ű����� �����Ǿ��ٰ�
	 * ������ �������̽��� �����Ͽ� �迭�� ��ȯ�մϴ�.
	 * => Goat Ŭ������ Animal �߻� Ŭ������ �ڼ� Ŭ�����̹Ƿ� implements Ű���带 ��뤾�Ƥ�
	 * �������̽��� ������������ �ʾұ� ������ Eating �������̽��� �������� �ʽ��ϴ�.
	 *  
	 * @throws ClassNotFoundException Ŭ������ ã�� ����
	 */
	@Test
	void givenClass_whenGetsImplementedInterfaces_thenCorrect() throws ClassNotFoundException {
		Class<?> goatClass = Class.forName("role3.reflection.ex02.Goat");
		Class<?> animalClass = Class.forName("role3.reflection.ex02.Animal");
		
		Class<?>[] goatInterfaces = goatClass.getInterfaces();	// [Locomotion]
		Class<?>[] animalInterfaces = animalClass.getInterfaces(); // [Eating]
		
		assertEquals(1, goatInterfaces.length);
		assertEquals(1, animalInterfaces.length);
		assertEquals("Locomotion", goatInterfaces[0].getSimpleName());
		assertEquals("Eating", animalInterfaces[0].getSimpleName());
		
	}
	
	/**
	 * title : Ŭ������ �־����� �ش� Ŭ������ �����ڵ��� �����ϰ� �������� ������ �̸��� Ȯ��
	 * Class<?>.getConstructors() : �ش� Ŭ������ �����ڵ��� �迭 ���·� ����, �� public �����ڸ� ����
	 * @throws ClassNotFoundException Ŭ������ ã�� ����
	 */
	@Test
	void givenClass_whenGetsConstructor_thenCorrect() throws ClassNotFoundException {
		Class<?> goatClass = Class.forName("role3.reflection.ex02.Goat");
		
		Constructor<?>[] constructors = goatClass.getConstructors();
		
		assertEquals(1, constructors.length);
		assertEquals("role3.reflection.ex02.Goat", constructors[0].getName());
		
	}

	/**
	 * title : Ŭ������ �־����� �ش� Ŭ������ �ʵ������� �����ϰ� ������ �̸��� Ȯ��
	 * Class<?>.getDeclaredFields() : �ش� Ŭ������ �ʵ� ������� �����Ͽ� �迭 ���·� ��ȯ
	 * 								  ��� ���� ������ �����Ѵ�. ��, ��ӹ��� �ʵ�� �����Ѵ�.
	 * @throws ClassNotFoundException Ŭ������ ã�� ����
	 */
	@Test
	void givenClass_whenGetsFields_thenCorrect() throws ClassNotFoundException {
		Class<?> animalClass = Class.forName("role3.reflection.ex02.Animal");
		Field[] fields = animalClass.getDeclaredFields();
		
		List<String> actualFields = getFieldNames(fields);
		
		assertEquals(2, actualFields.size());
		assertTrue(actualFields.containsAll(Arrays.asList("name", "CATEGORY")));
	}

	/**
	 * title : Ŭ������ �־����� �ش� Ŭ������ �޼������ �����ϰ� ������ �̸����� Ȯ��
	 * Class<?>.getDeclaredMethods() : �ش� Ŭ������ �޼��� ������� �����Ͽ� �迭 ���·� ��ȯ
	 * 								   ��� ���� ������ �����Ѵ�. ��, ��ӹ��� �޼���� �����Ѵ�.
	 * @throws ClassNotFoundException Ŭ������ ã�� ����
	 */
	@Test
	void givenClass_whenGetsMethods_thenCorrect() throws ClassNotFoundException {
		Class<?> animalClass = Class.forName("role3.reflection.ex02.Animal");
		Method[] methods = animalClass.getDeclaredMethods();
		
		List<String> actualMethods = getMethodNames(methods);
		
		assertEquals(3, actualMethods.size());
		assertTrue(actualMethods.containsAll(Arrays.asList("getName", "setName", "getSound")));	
	}
	
	
	/**
	 * title : Ŭ������ �־����� �ش� Ŭ������ ��� �����ڸ� �����ϰ� ������ Ȯ��
	 * Class<?>.getConstructors() : �ش� Ŭ������ �����ڵ��� �����Ͽ� �迭 ���·� ��ȯ
	 * 								��, public ���� �����ڿ� ����  
	 * @throws ClassNotFoundException
	 */
	@Test
	void givenClass_whenGetsAllConstructors_thenCorrect() throws ClassNotFoundException {
		Class<?> birdClass = Class.forName("role3.reflection.ex02.Bird");
		Constructor<?>[] constructors = birdClass.getConstructors();
		
		assertEquals(3, constructors.length);
	}
	
	/**
	 * title : Ŭ������ �־����� ������ �����ڸ� �Ķ���� Ÿ�Կ� ���ؼ� ����
	 * Class<?>.getConstructor(Class<?>... parameterType) : �ش� Ŭ������ �����ڸ� �����ϴµ� �Ķ���Ϳ� 
	 * 														Ŭ���� Ÿ���� �����Ͽ� �ش� Ÿ���� �����ڰ� �ִ��� ������
	 * 													    �ش� �����ڰ� ������ NoSuchMethodException ���� �߻�
	 * @throws ClassNotFoundException Ŭ������ ã�� ����
	 * @throws NoSuchMethodException �����ڰ� �������� ����
	 * @throws SecurityException ���� ���� �߻�
	 */
	@Test
	void givenClass_whenGetsEachConstructorByParamType_thenCorrect() throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		Class<?> birdClass = Class.forName("role3.reflection.ex02.Bird");
		
		Constructor<?> cons1 = birdClass.getConstructor();
		Constructor<?> cons2 = birdClass.getConstructor(String.class);
		Constructor<?> cons3 = birdClass.getConstructor(String.class, boolean.class);
		
	}

	/**
	 * title : Ŭ������ �־������� ��Ÿ�ӿ� �ν��Ͻ��� �����Ͽ� ����� ���� �� Ȯ��
	 * Constructor<?>.newInstance(Object... initargs) : �ش� �����ڸ� ������� �ν��Ͻ� ����
	 * , private �������ӿ��� ���������� (java 9 ���ķδ� ����� ���)
	 * 
	 * newInstance() �޼��� ȣ���� private �������ӿ��� ȣ���Ͽ� �ν��Ͻ��� ������ �� �վ
	 * �̱��� Ŭ������ ������� ����� ������ ���� �� ����
	 * 
	 * @throws ClassNotFoundException Ŭ������ ã�� ����
	 * @throws NoSuchMethodException  �����ڰ� �������� ����
	 * @throws SecurityException	  ���� ����
	 * @throws InstantiationException �ν��Ͻ� ���� ����
	 * @throws IllegalAccessException ������ �� ���� ����� ����
	 * @throws IllegalArgumentException �������� ���� ���� 
	 * @throws InvocationTargetException invoke ���� ���� 
	 */
	@Test
	void givenClass_whenInstantiatesObjectsAtRuntime_thenCorrect() throws ClassNotFoundException
	                                                                    , NoSuchMethodException
	                                                                    , SecurityException
	                                                                    , InstantiationException
	                                                                    , IllegalAccessException
	                                                                    , IllegalArgumentException
	                                                                    , InvocationTargetException {
		Class<?> birdClass = Class.forName("role3.reflection.ex02.Bird");
		
		Constructor<?> cons1 = birdClass.getConstructor();
		Constructor<?> cons2 = birdClass.getConstructor(String.class);
		Constructor<?> cons3 = birdClass.getConstructor(String.class, boolean.class);
		
		Bird bird1 = (Bird) cons1.newInstance();
		Bird bird2 = (Bird) cons2.newInstance("Weaver bird");
		Bird bird3 = (Bird) cons3.newInstance("dove", true);
		
		assertEquals("bird", bird1.getName());
		assertEquals("Weaver bird", bird2.getName());
		assertEquals("dove", bird3.getName());
		
		assertFalse(bird1.walks());
		assertTrue(bird3.walks());
	}
	
	/**
	 * title : Ŭ������ �־������� �ش� Ŭ������ public �ʵ带 �����Ͽ� ������ �̸��� ����
	 * Class<?>.getFields() : �ش� Ŭ������ public �ʵ� ����� �迭�� ��ȯ  
	 * @throws ClassNotFoundException Ŭ������ ã�� ����
	 */
	@Test
	void givenClass_whenGetsPublicFields_thenCorrect() throws ClassNotFoundException {
		Class<?> birdClass = Class.forName("role3.reflection.ex02.Bird");
		
		Field[] fields = birdClass.getFields();
		
		assertEquals(1, fields.length);
		assertEquals("CATEGORY", fields[0].getName());
	}
	
	/**
	 * title : Ŭ������ �־������� �ʵ� �̸��� ���� �ش� Ŭ������ public �ʵ带 ����
	 * Class<?>.getField(String) : �ش� Ŭ������ ���ڿ� �ش��ϴ� �ʵ带 ����, ��, public �ʵ常 ������
	 * @throws ClassNotFoundException Ŭ������ ã�� ����
	 * @throws NoSuchFieldException �����ϰ��� �ϴ� �ʵ尡 ����
	 * @throws SecurityException ���� ����
	 */
	@Test
	void givenClass_whenGetsPublicFieldByName_thenCorrect() throws ClassNotFoundException, NoSuchFieldException, SecurityException {
		Class<?> birdClass = Class.forName("role3.reflection.ex02.Bird");
		
		Field field = birdClass.getField("CATEGORY");
		
		assertEquals("CATEGORY", field.getName());
	}
	
	/**
	 * title : Ŭ������ �־������� �ش� Ŭ������ ���ǵ� �ʵ� ������� �����ϰ� ������ �̸��� Ȯ����
	 * Class<?>.getDelaredFields() : ��� ���� �����ڸ� ������� �ش� Ŭ������ ��� �ʵ带 ������, ��, ��ӹ��� �ʵ�� ������
	 * @throws ClassNotFoundException Ŭ������ ã�� ����
	 */
	@Test
	void givenClass_whenGetsDeclaredFields_thenCorrect() throws ClassNotFoundException {
		Class<?> birdClass = Class.forName("role3.reflection.ex02.Bird");
		
		Field[] fields = birdClass.getDeclaredFields();
		
		assertEquals(1, fields.length);
		assertEquals("walks", fields[0].getName());	
	}
	
	/**
	 * title : Ŭ������ �־������� �ʵ� �̸��� ���� �ʵ带 ����
	 * Class<?>.getDeclaredField(String) : ���� �̸��� �ش��ش� Ŭ������ �ʵ� ����� ����, ��� ���� ������ ������
	 * @throws ClassNotFoundException Ŭ������ ã�� ����
	 * @throws NoSuchFieldException �ʵ带 ã�� ����
	 * @throws SecurityException ���� ����
	 */
	@Test
	void givenClass_whenGetsFieldsByName_thenCorrect() throws ClassNotFoundException, NoSuchFieldException, SecurityException {
		Class<?> birdClass = Class.forName("role3.reflection.ex02.Bird");
		Field field = birdClass.getDeclaredField("walks");
		
		assertEquals("walks", field.getName());
	}
	
	/**
	 * title : Ŭ���� �ʵ尡 �־������� �ش� �ʵ��� Ÿ���� ������
	 * Field.getType() : �ش� �ʵ��� Ŭ���� Ÿ���� �����Ͽ�, Class<?> Ÿ������ ��ȯ��
	 * @throws NoSuchFieldException ���� �ʵ尡 ����
	 * @throws SecurityException ���ȿ���
	 * @throws ClassNotFoundException Ŭ������ ã�� ����
	 */
	@Test
	void givenClassField_whenGetsType_thenCorrect() throws NoSuchFieldException, SecurityException, ClassNotFoundException {
		Field field = Class.forName("role3.reflection.ex02.Bird").getDeclaredField("walks");
		Class<?> fieldClass = field.getType();
		
		assertEquals("boolean", fieldClass.getSimpleName());	
	}

	/**
	 * title : Ŭ���� �ʵ尡 �־����� �ʵ��� ���� �����ϰ� ����
	 * Field.setAccessible(boolean) : private ���� ������ �ʵ忡 ������ �� �ֵ��� ������
	 * Field.set(Object, Object) : ���ڿ� �ν��Ͻ�, ���� �����Ͽ� ���ڷ� ������ Ŭ������ �ʵ��� ���� ������  
	 * @throws ClassNotFoundException Ŭ������ ã�� ����
	 * @throws InstantiationException �ν��Ͻ� ���� ����
	 * @throws IllegalAccessException ������ �� ���� �ʵ忡 ������
	 * @throws IllegalArgumentException ���� ������ �߸���
	 * @throws InvocationTargetException invoke �޼��� ����� ����
	 * @throws NoSuchMethodException ���� �޼��尡 ����
	 * @throws SecurityException ���� ����
	 * @throws NoSuchFieldException ���� �ʵ尡 ����
	 */
	@Test
	void givenClassField_whenSetsAndGetsValue_thenCorrect() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {
		Class<?> birdClass = Class.forName("role3.reflection.ex02.Bird");
		Bird bird = (Bird) birdClass.getConstructor().newInstance();
		Field field = birdClass.getDeclaredField("walks");
		field.setAccessible(true);
		
		assertFalse(field.getBoolean(bird));
		assertFalse(bird.walks());
		
		field.set(bird, true);
		
		assertTrue(field.getBoolean(bird));
		assertTrue(bird.walks());		
	}
	
	/**
	 * title : Ŭ���� �ʵ尡 �־����� �ش� Ŭ���� �ʵ��� ���� ����
	 * Class<?>.getField(String) : ���ڿ� �ش��ϴ� �ʵ带 �����մϴ�.
	 * Field.get(Object) : �ش� �ʵ��� ���� ������
	 * ��, �ʵ尡 public static�̸� ���ڴ� ���õ�.
	 * 
	 * @throws ClassNotFoundException Ŭ������ ã�� ����
	 * @throws NoSuchFieldException ���� �ʵ尡 ����
	 * @throws SecurityException ���� ����
	 * @throws IllegalArgumentException ���� ������ �߸���
	 * @throws IllegalAccessException ���� ���ϴ� �ʵ忡 ������
	 */
	@Test
	void givenClassField_whenGetsAndSetsWithNull_thenCorrect() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Class<?> birdClass = Class.forName("role3.reflection.ex02.Bird");
		Field field = birdClass.getField("CATEGORY");
		field.setAccessible(true);
		
		assertEquals("domestic", field.get(null));
	}
	
	/**
	 * title : Ŭ������ �־����� public ����� ��� �޼��带 ������
	 * Class<?>.getMethods() : ���������ڰ� public�� �ش� Ŭ������ �޼������ �����Ͽ� �迭 ���·� ��ȯ��
	 * @throws ClassNotFoundException Ŭ������ ã�� ����
	 */
	@Test
	void givenClass_whenGetsAllPublicMethods_thenCorrect() throws ClassNotFoundException {
		Class<?> birdClass = Class.forName("role3.reflection.ex02.Bird");
		Method[] methods = birdClass.getMethods();
		List<String> methodNames = getMethodNames(methods);
		
		assertTrue(methodNames.containsAll(Arrays.asList("equals"
													   , "notifyAll"
													   , "hashCode"
													   , "walks"
													   , "eats"
													   , "toString")));			
	}
	
	// getDeclaredMethod() �޼��带 ȣ���Ͽ� Ŭ������ ���ǵ� �޼������ �����մϴ�.
	// Ŭ���� ������ ������ �޼��� ���� (�߻� ũ����, �������̽��� ���ؼ� �����ǵ� �޼���)
	// ��� ���� ������ ����
	/**
	 * title : Ŭ������ �־����� �ش� Ŭ������ ��� �޼��带 ������
	 * Class<?>.getDeclaredMethods() : �ش� Ŭ������ �޼��带 ������, private �޼��嵵 ���Ե�
	 * @throws ClassNotFoundException Ŭ������ ã�� ����
	 */
	@Test
	void givenClass_whenGetsOnlyDeclaredMethods_thenCorrect() throws ClassNotFoundException {
		Class<?> birdClass = Class.forName("role3.reflection.ex02.Bird");
		List<String> actualMethodNames = getMethodNames(birdClass.getDeclaredMethods());
		
		List<String> expectedMethodNames = Arrays.asList("setWalks", "walks", "getSound", "eats", "method1");
		
		assertEquals(expectedMethodNames.size(), actualMethodNames.size());
	    assertTrue(expectedMethodNames.containsAll(actualMethodNames));
	    assertTrue(actualMethodNames.containsAll(expectedMethodNames));
	}

	/**
	 * title : �޼����̸��� �־����� Ŭ������ ���ǵ� �޼��带 ����
	 * Class<?>.getDeclaredMethod(String, Class<?>... parameterTypes) : Ŭ������ ���� �̸��� Ŭ���� Ÿ�Կ� �ش��ϴ� �޼��� ���� 
	 * @throws Exception �����ϰ��� �ϴ� �޼��尡 ����
	 */
	@Test
	public void givenMethodName_whenGetsMethod_thenCorrect() throws Exception {
	    Bird bird = new Bird();
	    Method walksMethod = bird.getClass().getDeclaredMethod("walks");
	    // �޼��尡 �Ű������� ������ �Ű������� Ŭ���� Ÿ���� �������־����
	    Method setWalksMethod = bird.getClass().getDeclaredMethod("setWalks", boolean.class);
	    // private �޼��� ����
	    Method method1Method = bird.getClass().getDeclaredMethod("method1");
	    

	    assertTrue(walksMethod.canAccess(bird));
	    assertTrue(setWalksMethod.canAccess(bird));
	    assertFalse(method1Method.canAccess(bird));	// method1 is private    
	}

	/**
	 * title : �޼��尡 �־����� invoke�Ͽ� �޼��带 �����Ŵ
	 * Method.invoke(Object, Object... args) : ���ڿ� �ش��ϴ� Ŭ������ �޼��带 ����
	 * @throws ClassNotFoundException Ŭ������ ã�� ����
	 * @throws InstantiationException �ν��Ͻ� ���� ����
	 * @throws IllegalAccessException �߸��� ���� ����
	 * @throws IllegalArgumentException �߸��� ���� ����
	 * @throws InvocationTargetException invoke ���� ����
	 * @throws NoSuchMethodException �����ϰ��� �ϴ� �޼��尡 ����
	 * @throws SecurityException ���� ����
	 */
	@Test
	public void givenMethod_whenInvokes_thenCorrect() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?> birdClass = Class.forName("role3.reflection.ex02.Bird");
	    Bird bird = (Bird) birdClass.getConstructor().newInstance();
	    Method setWalksMethod = birdClass.getDeclaredMethod("setWalks", boolean.class);
	    Method walksMethod = birdClass.getDeclaredMethod("walks");
	    boolean walks = (boolean) walksMethod.invoke(bird);	// bird.walks�� ȣ���Ͽ� walks �ʵ����� ������

	    assertFalse(walks);
	    assertFalse(bird.walks());

	    setWalksMethod.invoke(bird, true);

	    boolean walks2 = (boolean) walksMethod.invoke(bird);
	    assertTrue(walks2);
	    assertTrue(bird.walks());
	}
}
