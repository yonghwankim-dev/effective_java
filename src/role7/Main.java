package role7;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Foo foo = new Foo();
		try {
			// foo로 해야할 작업 수행
			// ...
		}finally {
			foo.terminate(); // 명시적 종료 메서드 호출
		}
	}

}
