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
	 * title : Field 배열의 원소들을 리스트로 이관시켜 반환함 
	 * @param fields 어떤 클래스의 필드멤버가 들어있는 배열
	 * @return 필드 멤버 이름들이 있는 문자열 리스트
	 */
	private static List<String> getFieldNames(Field[] fields){
		List<String> fieldNames = new ArrayList<String>();
		for(Field field : fields) {
			fieldNames.add(field.getName());
		}
		return fieldNames;
		
	}

	/**
	 * title : Method 배열의 원소들을 리스트로 이관시켜 반환함 
	 * @param methods 어떤 클래스의 메서드가 들어있는 배열
	 * @return 메서드 멤버 이름들이 있는 문자열 리스트
	 */
	private List<String> getMethodNames(Method[] methods) {
		List<String> methodNames = new ArrayList<String>();
		for(Method method : methods) {
			methodNames.add(method.getName());
		}
		return methodNames;
	}

	/**
	 * title : 인스턴스가 주어졌을때 인스턴스의 클래스 이름과 전체 경로를 확인
	 * Object.getClass() : 인스턴스의 클래스 정보 참조 (Class<?> 타입)
	 * Class<?>.getSimpleName() : 클래스 자체 이름을 참조, 익명인 경우 빈 문자열 참조
	 * Class<?>.getName() : 클래스의 패키지 경로를 포함한 이름을 참조
	 * Class<?>.getCanonicalName() : Java 언어 사양에서 정의한 패키지 경로를 포함한 기본 클래스의 표준 이름 참조 
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
	 * title : 인스턴스를 생성하지 않고 Class.forName 정적 멤버 메소드를 호출하여 클래스의 이름과 경로 확인
	 * Class.forName 메서드 클래스 이름 작성시 패키지 경로를 포함해야함
	 * Class.forName 메서드 호출시 클래스가 존재하지 않으면 ClassNotFoundException 예외 발생함  
	 * @throws ClassNotFoundException 클래스를 찾지 못함
	 */
	@Test
	void givenClassName_whenCreatesObject_thenCorrect() throws ClassNotFoundException {
		Class<?> clazz = Class.forName("role3.reflection.ex02.Goat");
	
		assertEquals("Goat", clazz.getSimpleName());
		assertEquals("role3.reflection.ex02.Goat", clazz.getName());
		assertEquals("role3.reflection.ex02.Goat", clazz.getCanonicalName());
	}
	
	/**
	 * title : 리플렉트 Modifier을 활용하여 클래스의 접근제어자를 확인
	 * Class.forName을 활용하여 비용이 많이 드는 인스턴스를 생성하는 대신 확인할 수 있음
	 * Modifier.isPublic(Class<?>) : 인자의 클래스 접근제어자가 public인지 참조
	 * Modifier.isAbstract(Class<?>) : 인자의 클래스 접근제어자가 abstract 클래스인지 참조 
	 * @throws ClassNotFoundException 클래스를 찾지 못함
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
	 * title : 클래스가 주어졌을때 해당 클래스의 패키지 경로를 참조
	 * Class<?>.getPackage() : 해당 클래스의 패키지 경로 참조(클래스 이름 제외) 
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
	 * title : 클래스가 주어졌을때 해당 클래스의 조상 클래스를 참조
	 * Class<?>.getSuperClass() : 해당 클래스의 조상 클래스를 참조.
	 *                            해당 클래스가 Object, Interface, 기본타입, void인 경우 null 리턴
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
	 * title : 클래스가 주어졌을때 해당 클래스의 구현된 인터페이스를 참조
	 * Class<?>.getInterfaces() : 해당 클래스의 구현된 인터페이스를 참조
	 * 
	 * 왜 Goat 클래스는 Eating 인터페이스(Animal 추상 클래스를 상속받은 상태)를 
	 * 구현하고 Locomotion 인터페이스를 구현함에도 Class<?>.getInterfaces() 참조에는 
	 * Locomotion 인터페이스만이 참조되는가?
	 * => getInterfaces() 메서드는 클래스가 명시적으로 implements 키워드로 구현되었다고
	 * 선언한 인터페이스만 참조하여 배열로 반환합니다.
	 * => Goat 클래스는 Animal 추상 클래스의 자손 클래스이므로 implements 키워드를 사용ㅎ아ㅕ
	 * 인터페이스를 직접선언하지 않았기 때문에 Eating 인터페이스를 참조하지 않습니다.
	 *  
	 * @throws ClassNotFoundException 클래스를 찾지 못함
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
	 * title : 클래스가 주어질때 해당 클래스의 생성자들을 참조하고 생성자의 개수와 이름을 확인
	 * Class<?>.getConstructors() : 해당 클래스의 생성자들을 배열 형태로 참조, 단 public 생성자만 참조
	 * @throws ClassNotFoundException 클래스를 찾지 못함
	 */
	@Test
	void givenClass_whenGetsConstructor_thenCorrect() throws ClassNotFoundException {
		Class<?> goatClass = Class.forName("role3.reflection.ex02.Goat");
		
		Constructor<?>[] constructors = goatClass.getConstructors();
		
		assertEquals(1, constructors.length);
		assertEquals("role3.reflection.ex02.Goat", constructors[0].getName());
		
	}

	/**
	 * title : 클래스가 주어질때 해당 클래스의 필드멤버들을 참조하고 개수와 이름을 확인
	 * Class<?>.getDeclaredFields() : 해당 클래스의 필드 멤버들을 참조하여 배열 형태로 반환
	 * 								  모든 접근 제어자 포함한다. 단, 상속받은 필드는 제외한다.
	 * @throws ClassNotFoundException 클래스를 찾지 못함
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
	 * title : 클래스가 주어질때 해당 클래스의 메서드들을 참조하고 개수와 이름들을 확인
	 * Class<?>.getDeclaredMethods() : 해당 클래스의 메서드 멤버들을 참조하여 배열 형태로 반환
	 * 								   모든 접근 제어자 포함한다. 단, 상속받은 메서드는 제외한다.
	 * @throws ClassNotFoundException 클래스를 찾지 못함
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
	 * title : 클래스가 주어질때 해당 클래스의 모든 생성자를 참조하고 개수를 확인
	 * Class<?>.getConstructors() : 해당 클래스의 생성자들을 참조하여 배열 형태로 반환
	 * 								단, public 접근 제어자에 한함  
	 * @throws ClassNotFoundException
	 */
	@Test
	void givenClass_whenGetsAllConstructors_thenCorrect() throws ClassNotFoundException {
		Class<?> birdClass = Class.forName("role3.reflection.ex02.Bird");
		Constructor<?>[] constructors = birdClass.getConstructors();
		
		assertEquals(3, constructors.length);
	}
	
	/**
	 * title : 클래스가 주어질때 각각의 생성자를 파라미터 타입에 의해서 참조
	 * Class<?>.getConstructor(Class<?>... parameterType) : 해당 클래스의 생성자를 참조하는데 파라미터에 
	 * 														클래스 타입을 전달하여 해당 타입의 생성자가 있는지 참조함
	 * 													    해당 생성자가 없으면 NoSuchMethodException 예외 발생
	 * @throws ClassNotFoundException 클래스를 찾지 못함
	 * @throws NoSuchMethodException 생성자가 존재하지 않음
	 * @throws SecurityException 보안 예외 발생
	 */
	@Test
	void givenClass_whenGetsEachConstructorByParamType_thenCorrect() throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		Class<?> birdClass = Class.forName("role3.reflection.ex02.Bird");
		
		Constructor<?> cons1 = birdClass.getConstructor();
		Constructor<?> cons2 = birdClass.getConstructor(String.class);
		Constructor<?> cons3 = birdClass.getConstructor(String.class, boolean.class);
		
	}

	/**
	 * title : 클래스가 주어졌을때 런타임에 인스턴스를 생성하여 멤버를 참조 및 확인
	 * Constructor<?>.newInstance(Object... initargs) : 해당 생성자를 기반으로 인스턴스 생성
	 * , private 생성자임에도 생성가능함 (java 9 이후로는 비권장 방법)
	 * 
	 * newInstance() 메서드 호출은 private 생성자임에도 호출하여 인스턴스를 생성할 수 잇어서
	 * 싱글턴 클래스를 대상으로 수행시 컨셉이 깨질 수 있음
	 * 
	 * @throws ClassNotFoundException 클래스를 찾지 못함
	 * @throws NoSuchMethodException  생성자가 존재하지 않음
	 * @throws SecurityException	  보안 예외
	 * @throws InstantiationException 인스턴스 생성 예외
	 * @throws IllegalAccessException 접근할 수 없는 멤버에 접근
	 * @throws IllegalArgumentException 부적합한 인자 전달 
	 * @throws InvocationTargetException invoke 수행 오류 
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
	 * title : 클래스가 주어졌을때 해당 클래스의 public 필드를 참조하여 개수와 이름을 참조
	 * Class<?>.getFields() : 해당 클래스의 public 필드 멤버를 배열로 반환  
	 * @throws ClassNotFoundException 클래스를 찾지 못함
	 */
	@Test
	void givenClass_whenGetsPublicFields_thenCorrect() throws ClassNotFoundException {
		Class<?> birdClass = Class.forName("role3.reflection.ex02.Bird");
		
		Field[] fields = birdClass.getFields();
		
		assertEquals(1, fields.length);
		assertEquals("CATEGORY", fields[0].getName());
	}
	
	/**
	 * title : 클래스가 주어졌을때 필드 이름에 의해 해당 클래스의 public 필드를 참조
	 * Class<?>.getField(String) : 해당 클래스의 인자에 해당하는 필드를 참조, 단, public 필드만 가능함
	 * @throws ClassNotFoundException 클래스를 찾지 못함
	 * @throws NoSuchFieldException 참조하고자 하는 필드가 없음
	 * @throws SecurityException 보안 예외
	 */
	@Test
	void givenClass_whenGetsPublicFieldByName_thenCorrect() throws ClassNotFoundException, NoSuchFieldException, SecurityException {
		Class<?> birdClass = Class.forName("role3.reflection.ex02.Bird");
		
		Field field = birdClass.getField("CATEGORY");
		
		assertEquals("CATEGORY", field.getName());
	}
	
	/**
	 * title : 클래스가 주어졌을때 해당 클래스의 정의된 필드 멤버들을 참조하고 개수와 이름을 확인함
	 * Class<?>.getDelaredFields() : 모든 접근 제어자를 대상으로 해당 클래스의 모든 필드를 참조함, 단, 상속받은 필드는 제외함
	 * @throws ClassNotFoundException 클래스를 찾지 못함
	 */
	@Test
	void givenClass_whenGetsDeclaredFields_thenCorrect() throws ClassNotFoundException {
		Class<?> birdClass = Class.forName("role3.reflection.ex02.Bird");
		
		Field[] fields = birdClass.getDeclaredFields();
		
		assertEquals(1, fields.length);
		assertEquals("walks", fields[0].getName());	
	}
	
	/**
	 * title : 클래스가 주어졌을때 필드 이름에 의해 필드를 참조
	 * Class<?>.getDeclaredField(String) : 인자 이름에 해당해는 클래스의 필드 멤버를 참조, 모든 접근 제어자 가능함
	 * @throws ClassNotFoundException 클래스를 찾지 못함
	 * @throws NoSuchFieldException 필드를 찾지 포함
	 * @throws SecurityException 보안 예외
	 */
	@Test
	void givenClass_whenGetsFieldsByName_thenCorrect() throws ClassNotFoundException, NoSuchFieldException, SecurityException {
		Class<?> birdClass = Class.forName("role3.reflection.ex02.Bird");
		Field field = birdClass.getDeclaredField("walks");
		
		assertEquals("walks", field.getName());
	}
	
	/**
	 * title : 클래스 필드가 주어졌을때 해당 필드의 타입을 참조함
	 * Field.getType() : 해당 필드의 클래스 타입을 참조하여, Class<?> 타입으로 반환함
	 * @throws NoSuchFieldException 참조 필드가 없음
	 * @throws SecurityException 보안예외
	 * @throws ClassNotFoundException 클래스를 찾지 못함
	 */
	@Test
	void givenClassField_whenGetsType_thenCorrect() throws NoSuchFieldException, SecurityException, ClassNotFoundException {
		Field field = Class.forName("role3.reflection.ex02.Bird").getDeclaredField("walks");
		Class<?> fieldClass = field.getType();
		
		assertEquals("boolean", fieldClass.getSimpleName());	
	}

	/**
	 * title : 클래스 필드가 주어질때 필드의 값을 변경하고 참조
	 * Field.setAccessible(boolean) : private 접근 제어자 필드에 접근할 수 있도록 설정함
	 * Field.set(Object, Object) : 인자에 인스턴스, 값을 전달하여 인자로 전달한 클래스의 필드의 값을 변경함  
	 * @throws ClassNotFoundException 클래스를 찾지 못함
	 * @throws InstantiationException 인스턴스 생성 예외
	 * @throws IllegalAccessException 접근할 수 없는 필드에 접근함
	 * @throws IllegalArgumentException 인자 전달이 잘못됨
	 * @throws InvocationTargetException invoke 메서드 수행시 오류
	 * @throws NoSuchMethodException 참조 메서드가 없음
	 * @throws SecurityException 보안 에외
	 * @throws NoSuchFieldException 참조 필드가 없음
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
	 * title : 클래스 필드가 주어질때 해당 클래스 필드의 값을 참조
	 * Class<?>.getField(String) : 인자에 해당하는 필드를 참조합니다.
	 * Field.get(Object) : 해당 필드의 값을 참조함
	 * 단, 필드가 public static이면 인자는 무시됨.
	 * 
	 * @throws ClassNotFoundException 클래스를 찾지 못함
	 * @throws NoSuchFieldException 참조 필드가 없음
	 * @throws SecurityException 보안 예외
	 * @throws IllegalArgumentException 인자 전달이 잘못됨
	 * @throws IllegalAccessException 접근 못하는 필드에 접근함
	 */
	@Test
	void givenClassField_whenGetsAndSetsWithNull_thenCorrect() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Class<?> birdClass = Class.forName("role3.reflection.ex02.Bird");
		Field field = birdClass.getField("CATEGORY");
		field.setAccessible(true);
		
		assertEquals("domestic", field.get(null));
	}
	
	/**
	 * title : 클래스가 주어질때 public 멤버인 모든 메서드를 참조함
	 * Class<?>.getMethods() : 접근제어자가 public인 해당 클래스의 메서드들을 참조하여 배열 형태로 반환함
	 * @throws ClassNotFoundException 클래스를 찾지 못함
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
	
	// getDeclaredMethod() 메서드를 호출하여 클래스의 정의된 메서드들을 참조합니다.
	// 클래스 내에서 구현된 메서드 포함 (추상 크랠스, 인터페이스에 의해서 재정의된 메서드)
	// 모든 접근 제어자 포함
	/**
	 * title : 클래스가 주어질때 해당 클래스의 모든 메서드를 참조함
	 * Class<?>.getDeclaredMethods() : 해당 클래스의 메서드를 참조함, private 메서드도 포함됨
	 * @throws ClassNotFoundException 클래스를 찾지 못함
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
	 * title : 메서드이름이 주어질때 클래스의 정의된 메서드를 참조
	 * Class<?>.getDeclaredMethod(String, Class<?>... parameterTypes) : 클래스에 인자 이름과 클래스 타입에 해당하는 메서드 참조 
	 * @throws Exception 참조하고자 하는 메서드가 없음
	 */
	@Test
	public void givenMethodName_whenGetsMethod_thenCorrect() throws Exception {
	    Bird bird = new Bird();
	    Method walksMethod = bird.getClass().getDeclaredMethod("walks");
	    // 메서드가 매개변수가 있으면 매개변수의 클래스 타입을 전달해주어야함
	    Method setWalksMethod = bird.getClass().getDeclaredMethod("setWalks", boolean.class);
	    // private 메서드 참조
	    Method method1Method = bird.getClass().getDeclaredMethod("method1");
	    

	    assertTrue(walksMethod.canAccess(bird));
	    assertTrue(setWalksMethod.canAccess(bird));
	    assertFalse(method1Method.canAccess(bird));	// method1 is private    
	}

	/**
	 * title : 메서드가 주어질때 invoke하여 메서드를 수행시킴
	 * Method.invoke(Object, Object... args) : 인자에 해당하는 클래스의 메서드를 수행
	 * @throws ClassNotFoundException 클래스를 찾지 못함
	 * @throws InstantiationException 인스턴스 생성 오류
	 * @throws IllegalAccessException 잘못된 접근 오류
	 * @throws IllegalArgumentException 잘못된 인자 전달
	 * @throws InvocationTargetException invoke 수행 오류
	 * @throws NoSuchMethodException 참조하고자 하는 메서드가 없음
	 * @throws SecurityException 보안 예외
	 */
	@Test
	public void givenMethod_whenInvokes_thenCorrect() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?> birdClass = Class.forName("role3.reflection.ex02.Bird");
	    Bird bird = (Bird) birdClass.getConstructor().newInstance();
	    Method setWalksMethod = birdClass.getDeclaredMethod("setWalks", boolean.class);
	    Method walksMethod = birdClass.getDeclaredMethod("walks");
	    boolean walks = (boolean) walksMethod.invoke(bird);	// bird.walks를 호출하여 walks 필드멤버를 참조함

	    assertFalse(walks);
	    assertFalse(bird.walks());

	    setWalksMethod.invoke(bird, true);

	    boolean walks2 = (boolean) walksMethod.invoke(bird);
	    assertTrue(walks2);
	    assertTrue(bird.walks());
	}
}
