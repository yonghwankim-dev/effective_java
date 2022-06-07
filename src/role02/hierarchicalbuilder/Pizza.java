package role02.hierarchicalbuilder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

// code 2-4 : 계층적으로 설계된 클래스와 잘 어울리는 빌더 패턴

// 참고 : 여기서 사용한 '시뮬레이트한 셀프 타입(simulated self-type)' 관용구는
// 빌더뿐만 아니라 임의의 유동적인 계층구조를 허용한다
public abstract class Pizza {
	public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}
	final Set<Topping> toppings;
	
	
	// Builder<T extends Builder<T>>
	// Builder 클래스의 제너릭 타입(T)는 Builder<T> 인터페이스 또는 클래스이거나
	// 하위 타입 클래스만을 제너릭 타입으로 받을 수 있음
	abstract static class Builder<T extends Builder<T>>{
		EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
		
		public T addTopping(Topping topping) {
			toppings.add(Objects.requireNonNull(topping));
			return self();
		}
		
		abstract Pizza build();
		
		// 하위 클래스는 이 메서드를 재정의(overriding)하여
		// "this"를 반환하도록 해야 한다.
		protected abstract T self();
	}
	
	public Pizza(Builder<?> builder) {
		this.toppings = builder.toppings.clone();	// item 50 참조
	}
}
