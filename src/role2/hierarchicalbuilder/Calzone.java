package role2.hierarchicalbuilder;

// code 2-6 : Į�ʳ� ���� - ������ ������ Ȱ���� ���� Ŭ���� (20p ~ 21p)
public class Calzone extends Pizza{
	private final boolean sauceInside;
	
	public static class Builder extends Pizza.Builder<Builder>{
		private boolean sauceInside = false;	// �⺻��

		public Builder sauceInside() {
			sauceInside = true;
			return this;
		}
		
		@Override
		Calzone build() {
			return new Calzone(this);
		}

		@Override
		protected Builder self() {
			return this;
		}		
	}
	
	private Calzone(Builder builder) {
		super(builder);
		this.sauceInside = builder.sauceInside;
	}

	@Override
	public String toString() {
        return String.format("%s�� ������ Į�ʳ� ���� (�ҽ��� %s��)",
                toppings, sauceInside ? "��" : "�ٱ�");
	}
	
	
}
