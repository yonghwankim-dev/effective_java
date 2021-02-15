package role7;

public class Foo {
	
	public void terminate() {
		// TODO Auto-generated method stub
		
	}
	
	// 이 객체는 바깥 객체를 종료시키는 역할을 수행
	private final Object finalizerGuardian = new Object(){
		@Override
		protected void finalize() {
			// TODO Auto-generated method stub
			// 바깥 Foo 객체를 종료 시킴
		}
	};
	
	protected void finalize(){
		terminate();
	}

	
	

}

class Foo_Child extends Foo{

	@Override
	protected void finalize(){
		// TODO Auto-generated method stub
		
		try {
			// 하위 클래스의 상태 종료
		}finally {
			// 상위 클래스의 상태 종료
			super.finalize();
		}
		
		
	}
	
}