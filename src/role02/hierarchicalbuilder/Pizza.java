package role02.hierarchicalbuilder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

// code 2-4 : ���������� ����� Ŭ������ �� ��︮�� ���� ����

// ���� : ���⼭ ����� '�ùķ���Ʈ�� ���� Ÿ��(simulated self-type)' ���뱸��
// �����Ӹ� �ƴ϶� ������ �������� ���������� ����Ѵ�
public abstract class Pizza {
	public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}
	final Set<Topping> toppings;
	
	
	// Builder<T extends Builder<T>>
	// Builder Ŭ������ ���ʸ� Ÿ��(T)�� Builder<T> �������̽� �Ǵ� Ŭ�����̰ų�
	// ���� Ÿ�� Ŭ�������� ���ʸ� Ÿ������ ���� �� ����
	abstract static class Builder<T extends Builder<T>>{
		EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
		
		public T addTopping(Topping topping) {
			toppings.add(Objects.requireNonNull(topping));
			return self();
		}
		
		abstract Pizza build();
		
		// ���� Ŭ������ �� �޼��带 ������(overriding)�Ͽ�
		// "this"�� ��ȯ�ϵ��� �ؾ� �Ѵ�.
		protected abstract T self();
	}
	
	public Pizza(Builder<?> builder) {
		this.toppings = builder.toppings.clone();	// item 50 ����
	}
}
